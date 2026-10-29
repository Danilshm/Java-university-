package db;

import exception.DataAccessException;
import model.User;
import model.Rank;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class H2UserRepositoryImpl implements UserRepository {

    @Override
    public User save(User user) {
        String sql = "MERGE INTO users (id, name, level, current_xp, rank) KEY(id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setInt(3, user.getLevel());
            pstmt.setInt(4, user.getCurrentXp());
            pstmt.setString(5, user.getRank().name());

            pstmt.executeUpdate();
            return user;
        } catch (SQLException e) {
            throw new DataAccessException("Failed to save user with ID: " + user.getId(), e);
        }
    }

    @Override
    public Optional<User> findById(String id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    int level = rs.getInt("level");
                    int currentXp = rs.getInt("current_xp");
                    Rank rank = Rank.valueOf(rs.getString("rank"));

                    // Восстанавливаем объект User с сохраненным состоянием
                    User user = new User(id, name, level, currentXp, rank);
                    return Optional.of(user);
                }
            }
        } catch (SQLException e) {
            throw new DataAccessException("Failed to load user with ID: " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                users.add(new User(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("level"),
                        rs.getInt("current_xp"),
                        Rank.valueOf(rs.getString("rank"))
                ));
            }
        } catch (SQLException e) {
            throw new DataAccessException("Failed to load all users", e);
        }
        return users;
    }

    @Override
    public boolean deleteById(String id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, id);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new DataAccessException("Failed to delete user with ID: " + id, e);
        }
    }

    @Override
    public Optional<User> findByName(String name) {
        return Optional.empty();
    }
}