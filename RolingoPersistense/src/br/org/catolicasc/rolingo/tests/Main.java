/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rolingo.tests;

import br.org.catolicasc.rolingo.daos.*;
import br.org.catolicasc.rolingo.daos.entities.*;
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
//        UserDAO userDao = new UserDAO(factory);
//        createNewUser("Will", "w@gmail.com", "123qwe", false, false);

//        DrinkDAO dao = new DrinkDAO(factory);
//        for (int i = 0; i < 12; i++) {
//            Drink ds = new Drink("Suco de Laranja", 
//                    "asd asd asdasdasd asdasdas das das dasdasd asd asd asd asd asd asd asd asd asdas da sdas dasd asd asd asd asd asd asd asd asd asd asd asd ",
//                    "1- asdasd asd a 2- 123123123 3- asd asd asd as 4- asd asd asd asd as d 5- asd asd as d",
//                    "https://i.pinimg.com/736x/cf/01/5b/cf015bb368357c198508fb1e94f6367d--orange-crush-drink-orange-crush-cocktail.jpg"
//            );
//            dao.create(ds);
//        }
        

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

    private static void createNewUser(String name, String email, String passwd, boolean isAdmin, boolean isBlock) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        UserDAO userDao = new UserDAO(factory);

        User user = new User(name, email, passwd, false, false);
        userDao.create(user);

    }

}
