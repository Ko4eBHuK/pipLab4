package ejb;

import domain.UserData;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


@Stateless(name="Registration")
public class Registration {
    private EntityManager em = Persistence.createEntityManagerFactory("DataUnit").createEntityManager();
    public int addUser(UserData user){
        TypedQuery<String> query = em.createNamedQuery("UserData.getByLogin", String.class);
        query.setParameter("login", user.getLogin());
        try {
            query.getSingleResult();
            return 412;
        }
        catch (Exception e){
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return 200;
        }
    }
}