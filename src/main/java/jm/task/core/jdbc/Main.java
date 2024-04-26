package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
        // реализуйте алгоритм здесь

        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        //userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser ("Платон", "Кабаков", (byte)11 );
        System.out.println(userDaoHibernate.getAllUsers());
        userDaoHibernate.removeUserById(Long.parseLong("2"));
        //userDaoHibernate.cleanUsersTable();
        //userDaoHibernate.dropUsersTable();
    }
}
