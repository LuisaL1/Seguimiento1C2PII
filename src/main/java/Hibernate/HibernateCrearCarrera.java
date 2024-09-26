package Hibernate;

import entidades.Carrera;
import jakarta.persistence.EntityManager;
import utilidades.JpaUtil;

import javax.swing.*;

public class HibernateCrearCarrera {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            // Solicitar los datos de la carrera
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la carrera");
            String codigo = JOptionPane.showInputDialog("Ingrese el código de la carrera");

            // Iniciar la transacción
            em.getTransaction().begin();

            // Crear el objeto Carrera
            Carrera carrera = new Carrera();
            carrera.setNombre(nombre);
            carrera.setCodigo(codigo);

            // Guardar la carrera
            em.persist(carrera);

            // Confirmar la transacción
            em.getTransaction().commit();

            // Mostrar el ID de la carrera
            System.out.println("Carrera creada con ID: " + carrera.getId());
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
