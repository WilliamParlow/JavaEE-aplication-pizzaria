/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rolingo.daos;

import javax.persistence.EntityManagerFactory;



/**
 *
 * @author Cliente
 */
public class DrinkDAO extends DrinkJpaController {
    
    private static final long serialVersionUID = 1L;
    
    public DrinkDAO(EntityManagerFactory emf) {
        super(emf);
    }
    
}
