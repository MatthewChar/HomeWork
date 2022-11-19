import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BookStoreMain {

	private JFrame frame;
	private JTextField SkuText;
	private JTextField TitleText;
	private JTextField PriceText;
	private JTextField QuanText;
	private JTextField SkuSearchText;
	private JTextField RemoveText;
	private JTextArea ViewText;
	private JButton addBtn;
	private JButton SaveBtn;
	private JButton RemoveBtn;
	private JButton DisSkuBtn;
	private JButton DisCateBtn;
	String userName = "";
	private ArrayList<TextBook> cateLoad;
	private Catelog cateSave = new Catelog();
	private TextBook b1;
	private Catelog c1 = new Catelog();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookStoreMain window = new BookStoreMain();
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
	public BookStoreMain() {
		initialize();
		ViewText.setText("Please fill in all items for adding a textbook otherwise your textbook will not be added.");

		RemoveText = new JTextField();
		RemoveText.setBounds(293, 199, 96, 19);
		frame.getContentPane().add(RemoveText);
		RemoveText.setColumns(10);
		boolean exists = true;
		try {
			// get system name
			userName = System.getProperty("user.name");

			// SystemName stores the name of the system
			// System.out.println("System Name : " + userName);
		} catch (Exception E) {
			System.err.println(E.getMessage());
		}
		File fileLoad = new File("C:\\Users\\" + userName + "\\Desktop\\LoadCatelog.txt");
		// File file = new File("Desktop\\LoadCatelog.txt");
		exists = fileLoad.exists();
		if (exists == true) {

			// Changing the file permissions
			fileLoad.setExecutable(true);
			fileLoad.setReadable(true);
			fileLoad.setWritable(true);
			// System.out.println("File permissions changed.");
			try {
				FileInputStream readData = new FileInputStream(fileLoad);
				ObjectInputStream readStream = new ObjectInputStream(readData);

				cateLoad = (ArrayList<TextBook>) readStream.readObject();
				readStream.close();
				c1.setCatelog(cateLoad);

			} catch (IOException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {
			ViewText.setText("File not found, but if this is your first run of the program then this is normal.");
			// System.out.println("File not found");
		}

//		File fileSave = new File("C:\\Users\\" + userName + "\\Desktop\\LoadCatelog.txt");
//		//Path filePath = Paths.get(file.getPath());
//		try {
//			FileOutputStream writeData = new FileOutputStream(fileSave);
//			ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
//
//			writeStream.writeObject(cateSave.getCatelog());
//			writeStream.flush();
//			writeStream.close();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performCatelog();
			}
		});

		RemoveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performCatelogRemove();
			}
		});

		DisSkuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performSkuDisplay();
			}
		});

		DisCateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performDisplay();
			}
		});

//		LoadBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				fileChooserSearch = new JFileChooser();
//				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
//				fileChooserSearch.setFileFilter(filter);
//				int returnVal = fileChooserSearch.showOpenDialog(null);
//				if (returnVal == JFileChooser.APPROVE_OPTION) {
//					File file = fileChooserSearch.getSelectedFile();
//					// Path filePath = Paths.get(file.getPath());
//					try {
//						FileInputStream readData = new FileInputStream(file.getPath());
//						ObjectInputStream readStream = new ObjectInputStream(readData);
//
//						cateLoad = (ArrayList<TextBook>) readStream.readObject();
//						readStream.close();
//						// System.out.println(textbook2.toString());
//					} catch (IOException | ClassNotFoundException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//				performCatelog(); //perfromLoad();	
//			}
//		});
		SaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				fileChooserSave = new JFileChooser();
