package Hibernate;

import entidades.Carrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utilidades.JpaUtil;

import java.util.Scanner;

public class HibernateListarWhereCarrera {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        EntityManager em = JpaUtil.getEntityManager(); // Obtener el EntityManager

        // Solicitar el código de la carrera
        System.out.print("Ingrese el código de carrera: ");
        String codigo = s.next();

        // Crear la consulta preparada
        Query consulta = em.createQuery("SELECT c FROM Carrera c WHERE c.codigo = ?1", Carrera.class);
        consulta.setParameter(1, codigo);

        try {
            // Obtener el resultado
            Carrera carrera = (Carrera) consulta.getSingleResult();
            // Mostrar el resultado
            System.out.println(carrera);
        } catch (Exception e) {
            System.out.println("Carrera no encontrada.");
        } finally {
            em.close(); // Cerrar el EntityManager
            JpaUtil.closeEntityManagerFactory(); // Cerrar el EntityManagerFactory si ya no lo necesitas
        }
    }
}
