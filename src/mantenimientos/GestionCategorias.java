package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.CategoriaInterface;
import model.Categoria;
import utils.MySQLConexion8;

public class GestionCategorias implements CategoriaInterface {

	@Override
	public ArrayList<Categoria> listadoCategoria() {
		ArrayList<Categoria> lista=null;
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;  // guarda el resultado de la consulta
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "select * from TB_CATEGORIA";
		   		   
		   pst = con.prepareStatement(sql);
		   // se setea, si hay ? en la cadena   
		   rs = pst.executeQuery(); //Ejecuta la sentencia y guarda el resultado 
		   
		   //pasar el objeto rs, al obj que se devuelve: lista
		   lista = new ArrayList<Categoria>();
		   while (rs.next()) {//Mientras rs, tiene informacion, lee cada fila
			   // Crea un obj u, que contendrá la fila o registro
			  Categoria p=new Categoria(rs.getString(1),rs.getString(2));
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
	
}
