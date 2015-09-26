package com.appdirect.backend.core.security;

/**
 * Created by cweerasekera
 */
//@Component
public class OpenIdUserDetailsService /*implements UserDetailsService*/ {
/*

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
*/
}
