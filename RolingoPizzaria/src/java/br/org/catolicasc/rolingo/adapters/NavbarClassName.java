/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rolingo.adapters;

/**
 *
 * @author Cliente
 */
public class NavbarClassName {
    
    private String pizza;
    private String dessert;
    private String drink;

    public NavbarClassName() {
        super();
    }

    public NavbarClassName(String pizza, String dessert, String drink) {
        this.pizza = pizza;
        this.dessert = dessert;
        this.drink = drink;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }
    
}
