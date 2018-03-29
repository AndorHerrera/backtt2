package com.klasnic.pos.model.data;


import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.orm.jpa.JpaTransactionManager;

/**
 *
 * @author Jesús Israel
 */
public class SessionData {

    private static final Logger logger = Logger.getLogger(SessionData.class.getName());

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private JpaTransactionManager transactionManager;
    private JpaRepositoryFactory repositoryFactory;

    boolean isConnected = false;

    private void available() {
        if (!isConnected) {
            throw new IllegalStateException("Session not connect.");
        }
    }

    public void connect(Map connectionString, String persistenceUnitName) {
        entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName, connectionString);
        logger.log(Level.INFO, "Entity Manager Factory Created.");

        transactionManager = new JpaTransactionManager(entityManagerFactory);
        logger.log(Level.INFO, "Jpa Transaction Manager Factory Created.");

        entityManager = entityManagerFactory.createEntityManager();
        logger.log(Level.INFO, "Entity Manager Created.");

        repositoryFactory = new JpaRepositoryFactory(entityManager);
        logger.log(Level.INFO, "Repository Factory Created.");

        isConnected = true;
    }

    public void close() {
        available();
        try {
            repositoryFactory = null;
            entityManager.close();
            entityManager = null;
            transactionManager = null;
            entityManagerFactory.close();
        } finally {
            isConnected = false;
        }
    }

    public void beginTransaction() {
        available();
        entityManager.getTransaction().begin();
    }

    public void commitTransaction() {
        available();
        entityManager.getTransaction().commit();
    }

    public <T extends Object> T getRepository(Class<T> repositoryInterface) {
        available();
        return repositoryFactory.getRepository(repositoryInterface);
    }
    
    /*
    public <T extends PersistentObject> T createObject() {
        return new T();
    }
    
    public <T extends PersistentObject> T saveObject(T object) {
        available();
       
        PersistentObjectRepository<T> repository = getRepository(PersistentObjectRepository.class);
        return repository.save(object);
        
    }*/
}
