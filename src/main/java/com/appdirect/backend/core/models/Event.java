/**
 * 
 */
package com.appdirect.backend.core.models;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.appdirect.backend.rest.resources.EventResource;

/**
 * @author cweerasekera
 *
 */
@XmlJavaTypeAdapter(EventResource.Adapter.class)
public interface Event extends BaseModel {
    public String getType();
}
