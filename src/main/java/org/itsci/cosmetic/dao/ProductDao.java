package org.itsci.cosmetic.dao;

import org.itsci.cosmetic.model.Product;
import org.itsci.cosmetic.model.Shop;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts();
    void saveProduct(Product product);
    Product getProduct(int id);
    void deleteProduct(int id);

    List<Product> getProductDoesNotHaveShop(int id);
}
