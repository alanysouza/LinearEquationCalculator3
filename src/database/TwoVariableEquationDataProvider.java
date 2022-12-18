package database;
import java.util.List;
import model.TwoVariableEquation;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Alany Souza 2021345 and Thaynna Vieira 2021288
 */

public class TwoVariableEquationDataProvider implements TwoVariableEquationDataProviderInterface{

    private static String DB_NAME = "equation_app";
    private static String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
    private static String USE_EQUATION_APP = "use "+DB_NAME+";";

    private static String TABLE_NAME = "two_variable_equation";
    private static String USER = "root";
    private static String PASS = "root";

    private static String ID_COL = "Id";
    private static String X_MATRICES_COL = "x_matrices";
    private static String Y_MATRICES_COL = "y_matrices";
    private static String EQUALS_MATRICES_COL = "equals_matrices";

    private static String X_VALUE_COL = "x_value";

    private static String Y_VALUE_COL = "y_value";

    private static String CREATED_BY_COL = "created_by";

    private Connection getConnection()  {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        return connection;
    }
    
    
    @Override
    public TwoVariableEquation findByMatrices(String xMatrices, String yMatrices, String equalsMatrices) {
         TwoVariableEquation equation = null;
        Connection connection = getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String xMatricesCondition = " " + X_MATRICES_COL + " = '" + xMatrices + "' ";
                String yMatricesCondition = " " + Y_MATRICES_COL + " = '" + yMatrices + "' ";
                String equalsMatricesCondition = " " + EQUALS_MATRICES_COL + " = '" + equalsMatrices + "' ";
                String whereClause = " WHERE" + xMatricesCondition + "AND" + yMatricesCondition + "AND" + equalsMatricesCondition;
                String query = "SELECT * from " + TABLE_NAME + whereClause + ";";
                statement.execute(USE_EQUATION_APP);
                ResultSet resultSet = statement.executeQuery(query);
                if (resultSet.next()) {
                    equation = createFromResultSet(resultSet);
                }
            } catch (SQLException sqlException) {
                System.out.println("An error occurred while performing query");
                sqlException.printStackTrace();
            }
        }
        return equation;
    }

    
    @Override
    public List<TwoVariableEquation> findByCreatedBy(int userId) {
         List<TwoVariableEquation> equations = new ArrayList<>();
        Connection connection = getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String createdByCondition = " " + CREATED_BY_COL + " = " + userId;
                String whereClause = " WHERE" + createdByCondition;
                String query = "SELECT * from " + TABLE_NAME + whereClause + ";";
                statement.execute(USE_EQUATION_APP);
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    equations.add(createFromResultSet(resultSet));
                }
            } catch (SQLException sqlException) {
                System.out.println("An error occurred while performing query");
                sqlException.printStackTrace();
            }
        }
        return equations;
    }

    
    @Override
    public int save(TwoVariableEquation equation) {
        int insertCount = 0;
        Connection connection = getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String columns = "("+X_MATRICES_COL+","+Y_MATRICES_COL+","+EQUALS_MATRICES_COL+","+ X_VALUE_COL+","+Y_VALUE_COL+","+CREATED_BY_COL+")";
                String values = "VALUES ('"+equation.getxMatrices()+"','"+equation.getyMatrices()+"','"+equation.getEqualsMatrices()+"',"+ equation.getxValue()+","+equation.getyValue()+","+equation.getCreatedBy()+")";
                String query = "INSERT into " + TABLE_NAME + columns + values + ";";
                statement.execute(USE_EQUATION_APP);
                insertCount = statement.executeUpdate(query);
            } catch (SQLException sqlException) {
                System.out.println("An error occurred while performing insert");
                sqlException.printStackTrace();
            }
        }
        return insertCount;
    }
    
        private TwoVariableEquation createFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ID_COL);
        String xMatricesRetrieved = resultSet.getString(X_MATRICES_COL);
        String yMatricesRetrieved = resultSet.getString(Y_MATRICES_COL);
        String equalsMatricesRetrieved = resultSet.getString(EQUALS_MATRICES_COL);
        double xValue = resultSet.getDouble(X_VALUE_COL);
        double yValue = resultSet.getDouble(Y_VALUE_COL);
        int createdBy = resultSet.getInt(CREATED_BY_COL);
        return new TwoVariableEquation(id, xMatricesRetrieved, yMatricesRetrieved, equalsMatricesRetrieved, xValue, yValue, createdBy);
    } 
}
