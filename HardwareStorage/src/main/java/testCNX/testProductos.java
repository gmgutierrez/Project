package testCNX;

import conexion.cnxProducto;
import dto.clases.producto;
import javafx.collections.ObservableList;

import java.util.Vector;

public class testProductos {
    public static void main(String[] args) {
   /*lectura*/
        cnxProducto cnxproducto = new cnxProducto();
        ObservableList<producto> productos = cnxproducto.lecturaProducto();
        for (int i = 0; i < productos.size(); i++) {
            productos.get(i).print();
        }
    /*insercion*/
        producto aux = new producto(2, "TIPO2","MARCA2","PRODUCTO2","GRAMOS","MODELO2",8,20,20,3);
        cnxproducto.insertarProducto(aux);
        System.out.println();
        productos.clear();
        productos = cnxproducto.lecturaProducto();
        for (int i = 0; i < productos.size(); i++) {
            productos.get(i).print();
        }
        /*eliminacion*/
        System.out.println();
        cnxproducto.eliminarProducto(2);
        productos.clear();
        productos = cnxproducto.lecturaProducto();
        for (int i = 0; i < productos.size(); i++) {
            productos.get(i).print();
        }
    }
}
