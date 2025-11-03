package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import logic.ControladorTenistas;

public class MenuSuperior {

    private final HBox barraBotones;

    public MenuSuperior(ControladorTenistas controlador, VistaTablaTenistas vistaTabla) {
        Button mostrarBtn = new Button("Mostrar Ingresados");
        Button ordenarPuntajeBtn = new Button("Ordenar por Puntaje ↓");
        Button ordenarEdadBtn = new Button("Ordenar por Edad ↑");
        Button ordenarPaisNombreBtn = new Button("Ordenar por País + Nombre ↑");

        mostrarBtn.setOnAction(e -> vistaTabla.actualizar(controlador));

        // Ordenamiento por puntaje usando QuickSort
        ordenarPuntajeBtn.setOnAction(e -> {
            controlador.ordenarPorPuntaje();
            vistaTabla.actualizar(controlador);
        });

        // Ordenamiento por edad usando Inserción
        ordenarEdadBtn.setOnAction(e -> {
            controlador.ordenarPorEdad();
            vistaTabla.actualizar(controlador);
        });

        // Ordenamiento por país + nombre usando ShellSort
        ordenarPaisNombreBtn.setOnAction(e -> {
            controlador.ordenarPorPaisNombre();
            vistaTabla.actualizar(controlador);
        });

        barraBotones = new HBox(10, mostrarBtn, ordenarPuntajeBtn, ordenarEdadBtn, ordenarPaisNombreBtn);
        barraBotones.setPadding(new Insets(10));
    }

    public HBox getBarraBotones() {
        return barraBotones;
    }
}
