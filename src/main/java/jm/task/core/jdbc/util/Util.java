package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Util {
//    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//    private final static String URL = "jdbc:mysql://localhost:3306/bd_test";
//    private final static String USERNAME = "root";
//    private final static String PASSWORD = "Platon1404!";

    private static final String BD_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String BD_URL = "jdbc:mysql://localhost:3306/bd_test";
    private static final String BD_USERNAME = "root";
    private static final String BD_PASSWORD = "Platon1404!";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(BD_DRIVER);
            connection = DriverManager.getConnection(BD_URL, BD_USERNAME, BD_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
//    public static void main(String[] args) {
//        try (Connection connection = Util.getConnection()) {
//            System.out.println("Connection successful!");
//            // здесь можно добавить код для выполнения тестовых операций с базой данных
//        } catch (Exception e) {
//            System.err.println("Connection failed: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
}


