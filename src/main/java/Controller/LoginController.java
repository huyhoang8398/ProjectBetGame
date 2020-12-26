package Controller;

import Model.UserAccount;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LoginController {

    @PersistenceContext
    private EntityManager em;

    public boolean checkLogin(String username, String password) {
        UserAccount userAccount = em.find(UserAccount.class, username);
        if (userAccount != null) {
            return userAccount.getPassword().equals(password);
        }
        return false;
    }
}
