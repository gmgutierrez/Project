package conexion;

import dto.clases.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class cnxProveedor {
    ObservableList<proveedor> proveedors = FXCollections.observableArrayList();

    public ObservableList<proveedor> getProveedores() {
        return proveedors;
    }

    public cnxProveedor(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            Connection conn = DriverManager.getConnection(url,user,psw);
            System.out.println("Conexión establecida");
            conn.close();
        } catch (Exception e) {
            System.err.println("Error al conectar");
            System.err.println(e.getMessage());
        }
    }
    public ObservableList<proveedor> lecturaProveedor(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query ="SELECT * FROM dbo.PROVEEDOR";

            Connection conn = DriverManager.getConnection(url,user,psw);
            Statement statement = conn.createStatement();
            ResultSet resultSet;
            //lectura
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                int codproveedor=resultSet.getInt(1);
                String name = resultSet.getString(2);
                String ruc = resultSet.getString(3);
                String direccion = resultSet.getString(4);
                String ciudad = resultSet.getString(5);
                String telef = resultSet.getString(6);
                String email = resultSet.getString(7);
                float formula = resultSet.getFloat(8);
                float factor = resultSet.getFloat(9);
                String fechas=resultSet.getString(10);
                proveedor aux=new proveedor(codproveedor,name,ruc,direccion,ciudad,telef
                        ,email,formula,factor,fechas);
                proveedors.add(aux);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Error al leer");
            System.err.println(e.getMessage());
        }
        return proveedors;
    }
    public void insertarProveedor(proveedor aux){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query = "INSERT INTO PROVEEDOR VALUES ("+aux.getCodProveedor()+",'"+aux.getNomProveedor()
                    +"','"+aux.getRucProveedor()+"','"+aux.getDireccionProveedor()+"','"+aux.getCiudadProveedor()
                    +"','"+aux.getTelefProveedor()+"','"+aux.getEmailProveedor()+"',"+aux.getFormulaProveedor()
                    +","+aux.getFactorProveedor()+",'"+aux.getFechaReg()+"')";

            Connection conn = DriverManager.getConnection(url,user,psw);
            //inserta
            Statement statement = conn.createStatement();
            int x = statement.executeUpdate(query);
            System.out.println("Filas afectadas "+x);
            conn.close();
        } catch (Exception e) {
            System.err.println("Error al insertar");
            System.err.println(e.getMessage());
        }
    }
    public void eliminarProveedor(int delete){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query="DELETE FROM PROVEEDOR WHERE codProveedor ="+delete;

            Connection conn = DriverManager.getConnection(url,user,psw);
            Statement statement = conn.createStatement();
            //elimina
            statement.executeUpdate(query);
            conn.close();
        } catch (Exception e) {
            System.err.println("Error al eliminar");
            System.err.println(e.getMessage());
        }
    }
}

