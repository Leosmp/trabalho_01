/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.Product_;
import entities.enunm.OrderStatus;
import java.time.Instant;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Souza
 */
public class OrderItemTeste extends Teste {
    
    @Test
    public void persistirOrderItem() {
        Order o;;
        o = (Order) em.find(Order.class, 2L);
        
        Product p;
        p = em.find(Product.class, 2L);
        
        OrderItem ordemIt = new OrderItem(o, p, 3, 1950.0);
       // ordemIt.setOrder(em.find(Order.class, 2L));
       // ordemIt.setPrice(1950.0);
       // ordemIt.setProduct(em.find(Product.class, 2L));
       // ordemIt.setQuantity(3);
        em.persist(ordemIt);
        em.flush();
        assertNotNull(ordemIt.getOrder());
        assertNotNull(ordemIt.getProduct());
    }
    
    @Test
    public void consultarOrderItem() {
        OrderItem ordemIt = em.find(OrderItem.class, 5L);
        System.out.println(String.valueOf(ordemIt.getPrice()));
        assertEquals("1950.0", String.valueOf(ordemIt.getPrice()));     
    }
    
}
