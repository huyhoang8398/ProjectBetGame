package View;

import Controller.BookmakeurController;
import Controller.ParieurController;
import Model.Matche;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.json.JsonObject;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped

public class DetailMatch implements Serializable {
    private int id;
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

    public Matche getDetailMatch() {
        return data.getDetailMatch(id);
    }
}
