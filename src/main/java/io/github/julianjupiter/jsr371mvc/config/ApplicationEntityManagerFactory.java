package io.github.julianjupiter.jsr371mvc.config;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.glassfish.hk2.api.Factory;
import org.glassfish.jersey.server.CloseableService;

public class ApplicationEntityManagerFactory implements Factory<EntityManager> {

    private final EntityManagerFactory entityManagerFactory;
    private final CloseableService closeableService;

    @Inject
    public ApplicationEntityManagerFactory(CloseableService closeableService) {
        this.closeableService = closeableService;
        this.entityManagerFactory = Persistence.createEntityManagerFactory("FIRST_JSR371_MVC");
    }

    @Override
    public EntityManager provide() {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        closeableService.add(() -> {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        });

        return entityManager;
    }

    @Override
    public void dispose(EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
