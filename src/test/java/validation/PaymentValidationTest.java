/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import entities.Payment;
import entities.Product;
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
public class PaymentValidationTest extends Teste {
    
        @Test(expected = ConstraintViolationException.class)
    public void persistInvalidProduct() {
        Payment pag = new Payment();
        try{
        em.persist(pag);
        em.flush();
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
            
            assertEquals(1, constraintViolations.size());
            assertNull(pag.getOrder());    
            throw ex;
        }
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void atualizeInvalidProduct() {
        TypedQuery<Payment> query = em.createQuery("SELECT pag FROM Payment pag WHERE pag.id = ?1", Payment.class);
        query.setParameter(1, 1);
        Payment pag = query.getSingleResult();           
        pag.setMoment("2022-06-20T19:53:0007Z");
        try {
            em.flush();
        } catch (ConstraintViolationException ex) {    
            assertEquals(1, ex.getConstraintViolations().size());
            throw ex;
        }
    }
    
}
