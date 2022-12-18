package solvers;

import database.ThreeVariableEquationDataProvider;
import database.ThreeVariableEquationDataProviderInterface;
import database.TwoVariableEquationDataProvider;
import database.TwoVariableEquationDataProviderInterface;
import model.ThreeVariableEquation;
import model.User;
import java.util.Arrays;
import java.util.Scanner;
import model.TwoVariableEquation;

/**
 *
 * @author Alany Souza 2021345 and Thaynna Vieira 2021288
 */


public class EquationService {
    private Scanner scanner;
    private ThreeVariableEquationDataProviderInterface threeVariableEquationDataProvider;
    private TwoVariableEquationDataProviderInterface twoVariableEquationDataProvider;
    private User user;

    public EquationService() {
        this.scanner = new Scanner(System.in);
        threeVariableEquationDataProvider = new ThreeVariableEquationDataProvider();
        twoVariableEquationDataProvider = new TwoVariableEquationDataProvider();
    }

       
   
    public void setUser(User user) {
        this.user = user;
    }

    public void showActions() {
        System.out.println("Please enter the number corresponding to the equation you want to solve");
        System.out.println("2.) Two Variable Equation");
        System.out.println("3.) Three Variable Equation");
        System.out.println("Enter '2' or '3'");

        int action = scanner.nextInt();
        System.out.printf("You have specified that you want to solve a %d variable equation \n", action);

        if (action == 2) {
            solveSimultaneousEqWith2Variables();
        } else if (action == 3) {
            solveSimultaneousEqWith3Variables();
        } else {
            System.out.println("Invalid variable number. This program can only solve 2 and 3 variable simultaneous equations");
        }
    }


    private void solveSimultaneousEqWith2Variables() {
        System.out.println("******** 2 variable simultaneous equation equation ********");
        
        // Display message for asking user to enter input
        System.out.println("Enter the coefficients of 2 variable");
        System.out.println("Enter in the format shown below");
        System.out.println("ax + by + c = d");
        System.out.println("For example, input: '1 2 3' represents 1x + 2y + 3 = 0");
        
        // Dealing with linear equations of 2 coefficients
        
        double[][] matrix = new double[2][2];
        double[] x_coeff = new double[2];
        double[] y_coeff = new double[2];
        double[] equals = new double[2];
        
        
        for (int i
                = 0; i < 2; i++) {
            // Inner loop for iterating columns
            for (int j = 0; j < 2; j++) {

                // Reading values from user and
                // entering in the matrix form
                int next = scanner.nextInt();
                matrix[i][j] = next;
                if (j == 0) {
                    x_coeff[i] = next;
                } else if (j == 1) {
                    y_coeff[i] = next;
                }
            }

            // One row input is over by now
            double e = scanner.nextInt();
            e = e*=-1;
            equals[i] = e;
        }
        char[][] operators = new char[2][2];
        for (char[] op : operators) {
            Arrays.fill(op, '+');
        }

        for (int i = 0; i < 2; i++) {
            if (y_coeff[i] < 0) {
                operators[i][0] = '-';
            }
             if (equals[i] > 0) { // greater than because we stored flipped value in array i.e 5 -> -5
                operators[i][1] = '-';
            }
        }
        
         System.out.println("Solving simultaneously the equations:");
        //Print as an equation
        double printEqualsVar1 = equals[0];
        printEqualsVar1 *= -1;
        double printEqualsVar2 = equals[1];
        printEqualsVar2 *= -1;
        
        System.out.printf("%20fx %s %fy %s %f= %d%n", x_coeff[0], operators[0][0], Math.abs(y_coeff[0]), operators[0][1],  Math.abs(printEqualsVar1), 0);
        System.out.printf("%20fx %s %fy %s %f = %d%n", x_coeff[1], operators[1][0], Math.abs(y_coeff[1]), operators[1][1],  Math.abs(printEqualsVar2), 0);
        System.out.println(equals[0]);
        System.out.println(equals[1]);
       
        System.out.printf("%n%30s%n%40s", "Yields:", "(x, y)  =  ");
        
         try {
            TwoVariablesCalculator sim2unk;
            sim2unk = new TwoVariablesCalculator(x_coeff, y_coeff, equals);
            double[] result3D = sim2unk.solveSimultaneous();
            System.out.printf("(%.2f, %.2f" + "" + ")%n", result3D[0], result3D[1]);
            saveTwoVariableEquation(x_coeff,y_coeff,equals,result3D[0], result3D[1],user);
        } catch (ArithmeticException e) {
            System.out.printf("(%s, %s)%n", "âˆž", "âˆž");
        }
    }


