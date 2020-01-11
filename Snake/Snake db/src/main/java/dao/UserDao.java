package dao;

import domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends GenericDao<User>  {

    private static final String INSERT = "INSERT INTO users(login, password) VALUES(?, ?)";
    private static final String SELECT = "SELECT userID, login, password, coins, `date` FROM users";
    private static final String UPDATE = "UPDATE users SET coins = ? WHERE userID = ?";
    private static final String DELETE = "DELETE FROM users WHERE userID = ? ";

    public UserDao(String connectionString, String user, String password) throws SQLException {
        super(connectionString, user, password);
        System.out.println("init");
    }

    @Override
    public void save(User data) throws SQLException {
        try {
            startTransaction();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, data.getLogin());
            preparedStatement.setString(2, data.getPassword());
            preparedStatement.executeUpdate();
            commit();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback();
        }
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();

        try {
            startTransaction();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT);

            while (resultSet.next()) {
                users.add(User.builder()
                        .id(resultSet.getInt("userID"))
                        .login(resultSet.getString("login"))
                        .password(resultSet.getString("password"))
                        .coins(resultSet.getInt("coins"))
                        .date(resultSet.getString("date"))
                        .build());
            }
            commit();
        } catch (SQLException e) {
            rollback();
        }
        return users;
    }

    @Override
    public void update(User data, int set) throws SQLException {
        try {
            startTransaction();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setInt(1, set);
            preparedStatement.setInt(2, data.getId());
            preparedStatement.execute();
            commit();
        } catch (SQLException e) {
            rollback();
        }
    }

    @Override
    public void delete(User data) throws SQLException {
        try {
            startTransaction();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, data.getId());
            preparedStatement.executeUpdate();
            commit();
        } catch (SQLException e) {
            rollback();
        }
    }
}
