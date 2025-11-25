package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import logic.ControladorTenistas;
import model.Tenista;

public class VistaTablaTenistas {

    private final VBox panelTabla;
    private final TableView<Tenista> tablaTenistas;
    private final ObservableList<Tenista> datos;

    public VistaTablaTenistas(ControladorTenistas controlador) {
        tablaTenistas = new TableView<>();
        datos = FXCollections.observableArrayList(controlador.obtenerTenistas());

        // --- Columnas ---
        TableColumn<Tenista, String> nombreCol = new TableColumn<>("Nombre");
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombreCol.setMinWidth(150);

        TableColumn<Tenista, String> paisCol = new TableColumn<>("País");
        paisCol.setCellValueFactory(new PropertyValueFactory<>("pais"));
        paisCol.setMinWidth(120);

        TableColumn<Tenista, Integer> edadCol = new TableColumn<>("Edad");
        edadCol.setCellValueFactory(new PropertyValueFactory<>("edad"));
        edadCol.setMinWidth(80);

        TableColumn<Tenista, Double> puntajeCol = new TableColumn<>("Puntaje");
        puntajeCol.setCellValueFactory(new PropertyValueFactory<>("puntaje"));
        puntajeCol.setMinWidth(100);

        // Agregar columnas a la tabla
        tablaTenistas.getColumns().addAll(nombreCol, paisCol, edadCol, puntajeCol);
        tablaTenistas.setItems(datos);

        // Ajuste automático de tamaño
        tablaTenistas.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        panelTabla = new VBox(tablaTenistas);
    }

    public void actualizar(ControladorTenistas controlador) {
        datos.setAll(controlador.obtenerTenistas());
    }

    public VBox getPanelTabla() {
        return panelTabla;
    }
}
