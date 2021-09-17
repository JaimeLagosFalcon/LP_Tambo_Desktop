package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import mantenimientos.GestionCategorias;
import mantenimientos.GestionProductos;
import mantenimientos.GestionProveedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.TextArea;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

import model.Categoria;
import model.Producto;
import model.Proveedor;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmProducto extends JFrame implements WindowListener, MouseListener, ActionListener {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtStock;
	private JTextField txtDescripcion;
	private JTextField txtPrecio;
	DefaultTableModel modelo = new DefaultTableModel();
	private JLabel lblMantenimientoCliente;
	private JButton btnLimpiar;
	private JComboBox cboCategoria;
	private JComboBox cboProveedor;
	private JLabel lblVencimiento;
	private JDateChooser dateFecha;
	private JTable tbSalida;
	private JScrollPane scrollPane;
	private JLabel label;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProducto frame = new FrmProducto();
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
	public FrmProducto() {
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmProducto.class.getResource("/img/logo.png")));
		setTitle("Mantenimiento - Producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 699, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setForeground(Color.BLUE);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodigo.setBounds(10, 43, 94, 25);
		contentPane.add(lblCodigo);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setForeground(Color.BLUE);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescripcion.setBounds(10, 76, 106, 24);
		contentPane.add(lblDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.BLUE);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrecio.setBounds(10, 151, 94, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setForeground(Color.BLUE);
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStock.setBounds(10, 181, 94, 14);
		contentPane.add(lblStock);
		
		JLabel lblTipo = new JLabel("Categoria");
		lblTipo.setForeground(Color.BLUE);
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTipo.setBounds(10, 206, 94, 25);
		contentPane.add(lblTipo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(114, 47, 124, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(114, 175, 62, 20);
		contentPane.add(txtStock);
		txtStock.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(114, 80, 319, 20);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(114, 144, 124, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(Color.GREEN);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrarDatos();
			}
		});
		btnRegistrar.setBounds(535, 39, 106, 34);
		contentPane.add(btnRegistrar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBackground(Color.RED);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			eliminarProducto();
			}
		});
		btnEliminar.setBounds(535, 154, 106, 34);
		contentPane.add(btnEliminar);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setForeground(Color.BLUE);
		lblProveedor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProveedor.setBounds(10, 242, 117, 14);
		contentPane.add(lblProveedor);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(Color.BLUE);
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			actualizarProducto();
			}
		});
		btnActualizar.setBounds(535, 97, 106, 34);
		contentPane.add(btnActualizar);
		
		
		
		lblMantenimientoCliente = new JLabel("Mantenimiento de Producto");
		lblMantenimientoCliente.setForeground(Color.BLUE);
		lblMantenimientoCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMantenimientoCliente.setBounds(164, 11, 296, 20);
		contentPane.add(lblMantenimientoCliente);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpiar.setBackground(Color.ORANGE);
		btnLimpiar.setBounds(535, 215, 106, 34);
		contentPane.add(btnLimpiar);
		
		cboCategoria = new JComboBox();
		cboCategoria.setBounds(114, 205, 143, 20);
		contentPane.add(cboCategoria);
		
		cboProveedor = new JComboBox();
		cboProveedor.setBounds(114, 236, 143, 20);
		contentPane.add(cboProveedor);
		
		lblVencimiento = new JLabel("Vencimiento");
		lblVencimiento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVencimiento.setForeground(Color.BLUE);
		lblVencimiento.setBounds(10, 117, 94, 14);
		contentPane.add(lblVencimiento);
		
		dateFecha = new JDateChooser();
		dateFecha.setDateFormatString("yyyy/MM/dd");
		dateFecha.setBounds(113, 111, 125, 20);
		contentPane.add(dateFecha);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 267, 663, 197);
		contentPane.add(scrollPane);
		
		tbSalida = new JTable();
		tbSalida.addMouseListener(this);
		tbSalida.setModel(modelo);
		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Fecha. Vencimiento");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock");
		modelo.addColumn("Categoria");
		modelo.addColumn("Proveedor");
		scrollPane.setViewportView(tbSalida);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmProducto.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
		label.setBounds(-114, 0, 797, 475);
		contentPane.add(label);
		
		llenarCombo();
		llenarCombo2();
		ajustarAnchoColumnas();
		listado();
	}
	
	void llenarCombo2(){
		ArrayList<Proveedor> lstProveedor=new GestionProveedor().listado();
		
		if(lstProveedor==null){
			JOptionPane.showMessageDialog(this,"Lista vacia");
		}else{
			cboProveedor.addItem("Seleccione");
			
			for (Proveedor p : lstProveedor) {
				cboProveedor.addItem(p.getNom_prove());
				
			}
		}
	}
	
	void llenarCombo(){
		
		ArrayList<Categoria> lstCategoria=new GestionCategorias().listadoCategoria();
		
		if(lstCategoria==null){
			JOptionPane.showMessageDialog(this,"Lista vacia");
		}else{
			cboCategoria.addItem("Seleccione");
			
			for (Categoria c : lstCategoria) {
				cboCategoria.addItem(c.getDesc_cat());
				
			}
		}
	}
	
	void actualizarProducto(){
		
		
		String desc_prod;
		String fvenci;
		double prec_prod;
		int stock_prod;
		String cod_cate;
		String cod_prove;
		String cod_prod;
		
		desc_prod=leerDescripcion();
		fvenci=leerfecha();
		prec_prod=leerPrecio();
		stock_prod=leerStock();
		cod_cate=leerCategoria();
		cod_prove=leerProveedor();
	    cod_prod=leerCodProducto();
	    
	    Producto p=new Producto(cod_prod, desc_prod, fvenci, prec_prod, stock_prod, cod_cate, cod_prove);
	    
	    int ok=new GestionProductos().actualizar(p);
	    
	    if(ok==0){
			JOptionPane.showMessageDialog(this,"Error al actualizar - Verifique datos");
		}else{
			JOptionPane.showMessageDialog(this,"Producto Actualizado");
			listado();
			limpiar();
		}
	    
	}
	
	void eliminarProducto(){
		String cod_prod;
		cod_prod = leerCodProducto();
		int rs =  new GestionProductos().eliminar(cod_prod);
		// salidas
		if(rs==0){
			JOptionPane.showMessageDialog(this, "Error al eliminar-Codigo no existe");
		}else{
			JOptionPane.showMessageDialog(this, "Producto eliminado");
			listado();
			limpiar();
		}
	}
	
	void registrarDatos(){
		
		String cod_prod;
		String desc_prod;
		String fvenci;
		double prec_prod;
		int stock_prod;
		String cod_cate;
		String cod_prove;
		
		cod_prod=leerCodProducto();
		desc_prod=leerDescripcion();
		fvenci=leerfecha();
		prec_prod=leerPrecio();
		stock_prod=leerStock();
		cod_cate=leerCategoria();
		cod_prove=leerProveedor();
		
		Producto p=new Producto(cod_prod, desc_prod, fvenci, prec_prod, stock_prod, cod_cate, cod_prove);
		
		GestionProductos ge=new GestionProductos();
		
		int ok=ge.registrar(p);
		
		if (ok == 0){
			JOptionPane.showMessageDialog(this, "Error al registrar");
		} else {
			JOptionPane.showMessageDialog(this, "Producto "+ p.getCod_prod()+" Registrado!");
			limpiar();
			listado();
		}
		
	}

	private String leerProveedor() {
        String cod=null,d;
		
		if(cboProveedor.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(this,"Seleccione Proveedor");
		}else{
			int n;
			
			d="RUC";
			
			cod=cboProveedor.getSelectedIndex()+"";
			n=6-cod.length();
			for(int i=0;i<n;i++){
				d+="0";
			}
			cod=d+cod;
		}
		return cod;
		
	}

	private String leerCategoria() {
        String cod=null,d;
		
		if(cboCategoria.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(this,"Seleccione Categoria");
		}else{
			int n;
			
			d="CA";
			
			cod=cboCategoria.getSelectedIndex()+"";
			n=3-cod.length();
			for(int i=0;i<n;i++){
				d+="0";
			}
			cod=d+cod;
		}
		return cod;
		
	}

	private String leerfecha() {
		SimpleDateFormat sfd=new SimpleDateFormat("yyyy/MM/dd");
		if(dateFecha.getCalendar()!=null){
			return sfd.format(dateFecha.getDate());
		}else{
			JOptionPane.showMessageDialog(this,"Seleccione Fecha de Vencimiento");
			return null;
		}
		
	}

	private String leerDescripcion() {
		if(txtDescripcion.getText().trim().length()>0){
			return txtDescripcion.getText();
		}else{
			JOptionPane.showMessageDialog(this,"Complete Descripcion de Producto");
			return null;
		}
		
	}

	private double leerPrecio() {
		if(txtPrecio.getText().trim().matches("[0-9]{1,3}\\.[0-9]{1,3}")){
			return Double.parseDouble(txtPrecio.getText());
		}else{
			JOptionPane.showMessageDialog(this,"Formato de Precio Incorrecto");
			return 0;
		}
		
	}

	

	

	private int leerStock() {
		if(txtStock.getText().trim().matches("[0-9]+")){
			return Integer.parseInt(txtStock.getText());
		}else{
			JOptionPane.showMessageDialog(this,"Formato Stock Incorrecto");
			return 0;
		}
		
	}

	private String leerCodProducto() {
		return txtCodigo.getText().trim();
	}
	
	private String ObtenerProducto(){
		GestionProductos gestion=new GestionProductos();
		txtCodigo.setText(gestion.generarProducto());
		return txtCodigo.getText();
	}
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
	}
	public void windowClosing(WindowEvent arg0) {
	}
	public void windowDeactivated(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowIconified(WindowEvent e) {
	}
	public void windowOpened(WindowEvent e) {
		if (e.getSource() == this) {
			windowOpenedThis(e);
		}
	}
	protected void windowOpenedThis(WindowEvent e) {
		ObtenerProducto();
		
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbSalida.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(8));  // CODIGO
		tcm.getColumn(1).setPreferredWidth(anchoColumna(22));  // DESCRIPCION
		tcm.getColumn(2).setPreferredWidth(anchoColumna(13));  // VENCIMIENTO
		tcm.getColumn(3).setPreferredWidth(anchoColumna(3));  //PRECIO
		tcm.getColumn(4).setPreferredWidth(anchoColumna(3));  //STOCK
		tcm.getColumn(5).setPreferredWidth(anchoColumna(5));  //CATEGORIA
		tcm.getColumn(6).setPreferredWidth(anchoColumna(7));  //PROVEEDOR

		
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	private void listado(){
		
		ArrayList<Producto> lstProducto=new GestionProductos().listado();
		
		if(lstProducto==null){
			JOptionPane.showMessageDialog(this,"Lista vacia");
		}else{
			modelo.setRowCount(0);
			
			for (Producto p : lstProducto) {
				Object aDatos[]={p.getCod_prod(),
						         p.getDesc_prod(),
						         p.getFvenci(),
						         p.getPrec_prod(),
						         p.getStock_prod(),
						         p.getCod_cate(),
						         p.getCod_prove()};
				modelo.addRow(aDatos);
				
			}
		}
	}
	
	private void enviar(){
		
		int fila=tbSalida.getSelectedRow();
		
		String cod_prod=tbSalida.getValueAt(fila, 0).toString();
		String desc_prod=tbSalida.getValueAt(fila, 1).toString();
		String fvenci=tbSalida.getValueAt(fila, 2).toString();
		String prec_prod=tbSalida.getValueAt(fila, 3).toString();
		String stock_prod=tbSalida.getValueAt(fila, 4).toString();
		String cod_cate=tbSalida.getValueAt(fila, 5).toString();
		String cod_prove=tbSalida.getValueAt(fila, 6).toString();
		String c=cod_cate.substring(2);
		
		
		String p=cod_prove.substring(4);
		
		
		txtCodigo.setText(cod_prod);
		txtDescripcion.setText(desc_prod);
		Date d=StringaDate(fvenci);
		dateFecha.setDate(d);
		txtPrecio.setText(prec_prod);
		txtStock.setText(stock_prod);
		cboCategoria.setSelectedIndex(Integer.parseInt(c));
		cboProveedor.setSelectedIndex(Integer.parseInt(p));
	}
	
	public Date StringaDate(String fecha) {
		SimpleDateFormat formatodetexto= new SimpleDateFormat("yyyy/MM/dd");
		Date fechae=null;
		try {
			fechae=formatodetexto.parse(fecha);
			return fechae;
		} catch (Exception e) {
			return null;
		}
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tbSalida) {
			mouseClickedTbSalida(arg0);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTbSalida(MouseEvent arg0) {
		enviar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(arg0);
		}
	}
	protected void actionPerformedBtnLimpiar(ActionEvent arg0) {
		limpiar();
	}

	private void limpiar() {
		ObtenerProducto();
		txtDescripcion.setText("");
		dateFecha.setCalendar(null);
		txtPrecio.setText("");
		txtStock.setText("");
		cboCategoria.setSelectedIndex(0);
		cboProveedor.setSelectedIndex(0);
		
	}
}
