/**
 * 
 */
package com.appdirect.backend.rest.controllers;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.entities.Marketplace;
import com.appdirect.backend.core.services.EventService;
import com.appdirect.backend.core.services.MarketplaceService;
import com.appdirect.backend.core.services.UrlResourceService;
import com.appdirect.backend.core.services.util.EventList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

/**
 * @author cweerasekera
 *
 */
public class EventControllerTest {
    private static final Logger LOG = LoggerFactory.getLogger(EventControllerTest.class);
    @InjectMocks
    private EventController controller;
    
    @Mock
    private EventService eventService;

    @Mock
    private UrlResourceService urlResourceService;

    @Mock
    private MarketplaceService marketplaceService;

    private MockMvc mockMvc;

    private static String ATOM_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<EventResource xmlns:atom=\"http://www.w3.org/2005/Atom\"><type>SUBSCRIPTION_ORDER</type></EventResource>";
    
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    
    @Test
    public void A_getExistingEvent() throws Exception{
        LOG.trace("--> A_getExistingEvent()");
        Event event = new Event();
        event.setUuid("f4bdda18-4db3-4475-9109-24bed5ae6ecf");
        event.setType("SUBSCRIPTION_ORDER");
        event.setFlag("DEVELOPMENT");

        Marketplace marketplace = new Marketplace();
        marketplace.setUuid("a49cfcdd-1438-415c-99c2-bd646b4c4020");
        marketplace.setBaseUrl("http://test.com");
        marketplace.setPartner("APPDIRECT");

        event.setMarketplace(marketplace);

        when(eventService.findEvent("f4bdda18-4db3-4475-9109-24bed5ae6ecf")).thenReturn(event);
        
        mockMvc.perform(get("/api/v1/events/f4bdda18-4db3-4475-9109-24bed5ae6ecf").accept(MediaType.APPLICATION_XML))
                .andExpect(status().isOk())
                .andExpect(xpath("/EventResource/type").string(event.getType()))
                .andDo(print());
        LOG.trace("<-- A_getExistingEvent()");
    }

    @Test
    public void B_getNonExistingEvent() throws Exception{
        when(eventService.findEvent("f4bdda18-4db3-4475-9109-24bed5ae6ecf")).thenReturn(null);

        mockMvc.perform(get("/api/v1/events/f4bdda18-4db3-4475-9109-24bed5ae6ecf"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void C_createNonExistingEvent() throws Exception {
        Event createdEvent = new Event();
        createdEvent.setUuid("f4bdda18-4db3-4475-9109-24bed5ae6ecf");
        createdEvent.setType("SUBSCRIPTION_ORDER");
        createdEvent.setFlag("DEVELOPMENT");

        Marketplace marketplace = new Marketplace();
        marketplace.setBaseUrl("http://www.example.com");
        marketplace.setPartner("APPDIRECT");

        createdEvent.setMarketplace(marketplace);

        when(eventService.createEvent(any(Event.class))).thenReturn(createdEvent);

        mockMvc.perform(post("/api/v1/events")
                .contentType(MediaType.APPLICATION_XML)
                .content(ATOM_XML.getBytes()))
                .andExpect(xpath("/EventResource/type").string(createdEvent.getType()))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void D_findAllEvents() throws Exception{
        List<Event> list = new ArrayList<Event>();
        Event event1 = new Event();
        event1.setUuid("f4bdda18-4db3-4475-9109-24bed5ae6ecf");
        event1.setType("Test Event 1");
        event1.setFlag("DEVELOPMENT");
        list.add(event1);

        Event event2 = new Event();
        event2.setUuid("f4bdda18-4db3-4475-9109-24bed5ae6ecf");
        event2.setType("Test Event 2");
        event2.setFlag("DEVELOPMENT");
        list.add(event2);

        EventList eventList = new EventList(list);

        when(eventService.findAllEvents()).thenReturn(eventList);

        mockMvc.perform(get("/api/v1/events"))
                //.andExpect(xpath("/EventResource/type"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void E_processUrl() throws Exception {
        String url = "http://localhost:8080/api/v1/events/85d13551-6d58-4ec8-b588-2311233a9971";

        Event event = new Event();
        event.setUuid("85d13551-6d58-4ec8-b588-2311233a9971");
        event.setType("Type Test 1");
        event.setFlag("DEVELOPMETN");
        event.setMarketplace(null);

        when(urlResourceService.findEvent(url)).thenReturn(event);
        when(eventService.createEvent(any(Event.class))).thenReturn(event);

        mockMvc.perform(get("/api/v1/events/subscription/create?eventUrl="+url))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
