/**
 * 
 */
package com.appdirect.backend.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author cweerasekera
 *
 */
@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
