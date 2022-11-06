package org.itsci.cosmetic.controller;

import org.itsci.cosmetic.model.Product;
import org.itsci.cosmetic.model.Shop;
import org.itsci.cosmetic.service.ProductService;
import org.itsci.cosmetic.service.ProductTypeService;
import org.itsci.cosmetic.service.ShopService;
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
@RequestMapping("/product")
public class ProductController {
    private String title = "สินค้า";
    @Autowired
    private ProductService productService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/list")
    public String listProduct(Model model) {
        model.addAttribute("title", "รายการ" + title);
        model.addAttribute("products", productService.getProducts());
        return "product/list";
    }

    @GetMapping("/create")
    public String showFormForAdd(Model model) {
        model.addAttribute("title", "เพิ่ม" + title);
        model.addAttribute("productTypes", productTypeService.getProductTypes());
        model.addAttribute("product", new Product());
        return "product/product-form";
    }

    @GetMapping("/{id}/update")
    public String showFormForUpdate(@PathVariable("id") int id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("title", "แก้ไข" + title);
        model.addAttribute("productTypes", productTypeService.getProductTypes());
        model.addAttribute("product", product);
        return "product/product-form";
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "มีข้อผิดพลาดในการบันทึก" + title);
            model.addAttribute("productTypes", productTypeService.getProductTypes());
            return "product/product-form";
        } else {
            Product entityProduct = productService.getProduct(product.getId());
            if (entityProduct != null) {
                productService.updateProduct(entityProduct, product);
            } else {
                productService.saveProduct(product);
            }
            return "redirect:/product/list";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/product/list";
    }

    @GetMapping("/{id}/view-shops")
    public String productViewShop(@PathVariable("id") int id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("title", title + " - รายการร้านค้า");
        model.addAttribute("product", product);
        model.addAttribute("shops", product.getShops());
        return "product/product-view-shops";
    }

    @GetMapping("/{id}/shop/add")
    public String showShopForAdd(@PathVariable("id") int id, Model model) {
        Product product = productService.getProduct(id);
        List<Shop> shops = shopService.getShopDoesNotHaveProduct(id);
        model.addAttribute("title", "เพิ่มร้านค้า");
        model.addAttribute("product", product);
        model.addAttribute("shops", shops);
        return "product/shop-list";
    }

    @PostMapping("/{id}/shop/add")
    public String addShop(@PathVariable("id") int productId, @RequestParam("shop") int shopId) {
        productService.addShopToProduct(productId, shopId);
        return "redirect:/product/" + productId + "/shop/add";
    }

    @GetMapping("/{id}/shop/{shop}/remove")
    public String productRemoveShop(@PathVariable("id") int productId, @PathVariable("shop") int shopId) {
        productService.removeShopFromProduct(productId, shopId);
        return "redirect:/product/" + productId + "/view-shops";
    }

}
