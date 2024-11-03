import servicios.CasaServicio;
import servicios.ClienteServicio;
import servicios.ComentarioServicio;
import servicios.EstanciaServicio;
import servicios.FamiliaServicio;
import servicios.MenuServicio;

import java.sql.Date;

public class App {
    public static void main(String[] args) throws Exception {
        // pruebaCasa();
        // pruebaCliente();
        // pruebaComentario();
        // pruebaEstancia();
        // pruebaFamila();
        MenuServicio menu = new MenuServicio();
        menu.empezarMenu();
        menu.close();
    }

    private static void pruebaFamila() {
        FamiliaServicio famServicio = new FamiliaServicio();
        // famServicio.crearFamilia("FamiliaA", 4, 40, 2, "familiaA@mail.com", 4);
        // famServicio.modificarFamilia(9, "FamiliaB", 4, 40, 2, "familiaA@mail.com", 4);
        // famServicio.listarFamilias();
        famServicio.buscarFamilia(9);

    }

    private static void pruebaEstancia() {
        EstanciaServicio estanciaServicio = new EstanciaServicio();
        Date fechaDesde = Date.valueOf("2024-01-02");
        Date fechaHasta = Date.valueOf("2024-01-06");
        // estanciaServicio.crearEstancia(2, 4, "NombreA", fechaDesde, fechaHasta);
        // estanciaServicio.modificarEstancia(9, 2, 4, "NombreB", fechaDesde, fechaHasta);
        // estanciaServicio.listarEstancias();
        estanciaServicio.buscarEstancia(9);
    }

    private static void pruebaComentario() {
        ComentarioServicio comentarioServicio = new ComentarioServicio();
        // comentarioServicio.crearComentario(4, "comentarioA");
        // comentarioServicio.eliminarComentario(9);
        comentarioServicio.modificarComentario(8, 2, "comentarioA");
        comentarioServicio.listarComentarios();
    }

    private static void pruebaCliente() {
        ClienteServicio clienteServicio = new ClienteServicio();
        // clienteServicio.crearCliente("NombreA", "CalleA", 1, "12345", "Lima", "Peru", "1@email.com");
        // clienteServicio.modificarCliente(8, "NombreB", "CalleA", 1, "12345", "Lima", "Peru", "1@email.com");
        // clienteServicio.listarClientes();
        clienteServicio.buscarCliente(5);
    }

    private static void pruebaCasa() {
        CasaServicio casaServicio = new CasaServicio();
        Date fechaDesde = Date.valueOf("2024-01-02");
        Date fechaHasta = Date.valueOf("2024-01-06");
        // casaServicio.crearCasa("calleA", 19, "12345", "Lima", "Peru", fechaDesde, fechaHasta, 2, 7, 200, "Casa");
        // casaServicio.modificarCasa(10, "calleB", 19, "12345", "Lima", "Peru", fechaDesde, fechaHasta, 2, 7, 200, "Casa");
        // casaServicio.listarCasas();
        casaServicio.buscarCasa(4);
    }
}


// xBuscar y listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años. 
// xBuscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido. 
// xBuscar y listar  todas aquellas familias cuya dirección de email sea Hotmail. 
// xConsulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada y un número de días específico. 
// Buscar y listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron. 
// Buscar y listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y además la información de la casa que reservó. La que reemplazaría a la anterior 
// Crear un método para incrementar el precio por día. El mismo debe recibir como parámetro el % de aumento. En esta ocasión, debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostrar los precios actualizados. 
// xObtener el número de casas que existen para cada uno de los países diferentes.
// Buscar y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’. 
// Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas. 