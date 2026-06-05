/*


 */
package sesion27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author tl
 */
public class Coleccion {

    public static void main() {
        // =========================
        // LIST (permite duplicados y mantiene orden)
        // =========================
        List<String> listaNombres = new ArrayList<>();

        listaNombres.add("Juan");
        listaNombres.add("Ana");
        listaNombres.add("Pedro");
        listaNombres.add("Juan"); // duplicado permitido

        System.out.println("LISTA:");
        for (String nombre : listaNombres) {
            System.out.println(nombre);
        }

        System.out.println("---------------------");

        // =========================
        // SET (no permite duplicados)
        // =========================
        Set<String> setNombres = new HashSet<>();

        setNombres.add("Juan");
        setNombres.add("Ana");
        setNombres.add("Pedro");
        setNombres.add("Juan"); // NO se agrega

        System.out.println("SET:");
        for (String nombre : setNombres) {
            System.out.println(nombre);
        }

        System.out.println("---------------------");

        // =========================
        // MAP (clave - valor)
        // =========================
        Map<Integer, String> empleados = new HashMap<>();

        empleados.put(101, "Juan Pérez");
        empleados.put(102, "Ana López");
        empleados.put(103, "Pedro Gómez");
        empleados.put(101, "Juan Actualizado"); // reemplaza el anterior

        System.out.println("MAP:");
        for (Map.Entry<Integer, String> entry : empleados.entrySet()) {
            System.out.println("ID: " + entry.getKey()
                    + " -> Nombre: " + entry.getValue());
        }

        System.out.println("---------------------");

        // =========================
        // ACCESO DIRECTO EN MAP
        // =========================
        System.out.println("Empleado con ID 102: " + empleados.get(102));
    }

}
