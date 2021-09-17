package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionCategorias;
import mantenimientos.GestionProductos;
import mantenimientos.GestionProveedor;
import model.Categoria;
import model.Producto;
import model.Proveedor;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ConsultaProducto extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JDateChooser datefecha;
	private JComboBox cboCategoria;
	private JComboBox cboProveedor;
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
					ConsultaProducto frame = new ConsultaProducto();
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
	public ConsultaProducto() {
		setTitle("Consultar Producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 634, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 598, 264);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		datefecha = new JDateChooser();
		datefecha.setDateFormatString("yyyy/MM/dd");
		datefecha.setBounds(115, 68, 142, 20);
		contentPane.add(datefecha);
		
		cboProveedor = new JComboBox();
		cboProveedor.setBounds(344, 17, 141, 20);
		contentPane.add(cboProveedor);
		
		cboCategoria = new JComboBox();
		cboCategoria.setBounds(115, 17, 131, 20);
		contentPane.add(cboCategoria);
		
		JLabel lblVencimiento = new JLabel("Vencimiento");
		lblVencimiento.setForeground(Color.BLUE);
		lblVencimiento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVencimiento.setBounds(10, 68, 113, 14);
		contentPane.add(lblVencimiento);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setForeground(Color.BLUE);
		lblProveedor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProveedor.setBounds(256, 18, 78, 14);
		contentPane.add(lblProveedor);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.BLUE);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCategoria.setBounds(10, 13, 95, 25);
		contentPane.add(lblCategoria);
		
		button = new JButton("Consultar");
		button.addMouseListener(this);
		button.addActionListener(this);
		button.setBackground(Color.BLUE);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBounds(495, 32, 113, 39);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ConsultaProducto.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
		lblNewLabel.setBounds(-124, 0, 742, 376);
		contentPane.add(lblNewLabel);
		
		llenarCombo();
		llenarCombo2();
	}
	
	void llenarCombo(){
		ArrayList<Categoria> lstCategoria=new GestionCategorias().listadoCategoria();
		
		if(lstCategoria==null){
			JOptionPane.showMessageDialog(this,"Lista Vacia");
		}else{
			cboCategoria.addItem("Seleccione");
			for (Categoria c : lstCategoria) {
				cboCategoria.addItem(c.getDesc_cat());
			}
		}
	}
	
	void llenarCombo2(){
		ArrayList<Proveedor> lstProveedor=new GestionProveedor().listado();
		
		if(lstProveedor==null){
			JOptionPane.showMessageDialog(this,"Seleccione");
		}else{
			cboProveedor.addItem("Seleccione");
			
			for (Proveedor p : lstProveedor) {
				cboProveedor.addItem(p.getNom_prove());
			}
		}
	}
	
	void listado(){
		String fvenci;
		String cod_cate;
		String cod_prove;
		
		fvenci=leerFecha();
		cod_cate=leerCategoria();
		cod_prove=leerProveedor();
		
		ArrayList<Producto> lstProducto=new GestionProductos().consultar(fvenci, cod_cate, cod_prove);
		
		if(lstProducto==null || lstProducto.size()==0){
			txtS.setText("\t\t Seleccione Datos");
		}else{
			txtS.setText("\t\t >>>>>>> LISTA DE PRODUCTOS >>>>>>>>> \n\n");
			
			for (Producto p : lstProducto) {
				txtS.append("Codigo \t:"+p.getCod_prod()+"\n"+
						    "Descripción \t:"+p.getDesc_prod()+"\n"+
						    "Vencimiento \t:"+p.getFvenci()+"\n"+
						    "Precio \t:"+p.getPrec_prod()+"\n"+
						    "Stock \t:"+p.getStock_prod()+"\n"+
						    "Categoria \t:"+p.getCod_cate()+"\n"+
						    "Proveedor \t:"+p.getCod_prove()+"\n"+
						    "------------------------------------------------ \n\n");
			}
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

	private String leerFecha() {
		SimpleDateFormat sfd=new SimpleDateFormat("yyyy/MM/dd");
		if(datefecha.getCalendar()!=null){
			return sfd.format(datefecha.getDate());
		}else{
			JOptionPane.showMessageDialog(this,"Seleccione Fecha de Vencimiento");
			return null;
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			actionPerformedButton(e);
		}
	}
	protected void actionPerformedButton(ActionEvent e) {
		listado();
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
