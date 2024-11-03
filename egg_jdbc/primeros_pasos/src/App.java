import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Loading class `com.mysql.jdbc.Driver'. This is deprecated.
// The new driver class is `com.mysql.cj.jdbc.Driver'.
// The driver is automatically registered via the SPI and manual
// loading of the driver class is generally unnecessary.

public class App {
    private static final String HOST = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String USER = "root";
    private static final String PASSWORD = "mySql3gg";
    private static final String DATABASE = "vivero";
    // private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String ZONA = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static void main(String[] args) throws Exception {
        Connection conexion = getConnection();
        // buscarClientes(conexion);
        // buscarClientePorCodigo(conexion, 2);
        // buscarClientesPorEmpleado(conexion, 7);
        // getProductosParaReponer(conexion, 20);
        // getProductosGama(conexion, "Herramientas");
        // getPedidosPorCliente(conexion, 3);
        getPedidosPorEstado(conexion, "Pendiente");
        cerrarConexion(conexion);
    }

    private static void buscarProductos(Connection conexion, String sql, int columnCount) {
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            
            // ResultSetMetaData metadata = rs.getMetaData();
            // int columnCount = metadata.getColumnCount();
            while (rs.next()){
                String row = "";
                count++;
                for (int i = 1; i <= columnCount; i++) {
                    row += rs.getString(i);
                    if (i != columnCount){
                        row += " - ";
                    }
                }
                System.out.println(row);
            }
            System.out.println("Resultados: " + count);
            rs.close();
            stmt.close();
        } catch (SQLException e){
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    private static void getProductosParaReponer(Connection conexion, int puntoReposicion) {
        String sql = "SELECT codigo_producto, nombre, cantidad_en_stock "
            + "FROM producto WHERE cantidad_en_stock < " + puntoReposicion;
        buscarProductos(conexion, sql, 3);
    }

    private static void getProductosGama(Connection conexion, String nombreGama) {
        String sql = String.join(" ",
            "SELECT codigo_producto, nombre, g.id_gama, gama",
            "FROM gama_producto g",
            "INNER JOIN producto p ON g.id_gama = p.id_gama",
            "WHERE gama = '" + nombreGama + "'"
        );
        buscarProductos(conexion, sql, 4);
    }

    private static void getPedidosPorCliente(Connection conexion, int idCliente){
        String sql = "SELECT codigo_pedido, fecha_pedido, estado FROM pedido WHERE id_cliente= ?";
            
        try {
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, idCliente);

            ResultSet rs = pstmt.executeQuery();
            
            int count = 0;
            while (rs.next()){
                count++;
                int codigoPedido = rs.getInt("codigo_pedido");
                Date fecha = rs.getDate("fecha_pedido");
                String estado = rs.getString("estado");
                System.out.println(codigoPedido + " - " + fecha + " - " + estado);
            }
            System.out.println("Resultados: " + count);
            rs.close();
            pstmt.close();
        } catch (SQLException e){
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    private static void getPedidosPorEstado(Connection conexion, String estado){
        String sql = "SELECT codigo_pedido, fecha_pedido, estado FROM pedido WHERE estado= ?";
            
        try {
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, estado);

            ResultSet rs = pstmt.executeQuery();
            
            int count = 0;
            while (rs.next()){
                count++;
                int codigoPedido = rs.getInt("codigo_pedido");
                Date fecha = rs.getDate("fecha_pedido");
                String estadoRs = rs.getString("estado");
                System.out.println(codigoPedido + " - " + fecha + " - " + estadoRs);
            }
            System.out.println("Resultados: " + count);
            rs.close();
            pstmt.close();
        } catch (SQLException e){
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    private static void buscarClientes(Connection conexion) {
        String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente";
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            
            while (rs.next()){
                String nombre = rs.getString("nombre_contacto");
                String apellido = rs.getString("apellido_contacto");
                String telefono = rs.getString("telefono");
                count++;
                System.out.println(count + " - " + nombre + " " + apellido + " -  " + telefono);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e){
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    private static void buscarClientes(Connection conexion, String where) {
        String sql = "SELECT nombre_contacto, apellido_contacto, telefono FROM cliente " + where;
        try {
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            int count = 0;
            
            while (rs.next()){
                String nombre = rs.getString("nombre_contacto");
                String apellido = rs.getString("apellido_contacto");
                String telefono = rs.getString("telefono");
                count++;
                System.out.println(count + " - " + nombre + " " + apellido + " -  " + telefono);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e){
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }

    private static void buscarClientePorCodigo(Connection conexion, int codigoCliente) {
        String where = "WHERE codigo_cliente = " + codigoCliente;
        buscarClientes(conexion, where);
    }

    private static void buscarClientesPorEmpleado(Connection conexion, int codigoEmpleado) {
        String where = "WHERE id_empleado = " + codigoEmpleado;
        buscarClientes(conexion, where);
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conexion = null;

        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + ZONA;
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el contralado JDBC: " + e.getMessage());
            throw e;
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            throw e;
        }
        return conexion;
    }

    public static void cerrarConexion(Connection conexion) {
        if (conexion != null){
            try {
                // import java.sql.ResultSet;
                // if (resultSet != null) {
                //     resultSet.close();
                // }
                // import java.sql.Statement;
                // if (statement != null) {
                //     statement.close();
                // }
                conexion.close();
                System.out.println("La conexión a la base fue cerrada de manera correcta");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
