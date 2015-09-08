package com.appdirect.backend.rest.resources;

import com.appdirect.backend.core.model.BaseModel;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * Created by cweerasekera.
 */
public class BaseResource extends ResourceSupport implements BaseModel {
    private String uuid;
    private Date createdDate;
    private String createdBy;
    private Date lastModified;
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
        return createdDate;
    }

    public void setCreatedDate(Date createDate) {
        this.createdDate = createDate;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
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
