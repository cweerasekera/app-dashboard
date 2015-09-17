package com.appdirect.backend.core.services;

import com.appdirect.backend.core.entities.Event;

/**
 * Created by cweerasekera on 17/09/2015.
 */
public interface UrlResourceService {
    public Event findEvent(String url);
}
