import entidades.Carrera;
import jakarta.persistence.EntityManager;
import utilidades.JpaUtil;

import javax.swing.*;
import java.util.List;

public class CarreraCRUD {

    // Crear una nueva carrera
    public void crearCarrera() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la carrera:");
            String codigo = JOptionPane.showInputDialog("Ingrese el código de la carrera:");

            Carrera carrera = new Carrera();
            carrera.setNombre(nombre);
            carrera.setCodigo(codigo);

            em.getTransaction().begin();
            em.persist(carrera);
            em.getTransaction().commit();
            System.out.println("Carrera creada con ID: " + carrera.getId());
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error al crear la carrera: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    // Leer todas las carreras
    public void listarCarreras() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            List<Carrera> carreras = em.createQuery("SELECT c FROM Carrera c", Carrera.class).getResultList();
            carreras.forEach(System.out::println);
        } finally {
            em.close();
        }
    }

    // Editar una carrera existente
    public void editarCarrera() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el ID de la carrera a modificar:"));
            Carrera carrera = em.find(Carrera.class, id);
            if (carrera != null) {
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la carrera:", carrera.getNombre());
                String nuevoCodigo = JOptionPane.showInputDialog("Ingrese el nuevo código de la carrera:", carrera.getCodigo());

                em.getTransaction().begin();
                carrera.setNombre(nuevoNombre);
                carrera.setCodigo(nuevoCodigo);
                em.getTransaction().commit();
                System.out.println("Carrera actualizada: " + carrera);
            } else {
                System.out.println("Carrera no encontrada.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error al actualizar la carrera: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    // Eliminar una carrera
    public void eliminarCarrera() {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el ID de la carrera a eliminar:"));
            Carrera carrera = em.find(Carrera.class, id);
            if (carrera != null) {
                em.getTransaction().begin();
                em.remove(carrera);
                em.getTransaction().commit();
                System.out.println("Carrera eliminada.");
            } else {
                System.out.println("Carrera no encontrada.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error al eliminar la carrera: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}

