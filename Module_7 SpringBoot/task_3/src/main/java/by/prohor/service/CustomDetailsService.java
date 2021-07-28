package by.prohor.service;

import by.prohor.autentification.CustomUser;
import by.prohor.dao.UserDao;
import by.prohor.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Artsiom Prokharau 26.07.2021
 */

@Service
public class CustomDetailsService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public CustomUser loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserEntity userEntity;
        try {
            userEntity = userDao.getUserDetails(username);
            return new CustomUser(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
    }
}
