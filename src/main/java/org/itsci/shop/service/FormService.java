package org.itsci.shop.service;

import org.itsci.shop.model.Form;

import java.util.List;

public interface FormService {
    List<Form> getForms();
    public void saveForm(Form form);
    Form getForm(int formId);
    void deleteForm(int formId);
    void updateForm(Form formEntity, Form form);

    void addDrugToForm(int formId, int drugId);

    void removeDrugFromForm(int formId, int drugId);

    List<Form> getFormDoesNotHaveDrug(int id);
}
