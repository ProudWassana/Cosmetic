package org.itsci.shop.dao;

import org.itsci.shop.model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getCategories();

    void saveCategory(Category category);

    Category getCategory(int id);

    void deleteCategory(int id);

    Category getCategoryByCode(String code);
}
