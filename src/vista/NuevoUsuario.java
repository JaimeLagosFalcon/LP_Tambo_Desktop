package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import mantenimientos.GestionLogueo;
import model.Cliente;
import model.Empleado;
import model.ModeloNuevoUsuario;
import model.TipoUsuario;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class NuevoUsuario extends JFrame implements ActionListener, WindowListener, MouseListener {

	private JPanel contentPane;
	private JLabel lblCreaTuCuenta;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblUsuario;
	private JLabel lblClave;
	private JLabel lblFechaNacimiento;
	private JLabel lblTipoDeUsuario;
	private JTextField txtApellido;
	public static JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JComboBox cbotipo;
	private JDateChooser dateFecha;
	private JButton btnCrear;
	private JPasswordField txtClave;
	private JCheckBox check;
	private JLabel lblIdentificador;
	private JTextField txtIdentificador;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoUsuario frame = new NuevoUsuario();
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
	public NuevoUsuario() {
		addWindowListener(this);
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(NuevoUsuario.class.getResource("/img/signo-registrado.png")));
		setTitle("Registro de Nuevo Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 357, 454);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.disabledShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		check = new JCheckBox("Ver");
		check.addActionListener(this);
		
		btnCrear = new JButton("CREAR");
		btnCrear.addMouseListener(this);
		btnCrear.setBackground(new Color(199, 21, 133));
		btnCrear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCrear.setForeground(Color.WHITE);
		btnCrear.addActionListener(this);
		btnCrear.setBounds(114, 347, 100, 41);
		contentPane.add(btnCrear);
		
		lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setForeground(Color.WHITE);
		lblIdentificador.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIdentificador.setBounds(20, 131, 102, 14);
		contentPane.add(lblIdentificador);
		
		txtIdentificador = new JTextField();
		txtIdentificador.setEditable(false);
		txtIdentificador.setBounds(152, 137, 86, 20);
		contentPane.add(txtIdentificador);
		txtIdentificador.setColumns(10);
		check.setForeground(Color.BLACK);
		check.setBounds(289, 284, 46, 23);
		contentPane.add(check);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(152, 285, 130, 20);
		contentPane.add(txtClave);
		
		lblCreaTuCuenta = new JLabel("CREA TU CUENTA EN TAMBO");
		lblCreaTuCuenta.setForeground(Color.WHITE);
		lblCreaTuCuenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCreaTuCuenta.setBounds(42, 41, 271, 20);
		contentPane.add(lblCreaTuCuenta);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodigo.setBounds(20, 106, 58, 17);
		contentPane.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(20, 159, 72, 14);
		contentPane.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellido.setBounds(20, 195, 94, 20);
		contentPane.add(lblApellido);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuario.setBounds(20, 257, 94, 14);
		contentPane.add(lblUsuario);
		
		lblClave = new JLabel("Clave");
		lblClave.setForeground(Color.WHITE);
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClave.setBounds(20, 288, 46, 14);
		contentPane.add(lblClave);
		
		lblFechaNacimiento = new JLabel("Nacimiento");
		lblFechaNacimiento.setForeground(Color.WHITE);
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFechaNacimiento.setBounds(20, 322, 110, 14);
		contentPane.add(lblFechaNacimiento);
		
		lblTipoDeUsuario = new JLabel("Tipo de Usuario");
		lblTipoDeUsuario.setForeground(Color.WHITE);
		lblTipoDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTipoDeUsuario.setBounds(20, 226, 150, 20);
		contentPane.add(lblTipoDeUsuario);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(152, 197, 130, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setBounds(152, 254, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(152, 166, 140, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(152, 106, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		cbotipo = new JComboBox();
		cbotipo.addActionListener(this);
		
		cbotipo.setBounds(152, 228, 130, 20);
		contentPane.add(cbotipo);
		
		dateFecha = new JDateChooser();
		dateFecha.setBounds(152, 316, 130, 20);
		contentPane.add(dateFecha);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(NuevoUsuario.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
		label_1.setBounds(-189, 0, 530, 415);
		contentPane.add(label_1);
		
		llenarCombo();
		
	}
	
	void llenarCombo(){
		ArrayList<TipoUsuario> lsttipo=new GestionLogueo().listadodetipo();
		
		if(lsttipo==null){
			JOptionPane.showMessageDialog(this,"El combo box no posee datos");
		}else{
			cbotipo.addItem("Seleccione");
			
			for (TipoUsuario t : lsttipo) {
				
				cbotipo.addItem(t.getDes_tipo());
			}
		}
		
	}

	

	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == check) {
			actionPerformedChckbxNewCheckBox(arg0);
		}
		if (arg0.getSource() == cbotipo) {
			actionPerformedCbotipo(arg0);
		}
		if (arg0.getSource() == btnCrear) {
			actionPerformedBtnCrear(arg0);
		}
	}
	private void limpiar() {
		txtIdentificador.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		dateFecha.setCalendar(null);
		cbotipo.setSelectedIndex(0);
		ObtenerCodigoUsuario();
		dispose();
	}

	protected void actionPerformedBtnCrear(ActionEvent arg0) {
		registrarUsuario();
	}
	
	public String leerIdentificador(){
		return txtIdentificador.getText();
	}

	private void registrarUsuario() {
		
		if(txtIdentificador.getText().trim().length()>0){
			
			String cod_clii;
		    String cod_emplee;
		    
		    cod_clii=leerIdentificador();
		    cod_emplee=leerIdentificador();
		    
		    Cliente c=new GestionLogueo().buscarCliente(cod_clii);
			Empleado e=new GestionLogueo().buscarEmpleado(cod_emplee);
			
			if(c!=null){
				
				String cod_usu;
				String nom_usu;
				String ape_usu;
				String usuarioo;
				String clavee;
				String fnacim;
				String id_tipo;
				
				cod_usu=leerCodigoUsuario();
				nom_usu=leerNombre();
				ape_usu=leerApellido();
				usuarioo=leerUsuario();
				clavee=leerClave();
				fnacim=leerFNacimiento();
				id_tipo=leerTipo();
				
				ModeloNuevoUsuario nu=new ModeloNuevoUsuario(cod_usu, nom_usu, ape_usu, usuarioo, clavee, fnacim, id_tipo);
				
				int ok2=new GestionLogueo().registrar(nu);
				
				/**/
				
				
				String cod_cli;
				String usuario;
				String clave;
				
				usuario=leerUsuario();
				clave=leerClave();
				cod_cli=leerCodigoID();
				
				Cliente cli=new Cliente(cod_cli, usuario, clave,null, null, null, null, null,null);
				
				int ok1=new GestionLogueo().actualizarDatosCliente(cli);
				
				/**/
				
				if(ok2==0){
					JOptionPane.showMessageDialog(this, "ERROR AL REGISTRAR USUARIO");
				}else{
					JOptionPane.showMessageDialog(this, "CLIENTE " + nu.getNom_usu()+" "+nu.getApe_usu()+ " REGISTRADO");
					limpiar();
				}
				//if(ok1==0){
					//JOptionPane.showMessageDialog(this,"Error al actualizar - Verifique datos");
				//}else{
					//JOptionPane.showMessageDialog(this,"Cliente Actualizado");
				//}
				
				
				
				
			}
			
			
			if(e!=null){
				
				String cod_usu;
				String nom_usu;
				String ape_usu;
				String usuarioo;
				String clavee;
				String fnacim;
				String id_tipo;
				
				cod_usu=leerCodigoUsuario();
				nom_usu=leerNombre();
				ape_usu=leerApellido();
				usuarioo=leerUsuario();
				clavee=leerClave();
				fnacim=leerFNacimiento();
				id_tipo=leerTipo();
				
				ModeloNuevoUsuario nu=new ModeloNuevoUsuario(cod_usu, nom_usu, ape_usu, usuarioo, clavee, fnacim, id_tipo);
				
				int ok2=new GestionLogueo().registrar(nu);
				
				/**/
				
				
				String cod_emple;
				String usuario;
				String clave;
				
				usuario=leerUsuario();
				clave=leerClave();
				cod_emple=leerCodigoID();
				
				Empleado emple=new Empleado(cod_emple, usuario, clave, null, null, null, null, null, null, null);
				
				
				int ok1=new GestionLogueo().actualizarDatosEmpleado(emple);
				/**/
				if(ok2==0){
					JOptionPane.showMessageDialog(this, "ERROR AL REGISTRAR USUARIO");
				}else{
					JOptionPane.showMessageDialog(this, "EMPLEADO " + nu.getNom_usu()+" "+nu.getApe_usu()+ " REGISTRADO");
					limpiar();
				}
				
				//if(ok1==0){
					//JOptionPane.showMessageDialog(this,"Error al actualizar - Verifique datos");
				//}else{
					//JOptionPane.showMessageDialog(this,"Cliente Actualizado");
				//}
				
			}
			
			
			
		}else{
			
			String cod_usu;
			String nom_usu;
			String ape_usu;
			String usuario;
			String clave;
			String fnacim;
			String id_tipo;
			
			cod_usu=leerCodigoUsuario();
			nom_usu=leerNombre();
			ape_usu=leerApellido();
			usuario=leerUsuario();
			clave=leerClave();
			fnacim=leerFNacimiento();
			id_tipo=leerTipo();
			
			ModeloNuevoUsuario nu=new ModeloNuevoUsuario(cod_usu, nom_usu, ape_usu, usuario, clave, fnacim, id_tipo);
			
			int ok=new GestionLogueo().registrar(nu);
			
			if(ok==0){
				JOptionPane.showMessageDialog(this, "ERROR AL REGISTRAR USUARIO");
			}else{
				JOptionPane.showMessageDialog(this, "CLIENTE " + nu.getNom_usu()+" "+nu.getApe_usu()+ " REGISTRADO");
				limpiar();
			}
			
		}
		
		
		
		
		
		
		
	}

	private String leerCodigoID() {
		return txtIdentificador.getText();
	}

	private String ObtenerUsuario() {		
		GestionLogueo gl=new GestionLogueo();
		if(cbotipo.getSelectedIndex()==1){
			txtUsuario.setText(gl.generarUsuarioAdmmin());
			return txtUsuario.getText();
		}else if(cbotipo.getSelectedIndex()==2){
			txtUsuario.setText(gl.generarUsuarioCliente());
			return txtUsuario.getText();
		}else if(cbotipo.getSelectedIndex()==3){
			txtUsuario.setText(gl.generarUsuarioCajero());
			return txtUsuario.getText();
		}else if(cbotipo.getSelectedIndex()==4){
			txtUsuario.setText(gl.generarMantenimiento());
			return txtUsuario.getText();
			
		}else{
			return null;
		}
		
	}

	private String leerCodigoUsuario() {
		return txtCodigo.getText();
	}

	private String leerTipo() {
        String cod=null,d;
		
		if(cbotipo.getSelectedIndex()==0){
			JOptionPane.showMessageDialog(this,"Seleccione Tipo de Usuario");
		}else{
			int n;
			
			d="T";
			
			cod=cbotipo.getSelectedIndex()+"";
			n=4-cod.length();
			for(int i=0;i<n;i++){
				d+="0";
			}
			cod=d+cod;
		}
		return cod;
	}

	private String leerFNacimiento() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		if(dateFecha.getDate()==null){
			JOptionPane.showMessageDialog(this,"INSERTE CORRECTAMENTE LA FECHA");
			return null;
			
		}else{
			return sdf.format(dateFecha.getDate()) ;
		}
	}

	private String leerClave() {
		if(txtClave.getText().trim().matches("[0-9]{1,15}")){
			return txtClave.getText();
		}else{
			JOptionPane.showMessageDialog(this,"INSERTE CORRECTAMENTE LA CLAVE");
			return null;
		}
	}

	private String leerUsuario() {
		return txtUsuario.getText();
		
	}

	private String leerApellido() {
		
		if(txtApellido.getText().trim().length()>0){
			return txtApellido.getText().trim();
		}else{
			JOptionPane.showMessageDialog(this,"INSERTE CORRECTAMENTE EL APELLIDO");
			return null;		
		}
		
		
	}

	private String leerNombre() {
		if(txtNombre.getText().trim().length()>0){
			return txtNombre.getText().trim();
		}else{
			JOptionPane.showMessageDialog(this,"INSERTE CORRECTAMENTE EL NOMBRE");
			return null;		
		}
	}
	
	

	private String ObtenerCodigoUsuario() {
		GestionLogueo gl=new GestionLogueo();
		txtCodigo.setText(gl.generarCodigoUsuario());
		return txtCodigo.getText();
	}
	public void windowActivated(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowClosing(WindowEvent e) {
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
		ObtenerCodigoUsuario();
		
		
	}
	
	
	protected void actionPerformedCbotipo(ActionEvent arg0) {
		ObtenerUsuario();
		
	}
	
	
	
	
	
	
	
	public void busqueda(){
		
		String cod_cli;
	    String cod_emple;
	    
	    cod_cli=leerCliente();
	    cod_emple=leerEmpleado();
	    
	    Cliente c=new GestionLogueo().buscarCliente(cod_cli);
		Empleado e=new GestionLogueo().buscarEmpleado(cod_emple);
		
		if(c!=null){
			txtIdentificador.setText(c.getCod_cli());
			txtNombre.setText(c.getNom_cli());
			txtApellido.setText(c.getApell_cli());
			cbotipo.setSelectedIndex(2);
			cbotipo.setEnabled(false);
			Date d=StringaDate(c.getFnacim());
			dateFecha.setDate(d);
			txtNombre.setEditable(false);
			txtApellido.setEditable(false);
			dateFecha.setEnabled(false);
		}
		
		if(e!=null){
			txtIdentificador.setText(e.getCod_emple());
			txtNombre.setText(e.getNom_emple());
			txtApellido.setText(e.getApell_emple());
			
			Date d=StringaDate(e.getFnacim());
			dateFecha.setDate(d);
			
			txtNombre.setEditable(false);
			txtApellido.setEditable(false);
			dateFecha.setEnabled(false);
		}
	}

	/*VARIABLE GLOBAL*/
	private String global2(){
		String m=leerEmpleado();
		return m;
	}
	
	private String global1(){
		String n=leerCliente();
		return n;
	}
	
	
	private String leerEmpleado() {
		if(FrmBusqueda.txtNombre.getText().length()>0){
			return FrmBusqueda.txtCodigo.getText();
		}else{
			return null;
		}
	}

	private String leerCliente() {
		if(FrmBusqueda.txtNombre.getText().length()>0){
			return FrmBusqueda.txtCodigo.getText();
		}else{
			return null;
		}
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
	protected void actionPerformedChckbxNewCheckBox(ActionEvent arg0) {
		if(check.isSelected()){
			txtClave.setEchoChar((char)0);
		}else{
			txtClave.setEchoChar('●');
		}
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnCrear) {
			mouseEnteredBtnCrear(e);
		}
	}
	
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseEnteredBtnCrear(MouseEvent e) {
		btnCrear.setBackground(Color.GREEN);
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnCrear) {
			mouseExitedBtnCrear(e);
		}
	}
	protected void mouseExitedBtnCrear(MouseEvent e) {
		btnCrear.setBackground(Color.MAGENTA);
	}
}
