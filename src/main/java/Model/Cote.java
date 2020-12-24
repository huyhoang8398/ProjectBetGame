package Model;

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
}
