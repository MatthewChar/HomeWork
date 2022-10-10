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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;

public class MyMain {

	private JFrame frame;
	private JTextField MSDText;
	private JButton btnBuild;
	private JFileChooser fileChooser;
	private String numberHolder;
	private Stack S = new Stack();
	private Stack T = new Stack();
	private String[] strHolder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMain window = new MyMain();
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
	public MyMain() {
		initialize();

		btnBuild.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
				fileChooser.setFileFilter(filter);
				int returnVal = fileChooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					Path filePath = Paths.get(file.getPath());
					try {
						numberHolder = Files.readString(filePath);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				performMSD(numberHolder);
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

		JLabel lblNewLabel = new JLabel("Mean and Standard Deviation");
		lblNewLabel.setBounds(145, 10, 203, 20);
		frame.getContentPane().add(lblNewLabel);

		btnBuild = new JButton("File Chooser");
		btnBuild.setBounds(145, 79, 125, 26);
		frame.getContentPane().add(btnBuild);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(145, 173, 125, 80);
		frame.getContentPane().add(scrollPane);

		MSDText = new JTextField();
		scrollPane.setViewportView(MSDText);
		MSDText.setColumns(10);
	}

	public void performMSD(String numHolder) {
		Integer holder = 0;
		Double meanHold;
		Double stdHold;
		Boolean trueL = S.check(numHolder);

		strHolder = numHolder.split("\\r?\\n");

		for (int i = 0; i < strHolder.length; i++) {
			if (strHolder[i] == "") {
				continue;
			} else {
				if (trueL == false) {
					break;
				} else {
					holder = Integer.parseInt(strHolder[i]);
					S.push(holder);
					T.push(holder);
				}
			}
		}
		if (trueL == false) {
			MSDText.setText("please only input numbers or do not leave the text blank");
		} else {
			meanHold = S.sum(S);
			T.setMean(S.getMean());
			stdHold = T.stdDev(T);

			MSDText.setText("This is your Mean " + meanHold + " This is your Standard Deviation " + stdHold);
		}
	}
}