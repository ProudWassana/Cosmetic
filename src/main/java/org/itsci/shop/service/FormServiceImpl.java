package org.itsci.shop.service;

import org.itsci.shop.dao.CategoryDao;
import org.itsci.shop.dao.FormDao;
import org.itsci.shop.dao.DrugDao;
import org.itsci.shop.model.Category;
import org.itsci.shop.model.Form;
import org.itsci.shop.model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {
    @Autowired
    private FormDao formDao;

    @Autowired
    private DrugDao drugDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    @Transactional
    public List<Form> getForms() {
        return formDao.getForms();
    }

    @Override
    @Transactional
    public void saveForm(Form form) {
        Category category = categoryDao.getCategoryByCode(form.getCategory().getCode());
        form.setCategory(category);
        formDao.saveForm(form);
    }

    @Override
    @Transactional
    public Form getForm(int formId) {
        return formDao.getForm(formId);
    }

    @Override
    @Transactional
    public void deleteForm(int formId) {
        formDao.deleteForm(formId);
    }

    @Override
    @Transactional
    public void updateForm(Form formEntity, Form form) {
        formEntity.fill(form);
        saveForm(formEntity);
    }

    @Override
    @Transactional
    public void addDrugToForm(int formId, int drugId) {
        Drug drug = drugDao.getDrug(drugId);
        Form form = formDao.getForm(formId);
        form.getPolices().add(drug);
        formDao.saveForm(form);
    }

    @Override
    @Transactional
    public void removeDrugFromForm(int formId, int drugId) {
        Drug drug = drugDao.getDrug(drugId);
        Form form = formDao.getForm(formId);
        form.getPolices().remove(drug);
        formDao.saveForm(form);
    }

    @Override
    @Transactional
    public List<Form> getFormDoesNotHaveDrug(int id) {
        return formDao.getFormDoesNotHaveDrug(id);
    }

}