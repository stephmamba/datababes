
import java.awt.EventQueue;
//import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//import javax.swing.JTextField;
//import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

// class to handle array list
class UserList {
	private int userid;
    private String lastname;
    private String firstname;
    private String booksquantity;
    private String unpaidfines;
    
    public UserList(int id, String fname, String lname,
    		String numofbooks, String fines){
        this.userid = id;
        this.firstname = fname;
        this.lastname = lname;
        this.booksquantity = numofbooks;
 
        this.unpaidfines = fines;
    }
    
    public int getUserID(){
        return this.userid;
    }

    public String getFirstname(){
        return this.firstname;
    }

    public String getLastname(){
        return this.lastname;
    }
    
    public String getBooksBorrowed(){
        return this.booksquantity;
    }
    
	public String getUnpaidFines(){
        return this.unpaidfines;
    }

}


public class UsersActivity {

	private JFrame frmUsers;
	private JTable table;
	private JButton btnAddUser;
	private JButton btnEditUser;
	private JButton btnDeleteUser;
	private JButton btnAddbook;
	private JButton btnEditbook;
	private JButton btnDeletebook;
	private JButton btnBorrowBook;
	private JButton btnReturnBook;
	private JButton btnPayFines;
	private JButton btnLogout;

	

	
int buttonState = 1; //Determine which button was clicked, Add User or Edit User
private JTable table_1;

	
	static Connection getConn() {
		
		String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl";
		String suname = "test";
		String spass = "oracle";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DBURL,suname,spass);
		}catch (SQLException se) {
			JOptionPane.showMessageDialog(null, se.getMessage(), "SQL Connection Error",1);
	
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL Connection Error",1);
		}
		return conn;

	}
	
	//populate array list for JTable
	static ArrayList<UserList> listUsers() {
		ArrayList<UserList> userlist = new ArrayList<UserList>();
		Connection conn = getConn();
		UserList ul;
		
		try {
			
		
		String sql = "SELECT loginid, firstname, middlename, lastname, unpaidfine FROM patron";
		Statement st =  conn.createStatement();
		ResultSet result = st.executeQuery(sql);
			
			while (result.next()) {
				//System.out.println(result.getString(1).toString());
				ul = new UserList(
						result.getInt(1), 
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getString(5).toString());
				
				userlist.add(ul);
			}
		
			return userlist;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
	}
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersActivity window = new UsersActivity();
					window.frmUsers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UsersActivity() {
		initialize();
	}
	
	private void populateTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] rowData = new Object[5];
		
		//clear table rows
		try {
			model.setRowCount(0);
		} catch (Exception e) {
			// Ignoring Error to continue the program
		}
		
		table.setModel(model);
		
		//re-populate table rows
		for(int i = 0; i < listUsers().size(); i++){
			
	        rowData[0] = listUsers().get(i).getUserID();
	        rowData[1] = listUsers().get(i).getFirstname();
	        rowData[2] = listUsers().get(i).getLastname();
	        rowData[3] = listUsers().get(i).getBooksBorrowed();
	    	rowData[4] = listUsers().get(i).getUnpaidFines();
	   
	        
	    	model.addRow(rowData);
    	}
		table.setModel(model);
	    	
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		//Form Constructor
		frmUsers = new JFrame();
		frmUsers.setResizable(false);
		frmUsers.setTitle("Databetes Library System");
		frmUsers.setBounds(100, 100, 691, 430);
		frmUsers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUsers.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 30, 493, 345);
		frmUsers.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User ID", "First name", "Last name", "Books Borrowed", "Transaction Status", "Pending Fines"
			}
		));
		table_1.getColumnModel().getColumn(3).setPreferredWidth(92);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(104);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(83);
		scrollPane.setViewportView(table_1);
		
		btnAddUser = new JButton("Add User");
		btnAddUser.setBounds(25, 30, 130, 23);
		frmUsers.getContentPane().add(btnAddUser);
		
		btnEditUser = new JButton("Edit User");
		btnEditUser.setBounds(25, 53, 130, 23);
		frmUsers.getContentPane().add(btnEditUser);

		
		btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.setBounds(25, 76, 130, 23);
		frmUsers.getContentPane().add(btnDeleteUser);

	//	
		btnAddbook = new JButton("Add a New Book");
		btnAddbook.setBounds(25, 140, 130, 23);
		frmUsers.getContentPane().add(btnAddbook);

								
		btnEditbook = new JButton("Edit a Book");
		btnEditbook.setBounds(25, 163, 130, 23);
		frmUsers.getContentPane().add(btnEditbook);
		
		btnDeletebook = new JButton("Delete a Book");
		btnDeletebook.setBounds(25, 186, 130, 23);
		frmUsers.getContentPane().add(btnDeletebook);
//		
		btnBorrowBook = new JButton("Borrow a Book");
		btnBorrowBook.setBounds(25, 250, 130, 23);
		frmUsers.getContentPane().add(btnBorrowBook);
		
		btnReturnBook = new JButton("Return a Book");
		btnReturnBook.setBounds(25, 273, 130, 23);
		frmUsers.getContentPane().add(btnReturnBook);
		
		btnPayFines = new JButton("Pay Fines");
		btnPayFines.setBounds(25, 296, 130, 23);
		frmUsers.getContentPane().add(btnPayFines);
		
		
		btnLogout = new JButton("Logout");
		btnLogout.setBounds(25, 350, 130, 23);
		frmUsers.getContentPane().add(btnLogout);
		

		
	
	}

}
