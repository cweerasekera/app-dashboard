/**
 *
 */
package com.appdirect.backend.core.entities;

import com.appdirect.backend.core.model.EventModel;

import javax.persistence.*;

/**
 * @author cweerasekera
 */
@Entity(name = "event")
@Table(name = "event")
@NamedQueries({
        @NamedQuery(name=Event.QUERY_SELECT_ALL, query = "SELECT e FROM event e")
})
public class Event extends BaseEntity implements EventModel{

    public static final String QUERY_SELECT_ALL = "event.findAll";

    @Column(name="type", nullable = false)
    private String type;

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
