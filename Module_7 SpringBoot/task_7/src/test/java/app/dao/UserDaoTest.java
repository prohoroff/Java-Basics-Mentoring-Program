package app.dao;

import app.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    void findByNameLikeTest() {
        User user1 = new User("test", "test@gmail.com");
        User user2 = new User("test", "test@test.com");
        User user3 = new User("test", "test@kaka.com");

        assertEquals(0, userDao.findAll().size());
        userDao.save(user1);
        userDao.save(user2);
        userDao.save(user3);
        assertEquals(3, userDao.findAll().size());

        List<User> byEmailLike = userDao.findByEmailLike("%gmail%");
        assertEquals(1, byEmailLike.size());
    }

}