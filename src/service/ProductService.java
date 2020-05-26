package service;


import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    Product selectProduct(int id);

    List<Product> selectAllProducts(int offset, int noOfRecords);

    boolean updateProduct(Product product) throws SQLException;
    boolean deleteProduct(int id) throws  SQLException;

}
