package View;

import Controller.ParieurController;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped

public class DetailMatch implements Serializable {
    private int id;
    @EJB
    ParieurController data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
