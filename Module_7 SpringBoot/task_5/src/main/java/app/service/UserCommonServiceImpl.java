package app.service;

import app.dao.UserDao;
import app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Artsiom Prokharau 26.07.2021
 */

@Service
public class UserCommonServiceImpl implements CommonService<User> {

    @Autowired
    UserDao userDao;

    @Override
    public User create(User entity) {
        return userDao.save(entity);
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(long id) {
        return userDao.findById(id).get();
    }

    @Override
    public void update(User entity) {
        userDao.save(entity);
    }

    @Override
    public void delete(long id) {
        userDao.deleteById(id);
    }
}
