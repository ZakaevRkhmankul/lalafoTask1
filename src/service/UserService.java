package service;

import models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getUsers();
    User getUser(Long id);
    void updateUserById(Long id,String username,String newPassword);
    void deleteUserById(Long id);
}
