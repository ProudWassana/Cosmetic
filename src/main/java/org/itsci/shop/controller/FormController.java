package org.itsci.shop.controller;

import org.itsci.shop.model.Form;
import org.itsci.shop.model.Drug;
import org.itsci.shop.service.CategoryService;
import org.itsci.shop.service.DrugService;
import org.itsci.shop.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/form")
public class FormController {
    private String title = "แบบฟอร์มแจ้งอาการ";
    @Autowired
    private FormService formService;

    @Autowired
    private DrugService drugService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String listProduct(Model model) {
        model.addAttribute("title", "รายการ" + title);
        model.addAttribute("forms", formService.getForms());
        return "form/list";
    }

    @GetMapping("/create")
    public String showFormForAdd(Model model) {
        model.addAttribute("title", "เพิ่ม" + title);
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("form", new Form());
        return "form/do-form";
    }

    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        Form form = formService.getForm(id);
        model.addAttribute("title", "แก้ไข" + title);
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("form", form);
        return "form/do-form";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("form") Form form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "มีข้อผิดพลาดในการบันทึก" + title);
            model.addAttribute("categories", categoryService.getCategories());
            return "form/do-form";
        } else {
            Form entityForm = formService.getForm(form.getId());
            if (entityForm != null) {
                formService.updateForm(entityForm, form);
            } else {
                formService.saveForm(form);
            }
            return "redirect:/form/list";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable("id") int id) {
        formService.deleteForm(id);
        return "redirect:/form/list";
    }

    @GetMapping("/{id}/view-drugs")
    public String productViewShop(@PathVariable("id") int id, Model model) {
        Form form = formService.getForm(id);
        model.addAttribute("title", title + " - รายการใบแจ้งอาการ");
        model.addAttribute("forms", form);
        model.addAttribute("drugs", form.getPolices());
        return "form/form-view-drugs";
    }

    @GetMapping("/{id}/drug/add")
    public String showShopForAdd(@PathVariable("id") int id, Model model) {
        Form form = formService.getForm(id);
        List<Drug> drugs = drugService.getDrugDoesNotHaveForm(id);
        model.addAttribute("title", "แบบฟอร์มแจ้งอาการ");
        model.addAttribute("form", form);
        model.addAttribute("drugs", drugs);
        return "form/drug-list";
    }

    @PostMapping("/{id}/drug/add")
    public String addShop(@PathVariable("id") int formID, @RequestParam("drug") int drugId) {
        formService.addDrugToForm(formID, drugId);
        return "redirect:/form/" + formID + "/drug/add";
    }

    @GetMapping("/{id}/drug/{drugs}/remove")
    public String productRemoveShop(@PathVariable("id") int formID, @PathVariable("drugs") int drugId) {
        formService.removeDrugFromForm(formID, drugId);
        return "redirect:/form/" + formID + "/view-drugs";
    }
}
