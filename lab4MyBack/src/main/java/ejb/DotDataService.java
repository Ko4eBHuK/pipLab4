package ejb;

import domain.DotData;
import util.SendedDot;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Stateless(name="DotDataService")
public class DotDataService {
    private EntityManager em = Persistence.createEntityManagerFactory("DataUnit").createEntityManager();

    public void addDotData(DotData dotData){
        em.getTransaction().begin();
        em.persist(dotData);
        em.getTransaction().commit();
    }

    public List<SendedDot> getDotData(int user_id){
        TypedQuery<DotData> query = em.createNamedQuery("DotData.getByLoginPassword", DotData.class);
        query.setParameter("user_id",user_id);
        List<DotData> userHits = query.getResultList();
        List<SendedDot> userDots = new ArrayList<SendedDot>();
        SendedDot stepSendedDot = new SendedDot();
        for (DotData dotData: userHits) {
            stepSendedDot.setExecutionTime(String.valueOf(dotData.getExecutionTime()));
            stepSendedDot.setPointInArea(String.valueOf(dotData.isPointInArea()));
            stepSendedDot.setPointInArea(String.valueOf(dotData.isPointInArea()));
            stepSendedDot.setCurrentTime(dotData.getFormattedTime());
            stepSendedDot.setR(String.valueOf(dotData.getR()));
            stepSendedDot.setY(String.valueOf(dotData.getY()));
            stepSendedDot.setX(String.valueOf(dotData.getX()));
            userDots.add(stepSendedDot);
        }
        return userDots;
    }
}