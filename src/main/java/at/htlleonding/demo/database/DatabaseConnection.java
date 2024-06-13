package at.htlleonding.demo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String CONNECTION_STRING = "jdbc:derby:database;create=true";

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() { }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(CONNECTION_STRING);
            }
        } catch (SQLException e) {
            System.err.println("Error (getConnection): " + e.getMessage());
            e.printStackTrace();
        }

        return connection;
    }

    public void closeConnection() {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException ignored) {
        }
    }
}