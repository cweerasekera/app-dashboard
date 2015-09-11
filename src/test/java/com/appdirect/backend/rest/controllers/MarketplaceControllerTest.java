package com.appdirect.backend.rest.controllers;

import com.appdirect.backend.core.entities.Marketplace;
import com.appdirect.backend.core.services.MarketplaceService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


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

        mockMvc.perform(get("/rest/marketplace/"+marketplace.getUuid()))
            .andDo(print());
    }
}
