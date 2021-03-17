/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import entities.Client;
import entities.Product;
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
public class ProductValidationTest extends Teste {
    
        @Test(expected = ConstraintViolationException.class)
    public void persistInvalidProduct() {
        Product produto = new Product();
        try{
        em.persist(produto);
        em.persist(produto);
        em.flush();
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
            
            assertEquals(3, constraintViolations.size());
            assertNull(produto.getDescription());
            assertNull(produto.getPrice());
            assertNull(produto.getName());
            throw ex;
        }
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void atualizeInvalidProduct() {
        TypedQuery<Product> query = em.createQuery("SELECT produto FROM Product produto WHERE produto.id = ?1", Product.class);
        query.setParameter(1, 1);
        Product produto = query.getSingleResult();           
        produto.setPrice(108301801830178301.02);
        try {
            em.flush();
        } catch (ConstraintViolationException ex) {    
            assertEquals(1, ex.getConstraintViolations().size());
            throw ex;
        }
    }
    
}
