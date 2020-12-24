package View;

import Model.Cote;
import Model.Matche;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class BookmakeurFace implements Serializable {
    long id;
    Matche matcheHost;
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
