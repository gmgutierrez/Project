package conexion;

import dto.clases.*;
import java.sql.*;
import java.util.Vector;


public class cnxPedido {
    Vector<pedido> pedidos =new Vector();

    public cnxPedido(){
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
    public Vector lecturaPedido(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query ="SELECT * FROM dbo.PEDIDO";

            Connection conn = DriverManager.getConnection(url,user,psw);
            Statement statement = conn.createStatement();
            ResultSet resultSet;
            //lectura
            resultSet = statement.executeQuery(query);
            while(resultSet.next()) {
                int cod=resultSet.getInt(1);
                String fechas = resultSet.getString(2);
                float total = resultSet.getFloat(3);
                pedido aux=new pedido(cod,fechas,total);
                pedidos.addElement(aux);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Error al leer");
            System.err.println(e.getMessage());
        }
        return pedidos;
    }
    public void insertarPedido(pedido aux){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query = "INSERT INTO PEDIDO VALUES ("+aux.getCodPedido()+",'"+aux.getFecha()+"',"+aux.getTotal()+")";

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
    public void eliminarPedido(int delete){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=FERRETERIA";

            String query="DELETE FROM PEDIDO WHERE codPedido ="+delete;

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
