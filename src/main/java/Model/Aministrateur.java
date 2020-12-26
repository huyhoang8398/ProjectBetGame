package Model;

import javax.persistence.*;

@Entity
public class Aministrateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Aministrateur() {
    }

    public void createParieur(){

    }

    public void createBookmaker(){

    }

    public void updateParieur(){

    }

    public void updateBookmaker(){

    }

    public void removeParieur(){

    }

    public void removeBookmaker(){

    }
}
