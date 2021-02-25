/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import entities.Category;
import entities.Order;
import entities.OrderItem;
import entities.Payment;
import entities.Product;
import entities.enunm.OrderStatus;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Dev Dreamm
 */
public class JpqlTeste extends Teste{
    
    @Test
    public void categoriaPorNome(){
        logger.info("Executando categoriaPorNome()");
        TypedQuery<Category> query = em.createQuery(
            "SELECT c FROM Category c WHERE c.name LIKE :name", Category.class);
        query.setParameter("name", "Elect%");
        List<Category> categorias = query.getResultList();
        
        categorias.forEach(cat -> {
            assertTrue(cat.getName().startsWith("Elect"));
        });
        
        assertEquals(1, categorias.size());            
    }
    
    @Test
    public void categoriaPorNomeNamedQuery() {
        logger.info("Executando categoriaPorNomeNamedQuery()");
        TypedQuery<Category> query = em.createNamedQuery("Category.ByName", Category.class);
        query.setParameter("name", "Elect%");
        List<Category> categorias = query.getResultList();

        categorias.forEach(cat -> {
            assertTrue(cat.getName().startsWith("Elect"));
        });
        
        assertEquals(1, categorias.size());
    } 
    
    @Test
    public void pedidoPorData() {
        logger.info("Executando pedidoPorData()");
        TypedQuery<Order> query = em.createQuery(
                "SELECT o FROM Order o WHERE o.moment BETWEEN ?1 AND ?2",
                Order.class);
        query.setParameter(1, getData(20, Calendar.JUNE+1, 2019).toInstant().toString());//Janeiro = 0;
        query.setParameter(2, getData(23, Calendar.JUNE+1, 2019).toInstant().toString());
        
        List<Order> pedidos = query.getResultList();
        assertEquals(2, pedidos.size());
    }
    
    @Test
    public void pedidoPAID() {
        logger.info("Executando pedidoPAID()");
        TypedQuery<Order> query = em.createQuery(
                "SELECT o FROM Order o WHERE o.orderStatus = ?1",
                Order.class);
        query.setParameter(1, 2);
        
        List<Order> pedidos = query.getResultList();
        assertEquals(1, pedidos.size());
    }
    
    @Test
    public void itemPedidoPrecoMaxMin() {
        logger.info("Executando itemPedidoPrecoMaxMin()");
        Query query = em.createQuery(
                "SELECT MAX(oi.price), MIN(oi.price) FROM OrderItem oi");
        Object[] resultado = (Object[]) query.getSingleResult();
        String maiorPreco = resultado[0].toString();
        String menorPreco = resultado[1].toString();
        assertEquals("1250.0", maiorPreco);
        assertEquals("90.5", menorPreco);
    }
    
    @Test
    public void itemPedidoQtdMaiorQueUm() {
        logger.info("Executando itemPedidoQtdMaiorQueUm()");
        TypedQuery<OrderItem> query = em.createQuery(
                "SELECT oi FROM OrderItem oi WHERE oi.quantity > ?1", OrderItem.class);
        query.setParameter(1, 1);
        
        List<OrderItem> resultado = query.getResultList();
        assertEquals(3, resultado.size());
    }
    
    @Test
    public void pagamentoOrdenadoDesc() {
        logger.info("Executando pagamentoOrdenadoDesc()");
        TypedQuery<Payment> query = em.createQuery(
                "SELECT p FROM Payment p ORDER BY p.moment DESC",
                Payment.class);
        List<Payment> pagamentos = query.getResultList();
        assertEquals(3, pagamentos.size());

        pagamentos.forEach(pgto -> {
            assertNotNull(pgto.getMoment());
        });
    }
    
    @Test
    public void ordenacaoProdutoNome() {
        logger.info("Executando ordenacaoProdutoNome()");
        TypedQuery<Object[]> query;
        query = em.createQuery(
                "SELECT p.name, p.price FROM Product p ORDER BY p.name DESC",
                Object[].class);
        List<Object[]> produtos = query.getResultList();
        assertEquals(5, produtos.size());
        assertEquals("The Lord of the Rings: 90.5", produtos.get(0)[0] + ": " + produtos.get(0)[1]);
        assertEquals("Smart TV: 2190.0", produtos.get(1)[0] + ": " + produtos.get(1)[1]);
        assertEquals("Rails for Dummies: 100.99", produtos.get(2)[0] + ": " + produtos.get(2)[1]);
        assertEquals("PC Gamer: 1200.0", produtos.get(3)[0] + ": " + produtos.get(3)[1]);
        assertEquals("Macbook Pro: 1250.0", produtos.get(4)[0] + ": " + produtos.get(4)[1]);
    }
    
    @Test
    public void ordenacaoProdutoCategoria() {
        logger.info("Executando compradoresComCartao()");
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p JOIN p.categories cc ORDER BY p.price DESC",
                Product.class);
        List<Product> produtos = query.getResultList();
        assertEquals(6, produtos.size());

        produtos.forEach(produto -> {
            assertNotNull(produto.getPrice());
        });
    }
    
    @Test
    public void produtosCategoriaLeftJoin() {
        logger.info("Executando produtosCategoriaLeftJoin()");
        TypedQuery<Object[]> query;
        query = em.createQuery(
                "SELECT p.name, cat.name FROM Product p LEFT JOIN p.categories cat ORDER BY p.price",
                Object[].class);
        List<Object[]> produtos = query.getResultList();
        assertEquals(6, produtos.size());
    }
    
    
}
