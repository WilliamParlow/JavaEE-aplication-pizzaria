package br.org.catolicasc.rolingo.json.results;

import java.io.Serializable;

/**
 *
 * @author Fabio Tavares Dippold
 * 
 */
public class Error implements Serializable {
    private static final long serialVersionUID = -1970284650516193381L;
    
    private int code;
    private String description;

    public Error(int code, String description) {
        setCode(code);
        setDescription(description);
    }
    
    public int getCode() {
        return code;
    }

    public final void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
