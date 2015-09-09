package com.appdirect.backend.rest.controllers;

import com.appdirect.backend.rest.resources.MarketplaceResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cweerasekera on 09/09/2015.
 */
@Controller
@RequestMapping("/rest/marketplace")
public class MarketplaceController {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<MarketplaceResource> createMarketplace(@RequestBody MarketplaceResource sentMarketplace){

        return  null;
    }

}
