package com.sof3011.hangnt169.B10_Hibernate.repository;

import com.sof3011.hangnt169.B10_Hibernate.config.HibernateConfig;
import com.sof3011.hangnt169.B10_Hibernate.entity.Category1;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryRepository {
    // CRUD(CREATE - READ - UPDATE - DELETE)
    // GET ALL
    public List<Category1> getAll() {
        Session session = HibernateConfig.getFACTORY().openSession();
        List<Category1> lists = session.createQuery("FROM Category1").list();
        session.close();
        return lists;
    }

    // GET ONE
    public Category1 getOne(Long id1234) {
        Session session = HibernateConfig.getFACTORY().openSession();
        Query query = session.createQuery("FROM Category1 c WHERE  c.id1 =:id ");
//        Query query = session.createQuery("FROM Category1 c WHERE  c.id1 =:id AND c.categoryName =:name");
        query.setParameter(1, id1234);
//        query.setParameter(2,name);
        Category1 c1 = (Category1) query.getSingleResult();
        session.close();
        return c1;
    }

    // Add
    public void add(Category1 c) {
        Transaction tra = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            tra = s.beginTransaction();
            s.persist(c); // ADD
            tra.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete
    public void delete(Category1 c) {
        Transaction tra = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            tra = s.beginTransaction();
            s.delete(c); // DELETE
            tra.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update
    public void update(Category1 c) {
        Transaction tra = null;
        try (Session s = HibernateConfig.getFACTORY().openSession()) {
            tra = s.beginTransaction();
            s.merge(c); // Update
            tra.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getAll());
    }
}
