package logic;

import model.Tenista;

public class ListaEnlazadaTenistas {

    // Clase interna Nodo
    private static class Nodo {
        Tenista dato;
        Nodo siguiente;
        Nodo(Tenista dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo inicio;
    private int tamaño;

    public ListaEnlazadaTenistas() {
        inicio = null;
        tamaño = 0;
    }

    // Insertar un nuevo tenista al final de la lista
    public void insertar(Tenista t) {
        Nodo nuevo = new Nodo(t);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
        tamaño++;
    }

    // Mostrar todos los tenistas
    public void mostrar() {
        Nodo aux = inicio;
        System.out.printf("%-20s %-15s %-5s %-8s%n", "Tenista", "País", "Edad", "Puntaje");
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }

    // Buscar por nombre (para validación de duplicados)
    public boolean existeTenista(String nombre) {
        Nodo aux = inicio;
        while (aux != null) {
            if (aux.dato.getNombre().equalsIgnoreCase(nombre)) return true;
            aux = aux.siguiente;
        }
        return false;
    }

    public int getTamaño() {
        return tamaño;
    }

    public boolean estaVacia() {
        return inicio == null;
    }
}
