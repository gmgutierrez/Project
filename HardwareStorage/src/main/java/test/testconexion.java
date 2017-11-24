package test;

import java.sql.*;

public class testconexion {
    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String user ="sa";
            String psw="1234";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=prueba";

            Connection conn = DriverManager.getConnection(url,user,psw);
            Statement statement = conn.createStatement();
            ResultSet resultSet;

            resultSet = statement.executeQuery("SELECT nom_centro, dist_centro FROM dbo.centro");
            while(resultSet.next()) {
                String lastName = resultSet.getString("nom_centro");
                String address = resultSet.getString("dist_centro");
                System.out.println(lastName);
                System.out.println(address);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());

        }
    }
}
