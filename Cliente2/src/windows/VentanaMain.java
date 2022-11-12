package windows;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaMain extends JFrame {

	private JPanel contentPane;
	protected int resp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMain frame = new VentanaMain();
					frame.setVisible(true);
					System.out.println("a");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMain() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel pnl_Izq = new JPanel();
		contentPane.add(pnl_Izq);
		pnl_Izq.setLayout(new BorderLayout(0, 0));

		JLabel lbl_Img = new JLabel("");
		lbl_Img.setIcon(new ImageIcon(VentanaMain.class.getResource("/img/Diseño sin título.png")));
		pnl_Izq.add(lbl_Img, BorderLayout.CENTER);

		JPanel pnl_Derech = new JPanel();
		contentPane.add(pnl_Derech);
		pnl_Derech.setLayout(new BorderLayout(0, 0));

		JPanel pnl_Arriba = new JPanel();
		pnl_Derech.add(pnl_Arriba, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("¿Que Desea Hacer?");
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD | Font.ITALIC, 20));
		pnl_Arriba.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		pnl_Derech.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 0, 0, 0));

		JButton btnSesion = new JButton("Crear una sesion");
		btnSesion.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(btnSesion);

		JButton btnReto = new JButton("Crear Un Reto");
		btnReto.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_1.add(btnReto);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		JButton btnObtenerRetos = new JButton("Obtener Retos Activos");
		panel_2.add(btnObtenerRetos);
		btnObtenerRetos.setFont(new Font("Montserrat", Font.PLAIN, 15));

		JButton btnActivarReto = new JButton("Activar Reto");

		btnActivarReto.setFont(new Font("Montserrat", Font.PLAIN, 15));
		panel_2.add(btnActivarReto);

		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		JButton btnNewButton_2 = new JButton("Cerrar Sesion");
		btnNewButton_2.setFont(new Font("Montserrat", Font.BOLD, 15));
		panel.add(btnNewButton_2);

		btnActivarReto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JDialog.setDefaultLookAndFeelDecorated(true);
				Object[] selectionValues = { "Ciclismo", "Gordo", "Horses" };
				String initialSelection = "Dogs";
				Object selection = JOptionPane.showInputDialog(null, "¿Que reto quieres activar?", "Retos Activos",
						JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
				System.out.println(selection);
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);

			}
		});

	}

}
