package main;

import model.Tenista;
import logic.Ordenamientos;

public class MainApp {
    public static void main(String[] args) {
        Tenista[] lista = {
                new Tenista("Novak Djokovic", "Serbia", 28, 16790),
                new Tenista("Andy Murray", "Gran Bretaña", 28, 8855),
                new Tenista("Roger Federer", "Suiza", 34, 8795),
                new Tenista("Dominic Thiem", "Austria", 22, 2020),
                new Tenista("Rafael Nadal", "España", 29, 7480)
        };

        System.out.println("\n=== Original ===");
        Ordenamientos.mostrarTenistas(lista);

        System.out.println("\n=== Ordenado por puntaje (quicksort) ===");
        Ordenamientos.quicksortPorPuntaje(lista, 0, lista.length - 1);
        Ordenamientos.mostrarTenistas(lista);

        System.out.println("\n=== Ordenado por edad (inserción) ===");
        Ordenamientos.insercionPorEdad(lista);
        Ordenamientos.mostrarTenistas(lista);
    }
}
