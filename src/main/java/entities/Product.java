/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 *
 * @author Dev Dreamm
 */
@Entity
@Table(name = "TB_PRODUCT")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_PRODUCT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;;
    
    @NotBlank(message = "Preencha o nome do produto!")
    @Column(name = "NAME", length = 25, nullable = false)
    private String name;
    
    @NotBlank @Size(max = 250) 
    @Column(name = "DESCRIPTION", length = 150, nullable = false)
    private String description;
    
    @NotNull @Positive(message = "O preço precisa ser maior zero!")
    @Column(name = "PRICE", length = 100000, nullable = false)
    private Double price;
    
    @Column(name = "IMGURL", length = 20, nullable = false)
    private String imgUrl;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_PRODUCT_CATEGORY", joinColumns = {
        @JoinColumn(name = "ID_PRODUCT")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_CATEGORY")})
    private Set<Category> categories = new HashSet<>();

   @OneToMany(mappedBy = "orderItemPk.product", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)    
   private Set<OrderItem> items = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name, String description, Double price, String imgUrl) {
        //this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @JsonIgnore
    public Set<Order> getOrders() {
        Set<Order> set = new HashSet<>();
        for (OrderItem x : items) {
            set.add(x.getOrder());
        }
        return set;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
