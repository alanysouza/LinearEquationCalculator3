package solvers;

import model.User;

import java.util.Scanner;

/**
 *
 * @author Alany Souza 2021345 and Thaynna Vieira 2021288
 */

    //MUST USE THE USER:CCT AND THE PASSWORD:Dublin TO CONNECT AS AN ADM
    //MUST USE THE USER:Alany PASSWORD:2021235 TO CONNECT AS AN REGULAR USER
    

public class EquationApp {
    private Scanner scanner;
    private UserService userService;
    private EquationService equationService;

    public static void main(String[] args) {
        EquationApp application = new EquationApp();
        application.start();
    }

    public EquationApp() {
        this.scanner = new Scanner(System.in); //Scanner to get the user input
        this.userService = new UserService();
        this.equationService = new EquationService();
    }

    //get user login
    private void start() {
        System.out.println("Welcome to Alany's and Thaynna simultaneous equation solver");//Welcome message
        User user = userService.login();
        while (user == null) {
            System.out.println("Please try again"); //displays an error message in case user is not in the database
            user = userService.login();
        }
        this.userService.setUser(user);
        this.equationService.setUser(user);
        showMainMenuOptions();
    }

    //presents the user with the options menu
    private void showMainMenuOptions() {
        while (true) {
            System.out.println("Please select the action you would like to perform");
            System.out.println("Enter '1' to  view actions your user can perform");
            System.out.println("Enter '2' to solve simultaneous equations");
            System.out.println("Enter '3' to exit the application");
            int action = scanner.nextInt();
            if (action == 1) {
                userService.showUserActions();
            } else if (action == 2) {
                equationService.showActions();
            } else if (action == 3) {
                System.out.println("Exiting Equation App..."); 
                System.exit(0);
            } else { //in case the user makes an invalid input
                System.out.println("Unknown action entered"); 
                System.out.println("Please enter a valid option. 1, 2, or 3");
            }
        }
    }

}
