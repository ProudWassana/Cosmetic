package org.itsci.shop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.shop.model.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FormDaoImpl implements FormDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Form> getForms() {
        Session session = sessionFactory.getCurrentSession();
        Query<Form> query = session.createQuery("from Form", Form.class);
        List<Form> forms = query.getResultList();
        return forms;
    }

    @Override
    public void saveForm(Form form) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(form);
    }

    @Override
    public Form getForm(int formId) {
        Session session = sessionFactory.getCurrentSession();
        Form form = session.get(Form.class, formId);
        return form;
    }

    @Override
    public void deleteForm(int formId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Form where id=:formId");
        query.setParameter("formId", formId);
        query.executeUpdate();
    }

    @Override
    public List<Form> getFormDoesNotHaveDrug(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Form> query = session.createQuery("select s.forms from Drug s where s.id=:id");
        query.setParameter("id", id);
        List<Form> formList1 = query.getResultList();
        query = session.createQuery("from Form");
        List<Form> formList2 = query.getResultList();
        formList2.removeAll(formList1);
        return formList2;
    }

}
