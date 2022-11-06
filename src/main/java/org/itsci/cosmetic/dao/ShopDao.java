package org.itsci.cosmetic.dao;

import org.itsci.cosmetic.model.Product;
import org.itsci.cosmetic.model.Shop;

import java.util.List;

public interface ShopDao {

    List<Shop> getShops();
    void saveShop(Shop shop);
    Shop getShop(int shopId);
    void deleteShop(int shopId);

    List<Shop> getShopDoesNotHaveProduct(int id);

}
