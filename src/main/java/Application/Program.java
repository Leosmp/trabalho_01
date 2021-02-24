/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import entities.Category;
import entities.Client;
import entities.Order;
import entities.Payment;
import entities.Product;
import entities.User;
import entities.enunm.OrderStatus;
import java.time.Instant;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Dev Dreamm
 */
public class Program {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho_01");
    
    public static void main(String[] args) {   

        Client c1 = new Client(null, "Leonardo Luiz", "leo@gmail.com", "963258", "123965");
        //System.out.println("AQUI ----------> "+new User().toString());
        EntityManager em = null;
        EntityTransaction et = null;

        try {
            em = emf.createEntityManager(); //Criação do EntityManager.
            et = em.getTransaction(); //Recupera objeto responsável pelo gerenciamento de transação.
            et.begin();
            em.persist(c1);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
