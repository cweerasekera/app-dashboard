/**
 * 
 */
package com.appdirect.backend.rest.controllers;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.services.EventService;
import com.appdirect.backend.core.services.exceptions.EventExistsException;
import com.appdirect.backend.core.services.util.EventList;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.endsWith;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
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
        event.setUuid("f4bdda18-4db3-4475-9109-24bed5ae6ecf");
        event.setType("SUBSCRIPTION_ORDER");
        
        when(service.findEvent("f4bdda18-4db3-4475-9109-24bed5ae6ecf")).thenReturn(event);
        
        mockMvc.perform(get("/rest/events/f4bdda18-4db3-4475-9109-24bed5ae6ecf").accept(MediaType.APPLICATION_XML))
                .andExpect(status().isOk())
                .andExpect(xpath("/EventResource/type").string(event.getType()))
                .andDo(print());
    }

    @Test
    public void getNonExistingEvent() throws Exception{
        when(service.findEvent("f4bdda18-4db3-4475-9109-24bed5ae6ecf")).thenReturn(null);

        mockMvc.perform(get("/rest/events/f4bdda18-4db3-4475-9109-24bed5ae6ecf"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void createNonExistingEvent() throws Exception {
        Event createdEvent = new Event();
        createdEvent.setUuid("f4bdda18-4db3-4475-9109-24bed5ae6ecf");
        createdEvent.setType("SUBSCRIPTION_ORDER");

        when(service.createEvent(any(Event.class))).thenReturn(createdEvent);

        mockMvc.perform(post("/rest/events")
                .contentType(MediaType.APPLICATION_XML)
                .content(ATOM_XML.getBytes()))
                .andExpect(xpath("/EventResource/type").string(createdEvent.getType()))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void findAllEvents() throws Exception{
        List<Event> list = new ArrayList<Event>();

        Event event1 = new Event();
        event1.setUuid("f4bdda18-4db3-4475-9109-24bed5ae6ecf");
        event1.setType("Test Event 1");
        list.add(event1);

        Event event2 = new Event();
        event2.setUuid("f4bdda18-4db3-4475-9109-24bed5ae6ecf");
        event2.setType("Test Event 2");
        list.add(event2);

        EventList eventList = new EventList(list);

        when(service.findAllEvents()).thenReturn(eventList);

        mockMvc.perform(get("/rest/events"))
                //.andExpect(xpath("/EventResource/type"))
                .andExpect(status().isOk())
                .andDo(print());


    }

    @Test
    public void processUrl() throws Exception {
        mockMvc.perform(get("/rest/events/url/abc")).andDo(print());
    }
}
