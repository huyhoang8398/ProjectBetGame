package View;

import Controller.AministrateurController;
import Model.*;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class Datatable implements Serializable {

    @EJB
    AministrateurController administrateurController;

    List<Bookmakeur> bookmakeurs;
    List<Parieur> parieurs;
    List<Cote> cotes;
    List<Pari> paris;
    List<Matche> matches;
    List<UserAccount> userAccounts;

    public List<Bookmakeur> showBookmakeur() {
        List<Bookmakeur> listBookmakeur = administrateurController.getListBookmakeur();
        return listBookmakeur;
    }

    public List<Parieur> showParieur() {
        List<Parieur> listParieur = administrateurController.getListParieur();
        return listParieur;
    }

    public List<Cote> showCote() {
        List<Cote> listCote = administrateurController.getListCote();
        return listCote;
    }

    public List<Pari> showPari() {
        List<Pari> pariList = administrateurController.getListPari();
        return pariList;
    }

    public List<Matche> showMatche() {
        List<Matche> listMatche = administrateurController.getListMatche();
        return listMatche;
    }

    public List<UserAccount> showUserAccount() {
        List<UserAccount> userAccounts = administrateurController.getUserAccounts();
        return userAccounts;
    }

    public List<Bookmakeur> getBookmakeurs() {
        bookmakeurs = showBookmakeur();
        return bookmakeurs;
    }

    public List<Parieur> getParieurs() {
        parieurs = showParieur();
        return parieurs;
    }

    public List<Cote> getCotes() {
        cotes = showCote();
        return cotes;
    }

    public List<Pari> getParis() {
        paris = showPari();
        return paris;
    }

    public List<Matche> getMatches() {
        matches = showMatche();
        return matches;
    }

    public List<UserAccount> getUserAccounts() {
        userAccounts = showUserAccount();
        return userAccounts;
    }
}
