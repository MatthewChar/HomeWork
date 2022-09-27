package salesItem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class myMain {

	private JFrame frame;
	private JTextField itemText;
	private JTextField costText;
	private JTextField quanText;
	private JButton btnBuild;
	private JTextArea textList;
	private JLabel lblNewLabel_2;
	private JTextField saleText;

	private SalesSlip num = new SalesSlip();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myMain window = new myMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public myMain() {
		initialize();
		btnBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buildOutput();
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Sales Lists");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(170, 10, 93, 38);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Item");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(69, 62, 52, 21);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Cost: $");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(69, 107, 52, 21);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Quantity");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(58, 146, 63, 21);
		frame.getContentPane().add(lblNewLabel_1_2);

		itemText = new JTextField();
		itemText.setBounds(131, 64, 96, 19);
		frame.getContentPane().add(itemText);
		itemText.setColumns(10);

		costText = new JTextField();
		costText.setColumns(10);
		costText.setBounds(131, 109, 96, 19);
		frame.getContentPane().add(costText);

		quanText = new JTextField();
		quanText.setColumns(10);
		quanText.setBounds(131, 148, 96, 19);
		frame.getContentPane().add(quanText);

		btnBuild = new JButton("Add Item to Sales List");
		btnBuild.setBounds(106, 177, 157, 21);
		frame.getContentPane().add(btnBuild);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(106, 208, 157, 45);
		frame.getContentPane().add(scrollPane);

		textList = new JTextArea();
		textList.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(textList);

		lblNewLabel_2 = new JLabel("Total Sales");
		lblNewLabel_2.setBounds(314, 208, 63, 20);
		frame.getContentPane().add(lblNewLabel_2);

		saleText = new JTextField();
		saleText.setBounds(292, 234, 96, 19);
		frame.getContentPane().add(saleText);
		saleText.setColumns(10);
	}

	private void buildOutput() {
		if (check(itemText.getText()) == false || check(costText.getText()) == false
				|| check(quanText.getText()) == false || costCheck(costText.getText()) == false
				|| costCheck(quanText.getText()) == false) {
			textList.setText("Error");
		} else {
			String item = itemText.getText();
			Double cost = Double.parseDouble(costText.getText());
			Integer quan = Integer.parseInt(quanText.getText());

			num.addNewItem(new saleItem(item, cost, quan));

			textList.setText(num.toWord());
			saleText.setText(num.getToAmt());
		}

	}

	public Boolean costCheck(String str) {
		System.out.println("This is str " + str);
		
		Boolean trueC = true;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.' ) {
				continue;
			}
			else if (Character.isDigit(str.charAt(i)) != true) {
				trueC = false;
			}
		}
		System.out.println("This is trueC " + trueC);
		return trueC;
	}

	public Boolean check(String str) {
		Boolean trueT = true;
		if (str.isEmpty() == true) {
			trueT = false;
		}
		return trueT;
	}

}
