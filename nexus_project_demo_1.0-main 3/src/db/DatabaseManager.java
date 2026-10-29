package db;

import exception.DataAccessException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = DatabaseManager.class.getResourceAsStream("/application.properties")) {
            if (input == null) {
                try (InputStream clInput = DatabaseManager.class.getClassLoader().getResourceAsStream("application.properties")) {
                    if (clInput == null) {
                        throw new RuntimeException("Unable to find application.properties in classpath");
                    }
                    props.load(clInput);
                }
            } else {
                props.load(input);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load database configuration", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
        );
    }

    public static void initTables() {
        String schema = """
            CREATE TABLE IF NOT EXISTS users (
                id VARCHAR(50) PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                level INT DEFAULT 1,
                current_xp INT DEFAULT 0,
                rank VARCHAR(20) DEFAULT 'E_RANK'
            );

            CREATE TABLE IF NOT EXISTS tasks (
                id VARCHAR(50) PRIMARY KEY,
                user_id VARCHAR(50) NOT NULL,
                task_type VARCHAR(20) NOT NULL,
                title VARCHAR(255) NOT NULL,
                description TEXT,
                base_xp INT NOT NULL,
                completed BOOLEAN DEFAULT FALSE,
                target_score INT,
                FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
            );
        """;

        try (Connection conn = getConnection(); var stmt = conn.createStatement()) {
            stmt.execute(schema);
            System.out.println("[DATABASE] H2 Schema initialized from application.properties.");
        } catch (SQLException e) {
            throw new DataAccessException("Failed to initialize database tables", e);
        }
    }
}