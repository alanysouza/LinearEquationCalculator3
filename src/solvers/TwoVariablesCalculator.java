
package solvers;

/**
 *
 * @author Alany Souza 2021345 and Thaynna Vieira 2021288
 */
public class TwoVariablesCalculator {
     private final double[] x_coefficients;
    private final double[] y_coefficients;
    private final double[] equals;
    private final double[][] eliminator;
    private double x_variable;
    private double y_variable;

    public TwoVariablesCalculator(double[] x_coeff, double[] y_coeff, double[] eq) {
        x_coefficients = new double[]{x_coeff[0], x_coeff[1]};
        y_coefficients = new double[]{y_coeff[0], y_coeff[1]};
        equals = new double[]{eq[0], eq[1]};
        eliminator = new double[2][2];
    }

    public double[] solveSimultaneous() {
        // STEP 2: Multiply equation 1 by the coefficient of variable y in equation 2. 
        eliminator[0][0] = y_coefficients[1] * x_coefficients[0];
        eliminator[0][1] = y_coefficients[1] * equals[0];
        // STEP 3: Multiply equation 2 by the coefficient of variable y in equation 1.
        eliminator[1][0] = y_coefficients[0] * x_coefficients[1];
        eliminator[1][1] = y_coefficients[0] * equals[1];

        try {
            // STEPS 4, 5: Subtract the new equations obtained from Steps 2 and 3. Divide the R.H.S. from Step 4 by the coefficient of x to obtain x. 
            x_variable = (double)(eliminator[0][1] - eliminator[1][1]) / (eliminator[0][0] - eliminator[1][0]);
            // STEP 6: Obtain y by solving for y from any of the original equations, using the found value of x.
            y_variable = (double)(equals[0] - x_coefficients[0] * x_variable) / y_coefficients[0];
        } catch (ArithmeticException e) {
            throw e;
        }
        return new double[]{x_variable, y_variable};
    }
}
