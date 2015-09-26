package com.appdirect.backend.core.entities;

import com.appdirect.backend.core.model.UserModel;

import javax.persistence.*;

/**
 * Created by cweerasekera
 */
@Entity(name = "user")
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name=User.QUERY_SELECT_ALL, query = "SELECT u FROM user u"),
        @NamedQuery(name=User.QUERY_SELECT_BY_USERNAME, query = "SELECT u FROM user u WHERE u.username=?1")
        //@NamedQuery(name=User.QUERY_SELECT_BY_OPEN_ID, query = "SELECT u FROM user u WHERE u.openIdIdentifier=?1")
})
public class User extends BaseEntity implements UserModel {
    public static final String QUERY_SELECT_ALL = "user.findAll";
    public static final String QUERY_SELECT_BY_USERNAME = "user.findByUsername";
    public static final String QUERY_SELECT_BY_OPEN_ID = "user.findByOpenId";

    //@Column(name = "openid_identifier")
    //private String openIdIdentifier;

    @Column(name = "username", unique = true)
    private String username;

    private String password;

    private String emailAddress;

    /*public String getOpenIdIdentifier() {
        return openIdIdentifier;
    }

    public void setOpenIdIdentifier(String openIdIdentifier) {
        this.openIdIdentifier = openIdIdentifier;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
