
import java.awt.EventQueue;
//import java.awt.Window;
import java.awt.Window;

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
class PatronList {
	private int userid;
    private String lastname;
    private String firstname;
    private String booksquantity;
    private String unpaidfines;
    
    public PatronList(int id, String fname, String lname,
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


public class PatronActivity {

	private JFrame frmPatron;
	private JTable table;
	private JButton btnBorrowBook;
	private JButton btnLogout;

	

	
int buttonState = 1; //Determine which button was clicked, Add User or Edit User
private JTable table_1;
private JButton btnNewButton;

	
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
	static ArrayList<PatronList> listPatron() {
		ArrayList<PatronList> patronlist = new ArrayList<PatronList>();
		Connection conn = getConn();
		PatronList pl;
		
		try {
			
		
		String sql = "SELECT loginid, firstname, middlename, lastname, unpaidfine FROM patron";
		Statement st =  conn.createStatement();
		ResultSet result = st.executeQuery(sql);
			
			while (result.next()) {
				//System.out.println(result.getString(1).toString());
				pl = new PatronList(
						result.getInt(1), 
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getString(5).toString());
				
				patronlist.add(pl);
			}
		
			return patronlist;
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
					PatronActivity window = new PatronActivity();
					window.frmPatron.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PatronActivity() {
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
		for(int i = 0; i < listPatron().size(); i++){
			
	        rowData[0] = listPatron().get(i).getUserID();
	        rowData[1] = listPatron().get(i).getFirstname();
	        rowData[2] = listPatron().get(i).getLastname();
	        rowData[3] = listPatron().get(i).getBooksBorrowed();
	    	rowData[4] = listPatron().get(i).getUnpaidFines();
	   
	        
	    	model.addRow(rowData);
    	}
		table.setModel(model);
	    	
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		//Form Constructor
		frmPatron = new JFrame();
		frmPatron.setResizable(false);
		frmPatron.setTitle("Databetes Library System");
		frmPatron.setBounds(100, 100, 691, 430);
		frmPatron.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPatron.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(170, 30, 493, 345);
		frmPatron.getContentPane().add(scrollPane);
		
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
//		
		btnBorrowBook = new JButton("Book Activity");
		btnBorrowBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PatronBorrowBookActivity window = new PatronBorrowBookActivity();
					window.setVisible(true);
					frmPatron.dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnBorrowBook.setBounds(30, 64, 130, 23);
		frmPatron.getContentPane().add(btnBorrowBook);
		
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					frmPatron.dispose();
					LoginActivity window = new LoginActivity();
					window.showWindow(true);
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogout.setBounds(25, 350, 130, 23);
		frmPatron.getContentPane().add(btnLogout);	
		
		btnNewButton = new JButton("Help ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton.setBounds(30, 30, 130, 23);
		frmPatron.getContentPane().add(btnNewButton);
	}

	

}