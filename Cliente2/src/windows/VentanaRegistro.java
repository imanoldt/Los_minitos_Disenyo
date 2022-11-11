package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import datechooser.beans.DateChooserPanel;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblRegistro;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblFecha;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_2;
	private JTextField textField_3;
	private DateChooserPanel dateChooserPanel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][grow][][grow][grow][grow][grow][][][][][][][][][][][]", "[][][][][][][grow][][][][][][][][][][][][][][][][]"));
		
		lblRegistro = new JLabel("Registro");
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Montserrat", Font.PLAIN, 22));
		panel_1.add(lblRegistro, "cell 0 0 14 1,alignx center,aligny center");
		
		lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_2, "cell 0 2,grow");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 6 2 11 1,growx");
		textField.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_3, "cell 0 4,growx,aligny center");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 6 4 11 1,growx");
		textField_1.setColumns(10);
		
		lblFecha = new JLabel("Fecha de Nacimiento:\n");
		lblFecha.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblFecha, "cell 0 6");
		
		dateChooserPanel = new DateChooserPanel();
		panel_1.add(dateChooserPanel, "cell 5 6 12 1,grow");
		
		lblNewLabel_4 = new JLabel("Peso:");
		lblNewLabel_4.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_4, "cell 0 8,grow");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 7 8 10 1,growx");
		textField_2.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Altura:");
		lblNewLabel_5.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_5, "cell 0 10,grow");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "cell 7 10 10 1,growx");
		textField_3.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Registro");
		panel_1.add(lblNewLabel_1, "cell 17 22");
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/img/Diseño sin título.png")));
		panel.add(lblNewLabel);
		

	}

}
