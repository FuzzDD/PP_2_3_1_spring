package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    @Override
    public List<User> getUsersList() {
        return userDao.getUsersList();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User show(int id) {
        return userDao.show(id);
    }

    @Override
    public void update(int id, User updatetUser) {
    userDao.update(id, updatetUser);
    }

    @Override
    public void delete(int id) {
    userDao.delete(id);
    }
}
