/**
 * 
 */
package com.appdirect.backend.core.models.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.appdirect.backend.core.models.BaseModel;
import com.appdirect.backend.core.models.util.UUIDUtils;

/**
 * @author cweerasekera
 *
 */
@MappedSuperclass
public abstract class BaseEntity implements BaseModel {
    
    /**
     * 
     */
    private static final long serialVersionUID = -8819323439291184414L;

    /**
     * for h2 database
     */
    public static final String DB_DATA_TYPE = "VARBINARY(16)";

    @Id
    @Column(length = 16, name = "id", columnDefinition=DB_DATA_TYPE)
    private byte[] uuid;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified")
    private Date lastModified;

    @Column(name = "created_by", length = 30)
    private String createdBy;

    @Column(name = "modified_by", length = 30)
    private String modifiedBy;

    /*
     * (non-Javadoc)
     * @see com.appdirect.backend.core.models.BaseModel#getUuid()
     */
    @Override
    public String getUuid() {
        return UUIDUtils.fromByte(uuid).toString();
    }
    
    /*
     * (non-Javadoc)
     * @see com.appdirect.backend.core.models.BaseModel#getCreatedDate()
     */
    @Override
    public Date getCreatedDate() {
        return createdDate;
    }
    
    /*
     * (non-Javadoc)
     * @see com.appdirect.backend.core.models.BaseModel#getLastModified()
     */
    @Override
    public Date getLastModified() {
        return lastModified;
    }
    /*
     * (non-Javadoc)
     * @see com.appdirect.backend.core.models.BaseModel#getCreatedBy()
     */
    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    /*
     * (non-Javadoc)
     * @see com.appdirect.backend.core.models.BaseModel#getModifiedBy()
     */
    @Override
    public String getModifiedBy() {
        return modifiedBy;
    }

    @PrePersist
    protected void prepersist() {
        if (uuid == null)
            uuid = UUIDUtils.getIdAsByte(UUID.randomUUID());

        createdDate = new Date();
        //createdBy = SecurityUtil.getUsername();
        preupdate();
    }

    @PreUpdate
    protected void preupdate() {
        lastModified = new Date();
        //modifiedBy = SecurityUtil.getUsername();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
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

}
