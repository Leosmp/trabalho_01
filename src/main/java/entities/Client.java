/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "TB_CLIENT")
@DiscriminatorValue(value = "C")
@PrimaryKeyJoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
public class Client extends User implements Serializable{
    
    public Client(Long id, String name, String email, String phone, String password) {
        super(id, name, email, phone, password);
    }
    
    public Client(){
      
    }
    
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();
    
    
    public List<Order> getOrders() {
        return orders;
    }

}
