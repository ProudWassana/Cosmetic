package org.itsci.cosmetic.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "shops1")
public class Shop {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "product_shop", joinColumns = {@JoinColumn(name = "shop_id")}, inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> products;

    @NotNull
    @Pattern(regexp = "^SH[0-9]{3}")
    @Column(name = "code", length = 10, nullable = false, unique = true)
    private String code;
    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "address", columnDefinition = "TEXT")
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void fill(Shop shop) {
        this.code = shop.getCode();
        this.name = shop.getName();
        this.address = shop.getAddress();
    }

}
