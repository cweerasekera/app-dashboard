/**
 *
 */
package com.appdirect.backend.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author cweerasekera
 */
@Entity(name = "event")
@Table(name = "event")
@NamedQueries({
        @NamedQuery(name=Event.QUERY_SELECT_ALL, query = "SELECT e FROM event e")
})
public class Event {

    public static final String QUERY_SELECT_ALL = "event.findAll";

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
