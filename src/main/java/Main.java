import javax.swing.*;
import utilidades.JpaUtil;

public class Main {
    public static void main(String[] args) {
        CarreraCRUD carreraCRUD = new CarreraCRUD();
        String[] opciones = {"Crear Carrera", "Listar Carreras", "Editar Carrera", "Eliminar Carrera", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "CRUD Carreras",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

            switch (opcion) {
                case 0:
                    carreraCRUD.crearCarrera();
                    break;
                case 1:
                    carreraCRUD.listarCarreras();
                    break;
                case 2:
                    carreraCRUD.editarCarrera();
                    break;
                case 3:
                    carreraCRUD.eliminarCarrera();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    break;
            }
        } while (opcion != 4);


        JpaUtil.closeEntityManagerFactory();
    }
}


