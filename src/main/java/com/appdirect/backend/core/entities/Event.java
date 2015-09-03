/**
 *
 */
package com.appdirect.backend.core.entities;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
