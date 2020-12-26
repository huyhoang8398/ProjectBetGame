package Controller;


import Model.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AministrateurController {
    @PersistenceContext
    private EntityManager em;

    public List<Parieur> getListParieur() {
        List<Parieur> list = em.createQuery("select t from Parieur t").getResultList();
        return list;
    }

    public List<Bookmakeur> getListBookmakeur() {
        List<Bookmakeur> list = em.createQuery("select t from Bookmakeur t").getResultList();
        return list;
    }

    public List<Matche> getListMatche() {
        List<Matche> list = em.createQuery("select t from Matche t").getResultList();
        return list;
    }

    public List<Cote> getListCote() {
        List<Cote> list = em.createQuery("select t from Cote t").getResultList();
        return list;
    }

    public List<Pari> getListPari() {
        List<Pari> list = em.createQuery("select t from Pari t").getResultList();
        return list;
    }

    public List<UserAccount> getUserAccounts() {
        List<UserAccount> list = em.createQuery("select t from UserAccount t").getResultList();
        return list;
    }

    public long createBookmakeur(Bookmakeur bookmakeur) {
        em.persist(bookmakeur);
        em.persist(bookmakeur.getMatcheHost());
        em.persist(bookmakeur.getCote());
        em.persist(bookmakeur.getUserAccount());
        return bookmakeur.getId();
    }

    public long updateBookmakeur(Bookmakeur bookmakeur) {
        em.merge(bookmakeur);
        em.merge(bookmakeur.getMatcheHost());
        em.merge(bookmakeur.getCote());
        return bookmakeur.getId();
    }

    public void deleteBookmakeur(Bookmakeur bookmakeurFace) {
        em.remove(em.contains(bookmakeurFace) ? bookmakeurFace : em.merge(bookmakeurFace));
        em.remove(em.contains(bookmakeurFace.getMatcheHost()) ? bookmakeurFace.getMatcheHost() : em.merge(bookmakeurFace.getMatcheHost()));
        em.remove(em.contains(bookmakeurFace.getCote()) ? bookmakeurFace.getCote() : em.merge(bookmakeurFace.getCote()));
    }

    public long createParieur(Parieur parieur) {
        parieur.setMoney(1000); // 1000 Limcoin
        em.persist(parieur);
        em.persist(parieur.getUserAccount());
        em.persist(parieur.getPariLst());
        return parieur.getId();
    }

    public Parieur getParieur(long id){
        return em.find(Parieur.class, id);
    }

    public void updateParieur(Parieur parieurFace) {
        em.merge(parieurFace);
    }

    public void deleteParieur(Parieur parieurFace) {
        em.remove(em.contains(parieurFace) ? parieurFace : em.merge(parieurFace));
    }
}