//				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
//				fileChooserSave.setFileFilter(filter);
//				int returnVal = fileChooserSave.showOpenDialog(null);
//				if (returnVal == JFileChooser.APPROVE_OPTION) {
				File fileSave = new File("C:\\Users\\" + userName + "\\Desktop\\LoadCatelog.txt");
				// Path filePath = Paths.get(file.getPath());
				try {
					FileOutputStream writeData = new FileOutputStream(fileSave);
					ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

					writeStream.writeObject(cateSave.getCatelog());
					writeStream.flush();
					writeStream.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// }
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 692, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("TextBook Catalog");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(267, 10, 171, 37);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Add TextBook");
		lblNewLabel_1.setBounds(99, 46, 80, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("SKU");
		lblNewLabel_2.setBounds(48, 87, 36, 13);
		frame.getContentPane().add(lblNewLabel_2);

		SkuText = new JTextField();
		SkuText.setBounds(10, 110, 96, 19);
		frame.getContentPane().add(SkuText);
		SkuText.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Title");
		lblNewLabel_3.setBounds(165, 87, 36, 13);
		frame.getContentPane().add(lblNewLabel_3);

		TitleText = new JTextField();
		TitleText.setBounds(140, 110, 96, 19);
		frame.getContentPane().add(TitleText);
		TitleText.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Price");
		lblNewLabel_4.setBounds(39, 150, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Quantity");
		lblNewLabel_5.setBounds(150, 150, 64, 13);
		frame.getContentPane().add(lblNewLabel_5);

		PriceText = new JTextField();
		PriceText.setBounds(10, 173, 96, 19);
		frame.getContentPane().add(PriceText);
		PriceText.setColumns(10);

		QuanText = new JTextField();
		QuanText.setBounds(140, 173, 96, 19);
		frame.getContentPane().add(QuanText);
		QuanText.setColumns(10);

		addBtn = new JButton("Add TextBook");
		addBtn.setBounds(56, 228, 123, 21);
		frame.getContentPane().add(addBtn);

		JLabel lblNewLabel_7 = new JLabel("Save Catalog to a text file");
		lblNewLabel_7.setBounds(479, 57, 189, 13);
		frame.getContentPane().add(lblNewLabel_7);

		SaveBtn = new JButton("Save Catalog");
		SaveBtn.setBounds(479, 87, 123, 21);
		frame.getContentPane().add(SaveBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 282, 658, 155);
		frame.getContentPane().add(scrollPane);

		ViewText = new JTextArea();
		scrollPane.setViewportView(ViewText);

		JLabel lblNewLabel_8 = new JLabel("Remove TextBook");
		lblNewLabel_8.setBounds(289, 176, 113, 13);
		frame.getContentPane().add(lblNewLabel_8);

		RemoveBtn = new JButton("Remove TextBook");
		RemoveBtn.setBounds(267, 228, 141, 21);
		frame.getContentPane().add(RemoveBtn);

		JLabel lblNewLabel_9 = new JLabel("Display TextBook Using SKU");
		lblNewLabel_9.setBounds(250, 87, 188, 13);
		frame.getContentPane().add(lblNewLabel_9);

		DisSkuBtn = new JButton("Display TextBook");
		DisSkuBtn.setBounds(279, 146, 133, 21);
		frame.getContentPane().add(DisSkuBtn);

		SkuSearchText = new JTextField();
		SkuSearchText.setBounds(293, 110, 96, 19);
		frame.getContentPane().add(SkuSearchText);
		SkuSearchText.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Display Catelog");
		lblNewLabel_10.setBounds(506, 135, 96, 13);
		frame.getContentPane().add(lblNewLabel_10);

		DisCateBtn = new JButton("Display Catelog");
		DisCateBtn.setBounds(479, 172, 123, 21);
		frame.getContentPane().add(DisCateBtn);
	}

	public void performCatelog() {
		Integer convertSku = 0;
		Integer convertQuan = 0;
		Double convertD = 0.0;
		if (SkuText.getText().isEmpty() == false && QuanText.getText().isEmpty() == false
				&& PriceText.getText().isEmpty() == false && TitleText.getText().isEmpty() == false) {
			convertSku = Integer.parseInt(SkuText.getText());
			convertQuan = Integer.parseInt(QuanText.getText());
			convertD = Double.parseDouble(PriceText.getText());
			b1 = new TextBook(convertSku, TitleText.getText(), convertD, convertQuan);
			// c1.check(b1);
			if (c1.check(b1) == false) {
				ViewText.setText("This SKU already exists");
			} else {
				c1.getCatelog().add(b1);
				ViewText.setText(c1.toString());
			}
			// System.out.println(c1.getCatelog().size());
		} else if (SkuText.getText().isEmpty() == true || QuanText.getText().isEmpty() == true
				|| PriceText.getText().isEmpty() == true || TitleText.getText().isEmpty() == true) {
			ViewText.setText("Please do not leave any blanks  for adding a textbook.");
		}
//		if (cateLoad.isEmpty() == false && c1.getCatelog().isEmpty() == true) {
//		c1.setCatelog(cateLoad);
//		} else {
//			
//		}
		// c1.add(b1);
		// ViewText.setText(c1.toString());

		cateSave = c1;
		// System.out.println(cateSave);

	}

//	public void perfromLoad() {
//		System.out.println("This is cateload " + cateLoad);
//	}

	public void performSkuDisplay() {
		String holderSku = "";
		Integer sku = 0;
		int count = 0;
		if (SkuSearchText.getText().isEmpty() == false) {
			sku = Integer.parseInt(SkuSearchText.getText());
			// System.out.println("Outisde " + sku);
			for (int i = 0; i < c1.getCatelog().size(); i++) {
				// System.out.println("inside " + sku);
				// System.out.println("This is c1 " + c1.getCatelog().get(i).getSku());
				// System.out.println("This is c1 " + c1.getCatelog().get(i).toString());
				// System.out.println("inside " + holderSku);
				if (c1.getCatelog().get(i).getSku().equals(sku)) {
					holderSku = c1.getCatelog().get(i).toString();
					break;
				} else {
					holderSku = "The sku you are looking for does not exists";
				}
			}
			ViewText.setText(holderSku);
		}
	}

	public void performDisplay() {
		String holder = "";
		for (int i = 0; i < c1.getCatelog().size(); i++) {
			int count = i + 1;
			holder += c1.getCatelog().get(i).toString() + "\n";
			// System.out.println("This is Item " + count + "\n" +
			// c1.getCatelog().get(i).toString());
		}
		ViewText.setText(holder);
	}

	public void performCatelogRemove() {
		Integer skuNum = 0;
		skuNum = Integer.parseInt(RemoveText.getText());
		ViewText.setText(c1.remove(skuNum));
	}
}
