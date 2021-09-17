package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.LogueoInterface;
import model.Cliente;
import model.ConsultarUsuario;
import model.Empleado;
import model.ModeloNuevoUsuario;
import model.TipoUsuario;
import utils.MySQLConexion8;
import vista.ConsultaUsuarios;

public class GestionLogueo implements LogueoInterface{

	@Override
	public ArrayList<TipoUsuario> listadodetipo() {
		ArrayList<TipoUsuario> lista=null;
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null; 
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "SELECT * FROM TB_TIPO_USUARIO";
		   		   
		   pst = con.prepareStatement(sql);
		     
		   rs = pst.executeQuery(); 
		   
		  
		   lista = new ArrayList<TipoUsuario>();
		   while (rs.next()) {
			  TipoUsuario tu=new TipoUsuario(rs.getString(1),rs.getString(2));
			   
			   lista.add(tu);
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

	
	public int registrar(ModeloNuevoUsuario o) {		
		int rs = 0;
		
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "INSERT INTO TB_USUARIO VALUES(?,?,?,?,?,?,?)";
		   		   
		   pst = con.prepareStatement(sql);
		   
		   
		   pst.setString(1,o.getCod_usu());
		   pst.setString(2,o.getNom_usu());
		   pst.setString(3,o.getApe_usu());
		   pst.setString(4,o.getUsuario());
		   pst.setString(5,o.getClave());
		   pst.setString(6,o.getFnacim());
		   pst.setString(7,o.getId_tipo());
		   		   
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


	
	public String generarCodigoUsuario() {
		String codigo="T000000000";
		/*PLANTILLA*/
		Connection con = null;	
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion();
		 
		   
		   String sql = "SELECT SUBSTRING(MAX(codigo_usu),2) FROM TB_USUARIO";
		   pst=con.prepareStatement(sql);
		   rs=pst.executeQuery();
		   if(rs.next()){
			   
			   codigo=String.format("T00000%04d",rs.getInt(1)+1);
			   //codigo = "B" + new DecimalFormat("0000").format(Integer.parseInt(rs.getString(1))+1);
		   }
		   		   
		  
         
		} catch (Exception e) {
		   System.out.println("Error en registrar Cita :" + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar Cita : " + e.getMessage());
			
		}
		}
		return codigo;
	}


	
	public String generarUsuarioAdmmin() {
		
		String codigo="A0000";
		/*PLANTILLA*/
		Connection con = null;	
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion();
		 
		   
		   String sql = "SELECT SUBSTRING(MAX(USUARIO),2) FROM TB_USUARIO";
		   pst=con.prepareStatement(sql);
		   rs=pst.executeQuery();
		   if(rs.next()){
			   
			   codigo=String.format("A%04d",rs.getInt(1)+1);
			   //codigo = "B" + new DecimalFormat("0000").format(Integer.parseInt(rs.getString(1))+1);
		   }
		   		   
		  
         
		} catch (Exception e) {
		   System.out.println("Error en registrar" + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar" + e.getMessage());
			
		}
		}
		return codigo;
	}


	
	public String generarUsuarioCajero() {
		String codigo="U0000";
		/*PLANTILLA*/
		Connection con = null;	
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion();
		 
		   
		   String sql = "SELECT SUBSTRING(MAX(USUARIO),2) FROM TB_USUARIO";
		   pst=con.prepareStatement(sql);
		   rs=pst.executeQuery();
		   if(rs.next()){
			   
			   codigo=String.format("U%04d",rs.getInt(1)+1);
			   //codigo = "B" + new DecimalFormat("0000").format(Integer.parseInt(rs.getString(1))+1);
		   }
		   		   
		  
         
		} catch (Exception e) {
		   System.out.println("Error en registrar" + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar" + e.getMessage());
			
		}
		}
		return codigo;
	}


