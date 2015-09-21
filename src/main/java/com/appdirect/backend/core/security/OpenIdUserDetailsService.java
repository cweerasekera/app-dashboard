package com.appdirect.backend.core.security;

import com.appdirect.backend.core.entities.User;
import com.appdirect.backend.core.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by cweerasekera
 */
@Component
public class OpenIdUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String openIdIdentifier) throws UsernameNotFoundException {
        User user = userService.findUserByOpenId(openIdIdentifier);
        UserAccount userAccount = new UserAccount(user);
        if (userAccount == null){
            throw new UsernameNotFoundException(openIdIdentifier);
        }else {
            if (!userAccount.isEnabled()){
                throw new DisabledException("User is disabled");
            }
        }
        return userAccount;
    }
}
