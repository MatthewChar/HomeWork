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

public class LocMain {

	private JFrame frame;
	private JButton btnBuild;
	private JTextArea countText;
	private JFileChooser fileChooser;
	private String codeCount;
	private LocCounter javaCounter = new LocCounter();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocMain window = new LocMain();
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
	public LocMain() {
		initialize();

		btnBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Java Files", "java");
				fileChooser.setFileFilter(filter);
				int returnVal = fileChooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					Path filePath = Paths.get(file.getPath());
					try {
						codeCount = Files.readString(filePath);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				performCount(codeCount);
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

		JLabel lblNewLabel = new JLabel("Lines of Code Tester");
		lblNewLabel.setBounds(176, 10, 139, 29);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Select File to count code for");
		lblNewLabel_1.setBounds(170, 49, 196, 29);
		frame.getContentPane().add(lblNewLabel_1);

		btnBuild = new JButton("Count Button");
		btnBuild.setBounds(176, 102, 110, 21);
		frame.getContentPane().add(btnBuild);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 416, 120);
		frame.getContentPane().add(scrollPane);

		countText = new JTextArea();
		scrollPane.setViewportView(countText);
	}

	public void performCount(String codeCount) {
//		String codeAns = "";
//		codeAns = javaCounter.LineCount(codeCount);
		String codeHolder = javaCounter.LineCount(codeCount);
		countText.setText("This is your LOC: " + codeHolder + "\n" + "This is the number of comments you have: "
				+ javaCounter.getCommentCount() + "\n" + "This is your if, else if, else count: "
				+ javaCounter.getIfElseCount() + "\n" + "This is your switch count: " + javaCounter.getSwitchCount()
				+ "\n" + "This is your for loop count: " + javaCounter.getForCount() + "\n"
				+ "This is your while loop count: " + javaCounter.getWhileCount() + "\n"
				+ "This is your break and continue count: " + javaCounter.getbreconCount() + "\n"
				+ "This is your try and catch count: " + javaCounter.gettryCatchCount() + "\n" + 
				"This is how many methods you have: " + javaCounter.getMethodCount());
	}
}