	@Override
	public String generarUsuarioCliente() {
		String codigo="C0000";
		/*PLANTILLA*/
		Connection con = null;	
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion();
		 
		   
		   String sql = "SELECT SUBSTRING(MAX(USUARIO),2) FROM TB_USUARIO";
		   pst=con.prepareStatement(sql);
		   rs=pst.executeQuery();
		   if(rs.next()){
			   
			   codigo=String.format("C%04d",rs.getInt(1)+1);
			   //codigo = "B" + new DecimalFormat("0000").format(Integer.parseInt(rs.getString(1))+1);
		   }
		   		   
		  
         
		} catch (Exception e) {
		   System.out.println("Error en registrar" + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar" + e.getMessage());
			
		}
		}
		return codigo;
	}


	
	public ModeloNuevoUsuario validarAcceso(String usuario, String clave) {
		ModeloNuevoUsuario mnu=null;
		
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "SELECT * FROM TB_USUARIO WHERE USUARIO=? AND CLAVE=?";
		   		   
		   pst = con.prepareStatement(sql);
		   
		   pst.setString(1,usuario);
		   pst.setString(2,clave);
		    
		   rs = pst.executeQuery(); 
		   
		  if(rs.next()){
			  
			  mnu=new ModeloNuevoUsuario(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			  
		   }

		} catch (Exception e) {
		   System.out.println("Error en listado" + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al listar" + e.getMessage());
		}
		}
		return mnu;
	}


	@Override
	public String generarMantenimiento() {
		String codigo="M0000";
		/*PLANTILLA*/
		Connection con = null;	
		PreparedStatement pst = null;
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion();
		 
		   
		   String sql = "SELECT SUBSTRING(MAX(USUARIO),3) FROM TB_USUARIO";
		   pst=con.prepareStatement(sql);
		   rs=pst.executeQuery();
		   if(rs.next()){
			   
			   codigo=String.format("M%04d",rs.getInt(1)+1);
			   //codigo = "B" + new DecimalFormat("0000").format(Integer.parseInt(rs.getString(1))+1);
		   }
		   		   
		  
         
		} catch (Exception e) {
		   System.out.println("Error en registrar" + e.getMessage());
		} finally {
		  try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar" + e.getMessage());
			
		}
		}
		return codigo;
	}


	@Override
	public Cliente buscarCliente(String cod_cli) {
		Cliente c=null;
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		/*ESTE RESULSET VA A GUARDAR EL RESULTADO DE LA CONSULTA*/
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "SELECT * FROM TB_CLIENTE WHERE cod_cli=?";
		   		   
		   pst = con.prepareStatement(sql);
		   /*SOLAMENTE SE SETEA, SI HAY ? EN LA CADENA SQL*/
		   /*COMO LA SENTENCIA NO TIENE ? NO LO EJECUTAMOS SINO NOS SALE ERRORES*/
		   pst.setString(1,cod_cli);
		   
		   /*executequery ejecuta la sentencia y guarda el resultado*/	   
		   rs = pst.executeQuery(); 
		   
		   
		   /*PASAR EL OBJETOS RS(RESULTADO DE MI SENTENCIA), AL OBJETO QUE SE DEVUELVE: LISTA*/
		   if(rs.next()){/*SI QUE RS TIENE INFORMACION, LEE LA FILA*/
			   /*CREAR UN OBJETO DE U QUE CONTENDRA LA FILA O REGISTRO*/
			   c=new Cliente(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
		   
			    
			   
			   
			   
			   
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
		return c;
	}


	@Override
	public Empleado buscarEmpleado(String cod_emple) {
		Empleado m=null;
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		/*ESTE RESULSET VA A GUARDAR EL RESULTADO DE LA CONSULTA*/
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "SELECT * FROM TB_EMPLEADO WHERE cod_emple=?";
		   		   
		   pst = con.prepareStatement(sql);
		   /*SOLAMENTE SE SETEA, SI HAY ? EN LA CADENA SQL*/
		   /*COMO LA SENTENCIA NO TIENE ? NO LO EJECUTAMOS SINO NOS SALE ERRORES*/
		   pst.setString(1,cod_emple);
		   
		   /*executequery ejecuta la sentencia y guarda el resultado*/	   
		   rs = pst.executeQuery(); 
		   
		   
		   /*PASAR EL OBJETOS RS(RESULTADO DE MI SENTENCIA), AL OBJETO QUE SE DEVUELVE: LISTA*/
		   if(rs.next()){/*SI QUE RS TIENE INFORMACION, LEE LA FILA*/
			   /*CREAR UN OBJETO DE U QUE CONTENDRA LA FILA O REGISTRO*/
			   
			   m=new Empleado(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
			    
			   
			   
			   
			   
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
		return m;
	}


	@Override
	public int actualizarDatosCliente(Cliente cli) {
		int rs = 0;
		// Plantilla
		Connection con = null; // obtener la conexion con la BD
		PreparedStatement pst = null; // sirve para las sentencias
		try {
			//1. obtener conexion
			con = MySQLConexion8.getConexion();
			//2. crear cadena con la sentencia a ejecutar
			String sql = "UPDATE TB_CLIENTE SET usuario=? , clave=? WHERE cod_cli=?";
			//3. preparamos la cadena
			pst = con.prepareStatement(sql);
			// hay que setear si hay "?"
			
			pst.setString(1, cli.getUsuario());
			pst.setString(2, cli.getClave());
			pst.setString(3, cli.getCod_cli());
			
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
	public int actualizarDatosEmpleado(Empleado em) {
		int rs = 0;
		// Plantilla
		Connection con = null; // obtener la conexion con la BD
		PreparedStatement pst = null; // sirve para las sentencias
		try {
			//1. obtener conexion
			con = MySQLConexion8.getConexion();
			//2. crear cadena con la sentencia a ejecutar
			String sql = "UPDATE TB_EMPLEADO SET usuario=? , clave=? WHERE cod_emple=?";
			//3. preparamos la cadena
			pst = con.prepareStatement(sql);
			// hay que setear si hay "?"
			
			pst.setString(1, em.getUsuario());
			pst.setString(2, em.getClave());
			pst.setString(3,em.getCod_emple());
			
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
	public ArrayList<ConsultarUsuario> listadousuarios() {
		ArrayList<ConsultarUsuario> lista = null;
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null; 
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "SELECT P.CODIGO_USU,P.NOMBRE,P.APELLIDO,P.USUARIO,P.CLAVE,P.FNACIM,T.DES_TIPO \r\n"+
"FROM TB_USUARIO P \r\n"+
"INNER JOIN TB_TIPO_USUARIO T \r\n"+
"ON P.ID_TIPO=T.ID_TIPO \r\n"+
"ORDER BY P.CODIGO_USU ASC";
		   		   
		   pst = con.prepareStatement(sql);
		     
		   rs = pst.executeQuery(); 
		   
		  
		   lista = new ArrayList<ConsultarUsuario>();
		   while (rs.next()) {
			   ConsultarUsuario cu=new ConsultarUsuario(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7));
			 
			   
			   lista.add(cu);
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
