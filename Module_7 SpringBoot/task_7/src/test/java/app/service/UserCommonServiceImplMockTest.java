package app.service;

import app.dao.UserDao;
import app.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserCommonServiceImplMockTest {

    @InjectMocks
    UserCommonServiceImpl userCommonServiceImpl;

    @Mock
    UserDao userDao;

    @Test
    void createTest() {
        User user = new User("test", "test@gmail.com");
        when(userDao.save(any(User.class))).thenReturn(user);

        assertNotNull(userCommonServiceImpl.create(user));

        verify(userDao, times(1)).save(user);
    }

    @Test
    void getAll() {
        List<User> users = Arrays.asList(new User(), new User(), new User());
        when(userDao.findAll()).thenReturn(users);

        assertEquals(3, userCommonServiceImpl.getAll().size());

        verify(userDao, times(1)).findAll();
    }

    @Test
    void findById() {
        User user = new User("test", "test@gmail.com");
        long id = user.getId();
        when(userDao.findById(any(Long.class))).thenReturn(java.util.Optional.of(user));

        assertNotNull(userCommonServiceImpl.findById(id));

        verify(userDao, times(1)).findById(id);
    }

    @Test
    void update() {
        User user = new User("test", "test@gmail.com");
        when(userDao.save(any(User.class))).thenReturn(user);

        userCommonServiceImpl.update(user);

        verify(userDao, times(1)).save(user);
    }

    @Test
    void delete() {
        userCommonServiceImpl.delete(1);

        verify(userDao, times(1)).deleteById(1L);
    }


}