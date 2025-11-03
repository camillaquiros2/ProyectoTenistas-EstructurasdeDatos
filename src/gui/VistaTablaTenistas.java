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

        TableColumn<Tenista, String> nombreCol = new TableColumn<>("Nombre");
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Tenista, String> paisCol = new TableColumn<>("País");
        paisCol.setCellValueFactory(new PropertyValueFactory<>("pais"));

        TableColumn<Tenista, Integer> edadCol = new TableColumn<>("Edad");
        edadCol.setCellValueFactory(new PropertyValueFactory<>("edad"));

        TableColumn<Tenista, Integer> puntajeCol = new TableColumn<>("Puntaje");
        puntajeCol.setCellValueFactory(new PropertyValueFactory<>("puntaje"));

        tablaTenistas.getColumns().addAll(nombreCol, paisCol, edadCol, puntajeCol);
        tablaTenistas.setItems(datos);
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