import db.DatabaseManager;
import db.H2TaskRepositoryImpl;
import db.H2UserRepositoryImpl;
import db.TaskRepository;
import db.UserRepository;
import model.*;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== [NEXUS SYSTEM INITIALIZED - V4.0 ARCHITECTURE] ===\n");

        DatabaseManager.initTables();

        UserRepository userRepository = new H2UserRepositoryImpl();
        TaskRepository taskRepository = new H2TaskRepositoryImpl();

        String userId = "user_001";
        User user = new User(userId, "Iskander");
        user.addXp(450); // Level 3, Rank D_RANK

        System.out.println("--- [PERSISTENCE: SAVING USER & TASKS] ---");
        userRepository.save(user);
        System.out.println("Saved User: " + user.getName() + " (Level " + user.getLevel() + ", Rank " + user.getRank() + ")");

        Task daily = new DailyTask("D10", "Read Clean Architecture", "Read Chapter 3 for 30 mins", 100);
        Task global = new GlobalQuest("Q10", "CTEC Exam", "Final Assessment", 300, 95);

        taskRepository.saveTaskWithUserId(daily, userId);
        taskRepository.saveTaskWithUserId(global, userId);
        System.out.println("Saved 2 tasks for user: " + userId);

        System.out.println("\n--- [PERSISTENCE: LOADING FROM H2 DATABASE] ---");

        Optional<User> loadedUserOpt = userRepository.findById(userId);
        if (loadedUserOpt.isPresent()) {
            User loadedUser = loadedUserOpt.get();
            System.out.println("Successfully restored User from H2:");
            System.out.println(" -> ID: " + loadedUser.getId());
            System.out.println(" -> Name: " + loadedUser.getName());
            System.out.println(" -> Level: " + loadedUser.getLevel());
            System.out.println(" -> Current XP: " + loadedUser.getCurrentXp());
            System.out.println(" -> Rank: " + loadedUser.getRank());
        } else {
            System.err.println("User not found in H2 DB!");
        }

        List<Task> loadedTasks = taskRepository.findByUserId(userId);
        System.out.println("\nSuccessfully loaded " + loadedTasks.size() + " tasks from H2:");
        for (Task t : loadedTasks) {
            System.out.println(" -> [" + t.getClass().getSimpleName() + "] " + t.getTitle() + " (XP: " + t.getBaseXp() + ")");
        }
    }
}