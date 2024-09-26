package Hibernate;

import entidades.Carrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import utilidades.JpaUtil;

import java.util.List;
import java.util.Scanner;

public class HibernateListarWhereMuchosCarreras {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        EntityManager em = JpaUtil.getEntityManager();

        // Solicitar el código mínimo de carrera
        System.out.print("Ingrese un código de carrera: ");
        String codigo = s.next();

        // Crear la consulta para listar varias carreras
        Query consulta = em.createQuery("SELECT c FROM Carrera c WHERE c.codigo > ?1", Carrera.class);
        consulta.setParameter(1, codigo);

        List<Carrera> carreras = consulta.getResultList();

        // Mostrar el resultado
        carreras.forEach(System.out::println);

        em.close();
    }
}

