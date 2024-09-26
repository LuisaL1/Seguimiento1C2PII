package Hibernate;

import entidades.Carrera;
import jakarta.persistence.EntityManager;
import utilidades.JpaUtil;

import javax.swing.*;

public class HibernateEditarCarrera {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            // Solicitar el ID de la carrera a modificar
            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el ID de la carrera a modificar:"));

            // Buscar la carrera en la base de datos
            Carrera carrera = em.find(Carrera.class, id);

            // Solicitar los nuevos datos
            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la carrera:", carrera.getNombre());
            String nuevoCodigo = JOptionPane.showInputDialog("Ingrese el nuevo código de la carrera:", carrera.getCodigo());

            // Iniciar la transacción
            em.getTransaction().begin();

            // Actualizar los datos
            carrera.setNombre(nuevoNombre);
            carrera.setCodigo(nuevoCodigo);

            // Confirmar la transacción
            em.getTransaction().commit();

            // Mostrar la carrera actualizada
            System.out.println("Carrera actualizada: " + carrera);
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Error al actualizar la carrera: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}

