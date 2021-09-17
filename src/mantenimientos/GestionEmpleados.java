package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.EmpleadoInterface;
import model.Cargo;
import model.Distrito;
import model.Empleado;
import utils.MySQLConexion8;

public class GestionEmpleados implements EmpleadoInterface {

	@Override
	public int registrar(Empleado emp) {
		int rs = 0;
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "insert into TB_EMPLEADO values (?,default,default,?,?,?,?,?,?,?);";
		   		   
		   pst = con.prepareStatement(sql);
		   
		   pst.setString(1, emp.getCod_emple());
		   pst.setString(2, emp.getNom_emple());
		   pst.setString(3, emp.getApell_emple());
		   pst.setString(4, emp.getFnacim());
		   pst.setString(5, emp.getCorreo_emple());
		   pst.setString(6, emp.getTelef_emple());
		   pst.setString(7, emp.getCod_dist());
		   pst.setString(8, emp.getCod_cargo());
		   		   
		   rs = pst.executeUpdate(); 

		} catch (Exception e) {
		   System.out.println("Error en registrar " + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar : " + e.getMessage());
		}
		}

		return rs; 
	}

	@Override
	public int eliminar(String cod_emple) {
		int rs = 0; //valor en caso de error
		//Plantilla
		Connection con = null; // obtener la conexion con la BD
		PreparedStatement pst = null; // sirve para las sentencias
		try {
			//1. obtener conexion
			con = MySQLConexion8.getConexion();
			//2. crear cadena con la sentencia a ejecutar
			String sql = "delete from TB_EMPLEADO where cod_emple=?";
			//3. preparamos la cadena
			pst = con.prepareStatement(sql);
			//si la cadena tiene ? hay que setear!!!!
			pst.setString(1, cod_emple);
			// 4.ejecutamos la sentencia y guardamos resultado
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en eliminar : "+e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : "+e.getMessage());
			}
		}
		return rs;
	}

	@Override
	public int actualizar(Empleado emp) {
		int rs = 0;
		// Plantilla
		Connection con = null; // obtener la conexion con la BD
		PreparedStatement pst = null; // sirve para las sentencias
		try {
			//1. obtener conexion
			con = MySQLConexion8.getConexion();
			//2. crear cadena con la sentencia a ejecutar
			String sql = "update TB_EMPLEADO set  nom_emple=?, apell_emple=?,fnacim=?,correo_emple=? ,telef_emple=?,cod_dist=?, cod_cargo=? where cod_emple=?";
			//3. preparamos la cadena
			pst = con.prepareStatement(sql);
			// hay que setear si hay "?"
			pst.setString(1, emp.getNom_emple());
			pst.setString(2, emp.getApell_emple());
			pst.setString(3, emp.getFnacim());
			pst.setString(4, emp.getCorreo_emple());
			pst.setString(5, emp.getTelef_emple());
			pst.setString(6, emp.getCod_dist());
			pst.setString(7, emp.getCod_cargo());
			pst.setString(8,  emp.getCod_emple());
			
			// 4.ejecutamos la sentencia y guardamos resultado
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en actualizar : "+e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : "+e.getMessage());
			}
		}
		return rs;
	}

	@Override
	public Empleado buscar(int codigo) {
		Empleado emp = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;  // guarda el resultado de la consulta
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "select * from TB_EMPLEADO where cod_emple = ?";
		   		   
		   pst = con.prepareStatement(sql);
		   // se setea, si hay ? en la cadena   
		   pst.setInt(1, codigo);
		   rs = pst.executeQuery(); //Ejecuta la sentencia y guarda el resultado 
		   
		   //pasar el objeto rs, al obj que se devuelve: lista
		   if (rs.next()) {//Mientras rs, tiene informacion, lee cada fila
			   // Crea un obj u, que contendrá la fila o registro
			   
		   }
		} catch (Exception e) {
		   System.out.println("Error en busqueda : " + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar : " + e.getMessage());
		}
		}
		return emp;
	}

	@Override
	public ArrayList<Empleado> listado() {
		ArrayList<Empleado> lista = null;
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;  // guarda el resultado de la consulta
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "select * from TB_EMPLEADO";
		   		   
		   pst = con.prepareStatement(sql);
		   // se setea, si hay ? en la cadena   
		   rs = pst.executeQuery(); //Ejecuta la sentencia y guarda el resultado 
		   
		   //pasar el objeto rs, al obj que se devuelve: lista
		   lista = new ArrayList<Empleado>();
		   while (rs.next()) {//Mientras rs, tiene informacion, lee cada fila
			   // Crea un obj u, que contendrá la fila o registro
			   Empleado e=new Empleado(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
			   lista.add(e);
			  
		   }
		} catch (Exception e) {
		   System.out.println("Error en listado : " + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar : " + e.getMessage());
		}
		}
		return lista;
	}

	@Override
	public ArrayList<Distrito> listadoDistrito() {
		ArrayList<Distrito> lista = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;  // guarda el resultado de la consulta
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "select * from TB_DISTRITO";
		   		   
		   pst = con.prepareStatement(sql);
		     
		   rs = pst.executeQuery(); //Ejecuta la sentencia y guarda el resultado 
		   
		   //pasar el objeto rs, al obj que se devuelve: lista
		   lista = new ArrayList<Distrito>();
		   while (rs.next()) {//Mientras rs, tiene informacion, lee cada fila
			   // Crea un obj u, que contendrá la fila o registro
			   Distrito d = new Distrito(rs.getString(1), rs.getString(2));
			   lista.add(d);
		   }
		} catch (Exception e) {
		   System.out.println("Error en listado : " + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar : " + e.getMessage());
		}
		}
		return lista;
	}

	@Override
	public ArrayList<Cargo> listadoCargo() {
		ArrayList<Cargo> lista = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;  // guarda el resultado de la consulta
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "select * from TB_CARGO";
		   		   
		   pst = con.prepareStatement(sql);
		     
		   rs = pst.executeQuery(); //Ejecuta la sentencia y guarda el resultado 
		   
		   //pasar el objeto rs, al obj que se devuelve: lista
		   lista = new ArrayList<Cargo>();
		   while (rs.next()) {//Mientras rs, tiene informacion, lee cada fila
			   // Crea un obj u, que contendrá la fila o registro
			   Cargo c = new Cargo(rs.getString(1), rs.getString(2));
			   lista.add(c);
		   }
		} catch (Exception e) {
		   System.out.println("Error en listado : " + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar : " + e.getMessage());
		}
		}
		return lista;
	}

	@Override
	public String generarEmpleado() {
		
		String codigo="EM0000000";
		/*PLANTILLA*/
		Connection con = null;	
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion();
		 
		   
		   String sql = "SELECT SUBSTRING(MAX(cod_emple),3) FROM TB_EMPLEADO";
		   pst=con.prepareStatement(sql);
		   rs=pst.executeQuery();
		   if(rs.next()){
			   
			   codigo=String.format("EM000%04d",rs.getInt(1)+1);
			   
		   }
		   		   
		  
         
		} catch (Exception e) {
		   System.out.println("Error en generar empleado" + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar generador de empleado" + e.getMessage());
			
		}
		}
		return codigo;
	}

	@Override
	public ArrayList<Empleado> consulta(String fnacim, String cod_dist, String cod_cargo) {
		
		ArrayList<Empleado> lista=null;
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		/*ESTE RESULSET VA A GUARDAR EL RESULTADO DE LA CONSULTA*/
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "SELECT * FROM TB_EMPLEADO WHERE fnacim=? OR cod_dist=? OR cod_cargo=?";
		   		   
		   pst = con.prepareStatement(sql);
		   /*SOLAMENTE SE SETEA, SI HAY ? EN LA CADENA SQL*/
		   /*COMO LA SENTENCIA NO TIENE ? NO LO EJECUTAMOS SINO NOS SALE ERRORES*/
		
		   pst.setString(1,fnacim);
		   pst.setString(2,cod_dist);
		   pst.setString(3,cod_cargo);
		   
		   /*executequery ejecuta la sentencia y guarda el resultado*/	   
		   rs = pst.executeQuery(); 
		   
		   /*CONSTRUIMOS LA LISTA*/
		   lista=new ArrayList<Empleado>();
		   
		   /*PASAR EL OBJETOS RS(RESULTADO DE MI SENTENCIA), AL OBJETO QUE SE DEVUELVE: LISTA*/
		   while(rs.next()){/*MIESTRAS QUE RS TIENE INFORMACION, LEE CADA FILA*/
			   /*CREAR UN OBJETO DE U QUE CONTENDRA LA FILA O REGISTRO*/
			   Empleado e=new Empleado(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
			  
			   /*AGREGARMOS EL OBJETO A LA LISTA DE RETORNO*/
			   lista.add(e);
			   
		   }

		} catch (Exception e) {
		   System.out.println("Error en listado de tipos " + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al listar tipos : " + e.getMessage());
		}
		}
		return lista;
	}

}
