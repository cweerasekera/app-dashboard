/**
 * 
 */
package com.appdirect.backend.rest.resources;

import org.springframework.hateoas.ResourceSupport;

/**
 * @author cweerasekera
 *
 */
public class EventResource extends ResourceSupport {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
