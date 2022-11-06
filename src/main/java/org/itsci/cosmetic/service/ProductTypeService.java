package org.itsci.cosmetic.service;

import org.itsci.cosmetic.model.ProductType;

import java.util.List;

public interface ProductTypeService {

    List<ProductType> getProductTypes();

    void saveProductType(ProductType product);

    ProductType getProductType(int id);

    void deleteProductType(int id);

    ProductType getProductTypeByCode(String code);

    void updateProductType(ProductType dbProductType, ProductType productType);
}
