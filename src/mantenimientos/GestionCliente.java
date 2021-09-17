package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ClienteInterface;
import model.Cliente;
import model.Distrito;

import utils.MySQLConexion8;

public class GestionCliente implements ClienteInterface {

	@Override
	public int registrar(Cliente cli) {
		int rs = 0;
		// Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "insert into TB_CLIENTE values (?,default,default,?,?,?,?,?,?);";
		   		   
		   pst = con.prepareStatement(sql);
		   
		   pst.setString(1, cli.getCod_cli());
		   pst.setString(2, cli.getNom_cli());
		   pst.setString(3, cli.getApell_cli());
		   pst.setString(4,cli.getFnacim());
		   pst.setString(5, cli.getCorreo_cli());
		   pst.setString(6, cli.getTelef_cli());
		   pst.setString(7, cli.getCod_dist());
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
	public int eliminar(String cod_cli) {
		int rs = 0;
		
		// Plantilla
		Connection con = null; // obtener la conexion con la BD
		PreparedStatement pst = null; // sirve para las sentencias
		try {
			//1. obtener conexion
			con = MySQLConexion8.getConexion();
			//2. crear cadena con la sentencia a ejecutar
			String sql = "delete from TB_CLIENTE where cod_cli=?";
			//3. preparamos la cadena
			pst = con.prepareStatement(sql);
			//si la cadena tiene ? hay que setear!!!!
			pst.setString(1, cod_cli);
			// 4.ejecutamos la sentencia y guardamos resultado
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en eliminar Cliente"+e.getMessage());
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
	public int actualizar(Cliente cli) {
		int rs = 0;
		// Plantilla
		Connection con = null; // obtener la conexion con la BD
		PreparedStatement pst = null; // sirve para las sentencias
		try {
			//1. obtener conexion
			con = MySQLConexion8.getConexion();
			//2. crear cadena con la sentencia a ejecutar
			String sql = "UPDATE TB_CLIENTE SET nom_cli=?,apell_cli=?,fnacim=?,correo_cli=?,telef_cli=?,cod_dist=? WHERE cod_cli=?";
			//3. preparamos la cadena
			pst = con.prepareStatement(sql);
			// hay que setear si hay "?"
			
			pst.setString(1, cli.getNom_cli());
			pst.setString(2, cli.getApell_cli());
			pst.setString(3, cli.getFnacim());
			pst.setString(4, cli.getCorreo_cli());
			pst.setString(5, cli.getTelef_cli());
			pst.setString(6, cli.getCod_dist());
			pst.setString(7, cli.getCod_cli());
			
			// 4.ejecutamos la sentencia y guardamos resultado
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en actualizar Cliente"+e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar Cliente"+e.getMessage());
			}
		}
		return rs;
	}


	@Override
	public ArrayList<Distrito> listadoDistrito() {
		ArrayList<Distrito> lista = null;
		// Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null; 
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "select * from TB_DISTRITO";
		   		   
		   pst = con.prepareStatement(sql);
		     
		   rs = pst.executeQuery(); 
		   
		   
		   lista = new ArrayList<Distrito>();
		   while (rs.next()) {
			   
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


	
	public String generarCliente() {
		
		String codigo = "CLI000000";
		/*PLANTILLA*/
		Connection con = null;	
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion();
		 
		   
		   String sql = "SELECT SUBSTRING(MAX(cod_cli),4) FROM TB_CLIENTE";
		   pst=con.prepareStatement(sql);
		   rs=pst.executeQuery();
		   if(rs.next()){
			   
			   codigo=String.format("CLI00%04d",rs.getInt(1)+1);
			   
		   }
		   		   
		  
         
		} catch (Exception e) {
		   System.out.println("Error en generar cliente" + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar generador de cliente" + e.getMessage());
			
		}
		}
		return codigo;
	}


	@Override
	public ArrayList<Cliente> listadoCliente() {
		
		ArrayList<Cliente> lista=null;
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null; 
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "select * from TB_CLIENTE";
		   		   
		   pst = con.prepareStatement(sql);
		     
		   rs = pst.executeQuery(); 
		   
		   
		   lista = new ArrayList<Cliente>();
		   while (rs.next()) {
			   Cliente c=new Cliente(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8), rs.getString(9));
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
	public ArrayList<Cliente> consultar(String fnacim,String cod_dist) {
		
		ArrayList<Cliente> lista=null;
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		/*ESTE RESULSET VA A GUARDAR EL RESULTADO DE LA CONSULTA*/
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "SELECT * FROM TB_CLIENTE WHERE fnacim=? OR cod_dist=?";
		   		   
		   pst = con.prepareStatement(sql);
		   /*SOLAMENTE SE SETEA, SI HAY ? EN LA CADENA SQL*/
		   /*COMO LA SENTENCIA NO TIENE ? NO LO EJECUTAMOS SINO NOS SALE ERRORES*/
		
		   pst.setString(1,fnacim);
		   pst.setString(2,cod_dist);
		   
		   /*executequery ejecuta la sentencia y guarda el resultado*/	   
		   rs = pst.executeQuery(); 
		   
		   /*CONSTRUIMOS LA LISTA*/
		   lista=new ArrayList<Cliente>();
		   
		   /*PASAR EL OBJETOS RS(RESULTADO DE MI SENTENCIA), AL OBJETO QUE SE DEVUELVE: LISTA*/
		   while(rs.next()){/*MIESTRAS QUE RS TIENE INFORMACION, LEE CADA FILA*/
			   /*CREAR UN OBJETO DE U QUE CONTENDRA LA FILA O REGISTRO*/
			   Cliente c=new Cliente(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
			  
			   
			   /*AGREGARMOS EL OBJETO A LA LISTA DE RETORNO*/
			   lista.add(c);
			   
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
