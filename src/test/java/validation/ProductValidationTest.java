/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import entities.Client;
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
public class ProductValidationTest extends Teste {
    
    @Test(expected = ConstraintViolationException.class)
    public void persistInvalidProduct() {
        Product produto = new Product();
        try{
            produto.setPrice(10001.0);
            em.persist(produto);
            em.flush();
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
            
            assertEquals(3, constraintViolations.size());
            assertNull(produto.getDescription());
            assertNull(produto.getName());
            throw ex;
        }
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void atualizeInvalidProduct() {
        TypedQuery<Product> query = em.createQuery("SELECT produto FROM Product produto WHERE produto.id = ?1", Product.class);
        query.setParameter(1, 1);
        Product produto = query.getSingleResult();           
        produto.setPrice(0.01);
        produto.setName("testetestetestetestetesteteste");
        try {
            em.flush();
        } catch (ConstraintViolationException ex) {    
            assertEquals(2, ex.getConstraintViolations().size());
            throw ex;
        }
    }
    
}
