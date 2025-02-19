package ru.buevich.kata_test9.entity.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.buevich.kata_test9.entity.models.User;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) { entityManager.persist(user); }

    @Override
    public List<User> allUsers() {
        List<User> allUsers = entityManager.createQuery("from User", User.class).getResultList();
        return allUsers;
    }

    @Override
    public User findById(Long id) { return entityManager.find(User.class, id); }

    @Override
    public void updateUser(User user) { entityManager.merge(user); }

    @Override
    public void deleteById(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
