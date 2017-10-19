package br.org.catolicasc.rolingo.json.results;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fabio Tavares Dippold
 * 
 */
public class SimpleResult implements Serializable {
    private static final long serialVersionUID = -1449461141547054088L;
    
    private boolean success = true;
    private int count = 0;
    private Object datasource;
    private List<Error> errors;

    public SimpleResult() {
        this.errors = new ArrayList<>();
    }
    
    

    public void addError(Error error) {
        this.getErrors().add(error);
    }
    
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getDatasource() {
        return datasource;
    }

    public void setDatasource(Object datasource) {
        this.datasource = datasource;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
    
}
