package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ProductoInterface;
import model.Producto;
import utils.MySQLConexion8;

public class GestionProductos implements ProductoInterface{

	@Override
	public int registrar(Producto p) {
		int rs = 0;
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "insert into TB_PRODUCTO values (?,?,?,?,?,?,?);";
		   		   
		   pst = con.prepareStatement(sql);
		   
		   pst.setString(1, p.getCod_prod());
		   pst.setString(2, p.getDesc_prod());
		   pst.setString(3, p.getFvenci());
			pst.setDouble(4, p.getPrec_prod());
			pst.setInt(5, p.getStock_prod());
			pst.setString(6, p.getCod_cate());
			pst.setString(7, p.getCod_prove());
		   		   
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
	public int eliminar(String cod_prod) {
		int rs = 0; //valor en caso de error
		//Plantilla
		Connection con = null; // obtener la conexion con la BD
		PreparedStatement pst = null; // sirve para las sentencias
		try {
			//1. obtener conexion
			con = MySQLConexion8.getConexion();
			//2. crear cadena con la sentencia a ejecutar
			String sql = "delete from TB_PRODUCTO where cod_prod=?";
			//3. preparamos la cadena
			pst = con.prepareStatement(sql);
			//si la cadena tiene ? hay que setear!!!!
			pst.setString(1, cod_prod);
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
	public int actualizar(Producto p) {
		int rs = 0;
		// Plantilla
		Connection con = null; // obtener la conexion con la BD
		PreparedStatement pst = null; // sirve para las sentencias
		try {
			//1. obtener conexion
			con = MySQLConexion8.getConexion();
			//2. crear cadena con la sentencia a ejecutar
			String sql = "update TB_PRODUCTO set desc_prod=?,fvenci=?, prec_prod=?, stock_prod=?,cod_cate=?, cod_prove=? where cod_prod=?";
			//3. preparamos la cadena
			pst = con.prepareStatement(sql);
			// hay que setear si hay "?"
			
			pst.setString(1, p.getDesc_prod());
			pst.setString(2, p.getFvenci());
			pst.setDouble(3, p.getPrec_prod());
			pst.setInt(4, p.getStock_prod());
			pst.setString(5, p.getCod_cate());
			pst.setString(6, p.getCod_prove());
			pst.setString(7, p.getCod_prod());
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
	public Producto buscar(String cod_prod) {
		Producto p = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;  // guarda el resultado de la consulta
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "select * from TB_PRODUCTO where cod_prod = ?";
		   		   
		   pst = con.prepareStatement(sql);
		   // se setea, si hay ? en la cadena   
		   pst.setString(1, cod_prod);
		   rs = pst.executeQuery(); //Ejecuta la sentencia y guarda el resultado 
		   
		   //pasar el objeto rs, al obj que se devuelve: lista
		   if (rs.next()) {//Mientras rs, tiene informacion, lee cada fila
			   // Crea un obj u, que contendrá la fila o registro
			 p=new Producto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6),rs.getString(7));
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
		return p;
	}

	@Override
	public ArrayList<Producto> listado() {
		ArrayList<Producto> lista = null;
		//Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;  
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "select * from TB_PRODUCTO";
		   		   
		   pst = con.prepareStatement(sql);
		   
		   rs = pst.executeQuery(); 
		   
		   
		   lista = new ArrayList<Producto>();
		   while (rs.next()) {
			 
			  Producto p=new Producto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6),rs.getString(7));
			   lista.add(p);
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
	public String generarProducto() {
		
		String codigo="PR00000000";
		/*PLANTILLA*/
		Connection con = null;	
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion();
		 
		   
		   String sql = "SELECT SUBSTRING(MAX(cod_prod),3)FROM TB_PRODUCTO";
		   pst=con.prepareStatement(sql);
		   rs=pst.executeQuery();
		   if(rs.next()){
			   
			   codigo=String.format("PR0000%04d",rs.getInt(1)+1);
			   
		   }
		   		   
		  
         
		} catch (Exception e) {
		   System.out.println("Error en generar Producto" + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar generador de Producto" + e.getMessage());
			
		}
		}
		return codigo;
	}

	@Override
	public ArrayList<Producto> consultar(String fvenci, String cod_cate, String cod_prove) {
		
		ArrayList<Producto> lista=null;
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		/*ESTE RESULSET VA A GUARDAR EL RESULTADO DE LA CONSULTA*/
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "SELECT * FROM TB_PRODUCTO WHERE fvenci=? OR cod_cate=? OR cod_prove=?";
		   		   
		   pst = con.prepareStatement(sql);
		   /*SOLAMENTE SE SETEA, SI HAY ? EN LA CADENA SQL*/
		   /*COMO LA SENTENCIA NO TIENE ? NO LO EJECUTAMOS SINO NOS SALE ERRORES*/
		
		   pst.setString(1,fvenci);
		   pst.setString(2,cod_cate);
		   pst.setString(3,cod_prove);
		   
		   /*executequery ejecuta la sentencia y guarda el resultado*/	   
		   rs = pst.executeQuery(); 
		   
		   /*CONSTRUIMOS LA LISTA*/
		   lista=new ArrayList<Producto>();
		   
		   /*PASAR EL OBJETOS RS(RESULTADO DE MI SENTENCIA), AL OBJETO QUE SE DEVUELVE: LISTA*/
		   while(rs.next()){/*MIESTRAS QUE RS TIENE INFORMACION, LEE CADA FILA*/
			   /*CREAR UN OBJETO DE U QUE CONTENDRA LA FILA O REGISTRO*/
			   Producto p=new Producto(rs.getString(1), rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6),rs.getString(7));
			   
			  
			   
			   /*AGREGARMOS EL OBJETO A LA LISTA DE RETORNO*/
			   lista.add(p);
			   
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