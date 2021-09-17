package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import mantenimientos.GestionEmpleados;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

import model.Cargo;
import model.Cliente;
import model.Distrito;
import model.Empleado;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


public class FrmEmpleado extends JFrame implements ActionListener, WindowListener, MouseListener {
	
	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JLabel lblCargo;
	private JTextField txtTelefono;
	private JLabel lblTelefono;
	private JComboBox cboDistrito;
	private JLabel lblDistrito;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JComboBox cboCargo;
	private JLabel lblCorreo_1;
	private JTextField txtCorreo;
	private JButton btnAgregar;
	private JLabel lblMantenimientoDeEmpleado;
	private JButton btnLimpiar;
	private JLabel lblNacimiento;
	private JDateChooser dateFecha;
	private JTable table;
	private JScrollPane scrollPane;
	DefaultTableModel modelo=new DefaultTableModel();
	private JLabel label;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEmpleado frame = new FrmEmpleado();
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
	public FrmEmpleado() {
		addWindowListener(this);
		
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		setTitle("Mantenimiento - Empleado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCliente.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 771, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(Color.GREEN);
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(637, 21, 108, 39);
		contentPane.add(btnAgregar);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodigo.setBackground(Color.WHITE);
		lblCodigo.setForeground(Color.BLUE);
		lblCodigo.setBounds(10, 57, 73, 19);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setForeground(Color.BLUE);
		lblNombre.setBounds(10, 90, 73, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellido.setForeground(Color.BLUE);
		lblApellido.setBounds(10, 119, 73, 19);
		contentPane.add(lblApellido);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(109, 58, 135, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(109, 89, 135, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(109, 120, 135, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setForeground(Color.BLUE);
		lblCargo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCargo.setBounds(320, 88, 73, 19);
		contentPane.add(lblCargo);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(420, 58, 135, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setForeground(Color.BLUE);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTelefono.setBounds(320, 59, 73, 14);
		contentPane.add(lblTelefono);
		
		cboDistrito = new JComboBox();
		cboDistrito.setBounds(420, 120, 135, 20);
		contentPane.add(cboDistrito);
		
		lblDistrito = new JLabel("Distrito");
		lblDistrito.setForeground(Color.BLUE);
		lblDistrito.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDistrito.setBounds(320, 121, 73, 14);
		contentPane.add(lblDistrito);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setBackground(Color.BLUE);
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(637, 71, 108, 39);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEliminar.setBackground(Color.RED);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(637, 133, 108, 39);
		contentPane.add(btnEliminar);
		
		cboCargo = new JComboBox();
		cboCargo.setBounds(420, 89, 135, 20);
		contentPane.add(cboCargo);
		
		lblCorreo_1 = new JLabel("Correo");
		lblCorreo_1.setForeground(Color.BLUE);
		lblCorreo_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCorreo_1.setBounds(10, 183, 73, 14);
		contentPane.add(lblCorreo_1);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(109, 182, 247, 20);
		contentPane.add(txtCorreo);
		
		lblMantenimientoDeEmpleado = new JLabel("Mantenimiento de Empleado");
		lblMantenimientoDeEmpleado.setForeground(Color.BLUE);
		lblMantenimientoDeEmpleado.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMantenimientoDeEmpleado.setBounds(204, 11, 324, 23);
		contentPane.add(lblMantenimientoDeEmpleado);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setBackground(Color.ORANGE);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpiar.setBounds(637, 190, 108, 39);
		contentPane.add(btnLimpiar);
		
		lblNacimiento = new JLabel("Nacimiento");
		lblNacimiento.setForeground(Color.BLUE);
		lblNacimiento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNacimiento.setBounds(10, 149, 89, 19);
		contentPane.add(lblNacimiento);
		
		dateFecha = new JDateChooser();
		dateFecha.setBounds(109, 151, 135, 20);
		contentPane.add(dateFecha);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 253, 735, 198);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(modelo);
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Fecha");
		modelo.addColumn("Correo");
		modelo.addColumn("Telefono");
		modelo.addColumn("Distrito");
		modelo.addColumn("Cargo");
		
		scrollPane.setViewportView(table);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmEmpleado.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
		label.setBounds(-108, 0, 863, 462);
		contentPane.add(label);
		
		llenaComboDistrito();
		llenaComboCargo();
		listado();
		ajustarAnchoColumnas();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(arg0);
		}
		if (arg0.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(arg0);
		}
		if (arg0.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		eliminarDatos();
	}
	
	void registrarDatos(){
		// variables
		
		String cod_emple;
		String nom_emple;
		String apell_emple;
		String fnacim;
		String correo_emple;
		String telef_emple;
		String cod_dist;
		String cod_cargo;
		
		
		// entradas
		cod_emple=leerCodigoEmpleado();
		nom_emple =leerNombre();
		apell_emple =leerApellido();
		fnacim=leerFecha();
		correo_emple =leerCorreo();
		telef_emple =leerTelefono();
		cod_dist =leerCodDistrito();
		cod_cargo =leerCodCargo();
		
		
		
		
		Empleado e=new Empleado(cod_emple,null,null, nom_emple, apell_emple, fnacim, correo_emple, telef_emple, cod_dist, cod_cargo);
				
		
		GestionEmpleados ge = new GestionEmpleados();
		
		int ok = ge.registrar(e);		
		
		if (ok == 0){
			JOptionPane.showMessageDialog(this, "Error al registrar");
		} else {
			JOptionPane.showMessageDialog(this, "Empleado " + e.getNom_emple()+" "+e.getApell_emple() +" Registrado!");
			limpiar();
			listado();
		}
	}
	
	private String leerCodCargo() {
        String cod=null,d;
		
		if(cboCargo.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(this,"Seleccione Cargo");
		}else{
			int n;
			
			d="CR";
			
			cod=cboCargo.getSelectedIndex()+"";
			n=3-cod.length();
			for(int i=0;i<n;i++){
				d+="0";
			}
			cod=d+cod;
		}
		return cod;
	}

	private String leerCodDistrito() {
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
			JOptionPane.showMessageDialog(this,"Formato de Telefono Incorrecto");
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
			JOptionPane.showMessageDialog(this,"Complete Apellido de Empleado");
			return null;
		}
	}

	private String leerNombre() {
		if(txtNombre.getText().trim().length()>0){
			return txtNombre.getText();
		}else{
			JOptionPane.showMessageDialog(this,"Complete Nombre de Empleado");
			return null;
		}
	}


	private String leerCodigoEmpleado() {
		
		return txtCodigo.getText();
	}

	private void actualizarDatos() {
		String cod_emple;
		String nom_emple;
		String apell_emple;
		String fnacim;
		String correo_emple;
		String telef_emple;
		String cod_dist;
		String cod_cargo;
		
		
		// entradas
		cod_emple=leerCodigoEmpleado();
		nom_emple =leerNombre();
		apell_emple =leerApellido();
		fnacim=leerFecha();
		correo_emple =leerCorreo();
		telef_emple =leerTelefono();
		cod_dist =leerCodDistrito();
		cod_cargo =leerCodCargo();
		
		Empleado e=new Empleado(cod_emple, null, null, nom_emple, apell_emple, fnacim, correo_emple, telef_emple, cod_dist, cod_cargo);
		
		  
		
		int ok=new GestionEmpleados().actualizar(e);
		
		
		if (ok == 0) {
			JOptionPane.showMessageDialog(this, "Error al actualizar");
		}
		else {
			JOptionPane.showMessageDialog(this, "Empleado actualizado");
			limpiar();
			listado();
		}
	}
	

	
	private void eliminarDatos() {
		String cod_emple;
		cod_emple=leerCodigoEmpleado();
		
		int rs = new GestionEmpleados().eliminar(cod_emple);
		if (rs == 0) {
			JOptionPane.showMessageDialog(this, "Error al eliminar");
		}
		else {
			JOptionPane.showMessageDialog(this, "Empleado eliminado");
			limpiar();
			listado();
		}
	}
	
	protected void actionPerformedBtnAgregar(ActionEvent arg0) {
		registrarDatos();
	}
	
	void llenaComboDistrito() {
		ArrayList<Distrito> lstTipos = new GestionEmpleados().listadoDistrito();
		if (lstTipos == null) {
			JOptionPane.showMessageDialog(this, "Combo no tiene datos");
		} else {
			cboDistrito.addItem("Seleccione");
			for (Distrito d: lstTipos) {
				cboDistrito.addItem(d.getDesc_dist());
			}
		}
	}
	
	void llenaComboCargo() {
		ArrayList<Cargo> lstTipos = new GestionEmpleados().listadoCargo();
		if (lstTipos == null) {
			JOptionPane.showMessageDialog(this, "Combo no tiene datos");
		} else {
			cboCargo.addItem("Seleccione");
			for (Cargo c: lstTipos) {
				cboCargo.addItem(c.getDesc_cargo());
			}
		}
	}
	
	protected void actionPerformedBtnActualizar(ActionEvent arg0) {
		actualizarDatos();
	}
	
	private void obtenerEmpleado(){
		GestionEmpleados ge=new GestionEmpleados();
		txtCodigo.setText(ge.generarEmpleado());
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
		obtenerEmpleado();
		listado();
	}
	protected void actionPerformedBtnLimpiar(ActionEvent arg0) {
		limpiar();
	}

	private void limpiar() {
		obtenerEmpleado();
		txtNombre.setText("");
		txtApellido.setText("");
		dateFecha.setCalendar(null);
		txtCorreo.setText("");
		txtTelefono.setText("");
		cboCargo.setSelectedIndex(0);
		cboDistrito.setSelectedIndex(0);
		
	}
	
	private void listado(){
		ArrayList<Empleado> lstEmpleado=new GestionEmpleados().listado();
		
		if(lstEmpleado==null){
			JOptionPane.showMessageDialog(this,"Lista vacia");
		}else{
			modelo.setRowCount(0);
			for (Empleado e : lstEmpleado) {
				Object aDatos[]={e.getCod_emple(),
						         e.getNom_emple(),
						         e.getApell_emple(),
						         e.getFnacim(),
						         e.getCorreo_emple(),
						         e.getTelef_emple(),
						         e.getCod_dist(),
						         e.getCod_cargo()};
				modelo.addRow(aDatos);
				
			}
			
		}
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(12));  // CODIGO
		tcm.getColumn(1).setPreferredWidth(anchoColumna(13));  //NOMBRE
		tcm.getColumn(2).setPreferredWidth(anchoColumna(13));  //APELLIDO
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  //NACIMIENTO
		tcm.getColumn(4).setPreferredWidth(anchoColumna(26));  //CORREO
		tcm.getColumn(5).setPreferredWidth(anchoColumna(11));  //TELEFONO
		tcm.getColumn(6).setPreferredWidth(anchoColumna(7));  //DISTRITO
		tcm.getColumn(7).setPreferredWidth(anchoColumna(7));  //DISTRITO
		
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	private void enviar(){
		
		int fila=table.getSelectedRow();
		
		String cod_emple=table.getValueAt(fila,0).toString();
		String nom_emple=table.getValueAt(fila,1).toString();
		String apell_emple=table.getValueAt(fila,2).toString();
		String fnacim=table.getValueAt(fila,3).toString();
		String correo_emple=table.getValueAt(fila,4).toString();
		String telef_emple=table.getValueAt(fila,5).toString();
		String cod_dist=table.getValueAt(fila,6).toString();
		String cod_cargo=table.getValueAt(fila,7).toString();
		String m=cod_dist.substring(1);
		String l=cod_cargo.substring(2);
		
		
		txtCodigo.setText(cod_emple);
		txtNombre.setText(nom_emple);
		txtApellido.setText(apell_emple);
		Date d=StringaDate(fnacim);
		dateFecha.setDate(d);
		txtCorreo.setText(correo_emple);
		txtTelefono.setText(telef_emple);
		cboDistrito.setSelectedIndex(Integer.parseInt(m));
		cboCargo.setSelectedIndex(Integer.parseInt(l));
		
		
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
		if (arg0.getSource() == table) {
			mouseClickedTable(arg0);
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
	protected void mouseClickedTable(MouseEvent arg0) {
		enviar();
	}
}