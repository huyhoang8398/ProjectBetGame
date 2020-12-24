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

    public long createBookmakeur(Bookmakeur bookmakeurFace) {
        em.persist(bookmakeurFace);
        em.persist(bookmakeurFace.getMatchHost());
        em.persist(bookmakeurFace.getCote());
        return bookmakeurFace.getId();
    }

    public void updateBookmakeur(Bookmakeur bookmakeurFace) {
        em.merge(bookmakeurFace);
//        em.merge(bookmakeurFace.getMatchHost());
//        em.merge(bookmakeurFace.getCote());
    }

    public void deleteBookmakeur(Bookmakeur bookmakeurFace) {
        em.remove(em.contains(bookmakeurFace) ? bookmakeurFace : em.merge(bookmakeurFace));
        em.remove(em.contains(bookmakeurFace.getMatchHost()) ? bookmakeurFace.getMatchHost() : em.merge(bookmakeurFace.getMatchHost()));
        em.remove(em.contains(bookmakeurFace.getCote()) ? bookmakeurFace.getCote() : em.merge(bookmakeurFace.getCote()));
    }

    public long createParieur(Parieur parieurFace) {
        em.persist(parieurFace);
        return parieurFace.getId();
    }

    public void updateParieur(Parieur parieurFace) {
        em.merge(parieurFace);
    }

    public void deleteParieur(Parieur parieurFace) {
        em.remove(em.contains(parieurFace) ? parieurFace : em.merge(parieurFace));
    }
}
