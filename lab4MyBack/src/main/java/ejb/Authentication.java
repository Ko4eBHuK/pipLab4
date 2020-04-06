package ejb;

import domain.UserData;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@Stateless(name="Authentication")
public class Authentication {

    private EntityManager em = Persistence.createEntityManagerFactory("DataUnit").createEntityManager();
    public boolean findUser(String login, String hashPassword){
        TypedQuery<UserData> query = em.createNamedQuery("UserData.getPassword", UserData.class);
        query.setParameter("login",login);
        query.setParameter("password",hashPassword);
        try {
            UserData user = query.getSingleResult();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}