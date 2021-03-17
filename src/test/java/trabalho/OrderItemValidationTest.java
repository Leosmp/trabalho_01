/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import entities.Client;
import entities.OrderItem;
import java.util.Set;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author Souza
 */
public class OrderItemValidationTest extends Teste {
    
                
    @Test(expected = ConstraintViolationException.class)
    public void persistInvalidOrderItem() {
        OrderItem oi = new OrderItem();
        try{
        em.persist(oi);
        em.flush();
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
            
            assertEquals(4, constraintViolations.size());
            assertNull(oi.getPrice());            

            throw ex;
        }
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void atualizeInvalidOrderItem() {
        TypedQuery<OrderItem> query = em.createQuery("SELECT oi FROM OrderItem oi WHERE oi.id = ?1", OrderItem.class);
        query.setParameter(1, 2);
        OrderItem oi = query.getSingleResult();           
        oi.setPrice(01803871018730173171937464644646872.20);
        try {
            em.flush();
        } catch (ConstraintViolationException ex) {    
            assertEquals(1, ex.getConstraintViolations().size());
            throw ex;
        }
    }
    
}
