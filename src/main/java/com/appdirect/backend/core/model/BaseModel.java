package com.appdirect.backend.core.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by cweerasekera.
 */
public interface BaseModel extends Serializable {
    /**
     * @return the uuid
     */
    public String getUuid();

    /**
     * @return the createdDate
     */
    public Date getCreatedDate();

    /**
     * @return the lastModified
     */
    public Date getLastModified();

    /**
     * @return the createdBy
     */
    public String getCreatedBy();

    /**
     * @return the modifiedBy
     */
    public String getModifiedBy();
}
