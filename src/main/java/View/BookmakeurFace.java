package View;

import Controller.AdministrateurController;
import Controller.BookmakeurController;
import Controller.ParieurController;
import Model.Bookmakeur;
import Model.Cote;
import Model.Matche;
import Model.UserAccount;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class BookmakeurFace implements Serializable {
    long id;
    Matche matcheHost;
    Cote cote;

    @EJB
    BookmakeurController controller;

    @EJB
    AdministrateurController administrateurController;

    List<Matche> macths;

    public Matche getMatchHost() {
        return matcheHost;
    }

    public void setMatchHost(Matche matcheHost) {
        this.matcheHost = matcheHost;
    }

    public Cote getCote() {
        return cote;
    }

    public void setCote(Cote cote) {
        this.cote = cote;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Matche> getMacths() {
        return controller.getScheduleMatche();
    }

    public void createBookmaker(Matche matche ){
        Bookmakeur bookmakeur = new Bookmakeur();
        bookmakeur.setMatcheHost(matche);
        UserAccount bookmaker1 = new UserAccount();
        bookmaker1.setUsername("bookmaker1");
        bookmaker1.setPassword("bookmaker1");
        bookmaker1.setRole(1);
        bookmakeur.setUserAccount(bookmaker1);
        Cote cote = new Cote();
        bookmakeur.setCote(cote);
        administrateurController.createBookmakeur(bookmakeur);
    }
}
