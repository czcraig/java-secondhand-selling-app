package db;

import models.Advert;
import models.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBUser {

    private static Session session;

    public static void addFavouriteAdToUser(User user, Advert advert){
        user.addAdvertToFavourites(advert);
        DBHelper.update(user);
    }
    public static List<Advert> getUsersFavouriteAdverts(User user){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Advert> adverts = null;

        try {
            Criteria cr = session.createCriteria(Advert.class);
            cr.createAlias("favouritedBy", "user");
            cr.add(Restrictions.eq("user.id", user.getId()));
            cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            adverts = cr.list();
        }
        catch (HibernateException ex){
            ex.printStackTrace();
        }
        finally {
            session.close();
        }

        return adverts;
    }

    public static void addRatingToUser(User user, int rating){
        user.setRating(rating);
        DBHelper.update(user);
    }
}
