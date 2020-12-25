package Controller;


import Model.Bookmakeur;
import Model.Matche;
import Model.Parieur;

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

    public long createBookmakeur(Bookmakeur bookmakeur) {
        em.persist(bookmakeur);
        em.persist(bookmakeur.getMatchHost());
        em.persist(bookmakeur.getCote());
        return bookmakeur.getId();
    }

    public long updateBookmakeur(Bookmakeur bookmakeur) {
        em.merge(bookmakeur);
        em.merge(bookmakeur.getMatchHost());
        em.merge(bookmakeur.getCote());
        return bookmakeur.getId();
    }

    public void deleteBookmakeur(Bookmakeur bookmakeurFace) {
        em.remove(em.contains(bookmakeurFace) ? bookmakeurFace : em.merge(bookmakeurFace));
        em.remove(em.contains(bookmakeurFace.getMatchHost()) ? bookmakeurFace.getMatchHost() : em.merge(bookmakeurFace.getMatchHost()));
        em.remove(em.contains(bookmakeurFace.getCote()) ? bookmakeurFace.getCote() : em.merge(bookmakeurFace.getCote()));
    }

    public long createParieur(Parieur parieurFace) {
        parieurFace.setMoney(1000); // 1000 Limcoin
        em.persist(parieurFace);
        em.persist(parieurFace.getPariLst());
        return parieurFace.getId();
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
