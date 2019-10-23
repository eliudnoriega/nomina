/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control_BD;

import BD_Empleado.ModificarEmpleado;
import BD_Departamento.ModificarDepartamento;
import BD_HAB_DES.Agregar_hab_des;

import BD_Reportes.ConsultarReporte;
import static BD_Reportes.ConsultarReporte.jtablahaber;
import static BD_Reportes.ConsultarReporte.jTableListar;
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
public class Control_Empleado {
    
    
        DefaultTableModel modelo;
    //vector con los titulos de cada columna
    String[] titulosColumnas = { "DNI_EMP", "ID_DEPARTAMENTO", "SALARIO","PUESTO","CUENTA_BANCARIA","NOMBRE","PRIMER_APE","SEGUNDO_APE"};
    //matriz donde se almacena los datos de cada celda de la tabla
    String info[][] = {};
    // Conectar Base de Datos
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();
    
    
        public void ModificarEmpleado(String DNI_EMP,
                String ID_DEPARTAMENTO,String SALARIO,String PUESTO,
                String CUENTA_BANCARIA,String NOMBRE,String PRIMER_APE,String SEGUNDO_APE) {

    
        try {
             conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            
            // linea de codigo de mysql que actualiza regristos que va modificar
            int cantidad = comando.executeUpdate("update t_empleado set "
                + " SALARIO ='" + SALARIO + "' "+ ", PUESTO ='" + PUESTO + "'"+ ", CUENTA_BANCARIA ='" + CUENTA_BANCARIA + "'"+ " , NOMBRE ='" + NOMBRE + "' , PRIMER_APE ='" + PRIMER_APE + "' , SEGUNDO_APE ='" + SEGUNDO_APE + "'  where DNI_EMP='" + DNI_EMP+"'");
            if (cantidad == 1) {
                JOptionPane.showMessageDialog(null," Modifico con Exito");
            } else {
                JOptionPane.showMessageDialog(null,"No existe empleado de un codigo "+DNI_EMP);
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Error -->"+ex);
        }
    }//cierra metodo modificarCliente

     public static void  addEmpleado(String DNI_EMP,
                String ID_DEPARTAMENTO,String SALARIO,String PUESTO,
                String CUENTA_BANCARIA,String NOMBRE,String PRIMER_APE,String SEGUNDO_APE) {

         Connection reg = ConexionConBaseDatos.getConexion();//conecccion a la base de datos
   try {
            // Llamada al procedimiento almacenado
            CallableStatement cst = reg.prepareCall("{call insertar_empleado(?,?,?,?,?,?,?,?)}");

                // definimos los parametros de entrada
            
            cst.setString(1,DNI_EMP);
            cst.setString(2,ID_DEPARTAMENTO);
            cst.setString(3, SALARIO);
            cst.setString(4, PUESTO);
            cst.setString(5,CUENTA_BANCARIA);
            cst.setString(6,NOMBRE);
            cst.setString(7, PRIMER_APE);
            cst.setString(8, SEGUNDO_APE);
               
                   System.out.println("ejecutada: "+ID_DEPARTAMENTO);
                // Ejecuta el procedimiento almacenado
                cst.execute();
                
                // Se obtienen la salida del procedimineto almacenado


   }
          catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                reg.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
     
     

         ///////////
               public void CargarEmpleadoReporte(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
       
                   ConsultarReporte.jTableListar.setModel(modelo);


        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaEmpleado();
        
                               /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
     }
            public void CargarEmpleadoconsultaempleado(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
       
                ModificarEmpleado.jTableListarDocente.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaEmpleado();
        
                               /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
     }
                   public void CargarEmpleado_hab_des(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
       
                       Agregar_hab_des.jTableListarDocente.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaEmpleado();
        
                               /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
     }     
            
            
            
                       public void CargarEmpleadoconsultaReporteempleado(){
         
         modelo = new DefaultTableModel(info, titulosColumnas) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
      //le asigna el modelo al jtable
       
                           ModificarDepartamento.jTableListarDepartamento.setModel(modelo);

        //ejecuta una consulta a la BD
        ejecutarConsultaTodaTablaEmpleado();
        
                               /*              int[] anchos = {35, 300, 40, 200, 40};
        for (int i = 0; i < Ventas.SeleccionarProductos.getColumnCount(); i++) {
            Ventas.SeleccionarProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);}
         */
     }
            
             Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null;
    PreparedStatement ps = null;

                     public void ejecutarConsultaTodaTablaEmpleado() {
                         
                             conexion = ConexionConBaseDatos.getConexion();
                   ResultSet rs;
                        try{
                                // creamos la Conexion
                           
                                 conexion.setAutoCommit(false);
                                
                             
                                
                                /*instanciamos el objeto callable donde mandamos a pedir la cantidad
                                 *  parametros en este caso MostrarCampo no tiene
                                 *  y se coloca como se muestra*/
                                CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call lista_empleado()}");
                              rs=prcProcedimientoAlmacenado.executeQuery();
                              
                              
                           while(rs.next()){
/**
 * (`DNI_EMP`, `ID_DEPARTAMENTO`, `SALARIO`, `PUESTO`, `CUENTA_BANCARIA`, `NOMBRE`, `PRIMER_APE`, `SEGUNDO_APE`
 */                     
                String DNI_EMP = rs.getString("DNI_EMP");
                String ID_DEPARTAMENTO = rs.getString("ID_DEPARTAMENTO");
                String SALARIO = rs.getString("SALARIO");
                 String PUESTO = rs.getString("PUESTO");
                String CUENTA_BANCARIA = rs.getString("CUENTA_BANCARIA");
                String NOMBRE = rs.getString("NOMBRE");
                String PRIMER_APE = rs.getString("PRIMER_APE");
                String SEGUNDO_APE = rs.getString("SEGUNDO_APE");
//                BD_Planilla.AgregarPlanilla.ultimo_numero_id_planilla=
//                BD_Planilla.AgregarPlanilla.ultimo_numero_id_planilla;
                //crea un vector donde los está la informacion (se crea una fila)
                Object[] info = { DNI_EMP, ID_DEPARTAMENTO,SALARIO,PUESTO, CUENTA_BANCARIA, NOMBRE,PRIMER_APE,SEGUNDO_APE};

                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);
                                  
                           }
                                  
                                conexion.commit();
                                
                             
                                
                        }
                         
                         
                         catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error SQL:\n" + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            conexion = null;
        } finally {
            CerrarConexiones.metodoCerrarConexiones(conexion, sentencia, resultado, ps);
        }
                         
                         
                         
                         


    }//cierra metodo ejecutarConsulta
                     
    
    
    /////////
    public void buscarEmpleadoParaAgregarReporte(String parametroBusqueda) {

        

            modelo = new DefaultTableModel(info, titulosColumnas) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            ;
            //le asigna el modelo al jtable
            ConsultarReporte.jTableListar.setModel(modelo);
            //ejecuta una consulta a la BD
                       parametroBusqueda="%"+parametroBusqueda+"%";
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
            ModificarEmpleado.jTableListarDocente.setModel(modelo);
            //ejecuta una consulta a la BD
                       parametroBusqueda="%"+parametroBusqueda+"%";
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
                       parametroBusqueda="%"+parametroBusqueda+"%";
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
                       parametroBusqueda="%"+parametroBusqueda+"%";
            buscarRegistroPlanilla(parametroBusqueda);

    }

      
          public void buscarRegistroPlanillapordni(String parametroBusqueda) {
              
           conexion = ConexionConBaseDatos.getConexion();ResultSet rs; 
   try {   conexion.setAutoCommit(false); // Llamada al procedimiento almacenado
        CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call empleado_buscar_dni  (?)}");
        prcProcedimientoAlmacenado.setString(1, parametroBusqueda);// Parametro 1 del procedimiento almacenado
                // Definimos los tipos de los parametros de salida del procedimiento almacenado
                rs=prcProcedimientoAlmacenado.executeQuery();
                
               
                
                while(rs.next()){
                String DNI_EMP = rs.getString("DNI_EMP");
                String ID_DEPARTAMENTO = rs.getString("ID_DEPARTAMENTO");
                String SALARIO = rs.getString("SALARIO");
                 String PUESTO = rs.getString("PUESTO");
                String CUENTA_BANCARIA = rs.getString("CUENTA_BANCARIA");
                String NOMBRE = rs.getString("NOMBRE");
                String PRIMER_APE = rs.getString("PRIMER_APE");
                String SEGUNDO_APE = rs.getString("SEGUNDO_APE");
                Object[] info = { DNI_EMP, ID_DEPARTAMENTO,SALARIO,PUESTO, CUENTA_BANCARIA, NOMBRE,PRIMER_APE,SEGUNDO_APE};
                modelo.addRow(info);  //al modelo de la tabla le agrega una fila
                           }conexion.commit();
                        }
          catch (SQLException ex) {
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
            CallableStatement prcProcedimientoAlmacenado = conexion.prepareCall("{call empleado_buscar  (?)}");
                // Parametro 1 del procedimiento almacenado
            prcProcedimientoAlmacenado.setString(1, parametroBusqueda);
             
                // Definimos los tipos de los parametros de salida del procedimiento almacenado
                              rs=prcProcedimientoAlmacenado.executeQuery();
                              
/**
  * (`DNI_EMP`, `ID_DEPARTAMENTO`, `SALARIO`, `PUESTO`, `CUENTA_BANCARIA`, `NOMBRE`, `PRIMER_APE`, `SEGUNDO_APE`
  */                             
                           while(rs.next()){
                String DNI_EMP = rs.getString("DNI_EMP");
                String ID_DEPARTAMENTO = rs.getString("ID_DEPARTAMENTO");
                String SALARIO = rs.getString("SALARIO");
                 String PUESTO = rs.getString("PUESTO");
                String CUENTA_BANCARIA = rs.getString("CUENTA_BANCARIA");
                String NOMBRE = rs.getString("NOMBRE");
                String PRIMER_APE = rs.getString("PRIMER_APE");
                String SEGUNDO_APE = rs.getString("SEGUNDO_APE");
                
                Object[] info = { DNI_EMP, ID_DEPARTAMENTO,SALARIO,PUESTO, CUENTA_BANCARIA, NOMBRE,PRIMER_APE,SEGUNDO_APE};

                //al modelo de la tabla le agrega una fila
                //con los datos que están en info
                modelo.addRow(info);
                                  
                           }
                                  
                                conexion.commit();
                                
                             
                                
                        }
                         
         

   
          catch (SQLException ex) {
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