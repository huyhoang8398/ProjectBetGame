package View;

import Controller.AdministrateurController;
import Controller.ParieurController;
import Model.*;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped

public class DetailMatchFace implements Serializable {
    private int id;
    private int amount;
    private int moneyLeft;


    @EJB
    ParieurController data;
    Matche match;

    @Inject
    LoginFace loginFace;
    @EJB
    AdministrateurController administrateurController;

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


    public int getMoneyLeft() {
        UserAccount user = loginFace.getAuthenticationController().getUser();

        if (user != null) {
            Parieur parieurByUsername = administrateurController.getParieurByUsername(user.getUsername());
            this.moneyLeft = parieurByUsername.getMoney();
        }
        return moneyLeft;
    }

    public void betMatch(Integer id, Matche match) {
        if (amount > 0) {
            Cote cote = new Cote();
            cote.setExactScore(50);

            Pari pari = new Pari();
            pari.setMoney(amount);
            pari.setTeamId(id);
            pari.setCote(cote);
            pari.setMatche(match);

            UserAccount user = loginFace.getAuthenticationController().getUser();

            if (user != null) {
                Parieur parieurByUsername = administrateurController.getParieurByUsername(user.getUsername());
                data.createPari(parieurByUsername.getId(), pari);
            }
        }
    }

    public void autoBet(Integer id, Matche match) {
        Cote cote = new Cote();
        cote.setExactScore(50);

        Pari pari = new Pari();
        pari.setMoney(moneyLeft/2);
        pari.setTeamId(id);
        pari.setCote(cote);
        pari.setMatche(match);

        UserAccount user = loginFace.getAuthenticationController().getUser();

        if (user != null) {
            Parieur parieurByUsername = administrateurController.getParieurByUsername(user.getUsername());
            data.createPari(parieurByUsername.getId(), pari);
        }
    }

    public Integer getSuggestMoney() {
        return moneyLeft / 2;
    }
}
