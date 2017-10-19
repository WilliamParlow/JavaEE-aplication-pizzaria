/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rolingo.daos;

import br.org.catolicasc.rolingo.daos.entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Cliente
 */
public class UserDAO extends UserJpaController {
    
    private static final long serialVersionUID = 1L;
    
    public UserDAO(EntityManagerFactory emf) {
        super(emf);
    }
    
    public User findUser(String login, String passwd) {
        EntityManager user = getEntityManager();
        try {
            return (User) user.createNamedQuery("User.authenticate")
                    .setParameter("login", login)
                    .setParameter("passwd", passwd)
                    .getSingleResult();
        
        } finally {
            user.close();
        }
        
    }
        
}
