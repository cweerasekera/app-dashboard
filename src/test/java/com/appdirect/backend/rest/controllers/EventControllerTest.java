/**
 * 
 */
package com.appdirect.backend.rest.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.appdirect.backend.core.models.entities.EventEntity;
import com.appdirect.backend.core.services.EventService;
import com.appdirect.backend.rest.controllers.EventController;

/**
 * @author cweerasekera
 *
 */
public class EventControllerTest {
    
    private static final Logger LOG = LoggerFactory.getLogger(EventControllerTest.class);
    
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

    //@Test
    public void test() throws Exception{        
        mockMvc.perform(post("/test")                
                .content("<Event xmlns:atom=\"http://www.w3.org/2005/Atom\"><type>SUBSCRIPTION_ORDER</type></Event>")
                .contentType(MediaType.APPLICATION_XML)
        )
        .andDo(print());
    }
    
    @Test
    public void getExistingEvent() throws Exception{
        LOG.trace("ENTER getExistingEvent()");
        EventEntity event = new EventEntity();
        event.setType("SUBSCRIPTION_ORDER");
        LOG.debug("Event returned: {}" , service.createEvent(event));
        LOG.debug("Event found: {}" , service.find(event.getUuid()));
        when(service.find(event.getUuid())).thenReturn(event);
        
        mockMvc.perform(get("/rest/events/"+event.getUuid()))
        .andExpect(xpath("/EventResource/type").string(event.getType()))
        //.andExpect(xpath("/EventResource//links/@href", hasItem(endsWith("/events/1"))).exists())
        .andExpect(status().isOk())
        .andDo(print());
        LOG.trace("EXIT getExistingEvent()");
    }
}
