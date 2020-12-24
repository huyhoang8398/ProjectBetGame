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
}
