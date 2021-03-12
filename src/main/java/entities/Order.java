/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import Validator.ValidateState;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import entities.enunm.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Dev Dreamm
 */
@Entity
@Table(name = "TB_ORDER")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_ORDER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty
    @Column(name = "MOMENT", length = 20, nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd'T' HH:mm:ss'Z'", timezone = "GMT")
    private String moment;
    
    @ValidateState
    @Column(name = "ORDER_STATUS", length = 1, nullable = false)
    private Integer orderStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CLIENT")
    private Client client;
    
    @OneToMany(mappedBy = "orderItemPk.order", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "ID_PAYMENT")
    private Payment payment;

    public Order() {
    }

    public Order(Long id, String moment, OrderStatus orderStatus, Client client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public Double getTotal() {
        double sum = 0.0;
        for (OrderItem x : items) {
            sum += x.getSubTotal();
        }
        return sum;
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
        Order other = (Order) obj;
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
