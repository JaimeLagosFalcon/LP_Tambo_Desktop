package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionCliente;
import model.Cliente;
import model.Distrito;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class FrmCliente extends JFrame implements ActionListener, WindowListener, MouseListener {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JLabel lblTelefono;
	private JComboBox cboDistrito;
	private JLabel lblDistrito;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JLabel lblMantenimientoDeCliente;
	private JLabel lblFchnacimiento;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JDateChooser dateFecha;
	private JButton btnLimpiar;
	private JTable tbSalida;
	private JScrollPane scrollPane;
	private JButton btnAgregar;
	DefaultTableModel modelo=new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCliente frame = new FrmCliente();
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
	public FrmCliente() {
		addWindowListener(this);
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		setTitle("Mantenimiento - Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCliente.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 796, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAgregar = new JButton("Registrar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBackground(new Color(50, 205, 50));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setBounds(634, 21, 113, 30);
		contentPane.add(btnAgregar);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodigo.setBackground(Color.WHITE);
		lblCodigo.setForeground(Color.BLUE);
		lblCodigo.setBounds(24, 57, 73, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setForeground(Color.BLUE);
		lblNombre.setBounds(24, 87, 73, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellido.setForeground(Color.BLUE);
		lblApellido.setBounds(24, 120, 73, 14);
		contentPane.add(lblApellido);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(107, 51, 135, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(Color.BLUE);
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCorreo.setBounds(24, 152, 73, 14);
		contentPane.add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(107, 146, 217, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(434, 56, 158, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setForeground(Color.BLUE);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTelefono.setBounds(292, 57, 73, 14);
		contentPane.add(lblTelefono);
		
		cboDistrito = new JComboBox();
		cboDistrito.setBounds(434, 86, 158, 20);
		contentPane.add(cboDistrito);
		
		lblDistrito = new JLabel("Distrito");
		lblDistrito.setForeground(Color.BLUE);
		lblDistrito.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDistrito.setBounds(292, 87, 73, 14);
		contentPane.add(lblDistrito);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBackground(new Color(65, 105, 225));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setBounds(634, 72, 113, 30);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setForeground(Color.WHITE);
		
		btnEliminar.setBounds(634, 120, 113, 30);
		contentPane.add(btnEliminar);
		
		lblMantenimientoDeCliente = new JLabel("Mantenimiento de Cliente");
		lblMantenimientoDeCliente.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMantenimientoDeCliente.setForeground(Color.BLUE);
		lblMantenimientoDeCliente.setBounds(219, 11, 302, 23);
		contentPane.add(lblMantenimientoDeCliente);
		
		lblFchnacimiento = new JLabel("Nacimiento");
		lblFchnacimiento.setForeground(Color.BLUE);
		lblFchnacimiento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFchnacimiento.setBounds(292, 120, 152, 14);
		contentPane.add(lblFchnacimiento);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(107, 82, 135, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(107, 114, 135, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		dateFecha = new JDateChooser();
		dateFecha.setDateFormatString("yyyy/MM/dd");
		dateFecha.setBounds(434, 120, 158, 20);
		contentPane.add(dateFecha);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBackground(new Color(255, 204, 0));
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setBounds(634, 163, 113, 30);
		contentPane.add(btnLimpiar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 200, 760, 202);
		contentPane.add(scrollPane);
		
		tbSalida = new JTable();
		tbSalida.addMouseListener(this);
		tbSalida.setModel(modelo);
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Fecha Nacimiento");
		modelo.addColumn("Correo");
		modelo.addColumn("Telefono");
		modelo.addColumn("Distrito");
		
		scrollPane.setViewportView(tbSalida);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmCliente.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
		label.setBounds(-95, 0, 875, 413);
		contentPane.add(label);
		
		llenarCombo();
		ObtenerCodigoCliente();
		ajustarAnchoColumnas();
		
	}
	
	void llenarCombo(){
		
		ArrayList<Distrito> lstDistrito=new GestionCliente().listadoDistrito();
		
		if(lstDistrito==null){
			JOptionPane.showMessageDialog(this,"El combo box no posee datos");
		}else{
			
			cboDistrito.addItem("Seleccione");
			
			for (Distrito d : lstDistrito) {
				cboDistrito.addItem(d.getDesc_dist());
			}
		}
	}
	
	private String ObtenerCodigoCliente(){
		GestionCliente gestion=new GestionCliente();
		txtCodigo.setText(gestion.generarCliente());
		return txtCodigo.getText();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
	}
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		agregarCliente();
	}

	private void agregarCliente() {
		/*VARIABLES*/
		String cod_cli;
		String nom_cli;
		String apell_cli;
		String fnacim;
		String correo_cli;
		String telef_cli;
		String cod_dist;
		
		/*ENTRADAS*/
		cod_cli=leerCodigo();
		nom_cli=leerNombre();
		apell_cli=leerApellido();
		fnacim=leerFecha();
		correo_cli=leerCorreo();
		telef_cli=leerTelefono();
		cod_dist=leerDistrito();
		
		Cliente c=new Cliente(cod_cli, null,null, nom_cli, apell_cli, fnacim, correo_cli, telef_cli, cod_dist);
		
		GestionCliente gu=new GestionCliente();
		
		int ok=gu.registrar(c);
		
		if (ok == 0){
			JOptionPane.showMessageDialog(this, "Error al registrar");
		} else {
			JOptionPane.showMessageDialog(this, "Usuario " + c.getNom_cli()+" "+c.getApell_cli()+" Registrado!");
			limpiarCliente();
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
		if(txtTelefono.getText().trim().matches("[0-9]{9}")){
			return txtTelefono.getText();
		}else if(txtTelefono.getText().trim().matches("[0-9]{7}")){
			return n+txtTelefono.getText();
		}else{
			JOptionPane.showMessageDialog(this,"Formato de Telefono No Valido");
			return null;
		}
		
	}

	private String leerCorreo() {
		if(txtCorreo.getText().trim().matches("[_a-z0-9-]+(\\.[_a-z0-9-]+)*@hotmail(\\.com)")){
			return txtCorreo.getText();
		}else{
			JOptionPane.showMessageDialog(this,"Formato de Correo no valido");
			return null;
		}
		
	}

	private String leerFecha() {
		SimpleDateFormat sfd=new SimpleDateFormat("yyyy/MM/dd");
		if(dateFecha.getCalendar()!=null){
			return sfd.format(dateFecha.getDate());
		}else{
			JOptionPane.showMessageDialog(this,"Seleccione Fecha de Nacimiento");
			return null;
		}
	}

	private String leerApellido() {
		if(txtApellido.getText().trim().length()>0){
			return txtApellido.getText();
		}else{
			JOptionPane.showMessageDialog(this,"Complete Apellido de Cliente");
			return null;
		}
	}

	private String leerNombre() {
		if(txtNombre.getText().trim().length()>0){
			return txtNombre.getText();
		}else{
			JOptionPane.showMessageDialog(this,"Complete Nombre de Cliente");
			return null;
		}
		
	}

	

	

	private String leerCodigo() {
		
		return txtCodigo.getText();
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbSalida.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(8));  // CODIGO
		tcm.getColumn(1).setPreferredWidth(anchoColumna(10));  //NOMBRE
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10));  //APELLIDO
		tcm.getColumn(3).setPreferredWidth(anchoColumna(13));  //NACIMIENTO
		tcm.getColumn(4).setPreferredWidth(anchoColumna(23));  //CORREO
		tcm.getColumn(5).setPreferredWidth(anchoColumna(10));  //TELEFONO
		tcm.getColumn(6).setPreferredWidth(anchoColumna(6));  //DISTRITO
		
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	private void listado(){
		ArrayList<Cliente> lstCliente=new GestionCliente().listadoCliente();
		
		if(lstCliente==null){
			JOptionPane.showMessageDialog(this,"Lista vacia");
		}else{
			modelo.setRowCount(0);
			for (Cliente cl : lstCliente) {
				Object aDatos[]={cl.getCod_cli(),
						         cl.getNom_cli(),
						         cl.getApell_cli(),
						         cl.getFnacim(),
						         cl.getCorreo_cli(),
						         cl.getTelef_cli(),
						         cl.getCod_dist()};
				modelo.addRow(aDatos);
				
			}
			
		}
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
		listado();
		
	}
	
	private void enviar(){
		
		int file=tbSalida.getSelectedRow();
		
		String codigo= tbSalida.getValueAt(file, 0).toString();
		String nombre=tbSalida.getValueAt(file, 1).toString();
		String apellido=tbSalida.getValueAt(file, 2).toString();
		String fec=tbSalida.getValueAt(file, 3).toString();
		String correo=tbSalida.getValueAt(file, 4).toString();
		String telefono=tbSalida.getValueAt(file, 5).toString();
		String distrito=tbSalida.getValueAt(file, 6).toString(); 
		String m=distrito.substring(1);
		
		if(telefono.length()==13){
			txtTelefono.setText(telefono.substring(6));
		}else{
			txtTelefono.setText(telefono);
		}
		
		txtCodigo.setText(codigo);
		txtNombre.setText(nombre);
		txtApellido.setText(apellido);
		Date d=StringaDate(fec);
		dateFecha.setDate(d);
		txtCorreo.setText(correo);
		
		cboDistrito.setSelectedIndex(Integer.parseInt(m));
		
		
		
		
		
		
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
	protected void actionPerformedBtnLimpiar(ActionEvent arg0) {
		limpiarCliente();
	}

	private void limpiarCliente() {
		ObtenerCodigoCliente();
		txtNombre.setText("");
		txtApellido.setText("");
		txtCorreo.setText("");
		txtTelefono.setText("");
		dateFecha.setCalendar(null);
		cboDistrito.setSelectedIndex(0);
		
	}
	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
		actualizarCliente();		
	}
	
	Cliente c=new Cliente();
	private JLabel label;
			

	private void actualizarCliente() {
		
		try {
			String cod_cli;
			String nom_cli;
			String apell_cli;
			String fnacim;
			String correo_cli;
			String telef_cli;
			String cod_dist;
			
			/*ENTRADAS*/
			cod_cli=leerCodigo();
			nom_cli=leerNombre();
			apell_cli=leerApellido();
			fnacim=leerFecha();
			correo_cli=leerCorreo();
			telef_cli=leerTelefono();
			cod_dist=leerDistrito();
			
			
			c=new Cliente(cod_cli, null, null, nom_cli, apell_cli, fnacim, correo_cli, telef_cli, cod_dist);
			
			int ok=new GestionCliente().actualizar(c);
			
			if(ok==0){
				JOptionPane.showMessageDialog(this,"Error al actualizar - Verifique datos");
			}else{
				JOptionPane.showMessageDialog(this,"Cliente Actualizado");
				listado();
				limpiarCliente();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Seleccione alguna fila");
		}
			
		
			
		
		
	}
	

	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarCliente();
	}

	private void eliminarCliente() {
		
		try {
		String cod_cli;
		cod_cli=leerCodigo();
		
		int ok=new GestionCliente().eliminar(cod_cli);
		
		if(ok==0){
			JOptionPane.showMessageDialog(this,"Error al eliminar - codigo no existe");
		}else{
			JOptionPane.showMessageDialog(this,"Cliente Eliminado");
			listado();
			limpiarCliente();
		}
		
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Seleccione fila a Eliminar");
		}
		
	}
}
