package by.prohor.autentification;

import by.prohor.entity.UserEntity;
import org.springframework.security.core.userdetails.User;

/**
 * Created by Artsiom Prokharau 26.07.2021
 */

public class CustomUser extends User {

    private static final long serialVersionUID = 1L;
    public CustomUser(UserEntity user) {
        super(user.getUsername(), user.getPassword(), user.getGrantedAuthoritiesList());
    }

}
