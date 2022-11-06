package org.itsci.cosmetic.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.cosmetic.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductTypeDaoImpl implements ProductTypeDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<ProductType> getProductTypes() {
        Session session = sessionFactory.getCurrentSession();
        Query<ProductType> query = session.createQuery("from ProductType", ProductType.class);
        List<ProductType> productTypes = query.getResultList();
        return productTypes;
    }

    @Override
    public void saveProductType(ProductType productType) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(productType);
    }

    @Override
    public ProductType getProductType(int id) {
        Session session = sessionFactory.getCurrentSession();
        ProductType productType = session.get(ProductType.class, id);
        return productType;
    }

    @Override
    public void deleteProductType(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from ProductType where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public ProductType getProductTypeByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query<ProductType> query = session.createQuery("from ProductType where code=:code", ProductType.class);
        query.setParameter("code", code);
        ProductType productType = query.getSingleResult();
        return productType;
    }
}
