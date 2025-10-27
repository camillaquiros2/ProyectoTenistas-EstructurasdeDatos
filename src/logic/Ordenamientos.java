package logic;

import model.Tenista;

public class Ordenamientos {

    public static int compararPorPuntaje(Tenista a, Tenista b) {
        return Integer.compare(b.getPuntaje(), a.getPuntaje());
    }

    public static int compararPorEdad(Tenista a, Tenista b) {
        return Integer.compare(a.getEdad(), b.getEdad());
    }

    public static int compararPorPaisNombre(Tenista a, Tenista b) {
        int pais = a.getPais().compareToIgnoreCase(b.getPais());
        return (pais != 0) ? pais : a.getNombre().compareToIgnoreCase(b.getNombre());
    }

    public static void quicksortPorPuntaje(Tenista[] arr, int izq, int der) {
        int i = izq, j = der;
        Tenista pivote = arr[(izq + der) / 2];

        while (i <= j) {
            while (compararPorPuntaje(arr[i], pivote) < 0) i++;
            while (compararPorPuntaje(arr[j], pivote) > 0) j--;
            if (i <= j) {
                Tenista temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++; j--;
            }
        }

        if (izq < j) quicksortPorPuntaje(arr, izq, j);
        if (i < der) quicksortPorPuntaje(arr, i, der);
    }

    public static void insercionPorEdad(Tenista[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Tenista actual = arr[i];
            int j = i - 1;
            while (j >= 0 && compararPorEdad(arr[j], actual) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = actual;
        }
    }

    public static void mostrarTenistas(Tenista[] lista) {
        System.out.printf("%-20s %-15s %-5s %-8s%n", "Tenista", "País", "Edad", "Puntaje");
        for (Tenista t : lista) {
            if (t != null) System.out.println(t);
        }
    }
}
