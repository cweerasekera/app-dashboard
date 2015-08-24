/**
 * 
 */
package com.appdirect.backend.rest.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.http.MediaType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.appdirect.backend.core.services.EventService;
import com.appdirect.backend.rest.controllers.EventController;

/**
 * @author cweerasekera
 *
 */
public class EventControllerTest {
    @InjectMocks
    private EventController controller;
    
    @Mock
    private EventService service;
    
    private MockMvc mockMvc;
    
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void test() throws Exception{        
        mockMvc.perform(post("/test")                
                .content("<Event xmlns:atom=\"http://www.w3.org/2005/Atom\"><type>SUBSCRIPTION_ORDER</type></Event>")
                .contentType(MediaType.APPLICATION_XML)
        )
        .andDo(print());
    }
    
    @Test
    public void getExistingEvent() throws Exception{
    }
}
