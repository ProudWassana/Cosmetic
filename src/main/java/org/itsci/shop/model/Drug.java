package org.itsci.shop.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "drugs")
public class Drug {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "form_drug", joinColumns = {@JoinColumn(name = "drug_id")}, inverseJoinColumns = {@JoinColumn(name = "form_id")})
    private List<Form> forms;

    @NotNull
    @Pattern(regexp = "^DR[0-9]{4}")
    @Column(name = "code", length = 10, nullable = false, unique = true)
    private String code;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "quantity")
    private String quantity;
    @NotNull
    @Column(name = "price")
    private String price;
    @NotNull
    @Column(name = "propertie")
    private String propertie;
    @NotNull
    @Column(name = "detail", columnDefinition = "TEXT")
    private String detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPropertie() {
        return propertie;
    }

    public void setPropertie(String propertie) {
        this.propertie = propertie;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void fill(Drug drug) {
        this.code = drug.getCode();
        this.name = drug.getName();
        this.quantity = drug.getQuantity();
        this.price = drug.getPrice();
        this.propertie = drug.getPropertie();
        this.detail = drug.getDetail();
    }
}
