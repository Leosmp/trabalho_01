/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
import entities.Client;
import entities.User;
import java.util.Calendar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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
        em.persist(usuario);
        em.flush(); //força que a persistência realizada vá para o banco neste momento.

        assertNotNull(usuario.getId());

    }
    
    @Test
    public void consultarClient() {
        Client usuario = em.find(Client.class, 3L);
        assertEquals("963258", usuario.getPhone());
        assertEquals("leo@gmail.com", usuario.getEmail());
        assertEquals("Leonardo Luiz",usuario.getName());

    }
    
        private Client criarClient() {
        Client usuario = new Client();
        usuario.setName("Leonardo Luiz");
        usuario.setEmail("leo@gmail.com");
        usuario.setPhone("963258");
        usuario.setPassword("123965");
               
        return usuario;
    }
    
}
