/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import entities.Order;
import entities.enunm.OrderStatus;
import java.util.Set;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import trabalho.Teste;

/**
 *
 * @author eletr
 */
public class OrderValidationTest extends Teste{
    
    @Test(expected = ConstraintViolationException.class)
    public void persistInvalidOrder() {
        Order ordem = new Order();
        try{
//        ordem.setMoment("2022-06-20T19:53:07Z");// moment null
//        ordem.setOrderStatus(OrderStatus.WAITING_PAYMENT); // onder null
        em.persist(ordem);
        em.flush();
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
            
            assertEquals(2, constraintViolations.size());
            assertNull(ordem.getId());
            throw ex;
        }
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void atualizeInvalidOrder() {
        TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE o.orderStatus = ?1", Order.class);
        query.setParameter(1, 2);
        Order o = query.getSingleResult();
        o.setMoment("2022-06-20T19:53:0007Z"); // moment maior que o limite;

        try {
            em.flush();
        } catch (ConstraintViolationException ex) {    
            assertEquals(1, ex.getConstraintViolations().size());
            throw ex;
        }
    }
}
