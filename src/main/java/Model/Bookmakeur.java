package Model;

import javax.persistence.*;

@Entity
public class Bookmakeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @OneToOne
    Matche matcheHost;
    @OneToOne
    Cote cote;

    @OneToOne
    UserAccount userAccount;

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

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Matche getMatcheHost() {
        return matcheHost;
    }

    public void setMatcheHost(Matche matcheHost) {
        this.matcheHost = matcheHost;
    }
}
