import java.sql.Date;

import entidades.Cliente;
import persistencia.ClienteDAO;
import persistencia.ProductoDAO;
import servicios.ClienteServicio;
import servicios.MenuServicio;
import servicios.PedidoServicio;

public class App {
    public static void main(String[] args) throws Exception {
        MenuServicio menu = new MenuServicio();
        menu.empezarMenu();
        menu.close();
        // pruebaPedidoServicio();
        // Date fechaPedido = Date.valueOf("2009-03-10");
        // System.out.println(fechaPedido.toString());
        
        // pruebaClienteServicio();
        // pruebaClienteDAO();
        // pruebaProductoDAO();
    }

    private static void pruebaPedidoServicio() {
        PedidoServicio ps = new PedidoServicio();
        try {
            Date fechaPedido = Date.valueOf("2009-03-10");
            Date fechaEsperada = Date.valueOf("2009-03-11");
            Date fechaEntrega = Date.valueOf("2009-03-11");

            ps.crearNuevoPedido(41,
                fechaPedido,
                fechaEsperada,
                fechaEntrega,
                "'Pendiente'",
                "'NULL'",
                6);
            System.out.println("Pedido 41 creado");
        } catch (Exception e) {
            System.out.println("Error pedido servicio");
            System.out.println(e.getMessage());
        }
    }

    private static void pruebaClienteServicio() {
        ClienteServicio cs = new ClienteServicio();
        try {
            // cs.crearNuevoCliente(23,
            //     "'ClienteC'",
            //     "'NombreC'",
            //     "'ApellidoC'",
            //     "'122456777'",
            //     "'122456666'",
            //     "'Lima'",
            //     "NULL",
            //     "'Peru'",
            //     "'12245'",
            //     8,
            //     30000
            // );
            cs.listarClientes();
        } catch (Exception e) {
            System.out.println("Error cliente servicio");
        }

    }

    private static void pruebaProductoDAO() {
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.eliminarProductoPorCodigo(1);
    }

    private static void pruebaClienteDAO() {
        ClienteDAO clienteDao = new ClienteDAO();
        // Cliente cA = new Cliente(20,
        //     "'ClienteA'",
        //     "'NombreA'",
        //     "'ApellidoA'",
        //     "'123456777'",
        //     "'123456666'",
        //     "'Lima'",
        //     "NULL",
        //     "'Peru'",
        //     "'12345'",
        //     8,
        //     30000
        // );
        // Cliente cB = new Cliente(22,
        //     "'ClienteB'",
        //     "'NombreB'",
        //     "'ApellidoB'",
        //     "'023456777'",
        //     "'023456666'",
        //     "'Lima'",
        //     "NULL",
        //     "'Peru'",
        //     "'02345'",
        //     8,
        //     31000
        // );
        // clienteDao.guardarCliente(cB);
        // clienteDao.listarTodosLosClientes();
        clienteDao.buscarClientePorCodigo(1);
    }
}
