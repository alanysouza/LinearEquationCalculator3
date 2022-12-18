package database;
import model.ThreeVariableEquation;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Alany Souza 2021345 and Thaynna Vieira 2021288
 */

public interface ThreeVariableEquationDataProviderInterface {
    ThreeVariableEquation findByMatrices(String xMatrices, String yMatrices, String zMatrices, String equalsMatrices);
    List<ThreeVariableEquation> findByCreatedBy(int userId);
    int save(ThreeVariableEquation equation);
    
}
