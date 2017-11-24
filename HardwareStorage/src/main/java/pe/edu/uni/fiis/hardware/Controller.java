package pe.edu.uni.fiis.hardware;

import conexion.cnxCliente;
import conexion.cnxProducto;
import conexion.cnxProveedor;
import dto.clases.cliente;
import dto.clases.producto;
import dto.clases.proveedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.xml.soap.Text;

public class Controller {
    @FXML FXMLLoader fxmlLoader;
    @FXML Parent root;
    @FXML private TableView detalleProv = new TableView();
    @FXML private TableView<producto> detalleProd = new TableView<producto>();
    @FXML private TableColumn<producto, Integer> codProducto = new TableColumn<producto, Integer>();
    @FXML private TableColumn<producto, String> tipoProducto = new TableColumn<producto, String>();
    @FXML private TableColumn<producto, String> marca = new TableColumn<producto, String>();
    @FXML private TableColumn<producto, String> unidadMedida = new TableColumn<producto, String>();
    @FXML private TableColumn<producto, String> modelo = new TableColumn<producto, String>();
    @FXML private TableColumn<producto, String> stock = new TableColumn<producto, String>();
    @FXML private TableColumn<producto, String> previoVenta = new TableColumn<producto, String>();
    @FXML private TextField idProd = new TextField();
    @FXML private TextField tipoProd = new TextField();
    @FXML private TextField ProdProv = new TextField();
    @FXML private TextField ProdMarca = new TextField();
    @FXML private TextField ProdModelo = new TextField();
    @FXML private TextField precCompra = new TextField();
    @FXML private TextField precVenta = new TextField();
    @FXML private TextField unitMedidaProd = new TextField();
    @FXML private TextField stockProd = new TextField();
    @FXML private TextArea descripProd = new TextArea();

    ObservableList<producto> products;


    @FXML private TableView<cliente> detalleCli = new TableView<cliente>();
    @FXML private TableColumn<cliente, Integer> codCliente = new TableColumn<cliente, Integer>();
    @FXML private TableColumn<cliente, Integer> tipoDto = new TableColumn<cliente, Integer>();;
    @FXML private TableColumn<cliente, String> nroDto = new TableColumn<cliente, String>();
    @FXML private TableColumn<cliente, String> nomCliente = new TableColumn<cliente, String>();
    @FXML private TableColumn<cliente, String> estado = new TableColumn<cliente, String>();
    @FXML private TableColumn<cliente, String> fechaReg = new TableColumn<cliente, String>();
    @FXML private TextField codCli = new TextField();
    @FXML private TextField nameCli = new TextField();
    @FXML private TextField company = new TextField();
    @FXML private TextField direccCli = new TextField();
    @FXML private TextField provCli = new TextField();
    @FXML private TextField departCli = new TextField();
    @FXML private TextField zipCodeCli = new TextField();
    @FXML private TextField countryCli = new TextField();
    @FXML private TextField emailCli = new TextField();
    @FXML private TextField nroCelCli = new TextField();
    @FXML private TextArea observCli = new TextArea();
    ObservableList<cliente> clients;

