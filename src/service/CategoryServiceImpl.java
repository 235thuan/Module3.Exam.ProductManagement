package service;

import model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/model3Exam";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";

    private static final String SELECT_ALL_CATEGORIES = "select * from category";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.err.println("Error1");
        } catch (ClassNotFoundException ex) {
            System.err.println("Error2");
        }
        return connection;
    }

    public CategoryServiceImpl() {
    }

    public List<Category> selectAllCategories() {
        List<Category> caregory = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int categoryId = rs.getInt("categoryId");
                String categoryName = rs.getString("categoryName");
                caregory.add(new Category(categoryId,categoryName));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return caregory;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public List<Category> selectAllCategories(int offset, int noOfRecords) {
        List<Category> categories = new ArrayList<>();
        String query = "select SQL_CALC_FOUND_ROWS * from category limit "
                + offset + ", " + noOfRecords;

        try (
                PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_ALL_CATEGORIES);
        ) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery(query);
            while (rs.next()) {
                int categoryId = rs.getInt("categoryId");
                String categoryName = rs.getString("categoryName");
                categories.add(new Category(categoryId,
                        categoryName));
            }
            rs.close();

            rs = preparedStatement.executeQuery("SELECT FOUND_ROWS()");
            if (rs.next())
                this.noOfRecords = rs.getInt(1);

        } catch (SQLException e) {
            printSQLException(e);
        }
        return categories;
    }
    private int noOfRecords;

    public int getNoOfRecords() {
        return noOfRecords;
    }


}
