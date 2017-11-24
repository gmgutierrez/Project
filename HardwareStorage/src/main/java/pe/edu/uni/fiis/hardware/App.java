package pe.edu.uni.fiis.hardware;

import dto.clases.cliente;
import dto.clases.proveedor;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class App extends Application {
    public static Stage ventPrinc;
    @FXML private TableView<cliente> detalleCli = new TableView<cliente>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        ventPrinc=primaryStage;
        final ObservableList<cliente> clients = FXCollections.observableArrayList(
                new cliente(1,1,"hello","lola","lolo","19/02/2011"),
                new cliente(2, 1,"Hola", "alo","hi", "19/10/2017"),
                new cliente(3,1, "74714588","nel","son","16/05/2010"));
        System.out.println(clients.size());
        detalleCli.setItems(clients);

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("filesfxml/Inicio.fxml"));
        ventPrinc.setTitle("HardWare Store 1.0");
        ventPrinc.setScene(new Scene(root, 640, 480));
        ventPrinc.setResizable(false);
        ventPrinc.show();

       ventPrinc.setFullScreen(true);
    }

    public static void main(String[] args) {
        launch(args);
    }

}