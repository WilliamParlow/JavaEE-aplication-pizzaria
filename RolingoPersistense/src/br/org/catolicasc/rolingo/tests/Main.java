/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rolingo.tests;
import br.org.catolicasc.rolingo.daos.UserDAO;
import br.org.catolicasc.rolingo.daos.entities.User;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Cliente
 */
public class Main {
    
    private static final String PERSISTENCE_UNIT_NAME = "RolingoPersistensePU";
    
    public static void main(String[] args) {
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO userDao = new UserDAO(factory);
        
//        User user = new User("Bianca", "bia@gmail.com", "bia@123qwe", false);
//        userDao.create(user);

        userAuthenticatedTest("will@gmail.com", "Will@123qwe");
        userAuthenticatedTest("ander@gmail.com", "Will@123qwe");
        
    }
    
    private static void userAuthenticatedTest(String login, String passwd) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO userDao = new UserDAO(factory);
        
        try {
            User user = userDao.findUser(login, passwd);
            
            System.out.println(String.format("User authenticated: %s", user.getName()));
        } catch (Exception e) {
            System.err.println(String.format("Fail to authenticate with login: %s & pass: %s", login, passwd));
        }
        
    }
    
}
