package Model;

public class SeasonMatch {
    int id;
    int currentMatchDay;

    public SeasonMatch(int id, int currentMatchDay) {
        this.id = id;
        this.currentMatchDay = currentMatchDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentMatchDay() {
        return currentMatchDay;
    }

    public void setCurrentMatchDay(int currentMatchDay) {
        this.currentMatchDay = currentMatchDay;
    }
}
