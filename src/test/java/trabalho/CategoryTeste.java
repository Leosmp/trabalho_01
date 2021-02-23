/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import entities.Category;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Souza
 */
public class CategoryTeste extends Teste {
    
    @Test
    public void persistirCategoria() {
        Category categoria = new Category();
        categoria.setName("Food"); 
        em.persist(categoria);
        em.flush();
        System.out.println("AQUIIII --------->"+categoria.getId());
        assertNotNull(categoria.getId());
    }
    
    @Test
    public void consultarCategoria() {
        Category categoria = em.find(Category.class, 4L);
        assertEquals("Food", categoria.getName());        
    }
    
    
    
    
}
