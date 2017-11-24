package conexion;

import dto.clases.cliente;

import dto.clases.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class cnxCliente {

    ObservableList<cliente> clientes = FXCollections.observableArrayList();

    public cnxCliente(){
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

    public cliente buscarCliente(String codigo){
        cliente aux = new cliente(0,0,"","","","");
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user = "sa";
            String psw = "1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query = "SELECT * FROM CLIENTE where codCliente="+codigo;

            Connection conn = DriverManager.getConnection(url, user, psw);
            Statement statement = conn.createStatement();

            ResultSet resultSet;
            resultSet = statement.executeQuery(query);
            resultSet.next();
            int codcliente =resultSet.getInt(1);
            int tipo =resultSet.getInt(2);
            String nro = resultSet.getString(3);
            String nombre = resultSet.getString(4);
            String estado = resultSet.getString(5);
            String fecha = resultSet.getString(6);
            aux=new cliente(codcliente,tipo,nro,nombre,estado,fecha);
            conn.close();
        } catch (Exception e) {
            System.err.println("Error al leer");
            System.err.println(e.getMessage());
            return null;
        }
        return aux;
    }

    public ObservableList<cliente> lecturaCliente(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query ="SELECT * FROM dbo.CLIENTE";

            Connection conn = DriverManager.getConnection(url,user,psw);
            Statement statement = conn.createStatement();
            ResultSet resultSet;
            //lectura
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                int codcliente =resultSet.getInt(1);
                int tipo =resultSet.getInt(2);
                String nro = resultSet.getString(3);
                String nombre = resultSet.getString(4);
                String estado = resultSet.getString(5);
                String fecha = resultSet.getString(6);
                cliente aux=new cliente(codcliente,tipo,nro,nombre,estado,fecha);
                clientes.add(aux);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Error al leer");
            System.err.println(e.getMessage());
        }
        return clientes;
    }
    public void insertarCliente(cliente aux){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query = "INSERT INTO CLIENTE VALUES("+aux.getCodCliente()+","+aux.getTipoDto()
                    +","+aux.getNroDto()+",'"+aux.getNomCliente()+"','"+aux.getEstado()
                    +"','"+aux.getFechaReg()+"')";

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
    public void eliminarCliente(int delete){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query="DELETE FROM CLIENTE WHERE codCliente ="+delete;

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
