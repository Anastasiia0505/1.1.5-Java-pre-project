package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь

        //UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        //userDaoHibernate.createUsersTable();
        //userDaoHibernate.saveUser ("Платон", "Кабаков", (byte)11 );
        //System.out.println(userDaoHibernate.getAllUsers());
       // userDaoHibernate.removeUserById(Long.parseLong("2"));
        //userDaoHibernate.cleanUsersTable();
        //userDaoHibernate.dropUsersTable();
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Платон", "Кабаков", (byte) 11);
        System.out.println(userService.getAllUsers());
        userService.removeUserById(Long.parseLong("2"));
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
