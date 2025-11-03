package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.ControladorTenistas;

public class InterfazTenistasGUI extends Application {

    private final ControladorTenistas controlador = new ControladorTenistas();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestor de Tenistas ATP");

        BorderPane root = new BorderPane();

        VistaTablaTenistas vistaTabla = new VistaTablaTenistas(controlador);
        MenuSuperior menuSuperior = new MenuSuperior(controlador, vistaTabla);
        PanelIngreso panelIngreso = new PanelIngreso(controlador, vistaTabla);

        root.setTop(menuSuperior.getBarraBotones());
        root.setCenter(vistaTabla.getPanelTabla());
        root.setBottom(panelIngreso.getPanelPrincipal());

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
