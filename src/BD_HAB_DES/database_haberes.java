package BD_HAB_DES;
import Control_BD.ConexionConBaseDatos;
import Haberes.*;
import java.sql.*;
/**
*  @web http://blog.jheysonmatta.com.pe/
 * @author Jheyson Matta
 */
public class database_haberes {
 /* DATOS PARA LA CONEXION */
  private String bd = "nomina";//BASE DE DATOS
  private String login = "root"; //USUARIO
  private String password = "Wallpaper1@@@"; //CONTRASEÑA
  private String url = "jdbc:mysql://localhost/"+bd;
  private Connection conn = null;
  String dni,fecha;

  /* Constructor de clase: Se conecta a la base de datos
  */
  public void EnviarDatos(String dni,String fecha){
      this.dni=dni;
        this.fecha=fecha;
  }
   public database_haberes(){
      try{
         conn = ConexionConBaseDatos.getConexion();
        Statement comando = conn.createStatement();
         if (conn!=null){
            System.out.println("OK base de datos "+bd+" listo");
         }
      }catch(SQLException e){
         System.out.println(e);
      }
    }

    public Connection getConnection()
    {
        return this.conn;
    }
/* Realiza una consulta a la base de datos, retorna un Object[][] con los
 * datos de la tabla persona
 */
    public Object[][] Select_Persona()
    {
        //44231255
     int registros = 0;   
     //SELECT t_haberes.ID_HAB,t_haberes.NOMBRE_HAB,t_doc_hab.MONTO_HAB,t_docente.NOMBRE , t_docente.AP_PATERNO,t_docente.AP_MATERNO FROM t_haberes INNER JOIN t_doc_hab ON t_haberes.ID_HAB = t_doc_hab.ID_HAB INNER JOIN t_docente ON t_doc_hab.DNI_DOC=t_docente.DNI_DOC
        String consulta = "SELECT t_doc_hab.ID_EMP_HAB,t_emp_hab.DNI_emp,t_haberes.ID_HABER,t_haberes.NOMBRE_HABER,t_doc_hab.MONTO_HAB,t_empleado.NOMBRE FROM t_haberes INNER JOIN t_emp_hab ON t_haberes.ID_HABER = t_emp_hab.ID_HAB INNER JOIN t_empleado ON t_emp_hab.DNI_EMP=t_empleado.DNI_EMP "
                + "WHERE t_docente.DNI_emp='"+dni+"' and FECHA='"+fecha+"'" ;
        
   //   String consulta = "Select p_id,p_nombre,p_apellido,p_edad FROM persona ";
      String consulta2 = "Select count(*) as total from t_haberes ";
      //obtenemos la cantidad de registros existentes en la tabla
      try{
         PreparedStatement pstm = conn.prepareStatement( consulta2 );
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
    //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][6];
    //realizamos la consulta sql y llenamos los datos en la matriz "Object"
      try{
         PreparedStatement pstm = conn.prepareStatement(consulta);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){          
             data[i][0] = res.getString( "ID_DOC_HAB" );
             data[i][1] = res.getString( "DNI_DOC" );
            data[i][2] = res.getString( "ID_HAB" );
            data[i][3] = res.getString( "NOMBRE_HAB" );
            data[i][4] = res.getString( "MONTO_HAB" );
            data[i][5] = res.getString( "NOMBRE" );
            i++;
         }
         res.close();
          }catch(SQLException e){
               System.out.println(e);
        }
    return data;
    }

/* Ejecuta la actualizacion de la tabla persona dado los valores de actualizacion
 * y el ID del registro a afectar
 */
    public boolean update(String valores, String ID_DOC_HAB,String DNI_DOC)
    {
        boolean res = false;        
        String q = " UPDATE t_doc_hab SET " + valores + " WHERE ID_DOC_HAB= " + ID_DOC_HAB +" and DNI_DOC= "+DNI_DOC;
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res=true;
         }catch(SQLException e){            
            System.out.println(e);
        }
        return res;
    }

}
