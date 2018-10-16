package org.koritsas.vinnslu.utils;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FakeData {

    @PersistenceContext
    EntityManager entityManager;

    public FakeData() {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void printEm(){
        System.out.println(this.entityManager);
    }
}
