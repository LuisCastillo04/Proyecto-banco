package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {

    public static Connection conexionMysql() // Tiene que ser estatico para que podamos conectar desde Metodos
    {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ahorramigo", "root", "admin");
            //JOptionPane.showMessageDialog(null, "Conectado a la BD");

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Driver not Found" + ex.getMessage());
        }
        return conexion;
    }//Cerrar método mysql

}
