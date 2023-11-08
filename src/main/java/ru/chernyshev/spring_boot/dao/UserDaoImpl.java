package ru.chernyshev.spring_boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.chernyshev.spring_boot.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User show(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(Long id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(show(id));
    }
}
