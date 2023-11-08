package ru.chernyshev.spring_boot.service;

import ru.chernyshev.spring_boot.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User show(Long id);

    public void save(User user);

    public void update(Long id, User updatedUser);

    public void delete(Long id);
}
