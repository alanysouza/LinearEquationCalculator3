
package solvers;
import java.util.List;
/**
 *
 * @author Alany Souza 2021345 and Thaynna Vieira 2021288
 */


//find the least common multiple 
//source https://www.geeksforgeeks.org/lcm-of-given-array-elements/

public class LCM {
    private List<Integer> elementArray;

    public LCM(List<Integer> elementArray) {
        this.elementArray = elementArray;
    }

    public int getLCM() {
        int lcm_of_array_elements = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < elementArray.size(); i++) {

                // lcm_of_array_elements (n1, n2, ... 0) = 0.
                // For negative number we convert into
                // positive and calculate lcm_of_array_elements.

                if (elementArray.get(i) == 0) {
                    return 0;
                } else if (elementArray.get(i) < 0) {
                    elementArray.set(i, elementArray.get(i) * (-1));
                }
                if (elementArray.get(i) == 1) {
                    counter++;
                }

                // Divide element_array by devisor if complete
                // division i.e. without remainder then replace
                // number with quotient; used for find next factor
                if (elementArray.get(i) % divisor == 0) {
                    divisible = true;
                    elementArray.set(i, elementArray.get(i) / divisor);
                }
            }

            // If divisor able to completely divide any number
            // from array multiply with lcm_of_array_elements
            // and store into lcm_of_array_elements and continue
            // to same divisor for next factor finding.
            // else increment divisor
            if (divisible) {
                lcm_of_array_elements = lcm_of_array_elements * divisor;
            } else {
                divisor++;
            }

            // Check if all element_array is 1 indicate
            // we found all factors and terminate while loop.
            if (counter == elementArray.size()) {
                return lcm_of_array_elements;
            }
        }
    }

}
