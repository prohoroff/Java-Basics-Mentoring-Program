package app.dao;


import app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Artsiom Prokharau 26.07.2021
 */


@Repository
public interface UserDao extends JpaRepository<User,Long> {
    List<User> findByEmailLike(String likeName);
}
