package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel lblLu;
	private JTextField tfLU;
	private JLabel lblApellido;
	private JTextField tfAp;
	private JLabel lblNombre;
	private JTextField tfNom;
	private JLabel lblEmail;
	private JTextField tfEmail;
	private JLabel lblGithubUrl;
	private JTextField tfGit;
	private JLabel lbfecha;
	private JLabel lbFoto;
	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
	tabInformation.setLayout(new GridLayout(5, 2, 0, 0));
		
		lblLu = new JLabel("LU");
		lblLu.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabInformation.add(lblLu);
		
		tfLU = new JTextField();
		tabInformation.add(tfLU);
		tfLU.setText(String.valueOf(studentData.getId()));
		tfLU.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabInformation.add(lblApellido);
		
		tfAp = new JTextField();
		tabInformation.add(tfAp);
		tfAp.setText(studentData.getLastName());
		tfAp.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabInformation.add(lblNombre);
		
		tfNom = new JTextField();
		tabInformation.add(tfNom);
		tfNom.setText(studentData.getFirstName());
		tfNom.setColumns(10);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabInformation.add(lblEmail);
		
		tfEmail = new JTextField();
		tabInformation.add(tfEmail);
		tfEmail.setText(studentData.getMail());
		tfEmail.setColumns(10);
		
		lblGithubUrl = new JLabel("Github URL");
		lblGithubUrl.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabInformation.add(lblGithubUrl);
		
		tfGit = new JTextField();
		tabInformation.add(tfGit);
		tfGit.setText(studentData.getGithubURL());
		tfGit.setColumns(10);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		lbfecha = new JLabel("");
		contentPane.add(lbfecha, BorderLayout.SOUTH);
		DateTimeFormatter dfecha= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter dhora=DateTimeFormatter.ofPattern("hh:mm:ss");
		String msjf= "Esta ventana fue generada el " + dfecha.format(LocalDateTime.now()) + " a las " + dhora.format(LocalDateTime.now());
		lbfecha.setText(msjf);
		
		lbFoto = new JLabel("");
		contentPane.add(lbFoto, BorderLayout.CENTER);
		ImageIcon img=null;
		try {
			img = new ImageIcon(new URL(studentData.getPathPhoto()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		lbFoto.setIcon(img);
		contentPane.add(lbFoto, BorderLayout.EAST);
	}
}
