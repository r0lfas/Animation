package com.example.demo.model;

import com.example.demo.config.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AnimationDAOImpl implements AnimationDAO {
    public void insertEntity(Animation animation) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(animation);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Animation findEntityByID(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Animation> animations = entityManager.
                createQuery("Select n FROM Animation n WHERE n.id = :id")
                .setParameter("id", id)
                .getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return animations.get(0);
    }

    public List<Animation> findEntities() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Animation> animations = entityManager.createQuery("SELECT n FROM Animation n")
                .getResultList();

        return animations;
    }

    public void updateEntity(Animation animation) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Animation animation2 = entityManager.find(Animation.class, animation.getId());
        animation2.setName(animation.getName());
        animation2.setGenre(animation.getGenre());
        animation2.setYear(animation.getYear());
        animation2.setGroups(animation.getGroups());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeEntityByID(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Animation animation = entityManager.find(Animation.class, id);
        entityManager.remove(animation);

        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
