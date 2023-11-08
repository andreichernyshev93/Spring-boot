package ru.chernyshev.spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.chernyshev.spring_boot.dao.UserDao;
import ru.chernyshev.spring_boot.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User show(Long id) {
        return userDao.show(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(Long id, User updatedUser) {
        userDao.update(id, updatedUser);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