    private void solveSimultaneousEqWith3Variables() {
        System.out.println("******** 3 variable simultaneous equation equation ********");

        // Display message for asking user to enter input
        System.out.println("Enter the coefficients of 3 variable");
        System.out.println("Enter in the format shown below");
        System.out.println("ax + by + cz = d");
        System.out.println("For example, input: '1 2 3 6' represents 1x + 2y + 3z = 6");

        // For 3*3 matrix or in other words
        // Dealing with linear equations of 3 coefficients
        int[][] matrix = new int[3][3];
        int[] x_coeff = new int[3];
        int[] y_coeff = new int[3];
        int[] z_coeff = new int[3];
        int[] equals = new int[3];
        for (int i = 0; i < 3; i++) {
            // Inner loop for iterating columns
            for (int j = 0; j < 3; j++) {

                // Reading values from usr and
                // entering in the matrix form
                int next = scanner.nextInt();
                matrix[i][j] = next;
                if (j == 0) {
                    x_coeff[i] = next;
                } else if (j == 1) {
                    y_coeff[i] = next;
                } else {
                    z_coeff[i] = next;
                }
            }

            // One row input is over by now
            equals[i] = scanner.nextInt();
        }

        char[][] operators = new char[3][2];
        for (char[] op : operators) {
            Arrays.fill(op, '+');
        }

        for (int i = 0; i < 3; i++) {
            if (y_coeff[i] < 0) {
                operators[i][0] = '-';
            }
            if (z_coeff[i] < 0) {
                operators[i][1] = '-';
            }
        }

        System.out.println("Solving simultaneously the equations:");
        //Print as an equation
        System.out.printf("%20dx %s %dy %s %dz = %d%n", x_coeff[0], operators[0][0], Math.abs(y_coeff[0]), operators[0][1], Math.abs(z_coeff[0]), equals[0]);
        System.out.printf("%20dx %s %dy %s %dz = %d%n", x_coeff[1], operators[1][0], Math.abs(y_coeff[1]), operators[1][1], Math.abs(z_coeff[1]), equals[1]);
        System.out.printf("%20dx %s %dy %s %dz = %d%n", x_coeff[2], operators[2][0], Math.abs(y_coeff[2]), operators[2][1], Math.abs(z_coeff[2]), equals[2]);
        System.out.printf("%n%30s%n%40s", "Yields:", "(x, y, z)  =  ");

        try {
            ThreeVariableCalculator sim3unk;
            sim3unk = new ThreeVariableCalculator(x_coeff, y_coeff, z_coeff, equals);
            double[] result3D = sim3unk.solveSimultaneous();
            System.out.printf("(%.2f, %.2f, %.2f)%n", result3D[0], result3D[1], result3D[2]);
            saveThreeVariableEquation(x_coeff,y_coeff,z_coeff,equals,result3D[0], result3D[1], result3D[2],user);
        } catch (ArithmeticException e) {
            System.out.printf("(%s, %s, %s)%n", "∞", "∞", "∞");
        }
    }


    private void saveThreeVariableEquation(int[] x_coeff, int[] y_coeff, int[] z_coeff, int[] equals, double x, double y, double z, User user) {
        String xMatrices =convertToCsv(x_coeff);
        String yMatrices =convertToCsv(y_coeff);
        String zMatrices =convertToCsv(z_coeff);
        String equalsMatrices =convertToCsv(equals);

        System.out.println("Saving Three variable equation for user: " + user.getFirstName() + " "+ user.getLastName());
        ThreeVariableEquation threeVariableEquation = new ThreeVariableEquation(xMatrices,yMatrices,zMatrices,equalsMatrices,x,y,z, user.getId());
        threeVariableEquationDataProvider.save(threeVariableEquation);
        System.out.println("Saved Three variable equation for user: " + user.getFirstName() + " "+ user.getLastName());
    }

    private void saveTwoVariableEquation(double[] x_coeff, double[] y_coeff, double[] equals, double x, double y, User user) {
        String xMatrices =convertToCsv(x_coeff);
        String yMatrices =convertToCsv(y_coeff);
        String equalsMatrices =convertToCsv(equals);

        System.out.println("Saving Two variable equation for user: " + user.getFirstName() + " "+ user.getLastName());
        TwoVariableEquation twoVariableEquation = new TwoVariableEquation(xMatrices,yMatrices,equalsMatrices,x,y, user.getId());
        twoVariableEquationDataProvider.save(twoVariableEquation);
        System.out.println("Saved Two variable equation for user: " + user.getFirstName() + " "+ user.getLastName());
    }
    
    private String convertToCsv(int[] matrices) {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<matrices.length;i++)
        {
            sb.append(matrices[i]);
            if(i != matrices.length-1)
            {
                sb.append(",");
            }
        }
        return sb.toString();
    }
    
      private String convertToCsv(double[] matrices) {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<matrices.length;i++)
        {
            int val = (int)matrices[i];
            sb.append(val);
            if(i != matrices.length-1)
            {
                sb.append(",");
            }
        }
        return sb.toString();
    }


    
    
}
