/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import entities.Order;
import entities.OrderItem;
import entities.Payment;
import entities.Product;
import java.time.Instant;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Souza
 */
public class PaymentTeste extends Teste {
    
    @Test
    public void persistirPayment() {
        Payment pagamento = new Payment();
        pagamento.setMoment(Instant.parse("2020-01-20T21:53:07Z"));
        pagamento.setOrder(em.find(Order.class, 4L));
        em.persist(pagamento);
        em.flush();
        assertNotNull(pagamento.getId());
 
    }
    
    @Test
    public void consultarPayment() {
       Payment pagamento = em.find(Payment.class, 2L);
       assertEquals("2020-01-20T21:53:07Z",pagamento.getMoment().toString());      
    }
    
}
