package db;

import models.Advert;
import models.CategoryType;
import models.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBAdvert {

    private static Session session;

    public static List<Advert> getUsersSellingAdverts(User seller){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Advert> adverts = null;

        try {
            Criteria cr = session.createCriteria(Advert.class);
            cr.add(Restrictions.eq("seller", seller));
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

    public static List<Advert> getAllAdvertsForCategory(CategoryType category){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Advert> adverts = null;

        try {
            Criteria cr = session.createCriteria(Advert.class);
            cr.add(Restrictions.eq("category", category));
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

    public static List<Advert> getAdvertsForLocation(String location){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Advert> adverts = null;

        try {
            Criteria cr = session.createCriteria(Advert.class);
            cr.add(Restrictions.ilike("location", location, MatchMode.ANYWHERE));
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


}
