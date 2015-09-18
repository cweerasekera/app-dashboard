package com.appdirect.backend.core.services.impl;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.services.UrlResourceService;
import com.appdirect.backend.rest.resources.EventResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by cweerasekera on 17/09/2015.
 */
@Service
public class UrlResourceServiceImpl implements UrlResourceService {
    private static final Logger LOG = LoggerFactory.getLogger(UrlResourceServiceImpl.class);

    @Override
    public Event findEvent(String url) {
        LOG.trace("ENTER findEvent()");
        LOG.debug("URL: [{}]",url);
        RestTemplate template = new RestTemplate();
        HttpEntity<EventResource> entity = template.getForEntity(url, EventResource.class);
        EventResource event = entity.getBody();
        MediaType contentType = entity.getHeaders().getContentType();
        LOG.debug("content-type",contentType);
        try {
            return event.toEvent();
        } finally {
            LOG.trace("EXIT findEvent()");
        }
    }
}
