package conexion;

import dto.clases.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class cnxProducto {

    ObservableList<producto> productos = FXCollections.observableArrayList();

    public cnxProducto(){
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
    public producto buscarProducto(String codigo){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user = "sa";
            String psw = "1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query = "SELECT * FROM PRODUCTO where codProducto="+codigo;

            Connection conn = DriverManager.getConnection(url, user, psw);
            Statement statement = conn.createStatement();

            ResultSet resultSet;
            resultSet = statement.executeQuery(query);
            resultSet.next();
            int codproducto =resultSet.getInt(1);
            String tipo = resultSet.getString(2);
            String marca = resultSet.getString(3);
            String name = resultSet.getString(4);
            String und = resultSet.getString(5);
            String model = resultSet.getString(6);
            int cant= resultSet.getInt(7);
            float preciocosto = resultSet.getFloat(8);
            int stocks = resultSet.getInt(9);
            float margens = resultSet.getFloat(10);
            producto aux=new producto(codproducto,tipo,marca,name,und
                    ,model,cant,preciocosto,stocks,margens);
            conn.close();
            return aux;
        } catch (Exception e) {
            System.err.println("Error al leer");
            System.err.println(e.getMessage());
            return null;
        }
    }
    public ObservableList<producto> lecturaProducto(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query ="SELECT * FROM dbo.PRODUCTO";

            Connection conn = DriverManager.getConnection(url,user,psw);
            Statement statement = conn.createStatement();
            ResultSet resultSet;
            //lectura
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                int codproducto =resultSet.getInt(1);
                String tipo = resultSet.getString(2);
                String marca = resultSet.getString(3);
                String name = resultSet.getString(4);
                String und = resultSet.getString(5);
                String model = resultSet.getString(6);
                int cant= resultSet.getInt(7);
                float preciocosto = resultSet.getFloat(8);
                int stocks = resultSet.getInt(9);
                float margens = resultSet.getFloat(10);
                producto aux=new producto(codproducto,tipo,marca,name,und
                        ,model,cant,preciocosto,stocks,margens);
                productos.add(aux);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Error al leer");
            System.err.println(e.getMessage());
        }
        return productos;
    }
    public void insertarProducto(producto aux){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query = "INSERT INTO PRODUCTO VALUES ("+aux.getCodProducto()+",'"+aux.getTipoProducto()
                    +"','"+aux.getMarca()+"','"+aux.getNombre()+"','"+aux.getUnidadMedida()+"','"
                    +aux.getModelo()+"',"+aux.getCantidad()+","+aux.getPrecioCosto()+","
                    +aux.getStock()+","+aux.getMargen()+")";

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
    public void eliminarProducto(int delete){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query="DELETE FROM PRODUCTO WHERE codProducto ="+delete;

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
