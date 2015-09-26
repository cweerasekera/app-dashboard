package com.appdirect.backend.core.model;

/**
 * Created by cweerasekera
 */
public interface UserModel extends BaseModel{
    //public String getOpenIdIdentifier();
    public String getUsername();
    public String getPassword();
    public String getEmailAddress();
}
