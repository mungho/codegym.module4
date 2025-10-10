package org.example.form_validation.service;

import org.example.form_validation.entity.User;
import org.example.form_validation.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean addUser(User user) {
        return userRepository.save(user) != null;
    }

    @Override
    public boolean updateUser(User user) {
        return userRepository.save(user) != null;
    }

    @Override
    public boolean deleteUser(User user) {
        if (userRepository.existsById(user.getId())) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }
}
