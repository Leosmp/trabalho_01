/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
import entities.Client;
import entities.Order;
import entities.User;
import entities.enunm.OrderStatus;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CacheRetrieveMode;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;


/**
 *
 * @author Souza
 */
public class ClientTeste extends Teste {
    

    @Test
    public void persistirClient() {
        Client usuario;
        usuario = criarClient();
        if(usuario != null){
            em.persist(usuario);
        }        
        em.flush(); //força que a persistência realizada vá para o banco neste momento.

        assertNotNull(usuario.getId());

    }
    
    @Test
    public void consultarClient() {
        Client usuario = em.find(Client.class, 1L);
        assertEquals("988888888", usuario.getPhone());
        assertEquals("maria@gmail.com", usuario.getEmail());
        assertEquals("Maria Brown",usuario.getName());

    }
    
        private Client criarClient() {
        Client usuario = new Client();
        usuario.setName("Leonardo Luiz");
        usuario.setEmail("leo@gmail.com");
        usuario.setPhone("963258888");
        usuario.setPassword("123965");
               
        return usuario;
    }
        
        @Test
    public void atualizarUsuario() {
        logger.info("Executando atualizarUsuario()");
        String novoNome = "Leonardo Luiz Souto";
        String novoEmail = "leoluiz@gmail.com";
        String novoTelefone = "990901010";
        String novaSenha = "654321"; 
        long id = 2L;
        Client cliente = em.find(Client.class, id);
        cliente.setEmail(novoEmail);
        cliente.setPhone(novoTelefone);
        cliente.setPassword(novaSenha);
        cliente.setName(novoNome);
        em.clear();
        em.merge(cliente);
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);
        cliente = em.find(Client.class, id, properties);
        assertEquals(novoEmail, cliente.getEmail());        
        assertEquals(novaSenha,cliente.getPassword());
    }
    
    
    @Test
    public void removerClient() {
        logger.info("Executando removerClient()");
        Client client = em.find(Client.class, 3L);
        if(client != null){
            em.remove(client);
        }        
        User user = em.find(User.class, 3L);
        assertNull(user);
    }
    
    public void criarOrder(Client cliente) {
        Order order = new Order();
        order.setMoment("2019-08-20T19:53:07Z");
        order.setOrderStatus(OrderStatus.WAITING_PAYMENT);
        order.setPayment(null);
        cliente.setOrders(order);
        em.persist(order);
        em.flush();
        assertNotNull(order.getId());
    }

    
}
