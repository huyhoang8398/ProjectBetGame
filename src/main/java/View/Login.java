package View;

import Controller.AdministrateurController;
import Controller.LoginController;
import Controller.ParieurController;
import Model.*;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class Login implements Serializable {
    String username;
    String password;
    boolean userLogined = false;
    @EJB
    AdministrateurController administrateurController;
    @EJB
    ParieurController parieurController;
    @EJB
    LoginController loginController;

    public Login() {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUserLogined() {
        return userLogined;
    }

    public void setUserLogined(boolean userLogined) {
        this.userLogined = userLogined;
    }

    public void test() {
        UserAccount admin = new UserAccount();
        admin.setRole(2);
        admin.setUsername("admin");
        admin.setPassword("admin");
        administrateurController.createAccount(admin);
    }

    public Integer login(String username, String password) {
        return loginController.checkLogin(username, password);
    }

}
