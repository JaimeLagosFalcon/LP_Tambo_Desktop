package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.ProveedorInterface;
import model.Proveedor;
import utils.MySQLConexion8;

public class GestionProveedor implements ProveedorInterface{

	@Override
	public int registrar(Proveedor p) {
		int rs=0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "insert into TB_PROVEEDOR values (?,?,?,?,?);";
		   		   
		   pst = con.prepareStatement(sql);
		   
		   pst.setString(1, p.getCod_prove());
		   pst.setString(2, p.getNom_prove());
		   pst.setString(3, p.getCorreo_prove());
		   pst.setString(4, p.getTelef_prove());	
		   pst.setString(5, p.getCod_dist());
		   		   
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
	public int eliminar(String cod_prove) {
		
		int rs = 0;
		/*PLANTILLA*/
		Connection con=null;
		PreparedStatement pst=null;
		
		try {
			
			con=MySQLConexion8.getConexion();
			
			String sql="DELETE FROM TB_PROVEEDOR WHERE cod_prove=?";
			
			pst=con.prepareStatement(sql);
			
			pst.setString(1, cod_prove);
			
			
			
			rs=pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Error al Eliminar"+e.getMessage());
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: "+e.getMessage());
			}
		}
		return rs;
	}

	@Override
	public int actualizar(Proveedor p) {
		
		int rs = 0;
		/*PLANTILLA*/
		Connection con=null; 
		PreparedStatement pst=null; 
		try {
			
			con=MySQLConexion8.getConexion();
			
			String sql="UPDATE TB_PROVEEDOR SET nom_prove=?,correo_prove=?,telef_prove=?,cod_dist=? WHERE cod_prove=?";
			
			pst=con.prepareStatement(sql);
			
			
			pst.setString(1,p.getNom_prove());
			pst.setString(2,p.getCorreo_prove());
			pst.setString(3,p.getTelef_prove());
			pst.setString(4,p.getCod_dist());
			pst.setString(5,p.getCod_prove() );
		
			
			rs=pst.executeUpdate();
			
			
			
		} catch (Exception e) {
			System.out.println("Error en actualizar : "+e.getMessage());
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar : "+e.getMessage());
			}
		}
	
		return rs;
	}

	@Override
	public ArrayList<Proveedor> listado() {
		
		ArrayList<Proveedor> lista=null;
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "SELECT * FROM TB_PROVEEDOR";
		   		   
		   pst = con.prepareStatement(sql);
    
		   rs = pst.executeQuery(); 

		   lista=new ArrayList<Proveedor>();

		   while(rs.next()){
			   
			   Proveedor p=new Proveedor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5));

			   lista.add(p);
			   
		   }

		} catch (Exception e) {
		   System.out.println("Error en listado " + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al listar : " + e.getMessage());
		}
		}
		return lista;
	}

	@Override
	public ArrayList<Proveedor> consultaxnombre(String nom_prove) {
		ArrayList<Proveedor> lista=null;
		//SELECT * FROM TB_PROVEEDOR WHERE NOM_PROVE='LAYS'
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "SELECT * FROM TB_PROVEEDOR WHERE NOM_PROVE=?";
		   		   
		   pst = con.prepareStatement(sql);
		 
		   pst.setString(1,nom_prove);
		      
		   rs = pst.executeQuery(); 
		   
		   lista=new ArrayList<Proveedor>();
		   
		   
		   
		   
		   
		   while(rs.next()){
			   
			  Proveedor p=new Proveedor(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			   
			   lista.add(p);
			   
		   }

		} catch (Exception e) {
		   System.out.println("Error en consulta" + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al listar: " + e.getMessage());
		}
		}
		return lista;
	}

	@Override
	public String generarProveedor() {
		
		String codigo="RUC000000";
		/*PLANTILLA*/
		Connection con = null;	
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion();
		 
		   
		   String sql = "SELECT SUBSTRING(MAX(cod_prove),4)FROM TB_PROVEEDOR";
		   pst=con.prepareStatement(sql);
		   rs=pst.executeQuery();
		   if(rs.next()){
			   
			   codigo=String.format("RUC00%04d",rs.getInt(1)+1);
			   
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
	public ArrayList<Proveedor> consulta(String cod_dist) {
		ArrayList<Proveedor> lista=null;
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		/*ESTE RESULSET VA A GUARDAR EL RESULTADO DE LA CONSULTA*/
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "SELECT * FROM TB_PROVEEDOR WHERE cod_dist=?";
		   		   
		   pst = con.prepareStatement(sql);
		   /*SOLAMENTE SE SETEA, SI HAY ? EN LA CADENA SQL*/
		   /*COMO LA SENTENCIA NO TIENE ? NO LO EJECUTAMOS SINO NOS SALE ERRORES*/
		
		   
		   pst.setString(1,cod_dist);
		   
		   /*executequery ejecuta la sentencia y guarda el resultado*/	   
		   rs = pst.executeQuery(); 
		   
		   /*CONSTRUIMOS LA LISTA*/
		   lista=new ArrayList<Proveedor>();
		   
		   /*PASAR EL OBJETOS RS(RESULTADO DE MI SENTENCIA), AL OBJETO QUE SE DEVUELVE: LISTA*/
		   while(rs.next()){/*MIESTRAS QUE RS TIENE INFORMACION, LEE CADA FILA*/
			   /*CREAR UN OBJETO DE U QUE CONTENDRA LA FILA O REGISTRO*/
			   Proveedor p=new Proveedor(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			  
			   
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