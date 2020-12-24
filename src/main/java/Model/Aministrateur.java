package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aministrateur{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
