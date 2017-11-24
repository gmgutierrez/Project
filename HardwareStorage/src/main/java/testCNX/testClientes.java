package testCNX;

import conexion.cnxCliente;
import dto.clases.cliente;
import javafx.collections.ObservableList;

import java.util.Vector;

public class testClientes {
    public static void main(String[] args) {
   /*lectura*/
        cnxCliente cnxcliente = new cnxCliente();
        ObservableList<cliente> clientes = cnxcliente.lecturaCliente();
        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i).print();
        }
    /*insercion*/
        cliente aux = new cliente(2,1,"87654321","CLIENTE2"
                ,"ACTIVO","2012/05/05");
        cnxcliente.insertarCliente(aux);
        System.out.println();
        clientes.clear();
        clientes = cnxcliente.lecturaCliente();
        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i).print();
        }
        /*eliminacion*/
        System.out.println();
        cnxcliente.eliminarCliente(2);
        clientes.clear();
        clientes = cnxcliente.lecturaCliente();
        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i).print();
        }
    }
}
