/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import entities.Category;
import entities.Order;
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
public class CategoryValidationTest extends Teste {
        
    @Test(expected = ConstraintViolationException.class)
    public void persistInvalidCategory() {
        Category categoria = new Category();
        try{
        em.persist(categoria);
        em.persist(categoria);
        em.flush();
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
            
            assertEquals(1, constraintViolations.size());
            assertNull(categoria.getId());
            throw ex;
        }
    }
    
    @Test(expected = ConstraintViolationException.class)
    public void atualizeInvalidCategory() {
        TypedQuery<Category> query = em.createQuery("SELECT cat FROM Category cat WHERE cat.id = ?1", Category.class);
        query.setParameter(1, 3);
        Category cat = query.getSingleResult();   
        cat.setName("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut commodo semper ligula, sit amet semper mi. Donec porta imperdiet odio quis lobortis. Proin ullamcorper rhoncus tortor a fermentum. Sed quis pretium velit. In sollicitudin, velit euismod blandit ultrices, metus nunc commodo risus, sed scelerisque turpis nisl in ipsum. Cras ac porttitor odio. ");

        try {
            em.flush();
        } catch (ConstraintViolationException ex) {    
            assertEquals(1, ex.getConstraintViolations().size());
            throw ex;
        }
    }
    
}
