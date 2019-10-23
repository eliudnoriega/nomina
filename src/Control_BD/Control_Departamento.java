package Control_BD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BD_Empleado.AgregarEmpleado;
import BD_Departamento.ModificarDepartamento;
import Control_BD.CerrarConexiones;
import Control_BD.ConexionConBaseDatos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC PERSONAL RICH
 */
public class Control_Departamento {

    //modelo para la tabla
    DefaultTableModel modelo;
    //vector con los titulos de cada columna
    String[] titulosColumnas = {"ID_DEPARTAMENTO", "COD_DEPARTAMENTO", "DEPARTAMENTO", "ID_EMPRESA"}; //"EMPRESA"};
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
    // Conectar Base de Datos
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();

    public void ModificarDepartamento(String ID_DEPARTAMENTO, String COD_DEPARTAMENTO,
            String DEPARTAMENTO) {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();

            // linea de codigo de mysql que actualiza regristos que va modificar
            int cantidad = comando.executeUpdate("update t_departamento set COD_DEPARTAMENTO ='" + COD_DEPARTAMENTO + "', "
                    + " DEPARTAMENTO ='" + DEPARTAMENTO + "' " + " where ID_DEPARTAMENTO ='" + ID_DEPARTAMENTO + "'");
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null, " Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null, "No existe departamento de un codigo " + ID_DEPARTAMENTO);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error -->" + ex);
        }
    }//cierra metodo modificarCliente

    public static void addDepartamento(Integer ID_DEPARTAMENTO, String COD_DEPARTAMENTO,
            String DEPARTAMENTO, Integer ID_EMPRESA) {

        Connection reg = ConexionConBaseDatos.getConexion();
        try {

            // Llamada al procedimiento almacenado
            CallableStatement cst = reg.prepareCall("{call insertar_departamento  (?,?,?)}");

            // enviar parametros
            cst.setString(1, COD_DEPARTAMENTO);
            cst.setString(2, DEPARTAMENTO);
            cst.setInt(3, ID_EMPRESA);

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

    public void CargarEmpleadoconsultaReporteDepartamento() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //le asigna el modelo al jtable
        ModificarDepartamento.jTableListarDepartamento.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaDepartamento();

        /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
    }

    public void CargarDepartamentoEmpleado() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //le asigna el modelo al jtable
//        AgregarEmpleado.SeleccionarDepartamento.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaDepartamento();

        /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
    }
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

    public void ejecutarConsultaTodaTablaDepartamento() {

        conexion = ConexionConBaseDatos.getConexion();
        ResultSet rs;
        try {
            // creamos la Conexion

            conexion.setAutoCommit(false);

            /*instanciamos el objeto callable donde mandamos a pedir la cantidad
                                 *  parametros en este caso MostrarCampo no tiene
                                 *  y se coloca como se muestra*/
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call lista_departamento()}");
            rs = prcProcedimientoAlmacenado.executeQuery();

            while (rs.next()) {
                String ID_DEPARTAMENTO = rs.getString("ID_DEPARTAMENTO");
                String COD_DEPARTAMENTO = rs.getString("COD_DEPARTAMENTO");
                String DEPARTAMENTO = rs.getString("DEPARTAMENTO");
                String ID_EMPRESA = rs.getString("ID_EMPRESA");
                String EMPRESA = rs.getString("EMPRESA");

                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {ID_DEPARTAMENTO, COD_DEPARTAMENTO, DEPARTAMENTO, ID_EMPRESA,EMPRESA};

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

    public void buscarDepartamentoParaAgregarEmpleado(String parametroBusqueda) {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ;
        //le asigna el modelo al jtable
//        AgregarEmpleado.SeleccionarDepartamento.setModel(modelo);
        //ejecuta una consulta a la BD
        parametroBusqueda = "%" + parametroBusqueda + "%";
        buscarRegistroDepartamento(parametroBusqueda);

    }

    public void buscarRegistroDepartamento(String parametroBusqueda) {

        conexion = ConexionConBaseDatos.getConexion();
        ResultSet rs;
        try {

            conexion.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call departamento_buscar (?)}");
            prcProcedimientoAlmacenado.setString(1, parametroBusqueda);

            rs = prcProcedimientoAlmacenado.executeQuery();
            while (rs.next()) {
                String ID_DEPARTAMENTO = rs.getString("ID_DEPARTAMENTO");
                String COD_DEPARTAMENTO = rs.getString("COD_DEPARTAMENTO");
                String DEPARTAMENTO = rs.getString("DEPARTAMENTO");
                String ID_EMPRESA = rs.getString("ID_EMPRESA");
                String EMPRESA = rs.getString("EMPRESA");
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {ID_DEPARTAMENTO, COD_DEPARTAMENTO, DEPARTAMENTO, ID_EMPRESA,EMPRESA};

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

    public void buscarEmpleadoParaConsultaDepartamento(String parametroBusqueda) {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ;
        //le asigna el modelo al jtable
        ModificarDepartamento.jTableListarDepartamento.setModel(modelo);
        //ejecuta una consulta a la BD
        parametroBusqueda = "%" + parametroBusqueda + "%";
        buscarRegistroDepartamento(parametroBusqueda);

    }

    public void CargarGETDepartamento() {

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
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call lista_departamento()}");
            rs = prcProcedimientoAlmacenado.executeQuery();
            int departamento = 0;

            while (rs.next()) {
                departamento = rs.getInt("ID_DEPARTAMENTO");

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
