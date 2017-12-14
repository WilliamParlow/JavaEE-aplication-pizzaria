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
public class InputFormModel {

    private String id;
    private String name;
    private String type;
    private String value;
    private String classname;
    private String placeholder;
    private String label;
    private String inputtype;
    private boolean isRequired;
    private boolean isDisable;
    private boolean isHidden;

    public InputFormModel() {
        super();
    }

    public InputFormModel(String id, String name, String type, String value, String classname, String placeholder, String label, String inputtype, boolean isRequired, boolean isDisable, boolean isHidden) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
        this.classname = classname;
        this.placeholder = placeholder;
        this.label = label;
        this.inputtype = inputtype;
        this.isRequired = isRequired;
        this.isDisable = isDisable;
        this.isHidden = isHidden;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String isRequired() {
        return (isRequired) ? "required" : "";
    }

    public void setIsRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public String isDisable() {
        return (isDisable) ? "disabled" : "";
    }

    public void setIsDisable(boolean isDisable) {
        this.isDisable = isDisable;
    }

    public String isHidden() {
        return (isHidden) ? "hidden" : "";
    }

    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getInputtype() {
        return inputtype;
    }

    public void setInputtype(String inputtype) {
        this.inputtype = inputtype;
    }

}
