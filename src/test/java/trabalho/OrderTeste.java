/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import entities.Category;
import entities.Order;
import entities.enunm.OrderStatus;
import java.time.Instant;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Souza
 */
public class OrderTeste extends Teste {
    
   @Test
    public void persistirOrder() {
        Order ordem = new Order();
        ordem.setMoment(Instant.parse("2019-06-20T19:53:07Z"));
        ordem.setOrderStatus(OrderStatus.WAITING_PAYMENT);
        ordem.setPayment(null);
        em.persist(ordem);
        em.flush();
        assertNotNull(ordem.getId());
    }
    
    @Test
    public void consultarOrder() {
        Order ordem = em.find(Order.class, 4L);
       assertEquals("2019-06-20T19:53:07Z",ordem.getMoment().toString());      
    }
    
}
