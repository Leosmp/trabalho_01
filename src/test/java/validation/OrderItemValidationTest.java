/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import entities.OrderItem;
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
 * @author Souza
 */
public class OrderItemValidationTest extends Teste {
    
                
    @Test(expected = ConstraintViolationException.class)
    public void persistInvalidOrderItem() {
        OrderItem oi = new OrderItem();
        try{
        oi.setPrice(0.01);// preço abaixo do limite
        oi.setQuantity(0);
        em.persist(oi);
        em.flush();
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
            
            assertEquals(2, constraintViolations.size());
            assertNull(oi.getOrder());            

            throw ex;
        }
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void atualizeInvalidOrderItem() {
        TypedQuery<OrderItem> query = em.createQuery("SELECT oi FROM OrderItem oi WHERE oi.id = ?1", OrderItem.class);
        query.setParameter(1, 2);
        OrderItem oi = query.getSingleResult();           
        oi.setPrice(100001.0);
        oi.setQuantity(101);
        
        try {
            em.flush();
        } catch (ConstraintViolationException ex) {    
            assertEquals(2, ex.getConstraintViolations().size());
            throw ex;
        }
    }
    
}
