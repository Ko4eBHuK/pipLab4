package ejb;

import domain.UserData;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@Stateless(name="UserDataService")
public class UserDataService {
    private EntityManager em = Persistence.createEntityManagerFactory("DataUnit").createEntityManager();

    public UserData getUser(String login, String hashPassword){
        TypedQuery<UserData> query = em.createNamedQuery("UserData.getPassword", UserData.class);
        query.setParameter("login",login);
        query.setParameter("password",hashPassword);
        UserData user = query.getSingleResult();
        return user;
    }
}