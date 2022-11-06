package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class VentanaLoginN extends JFrame {

	private JPanel contentPane, pnlPrincipal, pnlIzquierda, pnlDerechaa;

	private JLabel lblIniciarSesion, lblCopy, lblUsuario, lblIconoUsu, lblContraseya;

	private JTextField txtUsuario;
	private JPasswordField passContraseya;
	private JButton btnIniciarSession, btnRegistrarse, btnSalir;
	private JLabel lblRegistrate;
	private JLabel lbl_o;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLoginN frame = new VentanaLoginN();
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

	public VentanaLoginN() {
		setTitle("LogIn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1414, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pnlPrincipal = new JPanel();
		contentPane.add(pnlPrincipal, BorderLayout.CENTER);
		pnlPrincipal.setLayout(new GridLayout(0, 2, 0, 0));

		pnlIzquierda = new JPanel();
		pnlIzquierda.setBackground(new Color(255, 140, 0));
		pnlPrincipal.add(pnlIzquierda);
		pnlIzquierda.setLayout(new MigLayout("", "[grow]", "[59.00][][46.00][36.00,top][][3.00][41.00][][fill][46.00][47.00,grow][][][][][][][][][][][][]"));

		lblIniciarSesion = new JLabel("Bienvenido de nuevo");
		lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesion.setBorder(null);
		lblIniciarSesion.setFont(new Font("Montserrat", Font.BOLD, 30));
		pnlIzquierda.add(lblIniciarSesion, "cell 0 0,alignx left,aligny center");

		lblIconoUsu = new JLabel("");
		lblIconoUsu.setIcon(new ImageIcon(VentanaLoginN.class.getResource("/img/basketc.png")));
		pnlIzquierda.add(lblIconoUsu, "cell 0 2,alignx center,aligny center");

		lblUsuario = new JLabel("Correo:");
		lblUsuario.setFont(new Font("Montserrat", Font.PLAIN, 16));
		pnlIzquierda.add(lblUsuario, "cell 0 3,alignx left,aligny center");

		txtUsuario = new JTextField();
		pnlIzquierda.add(txtUsuario, "cell 0 4,growx,aligny center");
		txtUsuario.setColumns(10);

		lblContraseya = new JLabel("Contraseña:");
		lblContraseya.setFont(new Font("Montserrat", Font.PLAIN, 16));
		pnlIzquierda.add(lblContraseya, "cell 0 6,alignx left,aligny center");

		passContraseya = new JPasswordField();
		pnlIzquierda.add(passContraseya, "cell 0 7,growx");

		pnlDerechaa = new JPanel();
		pnlDerechaa.setBorder(new MatteBorder(0, 3, 0, 0, (Color) new Color(0, 0, 0)));
		pnlDerechaa.setBackground(UIManager.getColor("Button.background"));
		pnlPrincipal.add(pnlDerechaa);
		pnlDerechaa.setLayout(new MigLayout("", "[598px]", "[][fill][][][][][][][][][][][][][]"));
				
				lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon(VentanaLoginN.class.getResource("/img/Diseño sin título.png")));
				pnlDerechaa.add(lblNewLabel_3, "cell 0 0 1 14");
		
				lblCopy = new JLabel("STRAVA 2022 CopyRight © Todos los derechos reservados a LosMinitos - Política de privacidad");
				lblCopy.setHorizontalAlignment(SwingConstants.CENTER);
				pnlDerechaa.add(lblCopy, "cell 0 14,alignx left,aligny top");

		// Imagenes
		// Imagen Salir boton login

		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/img/xApagada.png"));
		Image imgEscalada = imgIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

		ImageIcon imgIconEnc = new ImageIcon(getClass().getResource("/img/xEncendida.png"));
		Image imgEscaladaEnc = imgIconEnc.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
										
										lbl_o = new JLabel("O Inicia Sesion con:");
										lbl_o.setFont(new Font("Montserrat", Font.PLAIN, 14));
										pnlIzquierda.add(lbl_o, "cell 0 9");
										
										panel = new JPanel();
										pnlIzquierda.add(panel, "cell 0 10,grow");
										panel.setLayout(new GridLayout(1, 0, 0, 0));
										
										lblNewLabel_2 = new JLabel("GOOGLE");
										panel.add(lblNewLabel_2);
										
										lblNewLabel_1 = new JLabel("FACEBOOK");
										panel.add(lblNewLabel_1);
										
										lblNewLabel = new JLabel("LOCAL");
										panel.add(lblNewLabel);
								
										btnSalir = new JButton();
										btnSalir.setOpaque(false);
										btnSalir.addMouseMotionListener(new MouseMotionAdapter() {
											@Override
											public void mouseMoved(MouseEvent e) {
												System.out.println("Prueba");
												btnSalir.setBackground(new Color(0, 0, 0));
											}
										});
										
												btnIniciarSession = new JButton("Iniciar Sesion");
												
														btnIniciarSession.addActionListener(new ActionListener() {
															@SuppressWarnings("deprecation")
															@Override
															public void actionPerformed(ActionEvent e) {
																String usuario = txtUsuario.getText();
												
																String contrasenya = passContraseya.getText();
												
															}
												
														});
																
																		btnRegistrarse = new JButton("Registrarse");
																		btnRegistrarse.setFont(new Font("Monaco", Font.PLAIN, 16));
																		btnRegistrarse.setPreferredSize(new Dimension(120, 50));
																		pnlIzquierda.add(btnRegistrarse, "flowx,cell 0 14,alignx center,aligny center");
													
																btnIniciarSession.setFont(new Font("Monaco", Font.PLAIN, 16));
																btnIniciarSession.setPreferredSize(new Dimension(5000, 50));
																pnlIzquierda.add(btnIniciarSession, "cell 0 14,alignx center,aligny center");
										btnSalir.setText(" Salir");
										btnSalir.setRolloverIcon(new ImageIcon(VentanaLoginN.class.getResource("/img/xEncendida.png")));
										btnSalir.setFont(new Font("Monaco", Font.PLAIN, 16));
										btnSalir.setPreferredSize(new Dimension(5000, 20));
										pnlIzquierda.add(btnSalir, "cell 0 15,alignx center,aligny center");
										btnSalir.setIcon(new ImageIcon(imgEscalada));
										btnSalir.setRolloverIcon(new ImageIcon(imgEscaladaEnc));
										
										lblRegistrate = new JLabel("¡¡ Registrate !!");
										lblRegistrate.setFont(new Font("Montserrat", Font.PLAIN, 20));
										pnlIzquierda.add(lblRegistrate, "cell 0 16,alignx center,aligny center");
		
		//Hilos
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					lblRegistrate.setForeground(new Color (249, 194, 4));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					lblRegistrate.setForeground(Color.BLACK);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();

	}
}
