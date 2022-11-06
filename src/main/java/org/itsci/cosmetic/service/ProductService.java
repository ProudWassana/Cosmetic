package org.itsci.cosmetic.service;

import org.itsci.cosmetic.model.Product;
import org.itsci.cosmetic.model.Shop;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    public void saveProduct(Product product);
    Product getProduct(int productId);
    void deleteProduct(int productId);
    void updateProduct(Product productEntity, Product product);

    void addShopToProduct(int productId, int shopId);

    void removeShopFromProduct(int productId, int shopId);

    List<Product> getProductDoesNotHaveShop(int id);
}
