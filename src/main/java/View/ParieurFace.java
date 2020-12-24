package View;

import Model.Matche;
import Model.Pari;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ParieurFace implements Serializable {
    long id;
    String name;
    int money;

    public List<Matche> getListOfMatch(String search) {
        return null;
    }

    public int pickPariMatch(int idmatch, Pari pari) {
        return 0;
    }

    public int updatePariMatch(int idmatch, Pari pari) {
        return 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
