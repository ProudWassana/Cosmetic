package org.itsci.shop.dao;

import org.itsci.shop.model.Drug;

import java.util.List;

public interface DrugDao {

    List<Drug> getDrug();
    void saveDrug(Drug drug);
    Drug getDrug(int id);
    void deleteDrug(int id);

    List<Drug> getDrugDoesNotHaveForm(int id);

}
