import java.awt.EventQueue;
	
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class LoginActivity {
	private JFrame frmLogin;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	Connection conn = null;
	protected Object frmUsers;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginActivity window = new LoginActivity();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public LoginActivity() {
		initialize();
	}

	/**
	 *	Login GUI
	 */
	
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login Here");
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 350, 250);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("Databetes Library System");
		lblLogin.setBounds(90, 15, 150, 23);
		frmLogin.getContentPane().add(lblLogin);
		
		JLabel lblUserName = new JLabel("UserID:");
		lblUserName.setBounds(20, 54, 69, 14);
		frmLogin.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(20, 102, 69, 14);
		frmLogin.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(102, 51, 194, 20);
		frmLogin.getContentPane().add(txtUsername);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(102, 99, 194, 20);
		frmLogin.getContentPane().add(txtPassword);
		
		JButton btnLoginLibrarian = new JButton("Login as Librarian");
		btnLoginLibrarian.setBounds(20, 148, 140, 23);
		frmLogin.getContentPane().add(btnLoginLibrarian);
		
		JButton btnLoginPatron= new JButton("Login as User");
		btnLoginPatron.setBounds(173, 148, 140, 23);
		frmLogin.getContentPane().add(btnLoginPatron);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
			}
		});
		btnCancel.setBounds(120, 178, 89, 23);
		frmLogin.getContentPane().add(btnCancel);

	}
	
	
}
