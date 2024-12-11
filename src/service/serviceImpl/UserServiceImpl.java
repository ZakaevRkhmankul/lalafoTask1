package service.serviceImpl;

import dao.UserDao;
import dao.daoImpl.UserDaoImpl;
import models.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public void updateUserById(Long id, String username, String password, String newPassword) {
        userDao.updateUserById(id, username, password, newPassword);
    }

    @Override
    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
    }
}
