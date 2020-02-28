
import java.awt.EventQueue;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

// class to handle array list
class BookList{
	
    private int isbn;
    private String title;
    private String published;
    private String shelfid;
    private String dateborrowed;

    public BookList (int isbn, String title, String published, String shelfid, String status, String dateborrowed){
    	this.isbn = isbn;
    	this.title = title;
    	this.published = published;
    	this.shelfid = shelfid;
    	this.dateborrowed = dateborrowed;
		}

    	public int getISBN(){
    		return this.isbn;
    	}	

    	public String getTitle(){
    		return this.title;
    	}
    	
		public String getPublish(){
			return this.published;
		}

		public String getShelfid(){
			return this.shelfid;
		}

		public String getDateBorrowed(){
			return this.dateborrowed;
		}
}


public class LibrarianBorrowBookActivity {

	private JFrame frmRet;
	private JTable table;

	
	static Connection getConnect() {
		
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
	static ArrayList<BookList> listBooks() {
		ArrayList<BookList> userlist = new ArrayList<BookList>();
		Connection conn = getConnect();
		BookList bl;
		
		try {
			
			
			String sql = "SELECT isbn, title, publicationyear, shelf_shelfid, statusdate FROM book";
			Statement st =  conn.createStatement();
			ResultSet result = st.executeQuery(sql);
				
				while (result.next()) {
					//System.out.println(result.getString(1).toString());
					bl = new BookList(
							result.getInt(1), 
							result.getString(2),
							result.getString(3),
							result.getString(4),
							result.getString(5),
							result.getString(6).toString());
					
					userlist.add(bl);
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
					LibrarianBorrowBookActivity window = new LibrarianBorrowBookActivity();
					window.frmRet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		public LibrarianBorrowBookActivity() {
			
			make();
		}
	/**
	 * Create the application.
	 */
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
			for(int i = 0; i < listBooks().size(); i++){
				
		        rowData[0] = listBooks().get(i).getISBN();
		        rowData[1] = listBooks().get(i).getTitle();
		        rowData[2] = listBooks().get(i).getPublish();
		        rowData[3] = listBooks().get(i).getShelfid();
		    	rowData[4] = listBooks().get(i).getDateBorrowed();
		   
		        
		    	model.addRow(rowData);
	    	}
			table.setModel(model);
		    	
		}	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void make() {
		
		//Form Constructor
		frmRet = new JFrame();
		frmRet.setResizable(false);
		frmRet.setTitle("Books");
		frmRet.setBounds(100, 100, 530, 500);
		frmRet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRet.getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 30, 452, 345);
		frmRet.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ISBN", "Title", "Published", "Shelf ID", "Date Borrowed"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(84);
		scrollPane.setViewportView(table);
		
		JButton btnReturn = new JButton("Return Book");
		btnReturn.setBounds(187, 393, 130, 23);
		frmRet.getContentPane().add(btnReturn);
		
		JButton btnReserve = new JButton("Reserve Book");
		btnReserve.setBounds(352, 393, 130, 23);
		frmRet.getContentPane().add(btnReserve);
		
		JButton btnBorrow = new JButton("Borrow Book");
		btnBorrow.setBounds(30, 393, 130, 23);
		frmRet.getContentPane().add(btnBorrow);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						frmRet.dispose();
						UsersActivity.main(null);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}});
		btnNewButton.setBounds(187, 427, 130, 23);
		frmRet.getContentPane().add(btnNewButton);


	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianBorrowBookActivity window = new LibrarianBorrowBookActivity();
					window.frmRet.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}