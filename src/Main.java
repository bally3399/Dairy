import controllers.DiaryControllers;
import dtos.requests.CreateEntryRequest;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;


import javax.swing.*;

public class Main {
    private static DiaryControllers controllers;

    public static void main(String[] args) {
        display();

    }

    public static void display() {
        String display = """
                Welcome to My Diary
                1.Register user
                2.Login
                3.Create Entry
                4.UpdateEntry
                5.Logout
                6.Exit Application
                """;
        String choice = input(display);
        switch (choice.charAt(0)) {
            case '1':
                registerUser();
            case '2':
                login();
            case '3':
                CreateEntry();
            case '4':
                updateEntry();
            case '5':
                logout();
            case '6':
                exitApplication();
            default:
                display();
        }


    }

    private static void exitApplication() {
        System.exit(8);
    }

    private static void updateEntry() {
        String title = input("Enter title");
        String body = input("Enter body");
        String author = input("Enter your name");
        CreateEntryRequest updateEntry = new CreateEntryRequest();
        updateEntry.setTitle(title);
        updateEntry.setBody(body);
        updateEntry.setAuthor(author);
        print(controllers.update(updateEntry));
        display();

    }

    private static void login() {
        String username = input("Enter your name: ");
        String password = input("Enter your password");
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(username);
        loginRequest.setPassword(password);
        print(controllers.login(loginRequest));
        display();
    }

    private static void registerUser() {
        String username = input("Enter your name: ");
        String password = input("Enter your password");
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername(username);
        registerRequest.setPassword(password);
        print(controllers.register(registerRequest));
        display();

    }

    private static void CreateEntry() {
        String title = input("Enter title: ");
        String body = input("Enter  body: ");
        CreateEntryRequest createEntryRequest = new CreateEntryRequest();
        createEntryRequest.setBody(body);
        createEntryRequest.setTitle(title);
        print(controllers.createEntry(createEntryRequest));
        display();

    }

    private static String input(String display) {
        print(display);
        return JOptionPane.showInputDialog(null, display);
    }

    private static void print(String input) {
        JOptionPane.showMessageDialog(null, input);

    }

    private static void logout() {
        String username = input("Enter your password");
        print(controllers.logout(username));
        display();
    }
}