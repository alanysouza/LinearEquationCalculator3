
package database;
import model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Alany Souza 2021345 and Thaynna Vieira 2021288
 */

// methods to connects with the DB, write and read
public class UserDataProvider implements UserDataProviderInterface {
    private static String DB_NAME = "equation_app";
    private static String DB_URL = "jdbc:mysql://localhost/" + DB_NAME;
    private static String USE_EQUATION_APP = "use "+DB_NAME+";";

    private static String TABLE_NAME = "user";
    private static String USER = "root";
    private static String PASS = "root";
    private static String ID_COL = "Id";
    private static String USERNAME_COL = "username";
    private static String PASSWORD_COL = "password";
    private static String FIRST_NAME_COL = "first_name";
    private static String LAST_NAME_COL = "last_name";
    private static String IS_ADMIN = "is_admin";


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
    public List<User> listAll() {
        return new ArrayList<>();
    }

    //Search the user in the database
    @Override
    public User findByUsername(String username) {
        User user = null;
        Connection connection = getConnection();
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String userNameCondition = " " + USERNAME_COL + " = '" + username + "' ";
                String whereClause = " WHERE" + userNameCondition;
                String query = "SELECT * from " + TABLE_NAME + whereClause + ";";
                statement.execute(USE_EQUATION_APP);
                ResultSet resultSet = statement.executeQuery(query);
                if (resultSet.next()) {
                    user = createFromResultSet(resultSet);
                }
            } catch (SQLException sqlException) {
                System.out.println("An error occurred while performing user query"); //throws an error message
                sqlException.printStackTrace();
            }
        }
        return user;
    }

    //
    @Override
    public int updateFirstName(int userId, String firstName) {
        System.out.println("updateFirstName sql is not complete. User firstName was not updated");
        return 0;
    }

    @Override
    public int updateLastName(int userId, String firstName) {
        System.out.println("updateLastName sql is not complete. User lastName was not updated");
        return 0;
    }

    
    private User createFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ID_COL);
        String username = resultSet.getString(USERNAME_COL);
        String password = resultSet.getString(PASSWORD_COL);
        String firstName = resultSet.getString(FIRST_NAME_COL);
        String lastName = resultSet.getString(LAST_NAME_COL);
        boolean isAdmin = resultSet.getBoolean(IS_ADMIN);
        return new User(id, username, password, firstName, lastName, isAdmin);
    }
}
