package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoJDBCImpl();

    @Override
    public void createUsersTable() throws SQLException {
    userDao.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userDao.dropUsersTable();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
    userDao.saveUser(name,lastName,age);
        System.out.println("User с именем " + name + " " + lastName + " добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) {
    userDao.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {

        try {
            return userDao.getAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
        System.out.println("Данные удалены");

    }
}
