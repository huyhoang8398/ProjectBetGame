package View;

import Model.Matche;
import Model.Pari;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@SessionScoped
public class ParieurFace implements Serializable {
    long id;
    String name;
    int money;

    List<Matche> macths;

    @Inject
    DetailMatch detailMatch;

//    public JsonArray getListOfMatch(String search) {
//        JsonArray value = Json.createArrayBuilder()
//                .add(Json.createObjectBuilder()
//                        .add("id", 124)
//                        .add("homeTeam", "Crystal Palace FC")
//                        .add("awayTeam", "Leicester City FC"))
//                .add(Json.createObjectBuilder()
//                        .add("id", 125)
//                        .add("homeTeam", "Manchester United FC")
//                        .add("awayTeam", "Manchester City FC"))
//                .add(Json.createObjectBuilder()
//                        .add("id", 126)
//                        .add("homeTeam", "Barcelona FC")
//                        .add("awayTeam", "Athletic Bilbao FC"))
//                .build();
//
//        return value;
//    }

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

    public String detailMatch(int id) {
        detailMatch.setId(id);
        return "";
    }

    public List<Matche> getMacths() {
        Matche matche = new Matche();
        matche.setId(1);
        matche.setHomeTeam("Crrr");
        matche.setAwayTeam("CSSr");

        Matche matche2 = new Matche();

        matche2.setId(2);
        matche2.setHomeTeam("2");
        matche2.setAwayTeam("2");

        return Arrays.asList(matche, matche2);
    }
}
