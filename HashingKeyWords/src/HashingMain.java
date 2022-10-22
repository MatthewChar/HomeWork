import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class HashingMain {

	private JFrame frame;
	private JTextArea searchText;
	private JButton btnSearch;
	private JButton btnSave;
	private JButton btnKeyWord;
	private JFileChooser fileChooserSearch;
	private JFileChooser fileChooserSave;
	private String searchStr;
	private String keyWordHolder;
	private String saveStr;
	Searcher newSearch = new Searcher();
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HashingMain window = new HashingMain();
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
	public HashingMain() {
		initialize();

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooserSearch = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Java Files", "java");
				fileChooserSearch.setFileFilter(filter);
				int returnVal = fileChooserSearch.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooserSearch.getSelectedFile();
					Path filePath = Paths.get(file.getPath());
					try {
						searchStr = Files.readString(filePath);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				performSearch(searchStr);
			}
		});

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooserSave = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
				fileChooserSave.setFileFilter(filter);
				int returnVal = fileChooserSave.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooserSave.getSelectedFile();
					Path filePath = Paths.get(file.getPath());
					try {
						Files.writeString(filePath, saveStr);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});

		btnKeyWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooserSearch = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
				fileChooserSearch.setFileFilter(filter);
				int returnVal = fileChooserSearch.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooserSearch.getSelectedFile();
					Path filePath = Paths.get(file.getPath());
					try {
						keyWordHolder = Files.readString(filePath);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				performKeySetter(keyWordHolder);
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

		JLabel lblNewLabel = new JLabel("Key Word Finder");
		lblNewLabel.setBounds(180, 10, 119, 20);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Select File to Search");
		lblNewLabel_1.setBounds(64, 62, 119, 20);
		frame.getContentPane().add(lblNewLabel_1);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(64, 104, 85, 21);
		frame.getContentPane().add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 135, 278, 118);
		frame.getContentPane().add(scrollPane);

		searchText = new JTextArea();
		scrollPane.setViewportView(searchText);

		JLabel lblNewLabel_2 = new JLabel("Save to a Text File");
		lblNewLabel_2.setBounds(289, 62, 103, 20);
		frame.getContentPane().add(lblNewLabel_2);

		btnSave = new JButton("Save");
		btnSave.setBounds(296, 104, 85, 21);
		frame.getContentPane().add(btnSave);

		lblNewLabel_3 = new JLabel("Select your Keyword File");
		lblNewLabel_3.setBounds(298, 153, 128, 38);
		frame.getContentPane().add(lblNewLabel_3);

		btnKeyWord = new JButton("Find Keyword");
		btnKeyWord.setBounds(298, 212, 128, 21);
		frame.getContentPane().add(btnKeyWord);
	}

	public void performSearch(String searchStr) {
		//newSearch.addKeys(keyWordHolder);
		newSearch.strCheck(searchStr);
		newSearch.keySearch();
		
		searchText.setText("This is your LOC: " + newSearch.getLineCounter() +"\n" + 
		"This is the key words you used and how many times: " + newSearch.getTable() +"\n" + 
		"This is the time it took to perform the program in seconds: " + newSearch.getCounter().getTotalTime());

		saveStr = searchText.getText();
	}
	
	public void performKeySetter(String keyWordHolder) {
		//searchText.setText(keyWordHolder);
		newSearch.addKeys(keyWordHolder);
	}

}
