package ru.buevich.kata_test9.service;

import ru.buevich.kata_test9.models.User;
import java.util.List;

public interface UserService {
    void add(User user);
    List<User> allUsers();
    public User findById(Long id);
    void updateUser(User user);
    void deleteById(Long id);
}
