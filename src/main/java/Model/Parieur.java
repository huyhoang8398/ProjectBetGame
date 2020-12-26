package Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Parieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    int money;
    String twitterName;

    @OneToMany
    List<Pari> pariLst;

    @OneToOne
    UserAccount userAccount;

    public Parieur() {
    }

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

    public String getTwitterName() {
        return twitterName;
    }

    public void setTwitterName(String twitterName) {
        this.twitterName = twitterName;
    }

    public List<Pari> getPariLst() {
        return pariLst;
    }

    public void setPariLst(List<Pari> pari) {
        this.pariLst = pari;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
