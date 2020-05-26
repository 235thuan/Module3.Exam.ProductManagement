package service;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProductServiceImpl implements ProductService {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/model3Exam";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO product" + "  (productName," +
            "productPrice," +
            "productQuantity," +
            "productColour," +
            "productDescription," +
            "categoryName) VALUES " +
            " (?, ?, ?,?,?,?);";
    private static final String SELECT_PRODUCT_BY_ID =
            "select productId,productName,productPrice,productQuantity,productColour,productDescription,categoryName from product where productId =?";
    private static final String SELECT_ALL_PRODUCTS = "select * from product";
    private static final String UPDATE_PRODUCTS_SQL =
            "update product set productName=?, productPrice=? where productId = ?;";
    private static final String DELETE_PRODUCTS_SQL = "delete from product where productId = ?;";

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

    public ProductServiceImpl() {
    }

    public Product selectProduct(int id) {
        Product product = null;
        try (
                PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_PRODUCT_BY_ID);
        ) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("productId");
                String productName = rs.getString("productPrice");
                int productPrice = rs.getInt("productPrice");
                int productQuantity = rs.getInt("productQuantity");
                String productColour = rs.getString("productColour");
                String productDescription = rs.getString("productDescription");
                String categoryName = rs.getString("categoryName");
                product = new Product(productId,
                        productName,
                        productPrice,
                        productQuantity,
                        productColour,
                        productDescription,
                        categoryName);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
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

    public List<Product> selectAllProducts(int offset, int noOfRecords) {




        List<Product> products = new ArrayList<>();
        String query = "select SQL_CALC_FOUND_ROWS * from product limit "
                + offset + ", " + noOfRecords;

        try (
                PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_ALL_PRODUCTS);
        ) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery(query);
            while (rs.next()) {
                int productId = rs.getInt("productId");
                String productName = rs.getString("productPrice");
                int productPrice = rs.getInt("productPrice");
                int productQuantity = rs.getInt("productQuantity");
                String productColour = rs.getString("productColour");
                String productDescription = rs.getString("productDescription");
                String categoryName = rs.getString("categoryName");
                products.add(new Product(productId,
                        productName,
                        productPrice,
                        productQuantity,
                        productColour,
                        productDescription,
                        categoryName));
            }
            rs.close();

            rs = preparedStatement.executeQuery("SELECT FOUND_ROWS()");
            if (rs.next())
                this.noOfRecords = rs.getInt(1);

        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    private int noOfRecords;

    public int getNoOfRecords() {
        return noOfRecords;
    }

    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try (
                PreparedStatement statement = getConnection().prepareStatement(UPDATE_PRODUCTS_SQL);) {
            statement.setInt(3, product.getProductId());
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getProductPrice());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCTS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL)) {
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getProductPrice());
            preparedStatement.setInt(3, product.getProductQuantity());
            preparedStatement.setString(4, product.getProductColour());
            preparedStatement.setString(5, product.getProductDescription());
            preparedStatement.setString(6, product.getCategoryName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


}