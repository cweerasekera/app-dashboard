package com.appdirect.backend.core.entities;

import com.appdirect.backend.core.model.BaseModel;
import org.hibernate.annotations.GenericGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cweerasekera.
 */
@MappedSuperclass()
public abstract class BaseEntity implements BaseModel{
    private static final Logger LOG = LoggerFactory.getLogger(BaseEntity.class);
    
    public static final String DB_DATA_TYPE_TIMESTAMP = "TIMESTAMP";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uuid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", columnDefinition = DB_DATA_TYPE_TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_modified", columnDefinition = DB_DATA_TYPE_TIMESTAMP)
    private Date lastModified;

    @Column(name="created_by", length=30)
    private String createdBy;

    @Column(name="modified_by", length=30)
    private String modifiedBy;

    @Override
    public String getUuid() {
        LOG.trace("ENTER getUuid()");
        try{
            return uuid;
        }finally{
            LOG.trace("EXIT getUuid()");
        }
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @PrePersist
    protected  void prepersist(){
        LOG.trace("ENTER prepersist()");
        createdDate = new Date();
        createdBy = "username"; //TODO
        preupdate();
        LOG.trace("EXIT prepersist()");
    }

    @PreUpdate
    protected  void preupdate(){
        LOG.trace("ENTER preupdate()");
        lastModified = new Date();
        modifiedBy = "username"; //TODO
        LOG.trace("EXIT preupdate()");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        final BaseEntity other = (BaseEntity) obj;

        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }
}
