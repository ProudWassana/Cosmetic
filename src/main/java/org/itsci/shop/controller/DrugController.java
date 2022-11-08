package org.itsci.shop.controller;

import org.itsci.shop.model.Drug;
import org.itsci.shop.model.Form;
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
@RequestMapping("/drug")
public class DrugController {

    private String title = "ข้อมูลยา";

    @Autowired
    private DrugService drugService;

    @Autowired
    private FormService formService;

    @GetMapping("/list")
    public String listShop(Model model) {
        model.addAttribute("title", "รายชื่อยา" + title);
        model.addAttribute("drugs", drugService.getDrugs());
        return "drug/list";
    }

    @GetMapping("/create")
    public String showFormForAdd(Model model) {
        model.addAttribute("title", "เพิ่ม" + title);
        model.addAttribute("drug", new Drug());
        return "drug/drug-form";
    }

    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        Drug drug = drugService.getDrug(id);
        model.addAttribute("title", "แก้ไข" + title);
        model.addAttribute("drug", drug);
        return "drug/drug-form";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("drug") Drug drug, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "มีข้อผิดพลาดในการบันทึก" + title);
            return "drug/drug-form";
        } else {
            Drug entityDrug = drugService.getDrug(drug.getId());
            if (entityDrug != null) {
                drugService.updateDrug(entityDrug, drug);
            } else {
                drugService.saveDrug(drug);
            }
            return "redirect:/drug/list";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable("id") int id) {
        drugService.deleteDrug(id);
        return "redirect:/drug/list";
    }

    @GetMapping("/{id}/view-form")
    public String shopViewProduct(@PathVariable("id") int id, Model model) {
        Drug drug = drugService.getDrug(id);
        model.addAttribute("title", title + " - รายชื่อยา");
        model.addAttribute("drugs", drug);
        model.addAttribute("forms", drug.getForms());
        return "drug/drug-view-form";
    }

    @GetMapping("/{id}/form/add")
    public String showProductForAdd(@PathVariable("id") int id, Model model) {
        Drug drug = drugService.getDrug(id);
        List<Form> forms = formService.getFormDoesNotHaveDrug(id);
        model.addAttribute("title", "เพิ่มข้อมูลยา");
        model.addAttribute("drug", drug);
        model.addAttribute("forms", forms);
        return "drug/form-list";
    }

    @PostMapping("/{id}/form/add")
    public String addProduct(@PathVariable("id") int drugId, @RequestParam("form") int formId) {
        drugService.addFormToDrug(drugId, formId);
        return "redirect:/drug/" + drugId + "/form/add";
    }

    @GetMapping("/{id}/form/{forms}/remove")
    public String shopRemoveProduct(@PathVariable("id") int drugId, @PathVariable("forms") int formId) {
        drugService.removeFormFromDrug(drugId, formId);
        return "redirect:/drug/" + drugId + "/view-form";
    }
}
