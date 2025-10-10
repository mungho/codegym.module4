package org.example.form_validation.service;

import org.example.form_validation.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(User user);
}
