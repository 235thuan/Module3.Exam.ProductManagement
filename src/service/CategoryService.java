package service;

import model.Category;
import model.Product;

import java.util.List;

public interface CategoryService {
    List<Category> selectAllCategories(int offset, int noOfRecords);
    List<Category> selectAllCategories();
}
