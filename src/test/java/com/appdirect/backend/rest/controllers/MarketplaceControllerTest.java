package com.appdirect.backend.rest.controllers;

import com.appdirect.backend.core.entities.Marketplace;
import com.appdirect.backend.core.services.MarketplaceService;
import com.appdirect.backend.core.services.util.MarketplaceList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by cweerasekera on 11/09/2015.
 */
public class MarketplaceControllerTest {
    @InjectMocks
    private MarketplaceController controller;

    @Mock
    private MarketplaceService service;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getExistingMarketplace() throws Exception {
        Marketplace marketplace = new Marketplace();
        marketplace.setUuid("a49cfcdd-1438-415c-99c2-bd646b4c4020");
        marketplace.setBaseUrl("http://www.marketplace.com");
        marketplace.setPartner("APPDIRECT");

        when(service.findMarketplace(marketplace.getUuid())).thenReturn(marketplace);

        mockMvc.perform(get("/rest/marketplaces/" + marketplace.getUuid()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void findAllMarketplaces() throws Exception{
        List<Marketplace> list = new ArrayList<Marketplace>();
        Marketplace marketplace1 = new Marketplace();
        marketplace1.setUuid("a49cfcdd-1438-415c-99c2-bd646b4c4020");
        marketplace1.setBaseUrl("http://www.marketplace1.com");
        marketplace1.setPartner("PARTNER1");
        list.add(marketplace1);

        Marketplace marketplace2 = new Marketplace();
        marketplace2.setUuid("56d9f009-16c9-4a7f-81bb-8093ecdaf86b");
        marketplace2.setBaseUrl("http://www.marketplace2.com");
        marketplace2.setPartner("PARTNER2");
        list.add(marketplace2);

        MarketplaceList marketplaceList = new MarketplaceList(list);

        when(service.findAllMarketplaces()).thenReturn(marketplaceList);

        mockMvc.perform(get("/rest/marketplaces"))
                .andExpect(status().isOk())
                .andDo(print());

    }
}
