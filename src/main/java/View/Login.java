package View;

import Controller.AministrateurController;
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
    AministrateurController administrateurController;
    @EJB
    ParieurController parieurController;

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
        Bookmakeur bookmakeur = new Bookmakeur();
        bookmakeur.setCote(new Cote());
        bookmakeur.setMatcheHost(new Matche());
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("1");
        bookmakeur.setUserAccount(userAccount);
        administrateurController.createBookmakeur(bookmakeur);
    }

    //TODO login func
}
