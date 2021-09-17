package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import mantenimientos.GestionCliente;
import mantenimientos.GestionProveedor;
import model.Distrito;
import model.Proveedor;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class FrmProveedor extends JFrame implements ActionListener, WindowListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblCorreo;
	private JLabel lblNewLabel;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JTable tbSalida;
	private JScrollPane scrollPane;
	
	DefaultTableModel modelo=new DefaultTableModel();
	private JComboBox cboDistrito;
	private JLabel lblDsitrito;
	private JLabel lblMantenimientoDeProveedor;
	private JButton btnLimpiar;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProveedor frame = new FrmProveedor();
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
	public FrmProveedor() {
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmProveedor.class.getResource("/img/logo.png")));
		setTitle("Mantenimiento - Proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 686, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setForeground(Color.BLUE);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodigo.setBounds(20, 68, 86, 19);
		contentPane.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.BLUE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(20, 98, 86, 14);
		contentPane.add(lblNombre);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(Color.BLUE);
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCorreo.setBounds(20, 129, 68, 14);
		contentPane.add(lblCorreo);
		
		lblNewLabel = new JLabel("Telefono");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 160, 86, 14);
		contentPane.add(lblNewLabel);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(105, 69, 115, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(105, 97, 269, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(105, 128, 269, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(105, 159, 141, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(Color.GREEN);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(496, 48, 115, 39);
		contentPane.add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(Color.BLUE);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(496, 104, 115, 39);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.RED);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(496, 154, 115, 39);
		contentPane.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 256, 650, 199);
		contentPane.add(scrollPane);
		
		tbSalida = new JTable();
		tbSalida.addMouseListener(this);
		tbSalida.setModel(modelo);
		modelo.addColumn("Codigo ");
		modelo.addColumn("Nombre ");
		modelo.addColumn("Correo ");
		modelo.addColumn("Telefono ");
		modelo.addColumn("Distrito");
		scrollPane.setViewportView(tbSalida);
		
		cboDistrito = new JComboBox();
		cboDistrito.setBounds(105, 193, 141, 20);
		contentPane.add(cboDistrito);
		
		lblDsitrito = new JLabel("Distrito");
		lblDsitrito.setForeground(Color.BLUE);
		lblDsitrito.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDsitrito.setBounds(20, 194, 71, 14);
		contentPane.add(lblDsitrito);
		
		lblMantenimientoDeProveedor = new JLabel("Mantenimiento de Proveedor");
		lblMantenimientoDeProveedor.setForeground(Color.BLUE);
		lblMantenimientoDeProveedor.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMantenimientoDeProveedor.setBounds(196, 11, 321, 20);
		contentPane.add(lblMantenimientoDeProveedor);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setBackground(Color.ORANGE);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpiar.setBounds(496, 206, 115, 39);
		contentPane.add(btnLimpiar);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmProveedor.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
		label.setBounds(-115, 0, 785, 466);
		contentPane.add(label);
		
		listado();
		ajustarAnchoColumnas();
		llenarCombo();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(arg0);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent arg0) {
		ingresar();
	}

	private void ingresar() {
		
		/*VARIABLES*/
		String cod_dist,telef_prove;
		String nom_prove, correo_prove, cod_prove;
		 
		
		/*ENTRADAS*/
		cod_prove=leerCodigo();
		nom_prove=leerNombre();
		correo_prove=leerCorreo();
		telef_prove=leerTelefono();
		cod_dist=leerDistrito();
		
		Proveedor p=new Proveedor(cod_prove, nom_prove, correo_prove, telef_prove, cod_dist);
		
		GestionProveedor ge=new GestionProveedor();
		
		int ok=ge.registrar(p);
		
		if(ok==0){
			JOptionPane.showMessageDialog(this,"Error al Registrar");
		}else{
			JOptionPane.showMessageDialog(this, "Producto "+p.getNom_prove()+" Registrado!");
			limpiar();
			listado();
		}
		
		
	}

	private String leerDistrito() {
        String cod=null,d;
		
		if(cboDistrito.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(this,"Seleccione Distrito");
		}else{
			int n;
			
			d="D";
			
			cod=cboDistrito.getSelectedIndex()+"";
			n=4-cod.length();
			for(int i=0;i<n;i++){
				d+="0";
			}
			cod=d+cod;
		}
		return cod;
	}

	private String leerTelefono() {
		String n="+51 - ";
		if(txtTelefono.getText().trim().matches("[0-9]{7}")){
			return n+txtTelefono.getText();
		}else if(txtTelefono.getText().trim().matches("[0-9]{9}")){
			return txtTelefono.getText();		
		}else{
			JOptionPane.showMessageDialog(this,"Solo telefono fijo valido","AVISO TELEFONO",2);
			return null;
		}	
	}

	private String leerCorreo() {
		
			if(txtCorreo.getText().trim().matches("[_a-z0-9-]+(\\.[_a-z0-9-]+)*@hotmail(\\.com){0,1}")){
				return txtCorreo.getText().trim();
			}else{
				JOptionPane.showMessageDialog(this,"Formato de Correo no Valido","AVISO CORREO",2);
				return null;			
			}
		
	}

	private String leerNombre() {
		if(txtNombre.getText().trim().matches("[A-Za-z]+")){
			return txtNombre.getText().trim();
		}else if(txtNombre.getText().trim().length()==0){
			JOptionPane.showMessageDialog(this,"Nombre Vacio","Aviso",2);
			return null;
		}else{
			JOptionPane.showMessageDialog(this,"Formato de Nombre Incorrecto","Aviso",2);
			return null;
		}
	}
	
	private String leerCodigo() {
		return txtCodigo.getText();
	}
	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
		actualizarProveedor();
	}

	private void actualizarProveedor() {
		/*VARIABLES*/
		String cod_dist,telef_prove;
		String nom_prove, correo_prove, cod_prove;
		 
		
		/*ENTRADAS*/
		cod_prove=leerCodigo();
		nom_prove=leerNombre();
		correo_prove=leerCorreo();
		telef_prove=leerTelefono();
		cod_dist=leerDistrito();
		
		Proveedor p=new Proveedor(cod_prove, nom_prove, correo_prove, telef_prove, cod_dist);
		
		int ok=new GestionProveedor().actualizar(p);
		
		if(ok==0){
			JOptionPane.showMessageDialog(this,"Error al actualizar - Verifique datos");
		}else{
			JOptionPane.showMessageDialog(this,"Producto Actualizado");
			listado();
			limpiar();
		}
		
	
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarProveedor();
	}

	private void eliminarProveedor() {
		String cod_prove;
		
		/*ENTRADA*/
		cod_prove=leerCodigo();
		
		/*PROCESO*/
		int rs=new GestionProveedor().eliminar(cod_prove);
		
		if(rs==0){
			JOptionPane.showMessageDialog(this,"Error al eliminar - codigo no existe");
		}else{
			JOptionPane.showMessageDialog(this,"Proveedor eliminado");
		}
		
		
		
	}
	
	private void listado(){
		ArrayList<Proveedor> lstProveedor=new GestionProveedor().listado();
		
		if(lstProveedor==null){
			JOptionPane.showMessageDialog(this,"Lista Vacia");
		}else{
			modelo.setRowCount(0);
			
			for (Proveedor p : lstProveedor) {
				Object aDatos[]={p.getCod_prove(),
						         p.getNom_prove(),
						         p.getCorreo_prove(),
						         p.getTelef_prove(),
						         p.getCod_dist()};
				
				modelo.addRow(aDatos);
				
				
			}
		}
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbSalida.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(5));  // CODIGO
		tcm.getColumn(1).setPreferredWidth(anchoColumna(8));  // NOMBRE
		tcm.getColumn(2).setPreferredWidth(anchoColumna(22));  // CORREO
		tcm.getColumn(3).setPreferredWidth(anchoColumna(3));  //TELEFONO
		tcm.getColumn(4).setPreferredWidth(anchoColumna(3));  //DISTRITO
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	private void obtenerProveedor(){
		GestionProveedor ge=new GestionProveedor();
		txtCodigo.setText(ge.generarProveedor());
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
		obtenerProveedor();
	}
	protected void actionPerformedBtnLimpiar(ActionEvent arg0) {
		limpiar();
		
	}
	
	private void limpiar() {
		obtenerProveedor();
		txtNombre.setText("");
		txtCorreo.setText("");
		txtTelefono.setText("");
		cboDistrito.setSelectedIndex(0);
		
	}

	private void llenarCombo(){
		ArrayList<Distrito> lstDistrito=new GestionCliente().listadoDistrito();
		
		if(lstDistrito==null){
			JOptionPane.showMessageDialog(this,"Lista Vacia");
		}else{
			cboDistrito.addItem("Seleccione");
			
			for (Distrito d : lstDistrito) {
				cboDistrito.addItem(d.getDesc_dist());
				
			}
			
		}
	}
	
	private void enviar(){
		
		int fila=tbSalida.getSelectedRow();
		
		String cod_dist=tbSalida.getValueAt(fila, 0).toString();
		String telef_prove=tbSalida.getValueAt(fila, 1).toString();
		String nom_prove=tbSalida.getValueAt(fila, 2).toString();
		String correo_prove=tbSalida.getValueAt(fila, 3).toString();
		String cod_prove=tbSalida.getValueAt(fila, 4).toString();
		String m=cod_dist.substring(3);
		
		
		if(telef_prove.length()==13){
			txtTelefono.setText(telef_prove.substring(7));
		}else
			txtTelefono.setText(telef_prove);
		txtCodigo.setText(cod_prove);
		txtCorreo.setText(correo_prove);
		
		txtNombre.setText(nom_prove);
		cboDistrito.setSelectedIndex(Integer.parseInt(m));
	}
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tbSalida) {
			mouseClickedTbSalida(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTbSalida(MouseEvent arg0) {
		enviar();
	}
}
