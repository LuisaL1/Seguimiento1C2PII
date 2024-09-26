package entidades;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import entidades.Carrera;

public class CarreraDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarrerasCRUD");

    public void guardarCarrera(Carrera carrera) {
        EntityManager em = emf.createEntityManager();

        try {
            // Inicia una transacción
            em.getTransaction().begin();

            // Persiste el objeto en la base de datos
            em.persist(carrera);

            // Confirma la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            // Si hay un error, deshace la transacción
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

