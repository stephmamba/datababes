import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class EditUserActivity extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditUserActivity frame = new EditUserActivity();
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
	public EditUserActivity() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setBounds(31, 43, 89, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("*Middle Name:");
		lblMiddleName.setBounds(31, 68, 89, 14);
		contentPane.add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setBounds(31, 93, 89, 14);
		contentPane.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(31, 139, 89, 14);
		contentPane.add(lblAddress);
		
		JLabel lblCredentials = new JLabel("Credentials");
		lblCredentials.setBounds(31, 11, 92, 14);
		contentPane.add(lblCredentials);
		
		JLabel lblHouseNumber = new JLabel("House Number: ");
		lblHouseNumber.setBounds(31, 164, 117, 14);
		contentPane.add(lblHouseNumber);
		
		JLabel lblStreet = new JLabel("Street: ");
		lblStreet.setBounds(31, 189, 89, 14);
		contentPane.add(lblStreet);
		
		JLabel lblCity = new JLabel("City: ");
		lblCity.setBounds(31, 214, 89, 14);
		contentPane.add(lblCity);
		
		JLabel lblCounty = new JLabel("County: ");
		lblCounty.setBounds(31, 239, 89, 14);
		contentPane.add(lblCounty);
		
		JLabel lblLoginInformation = new JLabel("Login Information");
		lblLoginInformation.setBounds(31, 289, 117, 14);
		contentPane.add(lblLoginInformation);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(31, 314, 89, 14);
		contentPane.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(31, 339, 89, 14);
		contentPane.add(lblPassword);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(130, 161, 183, 20);
		contentPane.add(textField_3);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(31, 387, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(224, 387, 89, 23);
		contentPane.add(btnCancel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(130, 40, 183, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 65, 183, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(130, 90, 183, 20);
		contentPane.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(130, 186, 183, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(130, 211, 183, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(130, 236, 183, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setEditable(false);
		textField_7.setBounds(130, 314, 183, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setEditable(false);
		textField_8.setBounds(130, 336, 183, 20);
		contentPane.add(textField_8);
	}
}
