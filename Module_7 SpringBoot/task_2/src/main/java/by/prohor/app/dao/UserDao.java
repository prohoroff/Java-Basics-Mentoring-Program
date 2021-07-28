package by.prohor.app.dao;

import by.prohor.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Artsiom Prokharau 26.07.2021
 */


public interface UserDao extends JpaRepository<User,Long> {
}
