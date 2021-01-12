package View;

import Controller.AuthenticationController;
import Controller.ParieurController;
import Model.Cote;
import Model.Matche;
import Model.Pari;
import Model.UserAccount;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped

public class DetailMatch implements Serializable {
    private int id;
    private int amount;
    @EJB
    ParieurController data;
    Matche match;

    @EJB
    AuthenticationController authController;

    public Matche getMatch() {
        return match;
    }

    public void setMatch(Matche match) {
        this.match = match;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Matche getDetailMatch() {
        return data.getDetailMatch(id);
    }

    public void betMatch(Integer id, Matche match) {
        Cote cote = new Cote();
        cote.setExactScore(50);

        Pari pari = new Pari();
        pari.setMoney(amount);
        pari.setTeamId(id);
        pari.setCote(cote);
        pari.setMatche(match);

        UserAccount user = authController.getUser();

        if (user != null) data.createPari(user.getUsername(), pari);
    }

}
