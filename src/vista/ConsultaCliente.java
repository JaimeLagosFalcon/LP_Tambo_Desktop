package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.TextArea;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionCliente;
import model.Cliente;
import model.Distrito;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.WindowFocusListener;

public class ConsultaCliente extends JFrame implements ActionListener, MouseListener{

	private JPanel contentPane;
	private JDateChooser datefecha;
	private JComboBox cboDistrito;
	private JButton btnConsultar;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCliente frame = new ConsultaCliente();
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
	public ConsultaCliente() {
		
		
		setTitle("Consultar Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaCliente.class.getResource("/img/logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 514, 260);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		cboDistrito = new JComboBox();
		
		
		
		
		
		cboDistrito.setBounds(108, 24, 156, 20);
		contentPane.add(cboDistrito);
		
		datefecha = new JDateChooser();
		
		
		
		datefecha.setDateFormatString("yyyy/MM/dd");
		
		datefecha.setBounds(108, 64, 156, 20);
		contentPane.add(datefecha);
		
		JLabel lblNacimiento = new JLabel("Nacimiento");
		lblNacimiento.setForeground(Color.BLUE);
		lblNacimiento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNacimiento.setBounds(10, 70, 112, 14);
		contentPane.add(lblNacimiento);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addMouseListener(this);
		btnConsultar.addActionListener(this);
		
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(Color.BLUE);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultar.setBounds(407, 34, 101, 37);
		contentPane.add(btnConsultar);
		
		JLabel lblCodigo = new JLabel("Distrito");
		lblCodigo.setForeground(Color.BLUE);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCodigo.setBounds(20, 25, 65, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ConsultaCliente.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
		lblNewLabel.setBounds(-129, -12, 663, 378);
		contentPane.add(lblNewLabel);
		
		llenarCombo();
		
	}
	
	void llenarCombo(){
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
	
	void listado(){
		
		
		String fnacim;
		String cod_dist;
		
		cod_dist=leerDistrito();
		fnacim=leerFecha();
		
		ArrayList<Cliente> lstCliente=new GestionCliente().consultar(fnacim,cod_dist);
		
		if(lstCliente==null || lstCliente.size()==0 || datefecha==null){
			txtS.setText(" \n");
			txtS.setText("\t\tSeleccione Datos");
		}else{
			
			txtS.setText("\t\t>>>>>>>> LISTA DE CLIENTES >>>>>>>>>>>\n\n");
			for (Cliente c : lstCliente) {
				txtS.append("Codigo \t:"+c.getCod_cli()+"\n"+
			                "Nombre \t:"+c.getNom_cli()+" "+c.getApell_cli()+"\n"+
						    "Usuario\t:"+c.getUsuario()+"\n"+
			                "Clave \t :"+c.getClave()+"\n"+
						    "Nacimiento \t:"+c.getFnacim()+"\n"+
			                "Correo \t:"+c.getCorreo_cli()+"\n"+
						    "Telefono \t:"+c.getTelef_cli()+"\n"+
			                "Distrito \t:"+c.getCod_dist()+"\n"+
						    "---------------------------------------------------------------------------------------------\n\n"); 
			}
			
		}
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
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		listado();
	}
	public void mouseClicked(MouseEvent arg0) {
	}
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource() == btnConsultar) {
			mouseEnteredBtnConsultar(arg0);
		}
	}
	
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseEnteredBtnConsultar(MouseEvent arg0) {
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
