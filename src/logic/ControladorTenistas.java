package logic;

import model.Tenista;
import java.util.ArrayList;

public class ControladorTenistas {

    private final ArrayList<Tenista> lista = new ArrayList<>();

    // --- AGREGAR TENISTA (con validación opcional) ---
    public boolean agregarTenista(Tenista t) {
        if (t == null) {
            System.out.println("❌ El objeto Tenista no puede ser nulo.");
            return false;
        }

        if (!Validaciones.validarTenista(t)) return false;

        // Verificar duplicado
        for (Tenista existente : lista) {
            if (existente.getNombre().equalsIgnoreCase(t.getNombre())) {
                System.out.println("⚠️ El tenista \"" + t.getNombre() + "\" ya existe en la lista.");
                return false;
            }
        }

        lista.add(t);
        System.out.println("✅ Tenista agregado correctamente: " + t.getNombre());
        return true;
    }

    // --- OBTENER TENISTAS COMO ARREGLO ---
    public Tenista[] obtenerTenistas() {
        return lista.toArray(new Tenista[0]);
    }

    // --- ORDENAR POR PUNTAJE (descendente) ---
    public void ordenarPorPuntaje() {
        Tenista[] arr = obtenerTenistas();
        Ordenamientos.quicksortPorPuntaje(arr, 0, arr.length - 1);
        actualizarLista(arr);
    }

    // --- ORDENAR POR EDAD (ascendente) ---
    public void ordenarPorEdad() {
        Tenista[] arr = obtenerTenistas();
        Ordenamientos.insercionPorEdad(arr);
        actualizarLista(arr);
    }

    // --- ORDENAR POR PAÍS Y NOMBRE (ascendente) ---
    public void ordenarPorPaisNombre() {
        Tenista[] arr = obtenerTenistas();
        Ordenamientos.shellsortPorPaisNombre(arr);
        actualizarLista(arr);
    }

    // --- MOSTRAR LISTA EN CONSOLA ---
    public void mostrarLista() {
        if (lista.isEmpty()) {
            System.out.println("No hay tenistas registrados.");
            return;
        }
        System.out.printf("%-20s %-15s %-5s %-8s%n", "Tenista", "País", "Edad", "Puntaje");
        for (Tenista t : lista) {
            System.out.println(t);
        }
    }

    // --- ACTUALIZAR LISTA DESDE ARREGLO ---
    private void actualizarLista(Tenista[] arr) {
        lista.clear();
        for (Tenista t : arr) {
            lista.add(t);
        }
    }

    // --- MÉTODOS AUXILIARES PARA GUI ---
    public void limpiarLista() {
        lista.clear();
    }

    public boolean estaVacia() {
        return lista.isEmpty();
    }

    public int getCantidad() {
        return lista.size();
    }
}
