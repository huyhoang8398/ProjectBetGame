package View;

import Controller.AdministrateurController;
import Model.Parieur;
import Model.UserAccount;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named
@ViewScoped
public class Register implements Serializable {
    String username;
    String name;
    String password;
    String twitterName;
    String confirmPassword;

    @EJB
    AdministrateurController administrateurController;

    public Register() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTwitterName() {
        return twitterName;
    }

    public void setTwitterName(String twitterName) {
        this.twitterName = twitterName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    public long regist() {
        if (password.equals(confirmPassword))
        {
            Parieur parieur = new Parieur();
            parieur.setPariLst(new ArrayList<>());
            parieur.setName(name);
            parieur.setTwitterName(twitterName);
            UserAccount userAccount = new UserAccount();
            userAccount.setUsername(username);
            userAccount.setRole(0);
            userAccount.setPassword(password);
            parieur.setUserAccount(userAccount);
            long rs = administrateurController.createParieur(parieur);
            if (rs == -1) FacesContext.getCurrentInstance().addMessage("registerForm:registerUsername", new FacesMessage("Your username has been taken", "Your username has been taken"));
            else FacesContext.getCurrentInstance().addMessage("registerForm:registerStatus", new FacesMessage(FacesMessage.SEVERITY_INFO,"Your account has been registed", "Your account has been registed"));
            return rs;
        }
        FacesContext.getCurrentInstance().addMessage("registerForm:confirmPassword", new FacesMessage("Invalid Password", "You need to enter same password"));
        return -1;
    }
}