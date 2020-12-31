package Controller;

import Model.Bookmakeur;
import Model.Matche;
import Service.FootballRestService;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class BookmakeurController {
    @PersistenceContext
    private EntityManager em;
    String competition = "PL";

    public List<Matche> getScheduleMatche() {
        return FootballRestService.getScheduleMatch(competition);
    }

    public JsonArray getScheduleMatcheJson(String search) {
        List<Matche> matches = new ArrayList();
        if (search.isEmpty()) {
            matches = FootballRestService.getScheduleMatch(competition);
        } else {
            String searchstr = search.toLowerCase();
            List<Matche> allMatches = FootballRestService.getScheduleMatch(competition);
            for (Matche m : allMatches) {
                if (m.getHomeTeam().toLowerCase().contains(searchstr) || m.getAwayTeam().toLowerCase().contains(searchstr) || searchstr.contains(m.getId() + "")) {
                    matches.add(m);
                }
            }
        }

        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Matche m : matches) {
            arrayBuilder.add(m.toJsonObject());
        }
        JsonArray jsonArray = arrayBuilder.build();
        return jsonArray;
    }

    public Matche getMatche(int idmatch) {
        Matche matche = FootballRestService.getMatch(idmatch);
        return matche;
    }

    public int removeMatche(Matche matche) {
        em.remove(matche);
        em.remove(matche.getResultmatch());
        return 1;
    }


}