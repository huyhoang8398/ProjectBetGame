package Model;

import javax.json.Json;
import javax.json.JsonObject;

public class ResultMatch {
    String winner;
    int scoreHomeTeam;
    int scoreAwayTeam;

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

    public JsonObject toJsonObject(){
        return Json.createObjectBuilder()
                .add("winner",winner)
                .add("scoreHomeTeam",scoreHomeTeam)
                .add("scoreAwayTeam",scoreAwayTeam).build();
    }
}
