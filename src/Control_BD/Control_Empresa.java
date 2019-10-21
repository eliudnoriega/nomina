/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_BD;

import Empresa.ModificarEmpresa;
import BD_Establecimiento.ModificarEstablecimiento;
import BD_HAB_DES.Agregar_hab_des;
import BD_Reportes.ConsultarReporte;
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
 * @author el
 */
public class Control_Empresa {

    DefaultTableModel modelo;
    //vector con los titulos de cada columna
    String[] titulosColumnas = {"id","nombre"};
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
    // Conectar Base de Datos
    ConexionConBaseDatos conectar;

    public Control_Empresa() {
        conectar = new ConexionConBaseDatos();
    }

    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    private PreparedStatement ps;

    public void ModificarEmpresa(Integer codigo, String nombre) {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();

            // linea de codigo de mysql que actualiza regristos que va modificar
            int cantidad = comando.executeUpdate("update `empresa` set "
                    + " nombre ='" + nombre + "' where id='" + codigo + "'");
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null, " Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null, "No existe empresa de un codigo " + codigo);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error -->" + ex);
        }
    }//cierra metodo modificarCliente

    public void addEmpresa(String nombre) {

        try {
            conexion = ConexionConBaseDatos.getConexion();
            String query = "insert into `empresa`(`nombre`) values(?)";
            ps = conexion.prepareStatement(query);
            ps.setString(1, nombre);

            // linea de codigo de mysql que actualiza regristos que va modificar
            ps.execute();
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error -->" + ex);
        }
    }

    ///////////
    public void CargarDocenteReporte() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //le asigna el modelo al jtable

        ConsultarReporte.jTableListar.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaEmpresa();

        /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
    }

    public void CargarDocenteConsultaEmpresa() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //le asigna el modelo al jtable

        ModificarEmpresa.jTableListarEmpresa.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaEmpresa();

        /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
    }

    public void CargarDocente_hab_des() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //le asigna el modelo al jtable

        Agregar_hab_des.jTableListarDocente.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaEmpresa();

        /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
    }

    public void CargarDocenteconsultaReportedocente() {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //le asigna el modelo al jtable

        ModificarEstablecimiento.jTableListarEstablecimiento.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaEmpresa();

        /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
    }

    public void ejecutarConsultaTodaTablaEmpresa() {

        conexion = ConexionConBaseDatos.getConexion();
        try {
            // creamos la Conexion
            sentencia = conexion.createStatement();
            /*instanciamos el objeto callable donde mandamos a pedir la cantidad
                                 *  parametros en este caso MostrarCampo no tiene
                                 *  y se coloca como se muestra*/
            ResultSet rs = sentencia.executeQuery("select * from `empresa`");

            while (rs.next()) {

                String CODIGO = rs.getString("id");
                String NOMBRE = rs.getString("nombre");

//                BD_Planilla.AgregarPlanilla.ultimo_numero_id_planilla=
//                BD_Planilla.AgregarPlanilla.ultimo_numero_id_planilla;
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = {CODIGO, NOMBRE};

                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);

            }

    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }

    }//cierra metodo ejecutarConsulta

    /////////
    public void buscarDocenteParaAgregarReporte(String parametroBusqueda) {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ;
        //le asigna el modelo al jtable
        ConsultarReporte.jTableListar.setModel(modelo);
        //ejecuta una consulta a la BD
        parametroBusqueda = "%" + parametroBusqueda + "%";
        buscarRegistroPlanilla(parametroBusqueda);

    }

    public void buscarDocentePordni(String parametroBusqueda) {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ;
        //le asigna el modelo al jtable
        ConsultarReporte.jtablahaber.setModel(modelo);
        //ejecuta una consulta a la BD

        buscarRegistroPlanillapordni(parametroBusqueda);

    }

    public void buscarDocenteParaConsultadocente(String parametroBusqueda) {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ;
        //le asigna el modelo al jtable
        ModificarEmpresa.jTableListarEmpresa.setModel(modelo);
        //ejecuta una consulta a la BD
        parametroBusqueda = "%" + parametroBusqueda + "%";
        buscarRegistroPlanilla(parametroBusqueda);

    }

    public void buscarDocenteParahab_des(String parametroBusqueda) {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ;
        //le asigna el modelo al jtable
        Agregar_hab_des.jTableListarDocente.setModel(modelo);
        //ejecuta una consulta a la BD
        parametroBusqueda = "%" + parametroBusqueda + "%";
        buscarRegistroPlanilla(parametroBusqueda);

    }

    public void buscarDocenteParaConsultareporte(String parametroBusqueda) {

        modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ;
        //le asigna el modelo al jtable
        ConsultarReporte.jTableListar.setModel(modelo);
        //ejecuta una consulta a la BD
        parametroBusqueda = "%" + parametroBusqueda + "%";
        buscarRegistroPlanilla(parametroBusqueda);

    }

    public void buscarRegistroPlanillapordni(String parametroBusqueda) {
        conexion = ConexionConBaseDatos.getConexion();
        ResultSet rs;
        try {
            conexion.setAutoCommit(false); // Llamada al procedimiento almacenado
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call docente_buscar_dni  (?)}");
            prcProcedimientoAlmacenado.setString(1, parametroBusqueda);// Parametro 1 del procedimiento almacenado
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            rs = prcProcedimientoAlmacenado.executeQuery();
            while (rs.next()) {
                String DNI_DOCENTE = rs.getString("DNI_DOC");
                String ID_ESTABLECIMIENTO = rs.getString("ID_ESTAB");
                String COD_MOD = rs.getString("COD_MOD");
                String TIPO = rs.getString("TIPO");
                String CUENTA_BANCARIA = rs.getString("CUENTA_BANCARIA");
                String NOMBRE = rs.getString("NOMBRE");
                String AP_PATERNO = rs.getString("AP_PATERNO");
                String AP_MATERNO = rs.getString("AP_MATERNO");
                Object[] info = {DNI_DOCENTE, ID_ESTABLECIMIENTO, COD_MOD, TIPO, CUENTA_BANCARIA, NOMBRE, AP_PATERNO, AP_MATERNO};
                modelo.addRow(info);  //al modelo de la tabla le agrega una fila
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

    public void buscarRegistroPlanilla(String parametroBusqueda) {

        conexion = ConexionConBaseDatos.getConexion();
        ResultSet rs;
        try {
            // Conecta con la base de datos XE con el usuario system y la contraseña password

            // Llamada al procedimiento almacenado
            conexion.setAutoCommit(false);
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call docente_buscar  (?)}");
            // Parametro 1 del procedimiento almacenado
            prcProcedimientoAlmacenado.setString(1, parametroBusqueda);

            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            rs = prcProcedimientoAlmacenado.executeQuery();

            while (rs.next()) {
                String DNI_DOCENTE = rs.getString("DNI_DOC");
                String ID_ESTABLECIMIENTO = rs.getString("ID_ESTAB");
                String COD_MOD = rs.getString("COD_MOD");
                String TIPO = rs.getString("TIPO");
                String CUENTA_BANCARIA = rs.getString("CUENTA_BANCARIA");
                String NOMBRE = rs.getString("NOMBRE");
                String AP_PATERNO = rs.getString("AP_PATERNO");
                String AP_MATERNO = rs.getString("AP_MATERNO");

                Object[] info = {DNI_DOCENTE, ID_ESTABLECIMIENTO, COD_MOD, TIPO, CUENTA_BANCARIA, NOMBRE, AP_PATERNO, AP_MATERNO};

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

}
