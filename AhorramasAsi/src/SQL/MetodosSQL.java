/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import Menu.GUIAutentication.DatosDeSesion;
import Modelo.Cuenta;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MetodosSQL {

    private static Connection conexion;
    private static PreparedStatement sentenciaPreparada;
    private static ResultSet resultado;

    //===============================================================================
    public void insertarBD(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement psCiudad = null;
        PreparedStatement psDepartamento = null;
        PreparedStatement psCuenta = null;
        PreparedStatement psUsuario = null;

        // Llamar al método insertarBD
        try {
            //conexion a la base de datos
            conexion = ConexionDB.conexionMysql();

            // Inserción de datos en la tabla 'Departamento'
            String queryDepartamento = "INSERT INTO `departamento` (identificador, iddepartamento, nombre) VALUES (?, ?, ?)";
            psDepartamento = conexion.prepareStatement(queryDepartamento);
            psDepartamento.setString(1, usuario.getDepartamento().getIdentificador());
            psDepartamento.setInt(2, usuario.getDepartamento().getIdDepartamento());
            psDepartamento.setString(3, usuario.getDepartamento().getNombre());

            psDepartamento.executeUpdate();

            //luego usuario para obtener la cedula
            // Inserción de datos en la tabla 'Usuario'
            String queryUsuario = "INSERT INTO `usuario` (cedula, nombre, apellido, direccion, telefono, correo, tipoUsuario, contrasena, idCiudad, fechaIngreso, fechaNacimiento) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            psUsuario = conexion.prepareStatement(queryUsuario); // Usamos la variable ya declarada
            psUsuario.setDouble(1, usuario.getCedula());
            psUsuario.setString(2, usuario.getNombre());
            psUsuario.setString(3, usuario.getApellido());
            psUsuario.setString(4, usuario.getDireccion());
            psUsuario.setString(5, usuario.getTelefono());
            psUsuario.setString(6, usuario.getCorreo());
            psUsuario.setInt(7, usuario.getTipoUsuario());
            psUsuario.setString(8, usuario.getContrasena());
            psUsuario.setInt(9, usuario.getCiudad().getIdCiudad());
            psUsuario.setDate(10, new java.sql.Date(usuario.getFechaIngreso().getTime()));
            psUsuario.setDate(11, new java.sql.Date(usuario.getFechaNacimiento().getTime()));

            // Ejecutar inserción del usuario
            psUsuario.executeUpdate();

            // Inserción de datos en la tabla 'Ciudad'
            String queryCiudad = "INSERT INTO `ciudad` (identificador, idciudad, nombre, iddepartamento, cedula) VALUES (?, ?, ?, ?, ?)";
            psCiudad = conexion.prepareStatement(queryCiudad);
            psCiudad.setString(1, usuario.getCiudad().getIdentificador());
            psCiudad.setInt(2, usuario.getCiudad().getIdCiudad());
            psCiudad.setString(3, usuario.getCiudad().getNombre());
            psCiudad.setInt(4, usuario.getCiudad().getIdDepartamento());
            psCiudad.setDouble(5, usuario.getCedula());

            // Ejecutar inserción de la ciudad
            psCiudad.executeUpdate();

            // Inserción de datos en la tabla 'Cuenta'
            String queryCuenta = "INSERT INTO `cuenta` (idcuenta, idtipo, tipoCuenta, saldo, fechaApertura, cedula) VALUES (?, ?, ?, ?, ?, ?)";
            psCuenta = conexion.prepareStatement(queryCuenta);
            psCuenta.setString(1, usuario.getCuenta().getIdCuenta());
            psCuenta.setInt(2, usuario.getCuenta().getIdTipo());
            psCuenta.setString(3, usuario.getCuenta().getTipoCuenta());
            psCuenta.setDouble(4, usuario.getCuenta().getSaldo());
            psCuenta.setDate(5, new java.sql.Date(usuario.getCuenta().getFechaApertura().getTime()));
            psCuenta.setDouble(6, usuario.getCedula());

            // Ejecutar inserción de la cuenta
            psCuenta.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");

        } catch (SQLException e) {
            System.out.println("!!!Error: " + e.getMessage());
        } finally {
            // Cerrar PreparedStatements y conexión en caso de error
            try {
                if (psCiudad != null) {
                    psCiudad.close();
                }
                if (psDepartamento != null) {
                    psDepartamento.close();
                }
                if (psCuenta != null) {
                    psCuenta.close();
                }
                if (psUsuario != null) {
                    psUsuario.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    //===============================================================================
    public void actualizarBD(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement psCiudad = null;
        PreparedStatement psDepartamento = null;
        PreparedStatement psCuenta = null;
        PreparedStatement psUsuario = null;

        try {
            // Conexión a la base de datos
            conexion = ConexionDB.conexionMysql();

            // Actualización de datos en la tabla 'Departamento'
            String queryDepartamento = "UPDATE `departamento` SET nombre = ?, identificador = ? WHERE iddepartamento = ?";
            psDepartamento = conexion.prepareStatement(queryDepartamento);
            psDepartamento.setString(1, usuario.getDepartamento().getNombre()); // Actualiza el nombre del departamento
            psDepartamento.setString(2, usuario.getDepartamento().getIdentificador()); // Actualiza el identificador del departamento
            psDepartamento.setInt(3, usuario.getDepartamento().getIdDepartamento()); // Identifica el departamento por su ID

            // Ejecutar actualización del departamento
            psDepartamento.executeUpdate();

            // Actualización de datos en la tabla 'Usuario'
            String queryUsuario = "UPDATE `usuario` SET nombre = ?, apellido = ?, direccion = ?, telefono = ?, correo = ?, tipoUsuario = ?, contrasena = ?, idCiudad = ?, fechaIngreso = ?, fechaNacimiento = ? WHERE cedula = ?";
            psUsuario = conexion.prepareStatement(queryUsuario);
            psUsuario.setString(1, usuario.getNombre()); // Actualiza el nombre del usuario
            psUsuario.setString(2, usuario.getApellido()); // Actualiza el apellido del usuario
            psUsuario.setString(3, usuario.getDireccion()); // Actualiza la dirección del usuario
            psUsuario.setString(4, usuario.getTelefono()); // Actualiza el teléfono
            psUsuario.setString(5, usuario.getCorreo()); // Actualiza el correo
            psUsuario.setInt(6, usuario.getTipoUsuario()); // Actualiza el tipo de usuario
            psUsuario.setString(7, usuario.getContrasena()); // Actualiza la contraseña
            psUsuario.setInt(8, usuario.getCiudad().getIdCiudad()); // Actualiza el idCiudad
            psUsuario.setDate(9, new java.sql.Date(usuario.getFechaIngreso().getTime())); // Actualiza la fecha de ingreso
            psUsuario.setDate(10, new java.sql.Date(usuario.getFechaNacimiento().getTime())); // Actualiza la fecha de nacimiento
            psUsuario.setDouble(11, usuario.getCedula()); // Identifica el usuario por su cédula

            // Ejecutar actualización del usuario
            psUsuario.executeUpdate();

            // Actualización de datos en la tabla 'Ciudad'
            String queryCiudad = "UPDATE `ciudad` SET nombre = ?, iddepartamento = ?, identificador = ? WHERE idciudad = ? AND cedula = ?";
            psCiudad = conexion.prepareStatement(queryCiudad);
            psCiudad.setString(1, usuario.getCiudad().getNombre()); // Actualiza el nombre de la ciudad
            psCiudad.setInt(2, usuario.getCiudad().getIdDepartamento()); // Actualiza el idDepartamento
            psCiudad.setString(3, usuario.getCiudad().getIdentificador()); // Actualiza el identificador de la ciudad
            psCiudad.setInt(4, usuario.getCiudad().getIdCiudad()); // Identifica la ciudad por su ID
            psCiudad.setDouble(5, usuario.getCedula()); // Identifica la ciudad por la cédula del usuario

            // Ejecutar actualización de la ciudad
            psCiudad.executeUpdate();

            // Actualización de datos en la tabla 'Cuenta'
            String queryCuenta = "UPDATE `cuenta` SET idtipo = ?, tipoCuenta = ?, saldo = ?, fechaApertura = ? WHERE idcuenta = ? AND cedula = ?";
            psCuenta = conexion.prepareStatement(queryCuenta);
            psCuenta.setInt(1, usuario.getCuenta().getIdTipo()); // Actualiza el tipo de cuenta
            psCuenta.setString(2, usuario.getCuenta().getTipoCuenta()); // Actualiza el tipo de cuenta
            psCuenta.setDouble(3, usuario.getCuenta().getSaldo()); // Actualiza el saldo
            psCuenta.setDate(4, new java.sql.Date(usuario.getCuenta().getFechaApertura().getTime())); // Actualiza la fecha de apertura
            psCuenta.setString(5, usuario.getCuenta().getIdCuenta()); // Identifica la cuenta por su ID
            psCuenta.setDouble(6, usuario.getCedula()); // Identifica la cuenta por la cédula del usuario

            // Ejecutar actualización de la cuenta
            psCuenta.executeUpdate();

            JOptionPane.showMessageDialog(null, "Datos actualizados correctamente.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Cerrar PreparedStatements y conexión
            try {
                if (psCiudad != null) {
                    psCiudad.close();
                }
                if (psDepartamento != null) {
                    psDepartamento.close();
                }
                if (psCuenta != null) {
                    psCuenta.close();
                }
                if (psUsuario != null) {
                    psUsuario.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
//===============================================================================    

    public void eliminarBD(double cedula) {
        Connection conexion = null;
        PreparedStatement psUsuario = null;

        try {
            // Conexión a la base de datos
            conexion = ConexionDB.conexionMysql();

            // Eliminar el usuario de la tabla 'Usuario'
            String queryEliminarUsuario = "DELETE FROM usuario WHERE cedula = ?";
            psUsuario = conexion.prepareStatement(queryEliminarUsuario);
            psUsuario.setDouble(1, cedula);
            psUsuario.executeUpdate();

            // MySQL se encargará de eliminar en cascada las referencias en las tablas 'cuenta' y 'ciudad'
            JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
        } finally {
            // Cerrar el PreparedStatement y la conexión
            try {
                if (psUsuario != null) {
                    psUsuario.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

//===============================================================================
    public void cargarDatosTablaBD(JTable miTabla) {
        // Define las columnas de la tabla
        String[] tituloColumnas = {"Cédula", "Nombre", "Apellido", "Saldo", "Teléfono", "Correo"};
        DefaultTableModel tabla = new DefaultTableModel(null, tituloColumnas);

        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Conexión a la base de datos
            conexion = ConexionDB.conexionMysql();

            // Consulta para obtener los datos de los usuarios y su saldo
            String query = "SELECT u.cedula, u.nombre, u.apellido, cu.saldo, u.telefono, u.correo "
                    + "FROM usuario u " //Lo de arriba que define u
                    + "JOIN cuenta cu ON u.cedula = cu.cedula";

            // Preparar y ejecutar la consulta
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            // Recorrer los resultados y agregar las filas al modelo de tabla
            while (rs.next()) {

                Object[] fila = new Object[6];  // Número de columnas en la tabla

                fila[0] = rs.getDouble("cedula");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("apellido");
                fila[3] = rs.getDouble("saldo");
                fila[4] = rs.getString("telefono");
                fila[5] = rs.getString("correo");

                // Añadir la fila al modelo de la tabla
                tabla.addRow(fila);
            }

            // Asignar el modelo a la JTable
            miTabla.setModel(tabla);

        } catch (SQLException e) {
            System.out.println("Error al cargar los datos en la tabla: " + e.getMessage());
        } finally {
            // Cerrar ResultSet, PreparedStatement y conexión
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    //===============================================================================
    //===============================================================================
    //===============================================================================
    //Fin de los CRUD
    //===============================================================================
    //===============================================================================
    //===============================================================================
    //Cuenta jframe
    public void agregarCuentaBD(Cuenta cuenta) {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            // Conexión a la base de datos
            conexion = ConexionDB.conexionMysql();

            // Consulta para insertar una nueva cuenta
            String query = "INSERT INTO cuenta (idcuenta, idtipo, tipoCuenta, saldo, fechaapertura, cedula) VALUES (?, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(query);

            // Asignar los valores a los placeholders (?) en la consulta
            ps.setString(1, cuenta.getIdCuenta()); // ID de la cuenta
            ps.setInt(2, cuenta.getIdTipo()); // Tipo de cuenta
            ps.setString(3, cuenta.getTipoCuenta()); // Nombre del tipo de cuenta
            ps.setDouble(4, cuenta.getSaldo()); // Saldo inicial
            ps.setDate(5, new java.sql.Date(cuenta.getFechaApertura().getTime())); // Fecha de apertura
            ps.setDouble(6, cuenta.getCedula()); // Cédula del usuario asociado

            // Ejecutar la inserción
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cuenta insertada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar la cuenta: " + e.getMessage());
        } finally {
            // Cerrar el PreparedStatement y la conexión
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void cargarDatosCuentaBD(JTable miTabla) {
        // Define las columnas de la tabla
        String[] tituloColumnas = {"Cédula", "Tipo de Cuenta", "Fecha de Apertura", "ID Cuenta"};
        DefaultTableModel tabla = new DefaultTableModel(null, tituloColumnas);

        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Conexión a la base de datos
            conexion = ConexionDB.conexionMysql();

            // Consulta para obtener los datos de las cuentas
            String query = "SELECT cu.cedula, cu.tipoCuenta, cu.fechaapertura, cu.idcuenta "
                    + "FROM cuenta cu";

            // Preparar y ejecutar la consulta
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            // Recorrer los resultados y agregar las filas al modelo de tabla
            while (rs.next()) {
                Object[] fila = new Object[4];  // Número de columnas en la tabla

                fila[0] = rs.getDouble("cedula");
                fila[1] = rs.getString("tipoCuenta");
                fila[2] = rs.getDate("fechaapertura");
                fila[3] = rs.getString("idcuenta");

                // Añadir la fila al modelo de la tabla
                tabla.addRow(fila);
            }

            // Asignar el modelo a la JTable
            miTabla.setModel(tabla);

        } catch (SQLException e) {
            System.out.println("Error al cargar los datos en la tabla: " + e.getMessage());
        } finally {
            // Cerrar ResultSet, PreparedStatement y conexión
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    //fin cuenta form  
    //===============================================================================
    //===============================================================================
    //===============================================================================
    public String buscarCedula(double cedula) {
        String mensaje = null; // Variable que utilizamos Panel Registro
        try {
            conexion = ConexionDB.conexionMysql();

            String buscar = "SELECT cedula FROM ahorramigo.usuario WHERE cedula=?";//Donde buscamos los datos
            sentenciaPreparada = conexion.prepareStatement(buscar);

            // Cambiar setString por setDouble ya que cedula es de tipo double
            sentenciaPreparada.setDouble(1, cedula);
            resultado = sentenciaPreparada.executeQuery();

            if (resultado.next()) {
                mensaje = "Existe cedula";
            } else {
                mensaje = "No existe cedula";
            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error:" + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mensaje; // Devolver el mensaje
    }

    public Usuario obtenerUsuarioBD(double cedula) {
        Usuario usuario = null; // Objeto para almacenar los datos del usuario
        try {
            conexion = ConexionDB.conexionMysql();

            // Consulta SQL para obtener cédula, contraseña y tipoUsuario de una sola vez
            String sql = "SELECT cedula, contrasena,nombre, tipoUsuario FROM ahorramigo.usuario WHERE cedula = ?";
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setDouble(1, cedula);

            resultado = sentenciaPreparada.executeQuery();

            if (resultado.next()) {
                // Si el usuario es encontrado, creamos un objeto Usuario con los datos
                usuario = new Usuario();
                usuario.setCedula(resultado.getDouble("cedula"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setContrasena(resultado.getString("contrasena"));
                usuario.setTipoUsuario(resultado.getInt("tipoUsuario"));

                // Le damos un valor a setNombre de nuestra clase sessiondata
                DatosDeSesion.setNombre(usuario.getNombre());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return usuario;
    }

    public String obtenerIdCuentaPorCedula(double cedula) {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String idCuenta = null;

        try {
            conexion = ConexionDB.conexionMysql();
            String query = "SELECT idcuenta FROM cuenta WHERE cedula = ?";
            ps = conexion.prepareStatement(query);
            ps.setDouble(1, cedula);
            rs = ps.executeQuery();

            if (rs.next()) {
                idCuenta = rs.getString("idcuenta");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return idCuenta;
    }

}
