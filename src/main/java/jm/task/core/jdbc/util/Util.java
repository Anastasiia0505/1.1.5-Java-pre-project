package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {

    private static final String BD_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String BD_URL = "jdbc:mysql://localhost:3306/bd_test";
    private static final String BD_USERNAME = "root";
    private static final String BD_PASSWORD = "Platon1404!";
    private static Session session = null;


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
    public static Session getSession() {
        if (session == null) {
            Configuration configuration = new Configuration();
            Properties settings = new Properties();
            settings.put(Environment.URL, BD_URL);
            settings.put(Environment.USER, BD_USERNAME);
            settings.put(Environment.PASS, BD_PASSWORD);
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            settings.put(Environment.SHOW_SQL, "true");
            configuration.setProperties(settings);
            configuration.addAnnotatedClass(User.class);
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            session = sessionFactory.openSession();

        }
        return session;
    }

}


