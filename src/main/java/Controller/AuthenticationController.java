package Controller;

import Model.UserAccount;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AuthenticationController {

    @PersistenceContext
    private EntityManager em;

    public Integer checkLogin(String username, String password) {
        if(username.equals("admin") && password.equals("admin")){
            return 2;
        }
        UserAccount userAccount = em.find(UserAccount.class, username);
        if (userAccount != null && userAccount.getPassword().equals(password)) return userAccount.getRole();
        return null;
    }
}
