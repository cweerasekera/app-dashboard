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

    @Column(name ="flag")
    private String flag;

    @OneToOne
    @Column(name = "marketplace")
    private Marketplace marketplace;

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String getFlag() {
        return flag;
    }

    @Override
    public Marketplace getMarketplace() {
        return marketplace;
    }

    public void setMarketplace(Marketplace marketplace) {
        this.marketplace = marketplace;
    }
}
