package conexion;

import dto.clases.*;
import java.sql.*;
import java.util.Vector;

public class cnxVenta {
    Vector<venta> ventas =new Vector();

    public cnxVenta(){
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
    public Vector lecturaVenta(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query ="SELECT * FROM dbo.VENTA";

            Connection conn = DriverManager.getConnection(url,user,psw);
            Statement statement = conn.createStatement();
            ResultSet resultSet;
            //lectura
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                int cod=resultSet.getInt(1);
                float sub = resultSet.getFloat(2);
                float igv = resultSet.getFloat(3);
                String fechas=resultSet.getString(4);
                venta aux=new venta(cod,sub,igv,fechas);
                ventas.addElement(aux);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Error al leer");
            System.err.println(e.getMessage());
        }
        return ventas;
    }
    public void insertarVenta(venta aux){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query = "INSERT INTO VENTA VALUES ("+aux.getCodVenta()+","+aux.getSubtotal()
                    +","+aux.getIGV()+",'"+aux.getFecha()+"')";

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
    public void eliminarVenta(int delete){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query="DELETE FROM VENTA WHERE codVenta ="+delete;

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