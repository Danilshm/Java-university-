package db;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDao {

    public void saveUser(User user, String userId) {
        String sql = "MERGE INTO users (id, name, level, current_xp, rank) KEY(id) VALUES (?, ?, ?, ?, ?)";
        try (var conn = DatabaseManager.getConnection(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, user.getName());
            pstmt.setInt(3, user.getLevel());
            pstmt.setInt(4, user.getCurrentXp());
            pstmt.setString(5, user.getRank().name());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("[DAO ERROR] Save user failed: " + e.getMessage());
        }
    }

    public void saveTask(Task task, String userId) {
        String sql = "MERGE INTO tasks (id, user_id, task_type, title, description, base_xp, completed, target_score) " +
                "KEY(id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        String type = switch (task) {
            case DailyTask d -> "DAILY";
            case WeeklyTask w -> "WEEKLY";
            case GlobalQuest g -> "GLOBAL";
            default -> throw new IllegalArgumentException("Unsupported task type");
        };

        try (var conn = DatabaseManager.getConnection(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task.getId());
            pstmt.setString(2, userId);
            pstmt.setString(3, type);
            pstmt.setString(4, task.getTitle());
            pstmt.setString(5, task.getDescription());
            pstmt.setInt(6, task.getBaseXp());
            pstmt.setBoolean(7, task.isCompleted());

            if (task instanceof GlobalQuest gq) {
                pstmt.setInt(8, gq.getTargetScore());
            } else {
                pstmt.setNull(8, Types.INTEGER);
            }

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("[DAO ERROR] Save task failed: " + e.getMessage());
        }
    }

    public List<Task> loadTasksByUserId(String userId) {
        var tasks = new ArrayList<Task>();
        String sql = "SELECT * FROM tasks WHERE user_id = ?";

        try (var conn = DatabaseManager.getConnection(); var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            try (var rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String title = rs.getString("title");
                    String desc = rs.getString("description");
                    int baseXp = rs.getInt("base_xp");

                    Task task = switch (rs.getString("task_type")) {
                        case "DAILY" -> new DailyTask(id, title, desc, baseXp);
                        case "WEEKLY" -> new WeeklyTask(id, title, desc, baseXp);
                        case "GLOBAL" -> new GlobalQuest(id, title, desc, baseXp, rs.getInt("target_score"));
                        default -> throw new IllegalStateException("Unknown task type");
                    };

                    task.setCompleted(rs.getBoolean("completed"));
                    tasks.add(task);
                }
            }
        } catch (SQLException e) {
            System.err.println("[DAO ERROR] Load tasks failed: " + e.getMessage());
        }
        return tasks;
    }
}