/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;
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
public class UserTeste extends Teste {
    

    @Test
    public void persistirUsuario() {
        User usuario;
        usuario = criarUsuario();
        em.persist(usuario);
        em.flush(); //força que a persistência realizada vá para o banco neste momento.

        assertNotNull(usuario.getId());

    }
    
    @Test
    public void consultarUsuario() {
        User usuario = em.find(User.class, 1L);
        assertEquals("963258", usuario.getPhone());
        assertEquals("leo@gmail.com", usuario.getEmail());
        assertEquals("Leonardo Luiz",usuario.getName());

    }
    
        private User criarUsuario() {
        User usuario = new User();
        usuario.setName("Leonardo Luiz");
        usuario.setEmail("leo@gmail.com");
        usuario.setPhone("963258");
        usuario.setPassword("123965");
               
        return usuario;
    }
    
}
