package org.itsci.cosmetic.service;

import org.itsci.cosmetic.dao.ProductTypeDao;
import org.itsci.cosmetic.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductTypeServiceImpl implements ProductTypeService{
    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    @Transactional
    public void saveProductType(ProductType productType) {
        productTypeDao.saveProductType(productType);
    }

    @Override
    @Transactional
    public ProductType getProductType(int id) {
        return productTypeDao.getProductType(id);
    }

    @Override
    @Transactional
    public void deleteProductType(int id) {
        productTypeDao.deleteProductType(id);
    }

    @Override
    @Transactional
    public ProductType getProductTypeByCode(String code) {
        return productTypeDao.getProductTypeByCode(code);
    }

    @Override
    @Transactional
    public void updateProductType(ProductType dbProductType, ProductType productType) {
        ProductType productTypeEntity = productTypeDao.getProductType(productType.getId());
        productTypeEntity.fill(productType);
        productTypeDao.saveProductType(productTypeEntity);
    }

    @Override
    @Transactional
    public List<ProductType> getProductTypes() {
        return productTypeDao.getProductTypes();
    }

}
