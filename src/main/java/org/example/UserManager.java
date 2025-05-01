package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static List<User> users = new ArrayList<>();
    private static User currentUser;

    /**
     * Checks if a user matches the given username and password, and then logs into that account
     * Helper method for the login method in the user class
     * @param username input username
     * @param password input password
     * @return true if the user has successfully logged in, otherwise false
     */
    public static boolean loginHelper(String username, String password) {
        for (User user : users) {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
                System.out.println("Login successful");
                currentUser = user;
                return true;
            }
        }
        System.out.println("Invalid username or password");
        return false;
    }

    /**
     * Logs out the currently logged-in user
     * Helper method for the logout method in the user class
     * @return true if the user has successfully been logged out, otherwise false
     */
    public static boolean logoutHelper() {
        if (currentUser != null) {
            System.out.println("You have successfully been logged out");
            currentUser = null;
            return true;
        }
        System.out.println("No user is currently logged in");
        return false;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}
