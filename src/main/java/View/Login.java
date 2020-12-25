package View;

import Controller.AministrateurController;
import Controller.ParieurController;
import Model.*;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

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
        bookmakeur.setMatchHost(new Matche());
        administrateurController.createBookmakeur(bookmakeur);

    }

    public void test2() {
        List<Bookmakeur> listBookmakeur = administrateurController.getListBookmakeur();
        List<Matche> listMatches = administrateurController.getListMatche();
        System.out.println("\n-------------------------------------------------------");
        for (Bookmakeur m : listBookmakeur) {
            System.out.println("bookmakerid" + m.getId());
        }
        for (Matche m : listMatches) {
            System.out.println("matchid" + m.getId());
        }
    }

    public void test3() {
        List<Bookmakeur> listBookmakeur = administrateurController.getListBookmakeur();
        Bookmakeur bookmakeur = listBookmakeur.get(0);
        administrateurController.deleteBookmakeur(bookmakeur);
    }

    public void test4() {
//        List<Bookmakeur> listBookmakeur = administrateurController.getListBookmakeur();
//        Bookmakeur bookmakeur = listBookmakeur.get(0);
//        administrateurController.deleteBookmakeur(bookmakeur);

        Pari pari = new Pari();
        List<Matche> listMatch = parieurController.getListMatch("");
        pari.setMatche(listMatch.get(0));
        pari.setCote(new Cote());

        parieurController.createPari(1,pari);
    }
}
