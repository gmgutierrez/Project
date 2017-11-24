package testCNX;

import conexion.cnxPedido;
import dto.clases.pedido;
import java.util.Vector;

public class testPedidos {
    public static void main(String[] args) {
    /*lectura*/
        cnxPedido cnxpedido = new cnxPedido();
        Vector<pedido> pedidos = cnxpedido.lecturaPedido();
        for (int i = 0; i < pedidos.size(); i++) {
            pedidos.elementAt(i).print();
        }
    /*insercion*/
        pedido aux = new pedido(2, "2021/05/05", 90);
        cnxpedido.insertarPedido(aux);
        System.out.println();
        pedidos.clear();
        pedidos = cnxpedido.lecturaPedido();
        for (int i = 0; i < pedidos.size(); i++) {
            pedidos.elementAt(i).print();
        }
        /*eliminacion*/
        System.out.println();
        cnxpedido.eliminarPedido(2);
        pedidos.clear();
        pedidos = cnxpedido.lecturaPedido();
        for (int i = 0; i < pedidos.size(); i++) {
            pedidos.elementAt(i).print();
        }
    }
}
