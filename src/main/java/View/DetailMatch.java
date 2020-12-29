package View;

import Controller.ParieurController;
import Model.Matche;
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
}
