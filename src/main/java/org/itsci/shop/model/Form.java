package org.itsci.shop.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "forms")
public class Form {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "form_drug", joinColumns = {@JoinColumn(name = "form_id")}, inverseJoinColumns = {@JoinColumn(name = "drug_id")})
    private List<Drug> drugs;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    int id;

    @NotNull
    @Pattern(regexp = "^FM[0-9]{4}")
    @Column(length = 10, nullable = false, unique = true)
    private String code;
    @NotNull
    private String name;
    @NotNull
    private String tel;
    @NotNull
    @Column(columnDefinition = "TEXT")
    private String description;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Drug> getPolices() {
        return drugs;
    }

    public void setPolices(List<Drug> drugs) {
        this.drugs = drugs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void fill(Form form) {
        this.code = form.getCode();
        this.name = form.getName();
        this.category = form.getCategory();
        this.description = form.getDescription();
    }
}
