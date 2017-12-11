/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.rolingo.daos.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Cliente
 */
@Entity
public class Dessert implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = false, nullable = false, length = 45)
    private String name;
    
    @Column(unique = false, nullable = false, length = 2000)
    private String recipe;
    
    @Column(unique = false, nullable = false, length = 45)
    private String ingredient;
    
    @Column(unique = false, nullable = true)
    private String imageUrl;

    public Dessert() {
        super();
    }

    public Dessert(String name, String recipe, String ingredient, String imageUrl) {
        this.name = name;
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.imageUrl = imageUrl;
    }
    
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
}