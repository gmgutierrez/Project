package testCNX;

import conexion.cnxVenta;
import dto.clases.venta;

import java.util.Vector;

public class testVenta {
    public static void main(String[] args) {
    /*lectura*/
        cnxVenta cnxventa = new cnxVenta();
        Vector<venta> ventas = cnxventa.lecturaVenta();
        for (int i = 0; i < ventas.size(); i++) {
            ventas.elementAt(i).print();
        }
    /*insercion*/
        venta aux = new venta(2,45,12,"2007/05/05");
        cnxventa.insertarVenta(aux);
        System.out.println();
        ventas.clear();
        ventas = cnxventa.lecturaVenta();
        for (int i = 0; i < ventas.size(); i++) {
            ventas.elementAt(i).print();
        }
        /*eliminacion*/
        System.out.println();
        cnxventa.eliminarVenta(2);
        ventas.clear();
        ventas = cnxventa.lecturaVenta();
        for (int i = 0; i < ventas.size(); i++) {
            ventas.elementAt(i).print();
        }
    }
}
