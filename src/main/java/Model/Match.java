package Model;

import javax.json.Json;
import javax.json.JsonObject;

public class Match {
    int id;
    String name;
    String startDate;
    String place;
    String duration;
    int homeTeamId;
    String homeTeam;
    int awayTeamId;
    String awayTeam;
    ResultMatch resultmatch;
    String url;

    public Match(int id) {
        this.id = id;
        this.url = "http://localhost:8080/REST-Service-1.0-SNAPSHOT/rest/service/parieur/match/"+id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public ResultMatch getResultmatch() {
        return resultmatch;
    }

    public void setResultmatch(ResultMatch resultmatch) {
        this.resultmatch = resultmatch;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JsonObject toJsonObject(){
        return Json.createObjectBuilder()
                .add("id", id)
                .add("name", name)
                .add("startDate", startDate)
                .add("place", place)
                .add("duration", duration)
                .add("homeTeamId", homeTeamId)
                .add("homeTeam", homeTeam)
                .add("awayTeamId", awayTeamId)
                .add("awayTeam", awayTeam)
                .add("resultmatch", resultmatch.toJsonObject())
                .add("url",url).build();
    }
}
