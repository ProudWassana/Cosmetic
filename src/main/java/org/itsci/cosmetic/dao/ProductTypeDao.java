package org.itsci.cosmetic.dao;

import org.itsci.cosmetic.model.ProductType;

import java.util.List;

public interface ProductTypeDao {

    List<ProductType> getProductTypes();

    void saveProductType(ProductType productType);

    ProductType getProductType(int id);

    void deleteProductType(int id);

    ProductType getProductTypeByCode(String code);
}
