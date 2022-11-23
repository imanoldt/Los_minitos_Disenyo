package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controllers.SesionController;
//import clss.TipoDeporte;
import datechooser.beans.DateChooserCombo;
import domain.TipoDeporte;

public class VentanaSesion extends JFrame {
	
	private SesionController controller;
	private JPanel contentPane;
	private JTextField txtDistancia, txtReto, txtObjetivo;
	private JTextField txtKm;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSesion frame = new VentanaSesion();
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
	public VentanaSesion(SesionController cont) {
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
		
		JLabel lblNewLabel = new JLabel("Creacion De Sesion");
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 17));
		pnlTitulo.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(7, 2, 0, 0));
		
		JLabel lblSesion = new JLabel("Titulo de la Sesion:");
		panel_1.add(lblSesion);
		txtReto = new JTextField();
		panel_1.add(txtReto);
		txtReto.setColumns(10);
		
		JLabel lblTipoDeporte = new JLabel("Tipo De Deporte");
		panel_1.add(lblTipoDeporte);
		
		JComboBox comboBox = new JComboBox();
		String[] s = new String[TipoDeporte.values().length];
		int i = 0;
		for(TipoDeporte t: TipoDeporte.values()) {
			s[i++] = t.toString();
		}
		comboBox.setModel(new DefaultComboBoxModel(s));
		panel_1.add(comboBox);
		
		JLabel lblFechaIni = new JLabel("Fecha de Inicio:");
		panel_1.add(lblFechaIni);
		
		DateChooserCombo dateChooserCombo = new DateChooserCombo();
		panel_1.add(dateChooserCombo);
		
		JLabel lblHora = new JLabel("Hora:");
		panel_1.add(lblHora);
		
		txtDistancia = new JTextField();
		panel_1.add(txtDistancia);
		txtDistancia.setColumns(10);
		
		JLabel lblObjetivo = new JLabel("Duracion:");
		panel_1.add(lblObjetivo);
		
		txtObjetivo = new JTextField();
		panel_1.add(txtObjetivo);
		txtObjetivo.setColumns(10);
		
		JLabel lblK = new JLabel("Recorrido (KM):");
		panel_1.add(lblK);
		
		txtKm = new JTextField();
		panel_1.add(txtKm);
		txtKm.setColumns(10);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnCrearSesion = new JButton("Crear Sesion");
		panel.add(btnCrearSesion);
		btnCrearSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				controller.makeSesion(txtReto.getText(), comboBox.getSelectedIndex(),
						Double.valueOf(txtKm.getText()),
						dateChooserCombo.getSelectedDate().getTime(),
						Integer.valueOf(txtDistancia.getText()), Double.valueOf(txtObjetivo.getText()));
				dispose();
			}
		});
	}
}


