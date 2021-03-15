package dao;

import model.Owner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;
import java.util.List;

public class OwnerDao {

    public Owner findByOwnerId(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.find(Owner.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Owner> displayOwners() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Owner", Owner.class);
            return (List<Owner>) query.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void createOwner(Owner owner) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(owner);
            transaction.commit();
            System.out.println("Owner was created: \n" + owner);
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

    public void deleteOwner(Owner owner) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(owner);
            transaction.commit();
            System.out.println("Owner was deleted:\n" + owner);
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

    public void updateOwner(Owner owner) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(owner);
            transaction.commit();
            System.out.println("Owner was updated: \n" + owner);
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
}
