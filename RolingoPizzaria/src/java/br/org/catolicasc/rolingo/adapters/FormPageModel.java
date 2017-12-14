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
public class FormPageModel {

    private String pageName;
    private String controller;
    private String formhidden;
    private String edithidden;
    private String domenu;
    private String formaction;
    private long modelid;

    public FormPageModel() {
        super();
    }

    public FormPageModel(String pageName, String controller, String formhiddem, String edithiddem, String domenu, String formaction, long modelid) {
        this.pageName = pageName;
        this.controller = controller;
        this.formhidden = formhiddem;
        this.edithidden = edithiddem;
        this.domenu = domenu;
        this.formaction = formaction;
        this.modelid = modelid;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getFormhidden() {
        return formhidden;
    }

    public void setFormhidden(String formhidden) {
        this.formhidden = formhidden;
    }

    public String getEdithidden() {
        return edithidden;
    }

    public void setEdithidden(String edithidden) {
        this.edithidden = edithidden;
    }

    public long getModelid() {
        return modelid;
    }

    public void setModelid(long modelid) {
        this.modelid = modelid;
    }

    public String getDomenu() {
        return domenu;
    }

    public void setDomenu(String domenu) {
        this.domenu = domenu;
    }

    public String getFormaction() {
        return formaction;
    }

    public void setFormaction(String formaction) {
        this.formaction = formaction;
    }
    
}
