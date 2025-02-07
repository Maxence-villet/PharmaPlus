package Feature_User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginSystem {
    private Map<String, User> users;
    private Scanner scanner;

    public LoginSystem() {
        users = new HashMap<>();
        scanner = new Scanner(System.in);
        users.put("admin", new User("admin", new AdminRole()));
        users.put("employee", new User("employee", new EmployeeRole()));
    }

    public User login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && password.equals("password")) {
            System.out.println("✅ Login successful!");
            return users.get(username);
        } else {
            System.out.println("❌ Login failed. Invalid username or password.");
            return null;
        }
    }
}