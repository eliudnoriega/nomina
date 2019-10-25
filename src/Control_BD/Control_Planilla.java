/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_BD;

import BD_Planilla.ModificarPlanilla;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author el
 */
public class Control_Planilla {
    //modelo para la tabla
    DefaultTableModel modelo;
    //vector con los titulos de cada columna
    String[] titulosColumnas = {"ID_PLANILLA", "COD_PLANILLA", "FECHA_INIIO", "FECHA_FIN"};
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
    // Conectar Base de Datos
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();

    public void ModificarPlanilla(String ID_PLANILLA, String COD_PLANILLA,
            String FECHA_INICIO, String FECHA_FIN) {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();

            // linea de codigo de mysql que actualiza regristos que va modificar
            int cantidad = comando.executeUpdate("update t_planilla set COD_PLANILLA ='" + COD_PLANILLA + "', "
                    + " FECHA_INICIO ='" + FECHA_INICIO + "', FECHA_FIN ='" + FECHA_FIN + "' " + " where ID_PLANILLA ='" + ID_PLANILLA + "'");
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null, " Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null, "No existe departamento de un codigo " + ID_PLANILLA);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error -->" + ex);
        }
    }//cierra metodo modificarCliente

    public static void addPlanilla(
            String COD_PLANILLA, String FECHA_INICIO, String FECHA_FIN) throws ParseException {

        Connection reg = ConexionConBaseDatos.getConexion();
        try {

            // Llamada al procedimiento almacenado
            CallableStatement cst = reg.prepareCall("{call insertar_planilla  (?,?,?)}");

            // enviar parametros
            cst.setString(1, COD_PLANILLA);
            cst.setDate(2, java.sql.Date.valueOf(FECHA_INICIO));
            cst.setDate(3, java.sql.Date.valueOf(FECHA_FIN));

            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            System.out.println("ejecutada");
            // Ejecuta el procedimiento almacenado
            cst.execute();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                reg.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public void CargarDocenteconsultaReportePlanilla() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //le asigna el modelo al jtable
        ModificarPlanilla.jTableListarDepartamento.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaPlanilla();

        /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
    }

    public void CargarPlanillaDocente() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //le asigna el modelo al jtable
//        AgregarDocente.SeleccionarDepartamento.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaPlanilla();

        /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
    }
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

    public void ejecutarConsultaTodaTablaPlanilla() {

        conexion = ConexionConBaseDatos.getConexion();
        ResultSet rs;
        try {
            // creamos la Conexion

            conexion.setAutoCommit(false);

            /*instanciamos el objeto callable donde mandamos a pedir la cantidad
                                 *  parametros en este caso MostrarCampo no tiene
                                 *  y se coloca como se muestra*/
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call lista_planilla()}");
            rs = prcProcedimientoAlmacenado.executeQuery();

            while (rs.next()) {
                String ID_PLANILLA = rs.getString("ID_PLANILLA");
                String COD_PLANILLA = rs.getString("COD_PLANILLA");
                String FECHA_INICIO = rs.getString("FECHA_INICIO");
                String FECHA_FIN = rs.getString("FECHA_FIN");

                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {ID_PLANILLA, COD_PLANILLA, FECHA_INICIO, FECHA_FIN};

                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }

            conexion.commit();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }

    }//cierra metodo ejecutarConsulta
    //           Control_Establecimiento cc = new Control_Establecimiento();

    public void buscarPlanillaParaAgregarDocente(String parametroBusqueda) {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ;
        //le asigna el modelo al jtable
//        AgregarDocente.SeleccionarDepartamento.setModel(modelo);
        //ejecuta una consulta a la BD
        parametroBusqueda = "%" + parametroBusqueda + "%";
        buscarRegistroPlanilla(parametroBusqueda);

    }

    public void buscarRegistroPlanilla(String parametroBusqueda) {

        conexion = ConexionConBaseDatos.getConexion();
        ResultSet rs;
        try {

            conexion.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call planilla_buscar  (?)}");
            prcProcedimientoAlmacenado.setString(1, parametroBusqueda);

            rs = prcProcedimientoAlmacenado.executeQuery();
            while (rs.next()) {
                String ID_PLANILLA = rs.getString("ID_PLANILLA");
                String COD_PLANILLA = rs.getString("COD_PLANILLA");
                String FECHA_INICIO = rs.getString("FECHA_INICIO");
                String FECHA_FIN = rs.getString("FECHA_FIN");
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {ID_PLANILLA, COD_PLANILLA, FECHA_INICIO, FECHA_FIN};

                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }

            conexion.commit();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public void buscarDocenteParaConsultaPlanilla(String parametroBusqueda) {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ;
        //le asigna el modelo al jtable
        ModificarPlanilla.jTableListarDepartamento.setModel(modelo);
        //ejecuta una consulta a la BD
        parametroBusqueda = "%" + parametroBusqueda + "%";
        buscarRegistroPlanilla(parametroBusqueda);

    }

    public void CargarGETPlanilla() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //ejecuta una consulta a la BD
        ejecutarGETDepartamento();

    }

    public void ejecutarGETDepartamento() {

        conexion = ConexionConBaseDatos.getConexion();
        ResultSet rs;
        try {
            // creamos la Conexion

            conexion.setAutoCommit(false);

            /*instanciamos el objeto callable donde mandamos a pedir la cantidad
                                 *  parametros en este caso MostrarCampo no tiene
                                 *  y se coloca como se muestra*/
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call lista_planilla()}");
            rs = prcProcedimientoAlmacenado.executeQuery();
            int departamento = 0;

            while (rs.next()) {
                departamento = rs.getInt("ID_PLANILLA");

            }

            BD_Departamento.AgregarDepartamento.ultim0_departamento = departamento;

            conexion.commit();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }

    }//cierra metodo ejecutarConsulta

    
}
