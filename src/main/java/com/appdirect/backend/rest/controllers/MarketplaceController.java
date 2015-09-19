package com.appdirect.backend.rest.controllers;

import com.appdirect.backend.core.entities.Marketplace;
import com.appdirect.backend.core.services.MarketplaceService;
import com.appdirect.backend.core.services.exceptions.MarketplaceExistsException;
import com.appdirect.backend.core.services.util.MarketplaceList;
import com.appdirect.backend.rest.exceptions.ConflictException;
import com.appdirect.backend.rest.resources.MarketplaceListResource;
import com.appdirect.backend.rest.resources.MarketplaceResource;
import com.appdirect.backend.rest.resources.asm.MarketplaceListResourceAsm;
import com.appdirect.backend.rest.resources.asm.MarketplaceResourceAsm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

/**
 * Created by cweerasekera on 09/09/2015.
 */
@Controller
@RequestMapping("/api/v1/marketplaces")
public class MarketplaceController {
    private static final Logger LOG = LoggerFactory.getLogger(MarketplaceController.class);

    private MarketplaceService marketplaceService;

    @Autowired
    public MarketplaceController(MarketplaceService marketplaceService){
        this.marketplaceService = marketplaceService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<MarketplaceListResource> findAllMarketplaces(){
        LOG.trace("ENTER findAllMarketplaces()");
        MarketplaceList list = marketplaceService.findAllMarketplaces();
        MarketplaceListResource resource = new MarketplaceListResourceAsm().toResource(list);
        try {
            return new ResponseEntity<MarketplaceListResource>(resource,HttpStatus.OK);
        } finally {
            LOG.trace("EXIT findAllMarketplaces()");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<MarketplaceResource> createMarketplace(@RequestBody MarketplaceResource sentMarketplace){
        LOG.trace("ENTER createMarketplace()");
        try {
            Marketplace createdMarketplace = marketplaceService.createMarketplace(sentMarketplace.toMarketplace());
            MarketplaceResource resource = new MarketplaceResourceAsm().toResource(createdMarketplace);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(resource.getLink("self").getHref()));
            return new ResponseEntity<MarketplaceResource>(resource, headers, HttpStatus.CREATED);
        }catch (MarketplaceExistsException e){
            LOG.error(e.getMessage(),e);
            throw new ConflictException(e);
        }finally {
            LOG.trace("EXIT createMarketplace()");
        }
    }

    @RequestMapping(value = "/{uuid}")
    public ResponseEntity<MarketplaceResource> getMarketplace(@PathVariable String uuid){
        LOG.trace("ENTER getMarketplace()");
        Marketplace marketplace = marketplaceService.findMarketplace(uuid);
        try {
            if (marketplace != null) {
                MarketplaceResource res = new MarketplaceResourceAsm().toResource(marketplace);
                return new ResponseEntity<MarketplaceResource>(res, HttpStatus.OK);
            } else {
                return new ResponseEntity<MarketplaceResource>(HttpStatus.NOT_FOUND);
            }
        }finally {
            LOG.trace("EXIT getMarketplace()");
        }
    }

}
