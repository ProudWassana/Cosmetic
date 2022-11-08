package org.itsci.shop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.shop.model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DrugDaoImpl implements DrugDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Drug> getDrug() {
        Session session = sessionFactory.getCurrentSession();
        Query<Drug> query = session.createQuery("from Drug", Drug.class);
        List<Drug> drugs = query.getResultList();
        return drugs;
    }

    @Override
    public void saveDrug(Drug drug) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(drug);
    }

    @Override
    public Drug getDrug(int drugId) {
        Session session = sessionFactory.getCurrentSession();
        Drug drug = session.get(Drug.class, drugId);
        return drug;
    }

    @Override
    public void deleteDrug(int drugId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Drug where id=:drugId");
        query.setParameter("drugId", drugId);
        query.executeUpdate();
    }

    @Override
    public List<Drug> getDrugDoesNotHaveForm(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Drug> query = session.createQuery("select p.drugs from Form p where p.id=:id");
        query.setParameter("id", id);
        List<Drug> drugList1 = query.getResultList();
        query = session.createQuery("from Drug");
        List<Drug> drugList2 = query.getResultList();
        drugList2.removeAll(drugList1);
        return drugList2;
    }

}
