package ru.buevich.kata_test9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.buevich.kata_test9.dao.UserDao;
import ru.buevich.kata_test9.models.User;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Transactional
    @Override
    public User findById(Long id) { return userDao.findById(id); }

    @Transactional
    @Override
    public void updateUser(User user) { userDao.updateUser(user); }

    @Transactional
    @Override
    public void deleteById(Long id) { userDao.deleteById(id); }
}
