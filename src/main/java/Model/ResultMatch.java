package Model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;

@Entity
public class ResultMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String winner = "";
    int scoreHomeTeam = 0;
    int scoreAwayTeam = 0;
    @OneToOne
    Matche matche;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getScoreHomeTeam() {
        return scoreHomeTeam;
    }

    public void setScoreHomeTeam(int scoreHomeTeam) {
        this.scoreHomeTeam = scoreHomeTeam;
    }

    public int getScoreAwayTeam() {
        return scoreAwayTeam;
    }

    public void setScoreAwayTeam(int scoreAwayTeam) {
        this.scoreAwayTeam = scoreAwayTeam;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JsonObject toJsonObject() {
        return Json.createObjectBuilder()
                .add("winner", winner)
                .add("scoreHomeTeam", scoreHomeTeam)
                .add("scoreAwayTeam", scoreAwayTeam).build();
    }

    public ResultMatch fromJsonObject(JsonObject jsonObject) {
        if (jsonObject.containsKey("id")) {
            this.setId(jsonObject.getInt("id"));
        }

        this.setScoreAwayTeam(jsonObject.getInt("scoreAwayTeam"));
        this.setScoreHomeTeam(jsonObject.getInt("scoreHomeTeam"));
        this.setWinner(jsonObject.getString("winner"));
        return this;
    }
}
