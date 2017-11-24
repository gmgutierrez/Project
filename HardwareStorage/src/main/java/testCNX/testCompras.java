package testCNX;

import conexion.cnxCompra;
import dto.clases.compra;

import java.util.Vector;

public class testCompras {
    public static void main(String[] args) {
    /*lectura*/
        cnxCompra cnxcompra = new cnxCompra();
        Vector<compra> compras = cnxcompra.lecturaCompra();
        for (int i = 0; i < compras.size(); i++) {
            compras.elementAt(i).print();
        }
    /*insercion*/
        compra aux = new compra(2,1,143,121,
                1,"2015/05/05");
        cnxcompra.insertarCompra(aux);
        System.out.println();
        compras.clear();
        compras = cnxcompra.lecturaCompra();
        for (int i = 0; i < compras.size(); i++) {
            compras.elementAt(i).print();
        }
        /*eliminacion*/
        System.out.println();
        cnxcompra.eliminarCompra(2);
        compras.clear();
        compras = cnxcompra.lecturaCompra();
        for (int i = 0; i < compras.size(); i++) {
            compras.elementAt(i).print();
        }
    }
}
