package org.itsci.shop.dao;

import org.itsci.shop.model.Form;

import java.util.List;

public interface FormDao {
    List<Form> getForms();
    void saveForm(Form form);
    Form getForm(int id);
    void deleteForm(int id);

    List<Form> getFormDoesNotHaveDrug(int id);
}
