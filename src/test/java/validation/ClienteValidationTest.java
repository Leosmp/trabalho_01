/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import entities.Client;
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
public class ClienteValidationTest extends Teste {
            
    @Test(expected = ConstraintViolationException.class)
    public void persistInvalidClient() {
        Client client = new Client();
        client.setPassword("123");
        client.setEmail("invalidemail");
        client.setPhone("1234567890");
        try{
        em.persist(client);
        em.flush();
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
            
            assertEquals(4, constraintViolations.size());
            assertNull(client.getId());
            throw ex;
        }
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void atualizeInvalidClient() {
        TypedQuery<Client> query = em.createQuery("SELECT client FROM Client client WHERE client.id = ?1", Client.class);
        query.setParameter(1, 2);
        Client client = query.getSingleResult();           
        client.setPassword("123456789");
        try {
            em.flush();
        } catch (ConstraintViolationException ex) {    
            assertEquals(1, ex.getConstraintViolations().size());
            throw ex;
        }
    }
    
}
