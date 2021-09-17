package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionCliente;
import mantenimientos.GestionProveedor;
import model.Distrito;
import model.Proveedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ConsultaProveedor extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JComboBox cboDistrito;
	private JButton button;
	private JTextArea txtS;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaProveedor frame = new ConsultaProveedor();
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
	public ConsultaProveedor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultaProveedor.class.getResource("/img/logo.png")));
		setTitle("Consultar Proveedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 412, 183);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		JLabel lblProveedor = new JLabel("Distrito");
		lblProveedor.setForeground(Color.BLUE);
		lblProveedor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProveedor.setBounds(10, 32, 101, 14);
		contentPane.add(lblProveedor);
		
		button = new JButton("Consultar");
		button.addMouseListener(this);
		button.setBackground(Color.BLUE);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.addActionListener(this);
		button.setBounds(307, 10, 101, 36);
		contentPane.add(button);
		
		cboDistrito = new JComboBox();
		cboDistrito.setBounds(94, 31, 124, 20);
		contentPane.add(cboDistrito);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ConsultaProveedor.class.getResource("/img/fondo2.png")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
		
		llenarCombo();
	}
	
	void llenarCombo(){
		ArrayList<Distrito> lstDistrito=new GestionCliente().listadoDistrito();
		
		if(lstDistrito==null){
			JOptionPane.showMessageDialog(this,"LISTA VACIA");
		}else{
			cboDistrito.addItem("Seleccione");
			for (Distrito p : lstDistrito) {
				cboDistrito.addItem(p.getDesc_dist());
			}
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		listado();
	}



	
	
	void listado(){
		String cod_dist=leerDistrito();
		
		ArrayList<Proveedor> lstProveedor=new GestionProveedor().consulta(cod_dist);
		
		if(lstProveedor==null || lstProveedor.size()==0){
			txtS.setText("\t\t Lista Vacia");
		}else{
			txtS.setText("\t>>>>>>>> LISTA DE PROVEEDORES >>>>>>>>\n\n");
			
			for (Proveedor p : lstProveedor) {
				txtS.append("Codigo \t:"+p.getCod_prove()+"\n"+
						    "Nombre \t:"+p.getNom_prove()+"\n"+
						    "Correo \t:"+p.getCorreo_prove()+"\n"+
						    "Telefono \t:"+p.getTelef_prove()+"\n"+
						    "Distrito \t:"+p.getCod_dist()+"\n"+
						    "-------------------------------------------------\n\n"); 
			}
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
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == button) {
			mouseEnteredButton(e);
		}
	}
	
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseEnteredButton(MouseEvent e) {
		button.setBackground(Color.GREEN);
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == button) {
			mouseExitedButton(e);
		}
	}
	protected void mouseExitedButton(MouseEvent e) {
		button.setBackground(Color.BLUE);
	}
}
