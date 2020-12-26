package View;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped

public class DetailMatch implements Serializable {
    private int id;

//    public JsonArray getMatchDetail(String id) {
//        JsonArray matchDetail = Json.createArrayBuilder()
//                .add(Json.createObjectBuilder()
//                        .add("id", "124")
//                        .add("homeTeam", "Crystal Palace FC")
//                        .add("awayTeam", "Leicester City FC")
//                        .add("oddHomeTeam", "50")
//                        .add("oddAwayTeam", "50")
//                        .add("startDate", "2020-12-28T15:00:00Z"))
//                .build();
//        return matchDetail;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
