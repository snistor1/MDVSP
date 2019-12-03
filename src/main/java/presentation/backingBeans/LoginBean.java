package presentation.backingBeans;

import data.dao.jpa.UserDAOJpa;
import data.dao.models.User;
import data.dao.spec.UserDAO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean {

    private String name;
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public String login() {
        UserDAO userDAO = getSessionBean().getUserDAO();

        long startTime = System.nanoTime();
        User user = userDAO.findByName(name);
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println(elapsedTime);

        if (pass.equals(user.getPass())) {
            getSessionBean().setUserName(name);
            return "upload";
        }

        return "errorLogin";

    }

    private SessionBean getSessionBean() {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        return (SessionBean) facesContext.getApplication()
                .createValueBinding("#{sessionBean}").getValue(facesContext);
    }

    public String goToSignup() {
        return "signup";
    }

    public LoginBean(){
        getSessionBean().setUserName("default_schema");
    }
}
