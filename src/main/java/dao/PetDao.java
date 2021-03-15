package dao;

import model.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;
import java.util.List;


public class PetDao {
    public Pet findByIdPet(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Pet pet = session.find(Pet.class, id);
            return pet;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void createPet(Pet pet) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(pet);
            transaction.commit();
            System.out.println("Pet was created: \n" + pet);
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

    public void deletePet(Pet pet) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(pet);
            transaction.commit();
            System.out.println("Pet was deleted: \n" + pet);
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

    public void updatePet(Pet pet) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(pet);
            transaction.commit();
            System.out.println("Pet was updated: \n" + pet);
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

    public List<Pet> displayPets() {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Pet", Pet.class);
            List<Pet> pets = query.list();
            return pets;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
