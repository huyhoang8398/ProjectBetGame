package Model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;

@Entity
public class Pari {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    int money;
    int teamId;

    @OneToOne
    Cote cote;

    @OneToOne
    Matche matche;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Cote getCote() {
        return cote;
    }

    public void setCote(Cote cote) {
        this.cote = cote;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Matche getMatche() {
        return matche;
    }

    public void setMatche(Matche matche) {
        this.matche = matche;
    }

    public JsonObject toJsonObject() {
        return Json.createObjectBuilder()
                .add("id", id)
                .add("money", money)
                .add("teamId", teamId)
                .add("matche", matche.toJsonObject())
                .add("cote", cote.toJsonObject()).build();
    }


    public Pari fromJsonObject(JsonObject jsonObject) {
        if(jsonObject.containsKey("id")) {
            this.setId(Long.parseLong(jsonObject.get("id").toString()));
        }
        this.setMoney(jsonObject.getInt("money"));
        this.setTeamId(jsonObject.getInt("teamId"));
        Matche m = new Matche();
        this.setMatche(m.fromJsonObject(jsonObject.getJsonObject("matche")));
        Cote cote = new Cote();
        this.setCote(cote.fromJsonObject(jsonObject.getJsonObject("cote")));
        return this;
    }
}
