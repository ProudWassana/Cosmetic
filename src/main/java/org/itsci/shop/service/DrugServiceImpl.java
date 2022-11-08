package org.itsci.shop.service;

import org.itsci.shop.dao.DrugDao;
import org.itsci.shop.dao.FormDao;
import org.itsci.shop.model.Drug;
import org.itsci.shop.model.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugDao drugDao;

    @Autowired
    private FormDao formDao;

    @Override
    @Transactional
    public List<Drug> getDrugs() {
        return drugDao.getDrug();
    }

    @Override
    @Transactional
    public void saveDrug(Drug drug) {
        drugDao.saveDrug(drug);
    }

    @Override
    @Transactional
    public Drug getDrug(int drugId) {
        return drugDao.getDrug(drugId);
    }

    @Override
    @Transactional
    public void deleteDrug(int drugId) {
        drugDao.deleteDrug(drugId);
    }

    @Override
    @Transactional
    public void updateDrug(Drug drugEntity, Drug drug) {
        drugEntity.fill(drug);
        drugDao.saveDrug(drugEntity);
    }

    @Override
    @Transactional
    public List<Drug> getDrugDoesNotHaveForm(int id) {
        return drugDao.getDrugDoesNotHaveForm(id);
    }

    @Override
    @Transactional
    public void addFormToDrug (int drugId, int formId) {
        Form form = formDao.getForm(formId);
        Drug drug = drugDao.getDrug(drugId);
        drug.getForms().add(form);
        drugDao.saveDrug(drug);
    }

    @Override
    @Transactional
    public void removeFormFromDrug(int drugId, int formId) {
        Form form = formDao.getForm(formId);
        Drug drug = drugDao.getDrug(drugId);
        drug.getForms().remove(form);
        drugDao.saveDrug(drug);
    }
}
