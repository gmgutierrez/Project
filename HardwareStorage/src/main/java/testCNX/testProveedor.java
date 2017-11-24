package testCNX;

import conexion.cnxProveedor;
import dto.clases.proveedor;
import javafx.collections.ObservableList;

import java.util.Vector;

public class testProveedor {
    public static void main(String[] args) {
    /*lectura*/
        cnxProveedor cnxproveedor = new cnxProveedor();
        ObservableList<proveedor> proveedors = cnxproveedor.lecturaProveedor();
        for (int i = 0; i < proveedors.size(); i++) {
            proveedors.get(i).print();
        }
    /*insercion*/
        proveedor aux = new proveedor(2,"PROVEEDOR2","RUC2","DIRECCION2",
                "CIUDAD2","TELEF2","EMAIL2",14,15,"2000/05/05");
        cnxproveedor.insertarProveedor(aux);
        System.out.println();
        proveedors.clear();
        proveedors = cnxproveedor.lecturaProveedor();
        for (int i = 0; i < proveedors.size(); i++) {
            proveedors.get(i).print();
        }
        /*eliminacion*/
        System.out.println();
        cnxproveedor.eliminarProveedor(2);
        proveedors.clear();
        proveedors = cnxproveedor.lecturaProveedor();
        for (int i = 0; i < proveedors.size(); i++) {
            proveedors.get(i).print();
        }
    }
}
