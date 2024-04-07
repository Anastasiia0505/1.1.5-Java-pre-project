package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Анастасия", "Прозорова", (byte) 35);
        userService.saveUser("Платон", "Кабаков", (byte) 10);
        userService.saveUser("Александр", "Кабаков", (byte) 35);
        userService.saveUser("Екатерина", "Старунчак", (byte) 33);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
