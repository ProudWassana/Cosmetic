package org.itsci.shop.service;

import org.itsci.shop.model.Drug;

import java.util.List;

public interface DrugService {

    List<Drug> getDrugs();
    void saveDrug(Drug drug);
    Drug getDrug(int drugId);
    void deleteDrug(int drugId);
    void updateDrug(Drug drugEntity, Drug drug);

    void addFormToDrug(int drugId, int formId);

    void removeFormFromDrug(int drugId, int formId);

    List<Drug> getDrugDoesNotHaveForm(int id);

}
