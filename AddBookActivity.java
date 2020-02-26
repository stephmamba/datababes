import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddBookActivity extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_4;

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
		
		textField = new JTextField();
		textField.setBounds(108, 45, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(108, 70, 200, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(108, 93, 200, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(108, 118, 200, 20);
		contentPane.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(108, 171, 200, 20);
		contentPane.add(textField_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(108, 146, 200, 20);
		contentPane.add(textField_4);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setBounds(10, 214, 89, 23);
		contentPane.add(btnAddBook);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(225, 214, 89, 23);
		contentPane.add(btnNewButton);
	}

}
