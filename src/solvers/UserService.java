package solvers;

import database.UserDataProvider;
import database.UserDataProviderInterface;
import model.User;

import java.util.Scanner;
/**
 *
 * @author Alany Souza 2021345 and Thaynna Vieira 2021288
 */

//Provides options for the users
public class UserService {
    private Scanner scanner;
    private UserDataProviderInterface userDataProvider;

    private User user;

    public UserService() {
        this.scanner = new Scanner(System.in);
        this.userDataProvider = new UserDataProvider(); //accesses the DB to verify user informations
    }

    public void setUser(User user) {
        this.user = user;
    }


    public User login() {
        System.out.println("Login process started");
        System.out.println("You will be prompted to enter your username and password");
        System.out.println("Please enter your username");
        String username = scanner.next();
        System.out.println("Please enter your password");
        String password = scanner.next();

        //verify user credentials inside the DB
        User user = userDataProvider.findByUsername(username);
        boolean validLogin = false;
        if(user != null) { 
            validLogin = user.getPassword().equals(password);
        }
        if(validLogin) { //if the user is in the DB, the system output an Welcome message
            System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName() + ". You have logged in successfully");
        }
        else {
            System.out.println("Could not find user with entered credentials"); ////displays an error message in case user is not in the DB
        }
        return user;
    }

    //check what type of user is using the program
    public void showUserActions() {
        if(user.isAdmin()) {
            showAdminUserActions();
        }
        else {
            showRegularUserActions();
        }
    }

    //set up options for the ADM (not all functions are working)
    private void showAdminUserActions() {
        while (true) {
            System.out.println("As an admin you are able to perform the following actions");
            System.out.println("Please enter the number corresponding to the action you want to perform");
            System.out.println("1.) Update first name");
            System.out.println("2.) Update last name");
            System.out.println("3.) View all two variable equations and solutions");
            System.out.println("4.) View all three variable equations and solutions");
            System.out.println("6.) List all users");
            System.out.println("7.) Delete a user");
            System.out.println("8.) Exit user action menu");
            int action = scanner.nextInt();
            if (action == 1) {
                updateFirstName();
            }
            else if (action == 2) {
                updateLastName();
            }
            else if (action == 3) {
                System.out.println("This is action is not available yet...");
            }
            else if (action == 4) {
                System.out.println("This is action is not available yet...");
            }
            else if (action == 5) {
                System.out.println("This is action is not available yet...");
            }
            else if (action == 6) {
                System.out.println("This is action is not available yet...");
            }
            else if (action == 7) {
                System.out.println("This is action is not available yet...");
            }
            else if (action == 8) {
                System.out.println("Exiting User action menu...");
                break;
            }
            else {
                System.out.println("Unknown admin user action entered");
            }
        }
    }
    
    //set up options for the Regular User
    private void showRegularUserActions() {
        while (true) {
            System.out.println("As a regular user you are able to perform the following actions");
            System.out.println("Please enter the number corresponding to the action you want to perform");
            System.out.println("1.) Update first name");
            System.out.println("2.) Update last name");
            System.out.println("3.) View all two variable equations and solutions");
            System.out.println("4.) View all three variable equations and solutions");
            System.out.println("5.) Exit user action menu");
            int action = scanner.nextInt();
            if (action == 1) {
                updateFirstName();
            }
            else if (action == 2) {
                updateLastName();
            }
            else if (action == 3) {
                System.out.println("This is action is not available yet...");
            }
            else if (action == 4) {
                System.out.println("This is action is not available yet...");
            }
            else if (action == 5) {
                System.out.println("Exiting User action menu...");
                break;
            }
            else {
                System.out.println("Unknown user action entered");
            }
        }
    }

    //Allows user to change the Name
    private void updateFirstName() {
        System.out.println("Please enter a new first name value");
        String value = scanner.next();
        if (value != null) {
            userDataProvider.updateFirstName(user.getId(),value.trim());
        }
    }

    private void updateLastName() {
        System.out.println("Please enter a new last name value");
        String value = scanner.next();
        if (value != null) {
            userDataProvider.updateLastName(user.getId(),value.trim());
        }
    }
    

}
