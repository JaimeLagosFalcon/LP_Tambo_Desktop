package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import mantenimientos.GestionLogueo;
import model.Cliente;
import model.Empleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class FrmBusqueda extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblInserteSuCodigo;
	public static JTextField txtCodigo;
	private JButton btnBuscar;
	private JLabel lblDatosEncontrados;
	private JLabel lblNombre;
	private JLabel lblApellido;
	public static JTextField txtNombre;
	private JTextField txtApellido;
	public static JButton btnAdquirirDatos;
	private JButton btnCrearDeTodos;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBusqueda frame = new FrmBusqueda();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmBusqueda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmBusqueda.class.getResource("/img/logo.png")));
		setTitle("Buscar Navegante Registrado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 348);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(66, 172, 63, 14);
		contentPane.add(lblNombre);
		
		lblDatosEncontrados = new JLabel("Datos Encontrados");
		lblDatosEncontrados.setBackground(SystemColor.windowText);
		lblDatosEncontrados.setForeground(SystemColor.activeCaptionText);
		lblDatosEncontrados.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDatosEncontrados.setBounds(148, 133, 170, 14);
		contentPane.add(lblDatosEncontrados);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 215, 0));
		panel.setBorder(new TitledBorder(null, "\u00BFEsta Registrado y no posee cuenta?", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 31, 414, 92);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblInserteSuCodigo = new JLabel("Inserte su Codigo");
		lblInserteSuCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInserteSuCodigo.setBounds(10, 55, 124, 14);
		panel.add(lblInserteSuCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(133, 53, 150, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(307, 45, 97, 34);
		panel.add(btnBuscar);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(0, 0, 0));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellido.setBounds(66, 197, 63, 14);
		contentPane.add(lblApellido);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(139, 170, 212, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setBounds(139, 195, 212, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		btnAdquirirDatos = new JButton("Adquirir \r\nDatos");
		btnAdquirirDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdquirirDatos.setEnabled(false);
		btnAdquirirDatos.addActionListener(this);
		
		btnCrearDeTodos = new JButton("Crear de todos modos");
		btnCrearDeTodos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrearDeTodos.addActionListener(this);
		btnCrearDeTodos.setBounds(230, 245, 181, 33);
		contentPane.add(btnCrearDeTodos);
		btnAdquirirDatos.setBounds(33, 245, 123, 33);
		contentPane.add(btnAdquirirDatos);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmBusqueda.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
		label.setBounds(-148, 0, 582, 309);
		contentPane.add(label);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnAdquirirDatos) {
			actionPerformedBtnAdquirirDatos(arg0);
		}
		if (arg0.getSource() == btnCrearDeTodos) {
			actionPerformedBtnCrearDeTodos(arg0);
		}
	}
	protected void actionPerformedBtnCrearDeTodos(ActionEvent arg0) {
		NuevoUsuario nu=new NuevoUsuario();
		nu.setVisible(true);
		nu.setLocationRelativeTo(null);
		dispose();
	}
	protected void actionPerformedBtnAdquirirDatos(ActionEvent arg0) {
		
		NuevoUsuario nu=new NuevoUsuario();
		nu.setVisible(true);
		nu.setLocationRelativeTo(null);
		nu.busqueda();
		dispose();
		
	}
	
	void busqueda(){
		
		try {
			String cod_cli;
		    String cod_emple;
		
		cod_cli=leerCliente();
		cod_emple=leerEmpleado();
		
		Cliente c=new GestionLogueo().buscarCliente(cod_cli);
		Empleado e=new GestionLogueo().buscarEmpleado(cod_emple);
		
		if(c!=null){
			txtNombre.setText(c.getNom_cli());
			txtApellido.setText(c.getApell_cli());
			btnAdquirirDatos.setEnabled(true);	
		}
		
		if(e!=null){
			txtNombre.setText(e.getNom_emple());
			txtApellido.setText(e.getApell_emple());
			btnAdquirirDatos.setEnabled(true);
			
		}
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(this,"No Existe Codigo");
		}
		
		
		
	}

	private String leerEmpleado() {
		if(txtCodigo.getText().trim().length()<0){
			JOptionPane.showMessageDialog(this,"Formato Incorrecto \n Formato:CLI000000 ó \n Formato:EM0000000");
			return null;
		}else{
			return txtCodigo.getText().trim();
		}
		
	}

	private String leerCliente() {
		if(txtCodigo.getText().trim().length()<0){
			JOptionPane.showMessageDialog(this,"Formato Incorrecto \n Formato:CLI000000 ó \n Formato:EM0000000");
			return null;
		}else{
			return txtCodigo.getText().trim();
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		
			busqueda();
	
	}
}
