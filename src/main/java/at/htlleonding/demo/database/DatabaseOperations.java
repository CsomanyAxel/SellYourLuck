package at.htlleonding.demo.database;

import at.htlleonding.demo.model.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class DatabaseOperations {
    public static int addGame(String length, int points, int sells) {
        DatabaseConnection database = DatabaseConnection.getInstance();

        String query = "INSERT INTO game (LENGTH, POINTS, SELLS) VALUES (?, ?, ?)";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, length);
            stmt.setInt(2, points);
            stmt.setInt(3, sells);
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }

            database.closeConnection();
        } catch (SQLException e) {
            System.err.println("Error (addGame): " + e.getMessage());
            e.printStackTrace();
        }

        return -1;
    }

    /*
    public static Game getGame(int id) {
        DatabaseConnection database = DatabaseConnection.getInstance();

        String query = "SELECT * FROM GAME WHERE ID = ?";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Game(rs.getInt("ID"), rs.getString("LENGTH"), rs.getInt("POINTS"), rs.getInt("SELLS"));
                }
            }

            database.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

     */

    public static LinkedList<Game> getAllGames() {
        DatabaseConnection database = DatabaseConnection.getInstance();
        LinkedList<Game> games = new LinkedList<>();

        String query = "SELECT * FROM game ORDER BY ID DESC";
        try (Connection conn = database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                games.add(new Game(rs.getInt("ID"), rs.getString("LENGTH"), rs.getInt("POINTS"), rs.getInt("SELLS")));
            }

            database.closeConnection();
        } catch (SQLException e) {
            System.err.println("Error (getAllGames): " + e.getMessage());
            e.printStackTrace();
        }

        return games;
    }
}
