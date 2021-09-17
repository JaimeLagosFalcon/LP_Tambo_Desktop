package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionVenta;
import model.Boleta;
import model.DetalleBoleta;
import model.Empleado;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Panel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Button;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class BoletaTrans extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtNumeroB;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JPanel panel_1;
	public static JTextField txtCliente;
	public static JTextField txtNombre;
	private JPanel panel_2;
	private JLabel lblProducto;
	public static JTextField txtProducto;
	private JButton btnBuscar2;
	public static JTextField txtDescripcion;
	public static JTextField txtStock;
	public static JTextField txtPrecio;
	private JLabel lblCantidad;
	private JSpinner sCantidad;
	private JLabel lblTotal;
	private JTextField txtTotal;
	private JLabel lblNombre;
	private JButton btnBuscar1;
	private JTextField txtFecha;
	private JLabel labelx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoletaTrans frame = new BoletaTrans();
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
	public BoletaTrans() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BoletaTrans.class.getResource("/img/logo.png")));
		setTitle("Boleta de Compra");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelx = new JLabel("");
		labelx.setBounds(306, 73, 73, 24);
		contentPane.add(labelx);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(561, 451, 86, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotal.setBounds(481, 447, 54, 24);
		contentPane.add(lblTotal);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Datos de Producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(255, 215, 0));
		panel_2.setBounds(10, 162, 664, 99);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnAgregar = new JButton("");
		btnAgregar.setBackground(new Color(255, 215, 0));
		btnAgregar.addMouseListener(this);
		btnAgregar.addActionListener(this);
		btnAgregar.setIcon(new ImageIcon(BoletaTrans.class.getResource("/img/carrito-de-compras.png")));
		btnAgregar.setBounds(211, 61, 40, 27);
		panel_2.add(btnAgregar);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProducto.setBounds(10, 22, 62, 14);
		panel_2.add(lblProducto);
		
		txtProducto = new JTextField();
		txtProducto.setEditable(false);
		txtProducto.setBounds(100, 21, 86, 20);
		panel_2.add(txtProducto);
		txtProducto.setColumns(10);
		
		btnBuscar2 = new JButton("");
		btnBuscar2.setBackground(new Color(255, 215, 0));
		btnBuscar2.addMouseListener(this);
		btnBuscar2.addActionListener(this);
		btnBuscar2.setIcon(new ImageIcon(BoletaTrans.class.getResource("/img/busqueda-de-datos.png")));
		btnBuscar2.setBounds(211, 20, 40, 33);
		panel_2.add(btnBuscar2);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setBounds(261, 21, 278, 20);
		panel_2.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setEditable(false);
		txtStock.setBounds(614, 21, 40, 20);
		panel_2.add(txtStock);
		txtStock.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(549, 21, 55, 20);
		panel_2.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidad.setBounds(10, 59, 73, 14);
		panel_2.add(lblCantidad);
		
		sCantidad = new JSpinner();
		sCantidad.setBackground(Color.WHITE);
		sCantidad.setModel(new SpinnerNumberModel(0, 0, 500, 1));
		sCantidad.setBounds(100, 58, 40, 20);
		panel_2.add(sCantidad);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos de Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(new Color(255, 215, 0));
		panel_1.setBounds(10, 34, 286, 98);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnBuscar1 = new JButton("");
		btnBuscar1.setBackground(new Color(255, 215, 0));
		btnBuscar1.addMouseListener(this);
		btnBuscar1.addActionListener(this);
		btnBuscar1.setIcon(new ImageIcon(BoletaTrans.class.getResource("/img/busqueda-de-datos.png")));
		btnBuscar1.setBounds(209, 11, 44, 35);
		panel_1.add(btnBuscar1);
		
		JLabel lblCodigoCliente = new JLabel("Cliente");
		lblCodigoCliente.setBounds(10, 23, 77, 19);
		panel_1.add(lblCodigoCliente);
		lblCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setBounds(97, 24, 102, 20);
		panel_1.add(txtCliente);
		txtCliente.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(97, 55, 165, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(10, 58, 77, 14);
		panel_1.add(lblNombre);
		
		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(null, "Datos de Boleta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 215, 0));
		panel.setBounds(389, 34, 285, 108);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(94, 63, 130, 20);
		panel.add(txtFecha);
		txtFecha.setColumns(10);
		txtFecha.setText(fecha());
		
		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setBounds(10, 24, 52, 19);
		panel.add(lblNumero);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtNumeroB = new JTextField();
		txtNumeroB.setEditable(false);
		txtNumeroB.setBounds(94, 25, 130, 20);
		panel.add(txtNumeroB);
		txtNumeroB.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 62, 39, 19);
		panel.add(lblFecha);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnGuardar = new JButton("Generar Compra");
		btnGuardar.setBackground(new Color(139, 0, 139));
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(166, 442, 167, 34);
		contentPane.add(btnGuardar);
		
		btnConsultar = new JButton("Nueva Compra");
		btnConsultar.setBackground(new Color(139, 0, 139));
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(10, 444, 146, 34);
		contentPane.add(btnConsultar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 272, 664, 154);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setBackground(Color.WHITE);
		txtS.setEditable(false);
		scrollPane.setViewportView(txtS);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(BoletaTrans.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
		lblNewLabel_1.setBounds(-106, 0, 790, 515);
		contentPane.add(lblNewLabel_1);
		
		
		generarBoleta();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
		if (arg0.getSource() == btnBuscar2) {
			actionPerformedBtnBuscar2(arg0);
		}
		if (arg0.getSource() == btnBuscar1) {
			actionPerformedBtnBuscar1(arg0);
		}
	}
	protected void actionPerformedBtnBuscar1(ActionEvent arg0) {
		DialogCliente dc=new DialogCliente();
		dc.setVisible(true);
		dc.setLocationRelativeTo(this);
	}
	protected void actionPerformedBtnBuscar2(ActionEvent arg0) {
		if(txtCliente.getText().length()==0){
			JOptionPane.showMessageDialog(this,"Seleccione Cliente");
		}else{
			DialogProducto dp=new DialogProducto();
		    dp.setVisible(true);
		    dp.setLocationRelativeTo(this);
		}
		
	}
	
	void generarBoleta(){
		GestionVenta g=new GestionVenta();
		txtNumeroB.setText(g.generarBoleta());
	}
	
	public String fecha(){
		Date fecha=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(fecha);
		
	}
	
	public String hora(){
		Date hora=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		return sdf.format(hora);
	}
	double total=0;
	private JTextArea txtS;
	private JButton btnAgregar;
	
	
	ArrayList<DetalleBoleta> carrito=new ArrayList<DetalleBoleta>();
	private JButton btnGuardar;
	private JButton btnConsultar;
	
	
	private void agregarProductos(){
		
		try {
			/*VARIABLES*/
			String cod_prod,desc_prod;
			double prec_prod,importetotal;
			int stock_prod,cant_prod;
			
			/*ENTRADAS*/
			cod_prod=leerCodProd();
			desc_prod=leerDescripcion();
			prec_prod=leerPrecio();
			stock_prod=leerStock();
			cant_prod=leerCantidad();
			
			if(stock_prod<cant_prod){
				JOptionPane.showMessageDialog(this,"Cantidad Insuficiente");
				sCantidad.setValue(0);
				return;
			}
			
			
			if(cant_prod==0){
				JOptionPane.showMessageDialog(this,"Seleccione Cantidad");
				sCantidad.setValue(0);
				return;
			}
			importetotal=prec_prod*cant_prod;
			total +=importetotal;
			
			//txtS.setText("CODIGO"+"\t"+"DESCRIPCION"+"\t\t"+"CANTIDAD"+"\t"+"PRECIO"+"\t"+"IMPORTE"+"\n");	
			txtS.append(cod_prod+"\t"+desc_prod+"\t\t"+cant_prod+"\t"+prec_prod+"\t"+String.format("%.2f",importetotal)+"\n");
			txtTotal.setText(String.format("%.2f",total));
		
				DetalleBoleta d=new DetalleBoleta(null, cod_prod, cant_prod, prec_prod, importetotal);
			
				carrito.add(d);
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Seleccione Producto");
			sCantidad.setValue(0);
		}
	
		
	}

	private int leerCantidad() {
		if(sCantidad.getValue().toString()=="0"){
			JOptionPane.showMessageDialog(this,"Eliga cantidad");
			return -1;
		}else{
			return Integer.parseInt(sCantidad.getValue().toString());
		}
		
	}

	private int leerStock() {
		return Integer.parseInt(txtStock.getText());
	}

	private double leerPrecio() {
		
		return Double.parseDouble(txtPrecio.getText());
	}

	private String leerDescripcion() {		
		return txtDescripcion.getText();
	}

	private String leerCodProd() {
		
		return txtProducto.getText();
	}
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		agregarProductos();
	}
	protected void actionPerformedBtnGuardar(ActionEvent arg0) {
		generarCompra();
	}

	
	private void generarCompra() {
		
		String num_bolet,fec_bolet,hor_bolet,cod_cli;
		String cod_emple;
		double tot_bol;
		
		num_bolet=leerNumero();
		fec_bolet=leerFecha();
		hor_bolet=leerHora();
		cod_cli=leerCliente();
		cod_emple=leerEmpleado();
		tot_bol=leerTotal();
		
		Boleta b=new Boleta(num_bolet, fec_bolet, hor_bolet, cod_cli, cod_emple, tot_bol);
		
		int rs=new GestionVenta().realizarVenta(b, carrito);
		
		if(rs==0){
			JOptionPane.showMessageDialog(this,"ERROR DE TRANSACCION");
		}else{
			JOptionPane.showMessageDialog(this,"TRANSACCION OK");
			nuevaBoleta();
		}
	}

	private double leerTotal() {
		
		return Double.parseDouble(txtTotal.getText());
	}

	private String leerEmpleado() {
		
		String usuario;
		
		usuario=LogueoTambo.mnu.getUsuario();
		
		Empleado e=new GestionVenta().buscar(usuario);
		
		
		return e.getCod_emple();
		
		
	}

	

	private String leerCliente() {
		return txtCliente.getText();
	}

	private String leerHora() {
		
		return hora();
	}

	private String leerFecha() {
		
		return txtFecha.getText();
	}

	private String leerNumero() {
		return txtNumeroB.getText();
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		nuevaBoleta();
	}

	private void nuevaBoleta() {
		txtCliente.setText("");
		txtDescripcion.setText("");
		fecha();
		txtNombre.setText("");
		generarBoleta();
		txtPrecio.setText("");
		txtProducto.setText("");
		txtS.setText("");
		txtStock.setText("");
		txtTotal.setText("");
		sCantidad.setValue(0);
		total=0;
		carrito=new ArrayList<DetalleBoleta>();
	}
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnAgregar) {
			mouseEnteredBtnAgregar(arg0);
		}
		if (arg0.getSource() == btnBuscar2) {
			mouseEnteredBtnBuscar2(arg0);
		}
		if (arg0.getSource() == btnBuscar1) {
			mouseEnteredBtnBuscar1(arg0);
		}
	}
	
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseEnteredBtnBuscar1(MouseEvent arg0) {
		btnBuscar1.setBackground(Color.GREEN);
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnAgregar) {
			mouseExitedBtnAgregar(e);
		}
		if (e.getSource() == btnBuscar2) {
			mouseExitedBtnBuscar2(e);
		}
		if (e.getSource() == btnBuscar1) {
			mouseExitedBtnBuscar1(e);
		}
	}
	private void mouseExitedBtnAgregar(MouseEvent e) {
		btnAgregar.setBackground(null);
		
	}

	private void mouseExitedBtnBuscar2(MouseEvent e) {
		btnBuscar2.setBackground(null);
		
	}

	protected void mouseExitedBtnBuscar1(MouseEvent e) {
		btnBuscar1.setBackground(null);
	}
	protected void mouseEnteredBtnBuscar2(MouseEvent arg0) {
		btnBuscar2.setBackground(Color.GREEN);
	}
	protected void mouseEnteredBtnAgregar(MouseEvent arg0) {
		btnAgregar.setBackground(Color.GREEN);
	}
}
