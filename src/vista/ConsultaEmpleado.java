package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCliente;
import mantenimientos.GestionEmpleados;
import model.Cargo;
import model.Distrito;
import model.Empleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.TextArea;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ConsultaEmpleado extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaEmpleado frame = new ConsultaEmpleado();
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
	public ConsultaEmpleado() {
		setTitle("Consultar Empleado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaEmpleado.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 575, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		datefecha = new JDateChooser();
		datefecha.setBounds(120, 57, 155, 20);
		contentPane.add(datefecha);
		
		lblNacimiento = new JLabel("Nacimiento");
		lblNacimiento.setForeground(Color.BLUE);
		lblNacimiento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNacimiento.setBounds(10, 63, 103, 14);
		contentPane.add(lblNacimiento);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 539, 263);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		cboDistrito = new JComboBox();
		cboDistrito.setBounds(273, 18, 130, 20);
		contentPane.add(cboDistrito);
		
		cboCargo = new JComboBox();
		cboCargo.setBounds(72, 18, 115, 20);
		contentPane.add(cboCargo);
		
		lblDistrito = new JLabel("Distrito");
		lblDistrito.setForeground(Color.BLUE);
		lblDistrito.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDistrito.setBounds(197, 19, 78, 14);
		contentPane.add(lblDistrito);
		
		JLabel lblCodigo = new JLabel("Cargo");
		lblCodigo.setForeground(Color.BLUE);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodigo.setBounds(10, 17, 65, 19);
		contentPane.add(lblCodigo);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(this);
		btnConsultar.addActionListener(this);
		btnConsultar.setBackground(Color.BLUE);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBounds(424, 12, 103, 32);
		contentPane.add(btnConsultar);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(ConsultaEmpleado.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
		label.setBounds(-118, 0, 677, 372);
		contentPane.add(label);
		
		
		llenarCombo();
		llenarCombo2();
	}
	
	DefaultTableModel modelo = new DefaultTableModel();
	private JLabel label;
	private JLabel lblDistrito;
	private JComboBox cboCargo;
	private JComboBox cboDistrito;
	private JTextArea txtS;
	private JScrollPane scrollPane;
	private JLabel lblNacimiento;
	private JDateChooser datefecha;
	private JButton btnConsultar;
	
	
	void llenarCombo(){
		ArrayList<Cargo> lstCargo=new GestionEmpleados().listadoCargo();
		
		if(lstCargo==null){
			JOptionPane.showMessageDialog(this,"Lista Vacia");
		}else{
			cboCargo.addItem("Seleccione");
			for (Cargo c : lstCargo) {
				cboCargo.addItem(c.getDesc_cargo());
			}
		}
	}
	
	void llenarCombo2(){
		ArrayList<Distrito> lstDistrito=new GestionCliente().listadoDistrito();
		
		if(lstDistrito==null){
			JOptionPane.showMessageDialog(this,"Lista vacia");
		}else{
			cboDistrito.addItem("Seleccione");
			for (Distrito d : lstDistrito) {
				cboDistrito.addItem(d.getDesc_dist());
				
			}
		}
	}
	
	void listado(){
		
		String fnacim;
		String cod_dist;
		String cod_cargo;
		
		fnacim=leerFecha();
		cod_dist=leerDistrito();
		cod_cargo=leerCargo();
		
		ArrayList<Empleado> lstEmpleado=new GestionEmpleados().consulta(fnacim, cod_dist, cod_cargo);
		
		if(lstEmpleado==null|| lstEmpleado.size()==0){
			txtS.setText("\t\t Seleccione Datos");
		}else{
			txtS.setText("\t\t >>>>>>>>>> LISTA DE EMPLEADOS >>>>>>>>\n\n");
			
			for (Empleado e : lstEmpleado) {
				txtS.append("Codigo \t:"+e.getCod_emple()+"\n"+
						    "Usuario \t:"+e.getUsuario()+"\n"+
						    "Clave \t:"+e.getClave()+"\n"+
						    "Nombre \t:"+e.getNom_emple()+"\n"+
						    "Apellido \t:"+e.getApell_emple()+"\n"+
						    "Nacimiento \t:"+e.getFnacim()+"\n"+
						    "Correo \t:"+e.getCorreo_emple()+"\n"+
						    "Telefono \t:"+e.getTelef_emple()+"\n"+
						    "Distrito \t:"+e.getCod_dist()+"\n"+
						    "Cargo \t:"+e.getCod_cargo()+"\n"+
						    "---------------------------------------------------------------------\n\n"); 
			}
		}
		
		
	}

	private String leerCargo() {
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

	private String leerFecha() {
		SimpleDateFormat sfd=new SimpleDateFormat("yyyy/MM/dd");
		if(datefecha.getCalendar()!=null){
			return sfd.format(datefecha.getDate());
		}else{
			JOptionPane.showMessageDialog(this,"Seleccione Fecha de Nacimiento");
			return null;
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		listado();
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btnConsultar) {
			mouseEnteredBtnConsultar(e);
		}
	}
	
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseEnteredBtnConsultar(MouseEvent e) {
		btnConsultar.setBackground(Color.GREEN);
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btnConsultar) {
			mouseExitedBtnConsultar(e);
		}
	}
	protected void mouseExitedBtnConsultar(MouseEvent e) {
		btnConsultar.setBackground(Color.BLUE);
	}
}
