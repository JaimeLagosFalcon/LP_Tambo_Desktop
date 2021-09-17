package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Principal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem mntmEmpleado;
	private JMenuItem mntmEmpleado_1;
	private JMenuItem mntmSalir;
	private JMenuItem mntmProveedor;
	private JMenuItem mntmVentas;
	private JMenuItem mntmUsuarios;
	private JMenuItem mntmBoleta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		
		
		setTitle("Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 589);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setSelected(true);
		mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmSalir.setIcon(new ImageIcon(Principal.class.getResource("/img/logout (1).png")));
		mnSistema.add(mntmSalir);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setIcon(new ImageIcon(Principal.class.getResource("/img/cliente.png")));
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//LLAMO A LA VENTANA CLIENTE
				FrmCliente c = new FrmCliente();
				c.setVisible(true);
				c.setLocationRelativeTo(mntmCliente);
				
			}
		});
		mnMantenimiento.add(mntmCliente);
		
		JMenuItem mntmProducto = new JMenuItem("Producto");
		mntmProducto.setIcon(new ImageIcon(Principal.class.getResource("/img/caja.png")));
		mntmProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//LLAMO A LA VENTANA PRODUCTO
				FrmProducto p = new FrmProducto();
				p.setVisible(true);
				p.setLocationRelativeTo(mntmProducto);
				
			}
		});
		mnMantenimiento.add(mntmProducto);
		
		mntmProveedor = new JMenuItem("Proveedor");
		mntmProveedor.addActionListener(this);
		mntmProveedor.setIcon(new ImageIcon(Principal.class.getResource("/img/inventario.png")));
		mnMantenimiento.add(mntmProveedor);
		
		mntmEmpleado = new JMenuItem("Empleado");
		mntmEmpleado.setIcon(new ImageIcon(Principal.class.getResource("/img/empleados.png")));
		mntmEmpleado.addActionListener(this);
		mnMantenimiento.add(mntmEmpleado);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmCliente_1 = new JMenuItem("Cliente");
		mntmCliente_1.setIcon(new ImageIcon(Principal.class.getResource("/img/cliente.png")));
		mntmCliente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaCliente cc = new ConsultaCliente();
				cc.setVisible(true);
				cc.setLocationRelativeTo(mntmCliente_1);
				
			}
		});
		mnConsulta.add(mntmCliente_1);
		
		JMenuItem mntmProveedor_1 = new JMenuItem("Proveedor");
		mntmProveedor_1.setIcon(new ImageIcon(Principal.class.getResource("/img/inventario.png")));
		mntmProveedor_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaProveedor cp = new ConsultaProveedor();
				cp.setVisible(true);
				cp.setLocationRelativeTo(mntmProveedor_1);
				
			}
		});
		mnConsulta.add(mntmProveedor_1);
		
		JMenuItem mntmProveedor_2 = new JMenuItem("Producto");
		mntmProveedor_2.setIcon(new ImageIcon(Principal.class.getResource("/img/caja.png")));
		mntmProveedor_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaProducto cp = new ConsultaProducto();
				cp.setVisible(true);
				cp.setLocationRelativeTo(null);
				
			}
		});
		mnConsulta.add(mntmProveedor_2);
		
		mntmEmpleado_1 = new JMenuItem("Empleado");
		mntmEmpleado_1.addActionListener(this);
		mntmEmpleado_1.setIcon(new ImageIcon(Principal.class.getResource("/img/empleados.png")));
		mnConsulta.add(mntmEmpleado_1);
		
		mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.addActionListener(this);
		mntmUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/usuario.png")));
		mnConsulta.add(mntmUsuarios);
		
		JMenu mnTransaccion = new JMenu("Transaccion");
		mnTransaccion.addMouseListener(new MouseAdapter() {
			
			
		});
		menuBar.add(mnTransaccion);
		
		mntmBoleta = new JMenuItem("Boleta");
		mntmBoleta.addActionListener(this);
		mntmBoleta.setIcon(new ImageIcon(Principal.class.getResource("/img/caja-registradora.png")));
		mnTransaccion.add(mntmBoleta);
		
		JMenu mnReporte = new JMenu("Reporte");
		mnReporte.addMouseListener(new MouseAdapter() {
			
		});
		menuBar.add(mnReporte);
		
		mntmVentas = new JMenuItem("Ventas");
		mntmVentas.addActionListener(this);
		mntmVentas.setIcon(new ImageIcon(Principal.class.getResource("/img/bienes.png")));
		mnReporte.add(mntmVentas);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
		lblNewLabel.setBounds(-112, 0, 867, 540);
		contentPane.add(lblNewLabel);
		
		//if(LogueoTambo.mnu.getId_tipo()=="T0001"){
			//mntmUsuarios.setVisible(false);
		//}else if(LogueoTambo.mnu.getId_tipo()=="T0002"){
		//	mnMantenimiento.setVisible(false);
			//mntmCliente_1.setVisible(false);
			//mntmProveedor_1.setVisible(false);
			//mntmEmpleado_1.setVisible(false);
			//mntmUsuarios.setVisible(false);
			//mnTransaccion.setVisible(false);
			//mnReporte.setVisible(false);
		//}else if(LogueoTambo.mnu.getId_tipo()=="T0003"){
			//mntmUsuarios.setVisible(false);
			//mnReporte.setVisible(false);
		//}else{
			//mnTransaccion.setVisible(false);
		//}
		
		switch(LogueoTambo.mnu.getId_tipo()){
		case "T0001":/*ADMINISTRADOR*/
			mntmUsuarios.setVisible(false);
			break;
		case "T0002":/*CLIENTE*/
			mnMantenimiento.setVisible(false);
			mntmCliente_1.setVisible(false);
			mntmProveedor_1.setVisible(false);
			mntmEmpleado_1.setVisible(false);
			mntmUsuarios.setVisible(false);
			mnTransaccion.setVisible(false);
			mnReporte.setVisible(false);
			break;
		case "T0003":/*	CAJERO*/
			mntmUsuarios.setVisible(false);
			mnReporte.setVisible(false);
			break;
		default:
			mnTransaccion.setVisible(false);
			break;
		}
		
		
		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmVentas) {
			actionPerformedMntmVentas(arg0);
		}
		if (arg0.getSource() == mntmBoleta) {
			actionPerformedMntmBoleta(arg0);
		}
		if (arg0.getSource() == mntmUsuarios) {
			actionPerformedMntmUsuarios(arg0);
		}
		if (arg0.getSource() == mntmEmpleado_1) {
			actionPerformedMntmEmpleado_1(arg0);
		}
		if (arg0.getSource() == mntmProveedor) {
			actionPerformedMntmProveedor(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
		if (arg0.getSource() == mntmEmpleado) {
			actionPerformedMntmEmpleado(arg0);
		}
	}
	protected void actionPerformedMntmEmpleado(ActionEvent arg0) {
		FrmEmpleado e = new FrmEmpleado();
		e.setVisible(true);
		e.setLocationRelativeTo(mntmEmpleado);
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedMntmProveedor(ActionEvent arg0) {
		FrmProveedor p=new FrmProveedor();
		p.setVisible(true);
		p.setLocationRelativeTo(mntmProveedor);

	}
	protected void actionPerformedMntmEmpleado_1(ActionEvent arg0) {
		ConsultaEmpleado ce=new ConsultaEmpleado();
		ce.setVisible(true);
		ce.setLocationRelativeTo(mntmEmpleado_1);
	}
	protected void actionPerformedMntmUsuarios(ActionEvent arg0) {
		ConsultaUsuarios cu=new ConsultaUsuarios();
		cu.setVisible(true);
		cu.setLocationRelativeTo(mntmUsuarios);
	}
	protected void actionPerformedMntmBoleta(ActionEvent arg0) {
		BoletaTrans bt=new BoletaTrans();
		bt.setVisible(true);
		bt.setLocationRelativeTo(mntmBoleta);
	}
	protected void actionPerformedMntmVentas(ActionEvent arg0) {
		Reportes r=new Reportes();
		r.setVisible(true);
		r.setLocationRelativeTo(mntmVentas);
	}
}
