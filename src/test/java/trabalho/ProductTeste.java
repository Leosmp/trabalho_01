/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import entities.Product;
import entities.User;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Souza
 */
public class ProductTeste extends Teste {
    
    @Test
    public void persistirProduto() {
        Product produto;
        produto = criarProduto();
        em.persist(produto);
        em.flush(); //força que a persistência realizada vá para o banco neste momento.

        assertNotNull(produto.getId());

    }
    
    @Test
    public void consultarProduto() {
        Product produto = em.find(Product.class, 6L);
        assertEquals("Notebook",produto.getName());
        assertEquals("Um notebook comum",produto.getDescription());
        assertEquals("1500.0",produto.getPrice().toString());
    }
    
    
        private Product criarProduto() {
        Product produto = new Product();
        produto.setName("Notebook");
        produto.setDescription("Um notebook comum");
        produto.setPrice(1500.0);
        produto.setImgUrl("null");
       
        return produto;
    }
        
      @Test
      public void atualizarProduto(){
        logger.info("Executando atualizarProduto()");
        String novoNome = "Notebook HP";
        String novaDesc = "Um notebook de última geraçao";
        double novoPreco= 2000.0;
        Product produto = em.find(Product.class, 5L);
        produto.setName(novoNome);
        produto.setDescription(novaDesc);
        produto.setPrice(novoPreco);
        produto.setImgUrl("null");
        assertNotNull(produto);        
        em.clear();        
        em.merge(produto);
        em.flush();
      }
      
      @Test
      public void removerProduto(){
        logger.info("Executando removerCategoria()");
        Product produto = em.find(Product.class, 6L);
        assertNotNull(produto);
        em.remove(produto);
        em.flush();
      }
    
}
