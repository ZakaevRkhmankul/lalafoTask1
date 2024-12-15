package dao.daoImpl;

import dao.UserDao;
import database.Database;
import models.User;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) {
        System.out.println(Database.users.add(user));
    }

    @Override
    public List<User> getUsers() {
        return Database.users;
    }

    @Override
    public User getUser(Long id) {
        for (User user : Database.users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void updateUserById(Long id, String name, String newPassword) {
        for (User user : Database.users) {
            if (user.getId().equals(id)) {
                user.setName(name);
                user.setPassword(newPassword);
                System.out.println(user);
            }
        }
    }

    @Override
    public void deleteUserById(Long id) {
        for (User user : Database.users) {
            if (user.getId().equals(id)) {
                System.out.println(Database.users.remove(user));
            }
        }
    }
}
