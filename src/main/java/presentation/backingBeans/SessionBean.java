package presentation.backingBeans;

import data.dao.jpa.UserDAOJpa;
import data.dao.spec.UserDAO;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean {

    private String userName = "default_schema";

    private String currentSchema = "default_schema";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCurrentSchema() {
        return currentSchema;
    }

    public void setCurrentSchema(String currentSchema) {
        this.currentSchema = currentSchema;
    }
}
