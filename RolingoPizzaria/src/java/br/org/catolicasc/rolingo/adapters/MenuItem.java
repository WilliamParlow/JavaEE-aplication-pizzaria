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
public class MenuItem {
    
    private String name;
    private String url;

    public MenuItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public final void setUrl(String url) {
        this.url = url;
    }
    
}
