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

	
	private static Connection conn = null;
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

	private boolean isConnOpen() {
		
		String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl";
		String suname = "bebase";
		String spass = "oracle";
		
		try {
			conn = DriverManager.getConnection(DBURL,suname,spass);
			return true;
		}catch (SQLException se) {
			JOptionPane.showMessageDialog(null, se.getMessage(), "SQL Connection Error",1);
			return false;
			
		}catch (Exception e) {
			return false;
			
		}
	
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
		btnLoginLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText().trim();
				String passowrd = String.valueOf(txtPassword.getPassword());
			
				int count = 0; //counter if a record is found
				
				try {
					
					if (username.trim().isEmpty() || passowrd.trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "User Name and Password must not be empty");
					} else if (isConnOpen()) {
						String sql = "SELECT UserID, password FROM Librarian WHERE UserID = '"+username+"' AND password = '"+passowrd+"'";
						Statement st =  conn.createStatement();
						ResultSet result = st.executeQuery(sql);
						
						while (result.next()) {
							++count; 
						}
						
						//count values:
						//  1 = record found
						//  0 = no record found
						
						if (count<1) { //no query result 
							JOptionPane.showMessageDialog(null, "User Not Found", "Login", JOptionPane.WARNING_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Welcome", "Login", JOptionPane.INFORMATION_MESSAGE);
							UsersActivity.main(null);
							conn.close(); // close database connection
							frmLogin.dispose(); // close Login window
						}
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
			
	
		btnLoginLibrarian.setBounds(20, 148, 140, 23);
		frmLogin.getContentPane().add(btnLoginLibrarian);
		
		JButton btnLoginPatron= new JButton("Login as User");
		btnLoginPatron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText().trim();
				String passowrd = String.valueOf(txtPassword.getPassword());
			
				int count = 0; //counter if a record is found
				
				try {
					
					if (username.trim().isEmpty() || passowrd.trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "User Name and Password must not be empty");
					} else if (isConnOpen()) {
						String sql = "SELECT UserID, password FROM patron WHERE username = '"+username+"' AND password = '"+passowrd+"'";
						Statement st =  conn.createStatement();
						ResultSet result = st.executeQuery(sql);
						
						while (result.next()) {
							++count; 
						}
						
						//count values:
						//  1 = record found
						//  0 = no record found
						
						if (count<1) { //no query result 
							JOptionPane.showMessageDialog(null, "User Not Found", "Login", JOptionPane.WARNING_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Welcome", "Login", JOptionPane.INFORMATION_MESSAGE);
							PatronActivity.main(null);
							conn.close(); // close database connection
							frmLogin.dispose(); // close Login window
						}
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
			
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

	public void showWindow(boolean b) {
		// TODO Auto-generated method stub
		initialize();
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
}
