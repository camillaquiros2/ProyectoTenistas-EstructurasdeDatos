package logic;

import model.Tenista;

public class Ordenamientos {

    // Comparar por puntaje (descendente)
    public static int compararPorPuntaje(Tenista a, Tenista b) {
        return Integer.compare(b.getPuntaje(), a.getPuntaje());
    }

    // Comparar por edad (ascendente)
    public static int compararPorEdad(Tenista a, Tenista b) {
        return Integer.compare(a.getEdad(), b.getEdad());
    }

    // Comparar por país y luego por nombre (ascendente)
    public static int compararPorPaisNombre(Tenista a, Tenista b) {
        int pais = a.getPais().compareToIgnoreCase(b.getPais());
        return (pais != 0) ? pais : a.getNombre().compareToIgnoreCase(b.getNombre());
    }


    // --- ORDENAMIENTO QUICK SORT (PUNTAJE DESCENDENTE) ---
    public static void quicksortPorPuntaje(Tenista[] arr, int izq, int der) {
        if (arr == null || arr.length == 0) return;
        int i = izq, j = der;
        Tenista pivote = arr[(izq + der) / 2];

        while (i <= j) {
            while (compararPorPuntaje(arr[i], pivote) < 0) i++;
            while (compararPorPuntaje(arr[j], pivote) > 0) j--;
            if (i <= j) {
                Tenista temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (izq < j) quicksortPorPuntaje(arr, izq, j);
        if (i < der) quicksortPorPuntaje(arr, i, der);
    }


    // --- ORDENAMIENTO POR INSERCIÓN (EDAD ASCENDENTE) ---
    public static void insercionPorEdad(Tenista[] arr) {
        if (arr == null) return;
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


    // --- ORDENAMIENTO SHELLSORT (PAÍS + NOMBRE ASCENDENTE) ---
    public static void shellsortPorPaisNombre(Tenista[] arr) {
        if (arr == null) return;
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Tenista temp = arr[i];
                int j = i;
                while (j >= gap && compararPorPaisNombre(arr[j - gap], temp) > 0) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }


    // --- MOSTRAR TABLA DE TENISTAS ---
    public static void mostrarTenistas(Tenista[] lista) {
        if (lista == null || lista.length == 0) {
            System.out.println("No hay tenistas para mostrar.");
            return;
        }

        System.out.printf("%-20s %-15s %-5s %-8s%n", "Tenista", "País", "Edad", "Puntaje");
        for (Tenista t : lista) {
            if (t != null) System.out.println(t);
        }
    }

    public static void ordenarPorPuntaje(Tenista[] arr) {
        quicksortPorPuntaje(arr, 0, arr.length - 1);
    }

    public static void ordenarPorEdad(Tenista[] arr) {
        insercionPorEdad(arr);
    }

    public static void ordenarPorPaisNombre(Tenista[] arr) {
        shellsortPorPaisNombre(arr);
    }
}
