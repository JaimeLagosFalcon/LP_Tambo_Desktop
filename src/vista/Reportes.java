package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class Reportes extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reportes frame = new Reportes();
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
	public Reportes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Reportes.class.getResource("/img/logo.png")));
		setTitle("Reporte");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(187, 32, 148, 20);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 474, 307);
		contentPane.add(scrollPane);
		
		JTextArea txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		JLabel lblNmero = new JLabel("N\u00FAmero de Boleta");
		lblNmero.setForeground(Color.BLUE);
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNmero.setBounds(28, 33, 166, 14);
		contentPane.add(lblNmero);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setForeground(Color.WHITE);
		btnMostrar.setBackground(Color.BLUE);
		btnMostrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMostrar.setBounds(380, 20, 92, 43);
		contentPane.add(btnMostrar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Reportes.class.getResource("/img/a5b780d43f85fc8627c96656169213ff.png")));
		lblNewLabel.setBounds(-153, 0, 647, 399);
		contentPane.add(lblNewLabel);
	}
}
