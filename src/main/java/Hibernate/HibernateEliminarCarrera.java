package Hibernate;

import entidades.Carrera;
import jakarta.persistence.EntityManager;
import utilidades.JpaUtil;

import java.util.Scanner;

public class HibernateEliminarCarrera {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese el ID de la carrera a eliminar: ");
        Long id = s.nextLong();

        EntityManager em = JpaUtil.getEntityManager();

        try {
            Carrera carrera = em.find(Carrera.class, id);

            em.getTransaction().begin();

            // Eliminar la carrera
            em.remove(carrera);

            em.getTransaction().commit();

            System.out.println("Carrera eliminada.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

