package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/my_database";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "12345";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection is established");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection is not established");
        }
        return connection;
    }
    public static void closeConnection() throws SQLException {
        if (getConnection() != null) {
            getConnection().close();
            System.out.println("Connection closed");
        }
    }
    // должна быть добавлена конфигурация для Hibernate ( рядом с JDBC), без использования xml.
}
