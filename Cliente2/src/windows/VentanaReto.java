package windows;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import datechooser.beans.DateChooserDialog;
import es.deusto.ingenieria.sd.auctions.client.controller.RetoController;
import datechooser.beans.DateChooserCombo;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
//import clss.TipoDeporte;

public class VentanaReto extends JFrame {
	private RetoController controller;
	private JPanel contentPane;
	private JTextField txtReto;
	private JTextField txtDistancia;
	private JTextField txtObjetivo;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReto frame = new VentanaReto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaReto(RetoController cont) {
		controller = cont;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBackground(new Color(255, 165, 0));
		contentPane.add(pnlTitulo, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Creacion De Reto");
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 17));
		pnlTitulo.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(7, 2, 0, 0));
		
		JLabel lblReto = new JLabel("Nombre del Reto:");
		panel_1.add(lblReto);
		
		txtReto = new JTextField();
		panel_1.add(txtReto);
		txtReto.setColumns(10);
		
		JLabel lblFechaIni = new JLabel("Fecha de Inicio");
		panel_1.add(lblFechaIni);
		
		DateChooserCombo dateChooserCombo = new DateChooserCombo();
		panel_1.add(dateChooserCombo);
		
		JLabel lblFechaVencimiento = new JLabel("Fecha de Vencimiento");
		panel_1.add(lblFechaVencimiento);
		
		DateChooserCombo dateChooserCombo_1 = new DateChooserCombo();
		panel_1.add(dateChooserCombo_1);
		
		JLabel lblDistancia = new JLabel("Distancia");
		panel_1.add(lblDistancia);
		
		txtDistancia = new JTextField();
		panel_1.add(txtDistancia);
		txtDistancia.setColumns(10);
		
		JLabel lblObjetivo = new JLabel("Objetivo (Tiempo)");
		panel_1.add(lblObjetivo);
		
		txtObjetivo = new JTextField();
		panel_1.add(txtObjetivo);
		txtObjetivo.setColumns(10);
		
		JLabel lblTipoDeporte = new JLabel("Tipo De Deporte");
		panel_1.add(lblTipoDeporte);
		
		JComboBox cbTipoDeporte = new JComboBox();
		cbTipoDeporte.setModel(new DefaultComboBoxModel(controller.getDeporte()));
		panel_1.add(cbTipoDeporte);
		
		JButton btnCrearReto = new JButton("Crear Reto");

		panel_1.add(btnCrearReto);
		
		JButton btnCerrar = new JButton("Cerrar");
		panel_1.add(btnCerrar);
		
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		btnCrearReto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				controller.makeReto(txtReto.getText(), 
						dateChooserCombo.getSelectedDate().getTime().toString(), 
						dateChooserCombo_1.getSelectedDate().getTime().toString(), 
						Double.valueOf(txtDistancia.getText()), Double.valueOf(txtObjetivo.getText()), 
						(String)cbTipoDeporte.getSelectedItem());
				dispose();
			}
		});
	}

}
