package Controller;

import Model.UserAccount;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
public class AuthenticationController {
    UserAccount user;
    @PersistenceContext
    private EntityManager em;

    public Integer checkLogin(String username, String password) {
        if(username.equals("admin") && password.equals("admin")){
            return 2;
        }
        UserAccount userAccount = em.find(UserAccount.class, username);
        if (userAccount != null && userAccount.getPassword().equals(password)) {
            user = userAccount;
            return userAccount.getRole();
        }
        return null;
    }

    public UserAccount getUser() {
        return user;
    }
}
