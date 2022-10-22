import java.util.Hashtable;
import java.util.Vector;
import java.util.ArrayList;

public class Searcher {

	private Hashtable<String, Integer> table = new Hashtable<>();
	private ArrayList<String> newStr = new ArrayList<String>();
	private Vector<String> keyHolder = new Vector<String>();
	private Integer keyCounter;
	private Integer lineCounter = 0;
	private Timer counter = new Timer();

	//checks to see if key words are in the text and if so are added and counted in the hashtable
	public void keySearch() {
		counter.startTime();
		//System.out.println("In keySearch" + keyHolder);
		for (int i = 0; i < keyHolder.size(); i++) {
			keyCounter = 1;
			for (int j = 0; j < newStr.size(); j++) {
				if (newStr.get(j).contains(keyHolder.get(i))) {
					getTable().put(keyHolder.get(i), keyCounter++);
				}
			}
		}
		counter.endTime();
		counter.sumTime();
		//System.out.println("Counter in keySearch " + counter.sumTime());
		counter.totalTime();
	}

	// Removes comments and empty lines from code and counts line of code
	public void strCheck(String searchStr) {
		counter.startTime();
		String[] strFixer = searchStr.split("\n|\r");

		for (int i = 0; i < strFixer.length; i++) {
			if (strFixer[i].isBlank() == true || strFixer[i].contains("//") || strFixer[i].contains("/**")
					|| strFixer[i].contains("/*") || strFixer[i].contains("*") || strFixer[i].contains("*/")) {
				continue;
			} else {
				newStr.add(strFixer[i]);
				lineCounter++;
			}
		}
		counter.endTime();
		counter.sumTime();
		//System.out.println("Counter in strCheck " + counter.sumTime());
		counter.totalTime();
	}

	// Gets key words and adds to vector
	public void addKeys(String keyWordHolder) {
		counter.startTime();
		String[] strHolder = keyWordHolder.split("\n|\r|\t");

		for (int i = 0; i < strHolder.length; i++) {
			if (strHolder[i] == " " || strHolder[i] == "") {
				continue;
			} else {
				keyHolder.add(strHolder[i]);
			}
		}
		counter.endTime();
		counter.sumTime();
		//System.out.println("Counter in addKeys " + counter.sumTime());
		counter.totalTime();
		//System.out.println("In addkeys" + keyHolder);
	}
	

	public Integer getLineCounter() {
		return lineCounter;
	}

	public Hashtable<String, Integer> getTable() {
		return table;
	}

	public Timer getCounter() {
		return counter;
	}
}