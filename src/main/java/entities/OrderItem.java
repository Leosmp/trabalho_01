/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 *
 * @author Dev Dreamm
 */
@Entity
@Table(name = "TB_ORDER_ITEM")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID_ORDER_ITEM")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Embedded
    @Column(name = "ORDER_ITEM_PK")
    private OrderItemPK orderItemPk = new OrderItemPK();
    
    @NotNull
    @Min(1)
    @Max(100)
    @Column(name = "QUANTITY", length = 100, nullable = false)
    private Integer quantity;
    
    @NotNull
    @DecimalMin("0.1")
    @DecimalMax("100000.0")
    @Column(name = "PRICE", length = 100000, nullable = false)
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        super();
        orderItemPk.setOrder(order);
        orderItemPk.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        return orderItemPk.getOrder();
    }

    public void setOrder(Order order) {
        orderItemPk.setOrder(order);
    }

    public Product getProduct() {
        return orderItemPk.getProduct();
    }

    public void setProduct(Product product) {
        orderItemPk.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubTotal() {
        return price * quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderItemPk == null) ? 0 : orderItemPk.hashCode());
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
        OrderItem other = (OrderItem) obj;
        if (orderItemPk == null) {
            if (other.orderItemPk != null) {
                return false;
            }
        } else if (!orderItemPk.equals(other.orderItemPk)) {
            return false;
        }
        return true;
    }

}
