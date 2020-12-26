package Model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;

@Entity
public class Cote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long exactScore = 0;
    int victory = 0;
    int loss = 0;
    int pointNumber = 0;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }


    public long getExactScore() {
        return exactScore;
    }

    public void setExactScore(long exactScore) {
        this.exactScore = exactScore;
    }

    public int getVictory() {
        return victory;
    }

    public void setVictory(int victory) {
        this.victory = victory;
    }

    public int getLoss() {
        return loss;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getPointNumber() {
        return pointNumber;
    }

    public void setPointNumber(int pointNumber) {
        this.pointNumber = pointNumber;
    }

    public JsonObject toJsonObject() {
        return Json.createObjectBuilder()
                .add("id", id)
                .add("exactScore", exactScore)
                .add("victory", victory)
                .add("loss", loss)
                .add("pointNumber", pointNumber).build();
    }



    public Cote fromJsonObject(JsonObject jsonObject) {
        this.setId(Long.parseLong(jsonObject.get("id").toString()));
        this.setExactScore(jsonObject.getInt("exactScore"));
        this.setVictory(jsonObject.getInt("victory"));
        this.setLoss(jsonObject.getInt("loss"));
        this.setPointNumber(jsonObject.getInt("pointNumber"));
        return this;
    }
}
