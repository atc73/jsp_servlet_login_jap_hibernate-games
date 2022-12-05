package com.example.demo.connection;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerConnection {

    private static EntityManagerFactory ENTITY_MANAGER;

    private EntityManagerConnection() {

    }

    public static EntityManagerFactory getEntityManager() {
        if (ENTITY_MANAGER == null) {
            ENTITY_MANAGER = Persistence.createEntityManagerFactory("myPU");
        }
        return ENTITY_MANAGER;
    }
}
