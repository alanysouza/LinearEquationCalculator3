
package database;
import model.TwoVariableEquation;

import java.util.List;
/**
 *
 * @author Alany Souza 2021345 and Thaynna Vieira 2021288
 */

public interface TwoVariableEquationDataProviderInterface {
    public TwoVariableEquation findByMatrices(String xMatrices, String yMatrices, String equalsMatrices);
    public List<TwoVariableEquation> findByCreatedBy(int userId);
    public int save(TwoVariableEquation equation);
}
