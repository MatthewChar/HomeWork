import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BookStoreMain{

	private JFrame frame;
	private JTextField SkuText;
	private JTextField TitleText;
	private JTextField PriceText;
	private JTextField QuanText;
	private JTextField DisplayText;
	private JTextArea ViewText;
	private JButton addBtn;
	private JButton LoadBtn;
	private JButton SaveBtn;
	private JButton RemoveBtn;
	private JButton DisSkuBtn;
	private JButton DisCateBtn;
	private JFileChooser fileChooserSearch;
	private JFileChooser fileChooserSave;
	//private String strAdd;
	private String strSearch;
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
		ViewText.setText("If you have an existing catelog please load it up "
				+ "first otherwise you might run into problems.");
		
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performCatelog();
			}
		});
		
		RemoveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performCatelog();
			}
		});
		
		DisSkuBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performDisplay();
			}
		});
		
		DisCateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performDisplay();
			}
		});
		
		LoadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooserSearch = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
				fileChooserSearch.setFileFilter(filter);
				int returnVal = fileChooserSearch.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooserSearch.getSelectedFile();
					// Path filePath = Paths.get(file.getPath());
					try {
						FileInputStream readData = new FileInputStream(file.getPath());
						ObjectInputStream readStream = new ObjectInputStream(readData);

						cateLoad = (ArrayList<TextBook>) readStream.readObject();
						readStream.close();
						// System.out.println(textbook2.toString());
					} catch (IOException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				performCatelog(); //perfromLoad();	
			}
		});
		
		SaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooserSave = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
				fileChooserSave.setFileFilter(filter);
				int returnVal = fileChooserSave.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooserSave.getSelectedFile();
					//Path filePath = Paths.get(file.getPath());
					try {
						FileOutputStream writeData = new FileOutputStream(file.getPath());
						ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

						writeStream.writeObject(cateSave.getCatelog());
						writeStream.flush();
						writeStream.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
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
		
		JLabel lblNewLabel_6 = new JLabel("Load Catalog from text file");
		lblNewLabel_6.setBounds(277, 57, 157, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		LoadBtn = new JButton("Load Catalog");
		LoadBtn.setBounds(267, 83, 123, 21);
		frame.getContentPane().add(LoadBtn);
		
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
		lblNewLabel_8.setBounds(489, 113, 113, 13);
		frame.getContentPane().add(lblNewLabel_8);
		
		RemoveBtn = new JButton("Remove TextBook");
		RemoveBtn.setBounds(479, 136, 141, 21);
		frame.getContentPane().add(RemoveBtn);
		
		JLabel lblNewLabel_9 = new JLabel("Display TextBook Using SKU");
		lblNewLabel_9.setBounds(250, 140, 188, 13);
		frame.getContentPane().add(lblNewLabel_9);
		
		DisSkuBtn = new JButton("Display TextBook");
		DisSkuBtn.setBounds(267, 202, 133, 21);
		frame.getContentPane().add(DisSkuBtn);
		
		DisplayText = new JTextField();
		DisplayText.setBounds(287, 173, 96, 19);
		frame.getContentPane().add(DisplayText);
		DisplayText.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Display Catelog");
		lblNewLabel_10.setBounds(493, 176, 96, 13);
		frame.getContentPane().add(lblNewLabel_10);
		
		DisCateBtn = new JButton("Display Catelog");
		DisCateBtn.setBounds(479, 202, 123, 21);
		frame.getContentPane().add(DisCateBtn);
	}

	// Maybe make the values into strings so you can have nothing appear when
	// pressing other buttons
	public void performCatelog() {
		if (cateLoad != null) {
			c1.setCatelog(cateLoad);
		}
		Integer convertSku = 0;
		Integer convertQuan = 0;
		Double convertD = 0.0;
		if (SkuText.getText().isEmpty() == false || QuanText.getText().isEmpty() == false
				|| PriceText.getText().isEmpty() == false) {
			convertSku = Integer.parseInt(SkuText.getText());
			convertQuan = Integer.parseInt(QuanText.getText());
			convertD = Double.parseDouble(PriceText.getText());
			b1 = new TextBook(convertSku, TitleText.getText(), convertD, convertQuan);
			c1.getCatelog().add(b1);
			ViewText.setText(c1.toString());
			//System.out.println(c1.getCatelog().size());
		}
//		if (cateLoad.isEmpty() == false && c1.getCatelog().isEmpty() == true) {
//		c1.setCatelog(cateLoad);
//		} else {
//			
//		}
		// c1.add(b1);
		//ViewText.setText(c1.toString());

		cateSave = c1;
		//System.out.println(cateSave);

	}

//	public void perfromLoad() {
//		System.out.println("This is cateload " + cateLoad);
//	}
	
	public void performDisplay() {
		String holder = "";
		for (int i = 0; i < c1.getCatelog().size(); i++) {
			int count = i + 1;
			holder += c1.getCatelog().get(i).toString() + "\n";
			System.out.println("This is Item " + count + "\n" + c1.getCatelog().get(i).toString());
		}
		ViewText.setText(holder);
		
	}
}
