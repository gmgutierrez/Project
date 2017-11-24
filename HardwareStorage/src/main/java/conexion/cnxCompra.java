package conexion;

import dto.clases.*;
import java.sql.*;
import java.util.Vector;

public class cnxCompra {
    Vector<compra> compras =new Vector();

    public cnxCompra(){
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
    public Vector lecturaCompra(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query ="SELECT * FROM dbo.COMPRA";

            Connection conn = DriverManager.getConnection(url,user,psw);
            Statement statement = conn.createStatement();
            ResultSet resultSet;
            //lectura
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                int cod=resultSet.getInt(1);
                int codprov=resultSet.getInt(2);
                int num=resultSet.getInt(3);
                float sub = resultSet.getFloat(4);
                float igv = resultSet.getFloat(5);
                String fechas = resultSet.getString(6);
                compra aux=new compra(cod,codprov,num,sub,igv,fechas);
                compras.addElement(aux);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Error al leer");
            System.err.println(e.getMessage());
        }
        return compras;
    }
    public void insertarCompra(compra aux){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query = "INSERT INTO COMPRA VALUES ("+aux.getCodCompra()+","+aux.getCodProveedor()
                    +","+aux.getNumDocumento()+","+aux.getSubTotal()+","+aux.getIGV()+",'"+aux.getFecha()+"')";

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
    public void eliminarCompra(int delete){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query="DELETE FROM COMPRA WHERE codCompra ="+delete;

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

