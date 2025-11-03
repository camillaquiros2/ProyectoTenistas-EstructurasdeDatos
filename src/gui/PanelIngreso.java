package gui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import logic.ControladorTenistas;
import model.Tenista;
import logic.Validaciones;

public class PanelIngreso {

    private final VBox panelPrincipal;
    private final TextField nombreInput = new TextField();
    private final TextField paisInput = new TextField();
    private final TextField edadInput = new TextField();
    private final TextField puntajeInput = new TextField();

    public PanelIngreso(ControladorTenistas controlador, VistaTablaTenistas vistaTabla) {
        Label titulo = new Label("Ingreso de Tenistas");
        titulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        GridPane formulario = new GridPane();
        formulario.setHgap(10);
        formulario.setVgap(10);
        formulario.setPadding(new Insets(10));

        formulario.add(new Label("Nombre:"), 0, 0);
        formulario.add(nombreInput, 1, 0);

        formulario.add(new Label("País:"), 0, 1);
        formulario.add(paisInput, 1, 1);

        formulario.add(new Label("Edad:"), 0, 2);
        formulario.add(edadInput, 1, 2);

        formulario.add(new Label("Puntaje:"), 0, 3);
        formulario.add(puntajeInput, 1, 3);

        Button agregarBtn = new Button("Agregar Tenista");
        agregarBtn.setOnAction(e -> agregarTenista(controlador, vistaTabla));

        panelPrincipal = new VBox(10, titulo, formulario, agregarBtn);
        panelPrincipal.setPadding(new Insets(15));
    }

    private void agregarTenista(ControladorTenistas controlador, VistaTablaTenistas vistaTabla) {
        String nombre = nombreInput.getText().trim();
        String pais = paisInput.getText().trim();
        int edad;
        int puntaje;

        try {
            edad = Integer.parseInt(edadInput.getText().trim());
            puntaje = Integer.parseInt(puntajeInput.getText().trim());
        } catch (NumberFormatException e) {
            mostrarAlerta("Edad y puntaje deben ser números válidos.");
            return;
        }

        Tenista nuevo = new Tenista(nombre, pais, edad, puntaje);

        String mensajeError = Validaciones.validarYObtenerError(nuevo);
        if (mensajeError != null) {
            mostrarAlerta(mensajeError);
            return;
        }

        if (!controlador.agregarTenista(nuevo)) {
            mostrarAlerta("El tenista ya existe en la lista.");
            return;
        }

        vistaTabla.actualizar(controlador);
        limpiarFormulario();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Advertencia");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarFormulario() {
        nombreInput.clear();
        paisInput.clear();
        edadInput.clear();
        puntajeInput.clear();
    }

    public VBox getPanelPrincipal() {
        return panelPrincipal;
    }
}
