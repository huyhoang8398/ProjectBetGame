package View;

import Model.Match;
import Model.Pari;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class Parieur implements Serializable {
    String name;
    int money;

    public List<Match> getListOfMatch(String search){
        return null;
    }
    public int pickPariMatch(int idmatch, Pari pari){
        return 0;
    }
    public int updatePariMatch(int idmatch, Pari pari){
        return 0;
    }
}
