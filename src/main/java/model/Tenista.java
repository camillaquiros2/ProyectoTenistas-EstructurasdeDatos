package model;

public class Tenista {
    private String nombre;
    private String pais;
    private int edad;
    private double puntaje;   // <-- ahora es decimal

    public Tenista(String nombre, String pais, int edad, double puntaje) {
        this.nombre = nombre;
        this.pais = pais;
        this.edad = edad;
        this.puntaje = puntaje;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getEdad() {
        return edad;
    }

    public double getPuntaje() {
        return puntaje;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return String.format(
                "%-20s %-15s %-5d %-10.2f",
                nombre, pais, edad, puntaje
        );
    }
}
