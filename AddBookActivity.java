import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBookActivity extends JFrame {

	private JPanel contentPane;
	private JTextField textIsbn;
	private JTextField textBookTitle;
	private JTextField textDatePublished;
	private JTextField textAuthorId;
	private JTextField textCopyId;
	private JTextField textShelfId;
	
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookActivity frame = new AddBookActivity();
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
	public AddBookActivity() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddABook = new JLabel("Add a Book");
		lblAddABook.setBounds(130, 11, 74, 14);
		contentPane.add(lblAddABook);
		
		JLabel lblIsbnNumber = new JLabel("ISBN Number:");
		lblIsbnNumber.setBounds(10, 48, 88, 14);
		contentPane.add(lblIsbnNumber);
		
		JLabel lblBookTitle = new JLabel("Book Title: ");
		lblBookTitle.setBounds(10, 73, 74, 14);
		contentPane.add(lblBookTitle);
		
		JLabel lblDatePublished = new JLabel("Date Published: ");
		lblDatePublished.setBounds(10, 99, 93, 14);
		contentPane.add(lblDatePublished);
		
		JLabel lblAuthorid = new JLabel("AuthorID: ");
		lblAuthorid.setBounds(10, 124, 88, 14);
		contentPane.add(lblAuthorid);
		
		JLabel lblShelfid = new JLabel("ShelfID:");
		lblShelfid.setBounds(10, 149, 88, 14);
		contentPane.add(lblShelfid);
		
		JLabel lblCopyId = new JLabel("Copy ID:");
		lblCopyId.setBounds(10, 174, 74, 14);
		contentPane.add(lblCopyId);
		
		textIsbn = new JTextField();
		textIsbn.setBounds(108, 45, 200, 20);
		contentPane.add(textIsbn);
		textIsbn.setColumns(10);
		
		textBookTitle = new JTextField();
		textBookTitle.setColumns(10);
		textBookTitle.setBounds(108, 70, 200, 20);
		contentPane.add(textBookTitle);
		
		textDatePublished = new JTextField();
		textDatePublished.setColumns(10);
		textDatePublished.setBounds(108, 93, 200, 20);
		contentPane.add(textDatePublished);
		
		textAuthorId = new JTextField();
		textAuthorId.setColumns(10);
		textAuthorId.setBounds(108, 118, 200, 20);
		contentPane.add(textAuthorId);
		
		textCopyId = new JTextField();
		textCopyId.setColumns(10);
		textCopyId.setBounds(108, 171, 200, 20);
		contentPane.add(textCopyId);
		
		textShelfId = new JTextField();
		textShelfId.setColumns(10);
		textShelfId.setBounds(108, 146, 200, 20);
		contentPane.add(textShelfId);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(
					textIsbn.getText().isEmpty() ||
					textBookTitle.getText().isEmpty() ||
					textDatePublished.getText().isEmpty() ||
					textAuthorId.getText().isEmpty() ||
					textCopyId.getText().isEmpty() ||
					textShelfId.getText().isEmpty()
						) {
					
					JOptionPane.showMessageDialog(null, "Fields are empty", "Error", JOptionPane.INFORMATION_MESSAGE);
					
				}
				
			}
		});
		btnAddBook.setBounds(10, 214, 89, 23);
		contentPane.add(btnAddBook);
		
		JButton btnCancelBook = new JButton("Cancel");
		btnCancelBook.setBounds(225, 214, 89, 23);
		contentPane.add(btnCancelBook);
		
	}

}
