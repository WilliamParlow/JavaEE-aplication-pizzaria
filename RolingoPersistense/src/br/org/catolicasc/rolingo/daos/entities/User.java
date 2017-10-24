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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Cliente
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name = "User.authenticate",
            query = "SELECT usr FROM User usr WHERE usr.login = :login AND usr.passwd = :passwd"
    )
})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = false, nullable = false, length = 45)
    private String name;

    @Column(unique = true, nullable = false, length = 45)
    private String login;

    @Column(unique = false, nullable = false, length = 45)
    private String passwd;

    @Column(unique = false, nullable = false)
    private boolean admin;
    
    @Column(unique = false, nullable = false)
    private boolean blocked;

    public User() {
        super();
    }

    public User(String name, String login, String passwd, boolean admin, boolean blocked) {
        this.name = name;
        this.login = login;
        this.passwd = passwd;
        this.admin = admin;
        this.blocked = blocked;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setIsAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return "br.org.catolicasc.rolingo.daos.entities.User[ id=" + id + " ]";
    }

}
