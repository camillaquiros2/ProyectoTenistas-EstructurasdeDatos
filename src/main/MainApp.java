package main;

import model.Tenista;
import logic.Ordenamientos;
import logic.ListaEnlazadaTenistas;
import logic.Validaciones;

public class MainApp {

    public static void main(String[] args) {

        // ===== MATRIZ PRINCIPAL =====
        Tenista[] lista = {
                new Tenista("Novak Djokovic", "Serbia", 28, 16790),
                new Tenista("Andy Murray", "Gran Bretaña", 28, 8855),
                new Tenista("Roger Federer", "Suiza", 34, 8795),
                new Tenista("Dominic Thiem", "Austria", 22, 2020),
                new Tenista("Rafael Nadal", "España", 29, 7480)
        };

        System.out.println("\n=== MATRIZ ORIGINAL ===");
        Ordenamientos.mostrarTenistas(lista);

        // ===== ORDENAMIENTO POR PUNTAJE (QuickSort DESC) =====
        System.out.println("\n=== ORDENADO POR PUNTAJE (Quicksort DESC) ===");
        Ordenamientos.quicksortPorPuntaje(lista, 0, lista.length - 1);
        Ordenamientos.mostrarTenistas(lista);

        // ===== ORDENAMIENTO POR EDAD (Inserción ASC) =====
        System.out.println("\n=== ORDENADO POR EDAD (Inserción ASC) ===");
        Ordenamientos.insercionPorEdad(lista);
        Ordenamientos.mostrarTenistas(lista);

        // ===== LISTA ENLAZADA DE TENISTAS =====
        System.out.println("\n=== LISTA ENLAZADA DE TENISTAS ===");
        ListaEnlazadaTenistas listaEnlazada = new ListaEnlazadaTenistas();

        // Creación de nuevos tenistas (validados antes de insertar)
        Tenista t1 = new Tenista("Novak Djokovic", "Serbia", 28, 16790);
        Tenista t2 = new Tenista("Andy Murray", "Gran Bretaña", 28, 8855);
        Tenista t3 = new Tenista("Roger Federer", "Suiza", 34, 8795);
        Tenista t4 = new Tenista("Rafael Nadal", "España", 29, 7480);
        Tenista t5 = new Tenista("Dominic Thiem", "Austria", 22, 2020);

        // Insertar solo si pasa validación y no está duplicado
        insertarValidado(listaEnlazada, t1);
        insertarValidado(listaEnlazada, t2);
        insertarValidado(listaEnlazada, t3);
        insertarValidado(listaEnlazada, t4);
        insertarValidado(listaEnlazada, t5);

        // Mostrar lista enlazada final
        listaEnlazada.mostrar();
    }

    // ===== MÉTODO AUXILIAR =====
    private static void insertarValidado(ListaEnlazadaTenistas lista, Tenista t) {
        if (!Validaciones.validarTenista(t)) return;
        if (lista.existeTenista(t.getNombre())) {
            System.out.println("⚠️  El tenista \"" + t.getNombre() + "\" ya existe en la lista.");
            return;
        }
        lista.insertar(t);
        System.out.println("✅ Tenista agregado: " + t.getNombre());
    }
}