    public void Change(String s){
        try{
            fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("filesfxml/"+s+".fxml"));
            root = (Parent) fxmlLoader.load();
                /*còmo poner el nuevo fxml en la misma ventana*/
            Stage stage = App.ventPrinc;
            stage.setTitle("UnIris 1.0");
            stage.setScene(new Scene(root));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void showClientDetails(String code) {
        cnxCliente cnxcliente = new cnxCliente();
        cliente busca = cnxcliente.buscarCliente(code);
        if (busca != null) {
            // Fill the labels with info from the person object.
            codCli.setText(String.valueOf(busca.getCodCliente()));
            nameCli.setText(busca.getNomCliente());
            company.setText("Apple");
            direccCli.setText("Calle Las Brisas Mz. H Lt.25");
            provCli.setText("San Miguel");
            departCli.setText("Lima");
            zipCodeCli.setText("Lima 32");
            emailCli.setText("jdz@gmail.com");
            nroCelCli.setText("986250147");
            countryCli.setText("Perú");
            observCli.setText("Pues consume nivel medio. Saludos.");

            // TODO: We need a way to convert the birthday into a String!
            // birthdayLabel.setText(...);
        } else {
            // Person is null, remove all the text.
            codCli.setText("");
            nameCli.setText("");
            company.setText("");
            direccCli.setText("");
            provCli.setText("");
            departCli.setText("");
            zipCodeCli.setText("");
            emailCli.setText("");
            nroCelCli.setText("");
            countryCli.setText("");
            observCli.setText("");
        }
    }

    private void showProdDetails(String code) {
        cnxProducto cnxproducto = new cnxProducto();
        producto busca = cnxproducto.buscarProducto(code);
        if (busca != null) {
            // Fill the labels with info from the person object.
            idProd.setText(String.valueOf(busca.getCodProducto()));
            tipoProd.setText(busca.getTipoProducto());
            ProdProv.setText("Samsung");
            ProdMarca.setText(busca.getMarca());
            ProdModelo.setText(busca.getModelo());
            precCompra.setText(String.valueOf(busca.getPrecioCosto()));
            //precVenta.setText(busca.getPrecioVenta);
            unitMedidaProd.setText(busca.getUnidadMedida());
            stockProd.setText(String.valueOf(busca.getStock()));
            descripProd.setText("Producto muy consumido en la nasa");
            // TODO: We need a way to convert the birthday into a String!
            // birthdayLabel.setText(...);
        } else {
            // Person is null, remove all the text.
            idProd.setText("");
            tipoProd.setText("");
            ProdProv.setText("");
            ProdMarca.setText("");
            ProdModelo.setText("");
            precCompra.setText("");
            precVenta.setText("");
            unitMedidaProd.setText("");
            stockProd.setText("");
            descripProd.setText("");
        }
    }

    @FXML
     void initialize(){
            assert detalleCli != null : "fx:id=\"detalleCli\" was not injected: check your FXML file 'Consulta.fxml'.";
            codCliente.setCellValueFactory(
                    new PropertyValueFactory<cliente, Integer>("codCliente"));
            tipoDto.setCellValueFactory(
                    new PropertyValueFactory<cliente, Integer>("tipoDto"));
            nroDto.setCellValueFactory(
                    new PropertyValueFactory<cliente, String>("nroDto"));
            nomCliente.setCellValueFactory(
                    new PropertyValueFactory<cliente, String>("nomCliente"));
            estado.setCellValueFactory(
                    new PropertyValueFactory<cliente, String>("estado"));
            fechaReg.setCellValueFactory(
                    new PropertyValueFactory<cliente, String>("fechaReg"));

            clients = FXCollections.observableArrayList();
            cnxCliente cnxcliente = new cnxCliente();
            clients = cnxcliente.lecturaCliente();
            detalleCli.setItems(clients);

            showClientDetails("0");

            detalleCli.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showClientDetails(String.valueOf(newValue.getCodCliente())));
            /**************************************************/
            assert detalleProd != null : "fx:id=\"detalleProd\" was not injected: check your FXML file 'Consulta.fxml'.";
            codProducto.setCellValueFactory(
                new PropertyValueFactory<producto, Integer>("codProducto"));
            tipoProducto.setCellValueFactory(
                new PropertyValueFactory<producto, String>("tipoProducto"));
            marca.setCellValueFactory(
                new PropertyValueFactory<producto, String>("marca"));
            modelo.setCellValueFactory(
                new PropertyValueFactory<producto, String>("modelo"));
            unidadMedida.setCellValueFactory(
                    new PropertyValueFactory<producto, String>("unidadMedida"));
            stock.setCellValueFactory(
                new PropertyValueFactory<producto, String>("stock"));
            previoVenta.setCellValueFactory(
                    new PropertyValueFactory<producto, String>("precioVenta"));

            products = FXCollections.observableArrayList();
            cnxProducto cnxproducto = new cnxProducto();
            products = cnxproducto.lecturaProducto();
            detalleProd.setItems(products);
            showProdDetails("0");

            detalleProd.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showProdDetails(String.valueOf(newValue.getCodProducto())));


    }

    public void handleSubmitCliBtnBack(ActionEvent actionEvent) {
        Change("Inicio");
    }

    public void handleSubmitCliBtnSearch(ActionEvent actionEvent) {
        Change("Buscar");
    }

    public void handleSubmitCliBtnNew(ActionEvent actionEvent) {
        Change("Clientes/Registro");
    }

    public void handleSubmitCliBtnDelete(ActionEvent actionEvent) {
    }

    public void handleSubmitCliBtnUpdate(ActionEvent actionEvent) {
    }

    public void handleSubmitCliBtnSave(ActionEvent actionEvent) {
    }

    public void handleSubmitProvBtnUpdate(ActionEvent actionEvent) {
    }

    public void handleSubmitProvBtnDelete(ActionEvent actionEvent) {
    }

    public void handleSubmitProvBtnSearch(ActionEvent actionEvent) {
    }

    public void handleSubmitProvBtnNew(ActionEvent actionEvent) {
    }

    public void handleSubmitProvBtnBack(ActionEvent actionEvent) {
        Change("Inicio");
    }

    public void handleSubmitProvBtnSave(ActionEvent actionEvent) {
    }

    public void handleSubmitProdBtnUpdate(ActionEvent actionEvent) {
    }

    public void handleSubmitProdBtnDelete(ActionEvent actionEvent) {
    }

    public void handleSubmitProdBtnNew(ActionEvent actionEvent) {
    }

    public void handleSubmitProdBtnBack(ActionEvent actionEvent) {
        Change("Inicio");
    }

    public void handleSubmitProdBtnSearch(ActionEvent actionEvent) {
    }

    public void handleSubmitProdBtnSave(ActionEvent actionEvent) {
    }

    public void handleSubmitQuoteBtnNew(ActionEvent actionEvent) {
    }

    public void handleSubmitQuoteBtnlist(ActionEvent actionEvent) {
    }

    public void handleSubmitSalesBtnBack(ActionEvent actionEvent) {
        Change("Inicio");
    }

    public void handleSubmitPurchBtnNew(ActionEvent actionEvent) {
    }

    public void handleSubmitPurchOrderBtnlist(ActionEvent actionEvent) {
    }

    public void handleSubmitPurchBtnBack(ActionEvent actionEvent) {
        Change("Inicio");
    }

    public void handleSubmitPurchDelBtnNew(ActionEvent actionEvent) {
    }

    public void handleSubmitPurchDelivBtnlist(ActionEvent actionEvent) {
    }

    public void handleSubmitPurchDelivBtnBack(ActionEvent actionEvent) {
        Change("Inicio");
    }

    public void handleSubmitgoProv(ActionEvent actionEvent) {
        Change("Proveedores/Consulta");
        cnxProveedor cnxproveedor = new cnxProveedor();
        ObservableList<proveedor> proveedors = cnxproveedor.lecturaProveedor();
        detalleProv.setItems(proveedors);
    }

    public void handleSubmitgoProd(ActionEvent actionEvent) {
        cnxProducto cnxproducto = new cnxProducto();
        final ObservableList<producto> products = cnxproducto.lecturaProducto();
        detalleProd.setItems(products);
        Change("Productos/Catalogo");
    }

    public void handleSubmitgoCli(ActionEvent actionEvent) {
        Change("Clientes/Consulta");
    }
}
