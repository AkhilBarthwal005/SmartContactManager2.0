package com.scm.services;

import com.scm.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    User getUserByEmail(String email);
    User getUserById(Long id);
    void deleteUser(User user);
    void changePassword(User user, String newPassword);
    void forgotPassword(String email);
    List<User> getAllUsers();

}
