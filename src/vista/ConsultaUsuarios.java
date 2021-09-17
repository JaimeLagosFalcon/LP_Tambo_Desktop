package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import mantenimientos.GestionLogueo;
import model.ConsultarUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;

public class ConsultaUsuarios extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JTable tbSalida;
	private JScrollPane scrollPane;
	private JLabel lblUsuariosExistentes;
	DefaultTableModel modelo=new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUsuarios frame = new ConsultaUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaUsuarios() {
		setTitle("Consulta de Usuarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaUsuarios.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 682, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuariosExistentes = new JLabel("Usuarios Existentes");
		lblUsuariosExistentes.setForeground(Color.BLUE);
		lblUsuariosExistentes.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuariosExistentes.setBounds(273, 11, 182, 19);
		contentPane.add(lblUsuariosExistentes);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 646, 268);
		contentPane.add(scrollPane);
		
		tbSalida = new JTable();
		tbSalida.setModel(modelo);
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Usuario");
		modelo.addColumn("Clave");
		modelo.addColumn("Nacimiento");
		modelo.addColumn("Modo de Uso");
		
		scrollPane.setViewportView(tbSalida);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(ConsultaUsuarios.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
		label.setBounds(-130, 0, 886, 331);
		contentPane.add(label);
		
		ajustarAnchoColumnas();
		listado();
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbSalida.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(7));  // CODIGO
		tcm.getColumn(1).setPreferredWidth(anchoColumna(10));  //NOMBRE
		tcm.getColumn(2).setPreferredWidth(anchoColumna(8));  //APELLIDO
		tcm.getColumn(3).setPreferredWidth(anchoColumna(5));  //NACIMIENTO
		tcm.getColumn(4).setPreferredWidth(anchoColumna(5));  //CORREO
		tcm.getColumn(5).setPreferredWidth(anchoColumna(7));  //TELEFONO
		tcm.getColumn(6).setPreferredWidth(anchoColumna(13));  //DISTRITO
		
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	void listado(){
		ArrayList<ConsultarUsuario> lstUsuario=new GestionLogueo().listadousuarios();
		
		if(lstUsuario==null){
			JOptionPane.showMessageDialog(this,"LISTA VACIA");
		}else{
			modelo.setRowCount(0);
			
			for (ConsultarUsuario c : lstUsuario) {
				Object aDatos[]={c.getCodigo_usu(),
						         c.getNombre(),
						         c.getApellido(),
						         c.getUsuario(),
						         c.getClave(),
						         c.getFnacim(),
						         c.getDes_tipo()};
				modelo.addRow(aDatos);
			}
		}
		
	}
}
