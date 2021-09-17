package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.VentaInterface;
import model.Boleta;
import model.DetalleBoleta;
import model.Empleado;
import utils.MySQLConexion8;

public class GestionVenta implements VentaInterface {

	@Override
	public String generarBoleta() {
		
		String codigo="BL00000000";
		/*PLANTILLA*/
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			con= MySQLConexion8.getConexion();
			
			String sql="SELECT SUBSTRING(MAX(num_bolet),8) FROM TB_BOLETA";
			pst=con.prepareStatement(sql);
			rs= pst.executeQuery();
			
			if(rs.next()){
				codigo=String.format("BL0000%04d",rs.getInt(1)+1);
			}
		} catch (Exception e) {
			System.out.println("Error en generar boleta" + e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar generador de boleta" + e.getMessage());
				
			}
		}
		return codigo;
	}

	@Override
	public int realizarVenta(Boleta bl, ArrayList<DetalleBoleta> db) {
		
		int rs=0;
		/*PLANTILLA*/
		Connection con=null;		
		PreparedStatement pst1=null;
		PreparedStatement pst2=null;
		PreparedStatement pst3=null;
		
		try {
			con=MySQLConexion8.getConexion();
			
			con.setAutoCommit(false);
			
			String sql1="INSERT INTO TB_BOLETA VALUES (?,?,?,?,?,?)";
			
			pst1=con.prepareStatement(sql1);
			
			pst1.setString(1,bl.getNum_bolet());
			pst1.setString(2,bl.getFec_bolet());
			pst1.setString(3,bl.getHor_bolet());
			pst1.setString(4,bl.getCod_cli());
			pst1.setString(5,bl.getCod_emple());
			pst1.setDouble(6,bl.getTot_bol());		
			
			rs=pst1.executeUpdate();
			
			String sql2="INSERT INTO TB_DETALLE_BOLETA VALUES (?,?,?,?,?)";
			for (DetalleBoleta d : db) {
				pst2=con.prepareStatement(sql2);
				pst2.setString(1,bl.getNum_bolet());
				pst2.setString(2,d.getCod_prod());
				pst2.setInt(3,d.getCant_prod());
				pst2.setDouble(4,d.getPrec_prod());
				pst2.setDouble(5,d.getImportetotal());
				
				rs=pst2.executeUpdate();
			}
			
			String sql3="UPDATE TB_PRODUCTO SET stock_prod=stock_prod-? WHERE cod_prod=?";
			for (DetalleBoleta d : db) {
				pst3=con.prepareStatement(sql3);
				pst3.setInt(1,d.getCant_prod());
				pst3.setString(2,d.getCod_prod());
				rs=pst3.executeUpdate();
			}
			con.commit();
		} catch (Exception e) {
			  System.out.println("Error en registrar " + e.getMessage());
			   rs=0;
			   try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("Error al restaurar "+e1.getMessage());
			}
		}finally {
			  try {
					con.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar : " + e.getMessage());
					
				}
				}
		return rs;
	}

	@Override
	public Empleado buscar(String usuario) {
		Empleado m=null;
		/*PLANTILLA*/
		Connection con = null;
		PreparedStatement pst = null;
		/*ESTE RESULSET VA A GUARDAR EL RESULTADO DE LA CONSULTA*/
		ResultSet rs=null;
		
		try {
		   con = MySQLConexion8.getConexion(); 
		   String sql = "SELECT cod_emple  FROM TB_EMPLEADO WHERE usuario=?";
		   		   
		   pst = con.prepareStatement(sql);
		   /*SOLAMENTE SE SETEA, SI HAY ? EN LA CADENA SQL*/
		   /*COMO LA SENTENCIA NO TIENE ? NO LO EJECUTAMOS SINO NOS SALE ERRORES*/
		   pst.setString(1,usuario);
		   
		   /*executequery ejecuta la sentencia y guarda el resultado*/	   
		   rs = pst.executeQuery(); 
		   
		   
		   
		   
		   
		   
		   
		   /*PASAR EL OBJETOS RS(RESULTADO DE MI SENTENCIA), AL OBJETO QUE SE DEVUELVE: LISTA*/
		   if(rs.next()){/*SI QUE RS TIENE INFORMACION, LEE LA FILA*/
			   /*CREAR UN OBJETO DE U QUE CONTENDRA LA FILA O REGISTRO*/
			   m=new Empleado(rs.getString(1),null,null,null,null,null,null,null,null,null);
			    
			   
			   
			   
			   
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

}
