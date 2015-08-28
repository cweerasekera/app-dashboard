/**
 * 
 */
package com.appdirect.backend.rest.resources;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.hateoas.ResourceSupport;

import com.appdirect.backend.core.models.BaseModel;

/**
 * @author cweerasekera
 *
 */
@XmlTransient
public class BaseResource extends ResourceSupport implements BaseModel {

    /**
     * 
     */
    private static final long serialVersionUID = 5579169905266774841L;

    @XmlElement(name = "id")
    private String uuid;
    
    @XmlElement(name = "createDate")
    private Date createDate;

    @XmlElement(name = "createdBy")
    private String createdBy;
    
    @XmlElement(name = "lastModified")
    private Date lastModified;

    @XmlElement(name = "modifiedBy")
    private String modifiedBy;
    
    @Override
    public String getUuid() {
        return uuid;
    }
    
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public Date getCreatedDate() {
        return createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
    
    @Override
    public int hashCode() {
        return ((uuid == null) ? 0 : uuid.hashCode());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        final BaseResource other = (BaseResource) obj;

        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        
        return true;
    }    
}
