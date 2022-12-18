
package solvers;
import solvers.TwoVariablesCalculator;

import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Alany Souza 2021345 and Thaynna Vieira 2021288
 */
public class ThreeVariableCalculator {
     private final int[] x_coefficients;
    private final int[] y_coefficients;
    private final int[] z_coefficients;
    private final int[] equals;
    private final double[][] eliminator;
    private double x_variable;
    private double y_variable;
    private double z_variable;

    public ThreeVariableCalculator(int[] x_coeff, int[] y_coeff, int[] z_coeff, int[] eq) {
        x_coefficients = new int[]{x_coeff[0], x_coeff[1], x_coeff[2]};
        y_coefficients = new int[]{y_coeff[0], y_coeff[1], y_coeff[2]};
        z_coefficients = new int[]{z_coeff[0], z_coeff[1], z_coeff[2]};
        equals = new int[]{eq[0], eq[1], eq[2]};
        eliminator = new double[3][3];
    }

    public double[] solveSimultaneous() {
        List<Integer> stooge;
        stooge = Arrays.asList(
                Math.abs(z_coefficients[0]),
                Math.abs(z_coefficients[1]),
                Math.abs(z_coefficients[2])
        );

        //Multiply equations 1, 2, & 3 by the LCM of z coefficients divided by each equation's z coefficient.
        LCM l_c_m = new LCM(stooge);
        int lcm = l_c_m.getLCM();

        // STEP 1:
        eliminator[0][0] = (lcm * x_coefficients[0]) / z_coefficients[0];
        eliminator[0][1] = (lcm * y_coefficients[0]) / z_coefficients[0];
        eliminator[0][2] = (lcm * equals[0]) / z_coefficients[0];

        eliminator[1][0] = (lcm * x_coefficients[1]) / z_coefficients[1];
        eliminator[1][1] = (lcm * y_coefficients[1]) / z_coefficients[1];
        eliminator[1][2] = (lcm * equals[1]) / z_coefficients[1];

        eliminator[2][0] = (lcm * x_coefficients[2]) / z_coefficients[2];
        eliminator[2][1] = (lcm * y_coefficients[2]) / z_coefficients[2];
        eliminator[2][2] = (lcm * equals[2]) / z_coefficients[2];

        // STEP 2: Subtract the new equations obtained in Step 2; eqn (2) from eqn (1) and eqn (3) from eqn (2).
        double[] new_x = {
                eliminator[0][0] - eliminator[1][0],
                eliminator[1][0] - eliminator[2][0]
        };
        double[] new_y = {
                eliminator[0][1] - eliminator[1][1],
                eliminator[1][1] - eliminator[2][1]
        };
        double[] new_eq = {
                eliminator[0][2] - eliminator[1][2],
                eliminator[1][2] - eliminator[2][2]
        };

        try {
            // STEP 3: uses the methods used in the TwoVariableCalculator to calculate the X and Y elements
            double[] partial_solution;
            partial_solution = (new TwoVariablesCalculator(new_x, new_y, new_eq)).solveSimultaneous();

            x_variable = partial_solution[0];
            y_variable = partial_solution[1];
            // STEP 4: Solve for z using x and y from any original equation
            z_variable = (double)(equals[0] - x_coefficients[0] * x_variable - y_coefficients[0] * y_variable) / z_coefficients[0];
        } catch (ArithmeticException e) {
            throw e;
        }
        return new double[]{x_variable, y_variable, z_variable};
    }
}
