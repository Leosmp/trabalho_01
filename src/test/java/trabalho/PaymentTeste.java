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
        pagamento.setMoment("2020-01-20T21:53:07Z");
        pagamento.setOrder(em.find(Order.class, 4L));
        em.persist(pagamento);
        em.flush();
        assertNotNull(pagamento.getId());
 
    }
    
    @Test
    public void consultarPayment() {
       Payment pagamento = em.find(Payment.class, 4L);
       assertEquals("2020-01-20T21:53:07Z",pagamento.getMoment().toString());      
    }
    
        @Test
    public void atualizarPayment(){
        logger.info("Executando atualizarPayment()");
        String novoMoment = "2020-09-20T21:53:07Z";
        Payment pagamento = em.find(Payment.class, 3L);
        assertNotNull(pagamento);
        pagamento.setMoment(novoMoment);
        pagamento.setOrder(em.find(Order.class, 3L));
        em.clear();        
        em.merge(pagamento);
        em.flush();
    }
    
        @Test
    public void removerPayment() {
        logger.info("Executando removerPayment()");
        Payment pagamento = em.find(Payment.class, 4L);
        assertNotNull(pagamento);
        em.remove(pagamento);
        em.flush();
    }
    
}
