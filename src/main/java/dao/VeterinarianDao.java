package dao;

import model.Veterinarian;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;
import java.util.List;


public class VeterinarianDao {

    public Veterinarian findByIdVeterinarian(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Veterinarian veterinarian = session.find(Veterinarian.class, id);
            return veterinarian;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<Veterinarian> findByNameVet(String firstName) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Veterinarian where firstName=:firstName", Veterinarian.class);
            query.setParameter("firstName", firstName);
            List<Veterinarian> veterinarianList = query.list();
            return veterinarianList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void createVeterinarian(Veterinarian veterinarian) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(veterinarian);
            transaction.commit();
            System.out.println("Veterinarian was created: \n" + veterinarian);
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

    public void deleteVeterinarian(Veterinarian veterinarian) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(veterinarian);
            transaction.commit();
            System.out.println("Veterinarian deleted!\n" + veterinarian);
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

    public void updateVeterinarian(Veterinarian veterinarian) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(veterinarian);
            transaction.commit();
            System.out.println("Veterinarian was updated:\n " + veterinarian);
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

    public List<Veterinarian> displayVet() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Veterinarian", Veterinarian.class);
            List<Veterinarian> veterinarianList = query.list();
            return veterinarianList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
