package View;

import Model.Cote;
import Model.Match;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class Bookmakeur implements Serializable {
    Match matchHost;
    Cote cote;

    public Match getMatchHost() {
        return matchHost;
    }

    public void setMatchHost(Match matchHost) {
        this.matchHost = matchHost;
    }

    public Cote getCote() {
        return cote;
    }

    public void setCote(Cote cote) {
        this.cote = cote;
    }
}
