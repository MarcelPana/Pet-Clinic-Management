package dao;

import model.Consult;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;
import java.util.List;


public class ConsultDao {

    public Consult findByConsultId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.find(Consult.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void createConsult(Consult consult) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(consult);
            transaction.commit();
            System.out.println("Consult was created: \n" + consult);
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            System.out.println("Something went wrong!");
        } finally {
            session.close();
        }
    }

    public void deleteConsult(Consult consult) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(consult);
            transaction.commit();
            System.out.println("Consult was deleted:\n" + consult);
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            System.out.println("Something went wrong!");
        } finally {
            session.close();
        }
    }

    public void updateConsult(Consult consult) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(consult);
            transaction.commit();
            System.out.println("Consult was updated: " + consult);
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            System.out.println("Something went wrong!");
        } finally {
            session.close();
        }
    }

    public List<Consult> displayConsults() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Consult", Consult.class);
            return (List<Consult>) query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
