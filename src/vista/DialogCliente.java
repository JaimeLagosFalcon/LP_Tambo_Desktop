package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCliente;
import model.Cliente;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class DialogCliente extends JDialog implements ActionListener, MouseListener {

	private final JPanel contentPanel = new JPanel();
	private JTable tbSalida;
	DefaultTableModel modelo=new DefaultTableModel();
	private JButton cancelButton;
	private JButton okButton;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogCliente dialog = new DialogCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogCliente() {
		setTitle("Lista de Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogCliente.class.getResource("/img/logo.png")));
		setBounds(100, 100, 450, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 414, 206);
			contentPanel.add(scrollPane);
			
			tbSalida = new JTable();
			scrollPane.setViewportView(tbSalida);
			
			tbSalida.setModel(modelo);
		}
		{
			label = new JLabel("");
			label.setIcon(new ImageIcon(DialogCliente.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
			label.setBounds(-128, 0, 562, 275);
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 215, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setForeground(Color.WHITE);
				okButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				okButton.setBackground(new Color(0, 0, 255));
				okButton.addMouseListener(this);
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(this);
				cancelButton.setBackground(Color.RED);
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				cancelButton.setForeground(Color.WHITE);
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		listado();
	}
	
	void listado(){
		ArrayList<Cliente> lstCliente=new GestionCliente().listadoCliente();
		
		if(lstCliente==null){
			JOptionPane.showMessageDialog(this,"Lista Vacia");
		}else{
			modelo.setRowCount(0);
			for (Cliente c : lstCliente) {
				Object aDatos[]={c.getCod_cli(),c.getNom_cli()+" "+c.getApell_cli()};
				
				modelo.addRow(aDatos);
				
			}
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == okButton) {
			actionPerformedOkButton(arg0);
		}
		if (arg0.getSource() == cancelButton) {
			actionPerformedCancelButton(arg0);
		}
	}
	protected void actionPerformedCancelButton(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedOkButton(ActionEvent arg0) {
		enviarDatos();
	}

	private void enviarDatos() {
		int fila=tbSalida.getSelectedRow();
		
		BoletaTrans.txtCliente.setText(tbSalida.getValueAt(fila, 0).toString());
		BoletaTrans.txtNombre.setText(tbSalida.getValueAt(fila, 1).toString());
		dispose();
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
}
