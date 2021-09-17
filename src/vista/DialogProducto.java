package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import mantenimientos.GestionProductos;
import model.Producto;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DialogProducto extends JDialog implements ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JTable tbSalida;
	DefaultTableModel modelo=new DefaultTableModel();
	private JButton okButton;
	private JScrollPane scrollPane;
	private JLabel label;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogProducto dialog = new DialogProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogProducto() {
		setTitle("Lista de Productos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogProducto.class.getResource("/img/logo.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 414, 206);
			contentPanel.add(scrollPane);
			{
				tbSalida = new JTable();
				scrollPane.setViewportView(tbSalida);
			}
			tbSalida.setModel(modelo);
		}
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(DialogProducto.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
			label.setBounds(-192, 0, 626, 228);
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 215, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addMouseListener(this);
				okButton.setForeground(Color.WHITE);
				okButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				okButton.setBackground(Color.BLUE);
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(this);
				cancelButton.addMouseListener(this);
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				cancelButton.setBackground(Color.RED);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock");
		
		listado();
		ajustarAnchoColumnas();
		
	}
	
	void listado(){
		
		ArrayList<Producto> lstProducto=new GestionProductos().listado();
		
		if(lstProducto==null){
			JOptionPane.showMessageDialog(this,"Lista Vacia");
		}else{
			modelo.setRowCount(0);
			for (Producto p : lstProducto) {
				Object aDatos[]={p.getCod_prod(),
						         p.getDesc_prod(),
						         p.getPrec_prod(),
						         p.getStock_prod()};
				modelo.addRow(aDatos);
			}
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cancelButton) {
			actionPerformedCancelButton(arg0);
		}
		if (arg0.getSource() == okButton) {
			actionPerformedOkButton(arg0);
		}
	}
	protected void actionPerformedOkButton(ActionEvent arg0) {
		enviarDatos();
		
	}

	private void enviarDatos() {
		int fila=tbSalida.getSelectedRow();
		
		BoletaTrans.txtProducto.setText(tbSalida.getValueAt(fila, 0).toString());
		BoletaTrans.txtDescripcion.setText(tbSalida.getValueAt(fila, 1).toString());
		BoletaTrans.txtPrecio.setText(tbSalida.getValueAt(fila, 2).toString());
		BoletaTrans.txtStock.setText(tbSalida.getValueAt(fila, 3).toString());
		dispose();
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = tbSalida.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(15));  // CODIGO
		tcm.getColumn(1).setPreferredWidth(anchoColumna(51));  // USUARIO
		tcm.getColumn(2).setPreferredWidth(anchoColumna(1));  //CLAVE
		tcm.getColumn(3).setPreferredWidth(anchoColumna(1));  //NOMBRE
		
		
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == cancelButton) {
			mouseEnteredCancelButton(e);
		}
		if (e.getSource() == okButton) {
			mouseEnteredOkButton(e);
		}
	}
	
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseEnteredOkButton(MouseEvent e) {
		okButton.setBackground(Color.GREEN);
	}
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == okButton) {
			mouseExitedOkButton(e);
		}
		if (e.getSource() == cancelButton) {
			mouseExitedcancelButton(e);
		}
	}
	private void mouseExitedcancelButton(MouseEvent e) {
		cancelButton.setBackground(Color.RED);
		
	}

	protected void mouseExitedOkButton(MouseEvent e) {
		okButton.setBackground(Color.BLUE);
	}
	protected void mouseEnteredCancelButton(MouseEvent e) {
		cancelButton.setBackground(Color.GREEN);
	}
	protected void actionPerformedCancelButton(ActionEvent arg0) {
		dispose();
	}
}
