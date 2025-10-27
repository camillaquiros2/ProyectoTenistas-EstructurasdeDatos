package model;

public class Tenista {
    private String nombre;
    private String pais;
    private int edad;
    private int puntaje;

    public Tenista(String nombre, String pais, int edad, int puntaje) {
        this.nombre = nombre;
        this.pais = pais;
        this.edad = edad;
        this.puntaje = puntaje;
    }

    public String getNombre() { return nombre; }
    public String getPais() { return pais; }
    public int getEdad() { return edad; }
    public int getPuntaje() { return puntaje; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPais(String pais) { this.pais = pais; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setPuntaje(int puntaje) { this.puntaje = puntaje; }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-5d %-8d", nombre, pais, edad, puntaje);
    }
}
