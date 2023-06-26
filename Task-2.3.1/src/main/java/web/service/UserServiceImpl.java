package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
public class  UserServiceImpl implements UserService{
    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void add(User user) {
        userDao.add(user);

    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateUser(int id,User updateUser) {
        userDao.updateUser(id,updateUser);

    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);

    }
}
