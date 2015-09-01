/**
 * 
 */
package com.appdirect.backend.rest.controllers;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.services.EventService;
import com.appdirect.backend.core.services.exceptions.EventExistsException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.endsWith;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    private static String ATOM_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<EventResource xmlns:atom=\"http://www.w3.org/2005/Atom\"><type>SUBSCRIPTION_ORDER</type></EventResource>";
    
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
    @Test
    public void getExistingEvent() throws Exception{
        Event event = new Event();
        event.setId(1L);
        event.setType("SUBSCRIPTION_ORDER");
        
        when(service.findEvent(1L)).thenReturn(event);
        
        mockMvc.perform(get("/rest/events/1").accept(MediaType.APPLICATION_XML))
                .andExpect(status().isOk())
                .andExpect(xpath("/EventResource/type").string(event.getType()))
                .andDo(print());
    }

    @Test
    public void getNonExistingEvent() throws Exception{
        when(service.findEvent(1L)).thenReturn(null);

        mockMvc.perform(get("/rest/events/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void createNonExistingEvent() throws Exception {
        Event createdEvent = new Event();
        createdEvent.setId(1L);
        createdEvent.setType("SUBSCRIPTION_ORDER");

        when(service.createEvent(any(Event.class))).thenReturn(createdEvent);

        mockMvc.perform(post("/rest/events")
                .contentType(MediaType.APPLICATION_XML)
                .content(ATOM_XML.getBytes()))
                .andExpect(xpath("/EventResource/type").string(createdEvent.getType()))
                .andExpect(status().isCreated())
                .andDo(print());
    }
}
