package org.itsci.shop.service;

import org.itsci.shop.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();

    void saveCategory(Category product);

    Category getCategory(int id);

    void deleteCategory(int id);

    Category getCategoryByCode(String code);

    void updateCategory(Category dbCategory, Category category);
}
