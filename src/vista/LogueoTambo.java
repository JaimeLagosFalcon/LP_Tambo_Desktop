package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.HiloCerrar;
import mantenimientos.GestionLogueo;
import model.ModeloNuevoUsuario;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class LogueoTambo extends JFrame implements ActionListener, MouseListener, WindowListener {

	private JPanel contentPane;
	public static JTextField txtUsuario;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogueoTambo frame = new LogueoTambo();
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
	public LogueoTambo() {
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LogueoTambo.class.getResource("/img/logo.png")));
		setTitle("TAMBO - Acceso al Sistema");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 388, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addMouseListener(this);
		
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBackground(new Color(255, 215, 0));
		btnAceptar.addActionListener(this);
		
		lblAqui = new JLabel("Aqui !!");
		lblAqui.addMouseListener(this);
		
		lblstiempo = new JLabel("15s");
		lblstiempo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblstiempo.setForeground(Color.WHITE);
		lblstiempo.setBounds(302, 11, 47, 23);
		contentPane.add(lblstiempo);
		
		
		lblAqui.setForeground(Color.WHITE);
		lblAqui.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAqui.setBounds(218, 256, 71, 23);
		contentPane.add(lblAqui);
		
		lblCrearUnaCuenta = new JLabel("Crear una Cuenta");
		lblCrearUnaCuenta.setForeground(Color.WHITE);
		lblCrearUnaCuenta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCrearUnaCuenta.setBounds(69, 258, 139, 18);
		contentPane.add(lblCrearUnaCuenta);
		btnAceptar.setBounds(211, 202, 114, 31);
		contentPane.add(btnAceptar);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(197, 91, 104, 20);
		contentPane.add(txtClave);
		
		JLabel lblUsuario = new JLabel("USUARIO :");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(52, 61, 83, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A :");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContrasea.setBounds(52, 92, 114, 14);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(197, 60, 104, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnCerrar = new JButton("CERRAR");
		btnCerrar.addMouseListener(this);
		

		btnCerrar.addActionListener(this);
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setBackground(new Color(255, 215, 0));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCerrar.setBounds(40, 202, 114, 31);
		contentPane.add(btnCerrar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(LogueoTambo.class.getResource("/img/7b5ac4103933685.Y3JvcCwyODc3LDIyNTEsNTYyLDA.png")));
		lblNewLabel_1.setBounds(0, 0, 395, 311);
		contentPane.add(lblNewLabel_1);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		validar();
	}
	int intentos=0;
	
	public static ModeloNuevoUsuario mnu=new ModeloNuevoUsuario();
	
	private JPasswordField txtClave;
	private JButton btnCerrar;
	private JLabel lblCrearUnaCuenta;
	private JLabel lblAqui;
	public static JLabel lblstiempo;
			

	private void validar() {
		String usuario;
		String clave;
		
		usuario=leerUsuario();
		clave=leerClave();
		
		mnu=new GestionLogueo().validarAcceso(usuario, clave);
		
		if(mnu !=null){
			JOptionPane.showMessageDialog(null,"Bienvenido "+mnu.getNom_usu()+" a TAMBO");
			Principal p=new Principal();
			p.setVisible(true);
			p.setLocationRelativeTo(null);
			dispose();
		}else{
			intentos ++;
			JOptionPane.showMessageDialog(null,"Usuario ó Clave incorrecto \n intentos : "+intentos+"/3");
			cerrar();
		}
		
	}
	
	private void cerrar(){
		if(intentos==3){
			dispose();
		}
	}

	private String leerClave() {
		
		return txtClave.getText();
	}

	private String leerUsuario() {
		
		return txtUsuario.getText();
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
		

	protected void mouseClickedLblAqui(MouseEvent arg0) {
		FrmBusqueda fb=new FrmBusqueda();
		fb.setVisible(true);
		fb.setLocationRelativeTo(null);
	}
	
	
	
	
	
	
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnAceptar) {
			mouseEnteredBtnAceptar(e);
		}
		if (e.getSource() == btnCerrar) {
			mouseEnteredBtnCerrar(e);
		}
		if (e.getSource() == lblAqui) {
			mouseEnteredLblAqui(e);
		}
	}
	
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseEnteredLblAqui(MouseEvent e) {
		lblAqui.setForeground(Color.BLUE);
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnAceptar) {
			mouseExitedBtnAceptar(e);
		}
		if (e.getSource() == btnCerrar) {
			mouseExitedBtnCerrar(e);
		}
		if (e.getSource() == lblAqui) {
			mouseExitedLblAqui(e);
		}
	}
	
	
	
	private void mouseExitedBtnAceptar(MouseEvent e) {
		btnAceptar.setForeground(Color.white);
		
	}

	private void mouseExitedBtnCerrar(MouseEvent e) {
		btnCerrar.setForeground(Color.WHITE);
		
	}

	protected void mouseExitedLblAqui(MouseEvent e) {
		lblAqui.setForeground(Color.WHITE);
	}
	protected void mouseEnteredBtnCerrar(MouseEvent e) {
		btnCerrar.setForeground(Color.blue);
	}
	protected void mouseEnteredBtnAceptar(MouseEvent e) {
		btnAceptar.setForeground(Color.BLUE);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblAqui) {
			mouseClickedLblAqui(e);
		}
	}
	
	void hilo(){
		HiloCerrar h=new HiloCerrar(this);
		h.start();
	}
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
	}
	public void windowDeactivated(WindowEvent arg0) {
	}
	public void windowDeiconified(WindowEvent arg0) {
	}
	public void windowIconified(WindowEvent arg0) {
	}
	public void windowOpened(WindowEvent arg0) {
		if (arg0.getSource() == this) {
			windowOpenedThis(arg0);
		}
	}
	protected void windowOpenedThis(WindowEvent arg0) {
		hilo();
	}
}
