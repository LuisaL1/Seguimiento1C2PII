import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("CarrerasCRUD");

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        ENTITY_MANAGER_FACTORY.close();
    }
}

