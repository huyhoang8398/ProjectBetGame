package View;

import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class Aministrateur implements Serializable {
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
