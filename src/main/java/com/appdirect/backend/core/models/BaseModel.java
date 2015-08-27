/**
 * 
 */
package com.appdirect.backend.core.models;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cweerasekera
 *
 */
public interface BaseModel extends Serializable{
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
