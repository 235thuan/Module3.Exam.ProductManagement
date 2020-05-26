package service;

import model.Category;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface CategoryService {
    List<Category> selectAllCategories(int offset, int noOfRecords);
    List<Category> selectAllCategories();
    Category getCategoryName() throws SQLException;
}
