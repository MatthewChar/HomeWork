import java.util.ArrayList;

public class LocCounter {
	private int lineCount;
	private int ifElseCount;
	private int switchCount;
	private int forCount;
	private int whileCount;
	private int breconCount;
	private int tryCatchCount;
	private int commentCount;
	private String methodName;

	public int getLineCount() {
		return lineCount;
	}

	public int getIfElseCount() {
		return ifElseCount;
	}

	public int getSwitchCount() {
		return switchCount;
	}

	public int getForCount() {
		return forCount;
	}

	public int getWhileCount() {
		return whileCount;
	}

	public int getbreconCount() {
		return breconCount;
	}

	public int gettryCatchCount() {
		return tryCatchCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public String getMethodName() {
		return methodName;
	}

	public String LineCount(String codeStr) {
		commentCount = 0;
		lineCount = 0;
		String[] codeHold = codeStr.split("\n|\r");
		ArrayList<String> newCodeHold = new ArrayList<String>();
		for (int i = 0; i < codeHold.length; i++) {
			if (codeHold[i].contains("//") || codeHold[i].contains("/**") || codeHold[i].contains("/*")) {
				commentCount++;
			}
			if (codeHold[i].isBlank() == true || codeHold[i].contains("//") || codeHold[i].contains("/**")
					|| codeHold[i].contains("/*") || codeHold[i].contains("*") || codeHold[i].contains("*/")) {
				continue;
			} else {
				newCodeHold.add(codeHold[i]);
				lineCount++;
			}
		}
		// System.out.println(newCodeHold.length);
		controlCount(newCodeHold);
		return "" + lineCount;
	}

	public void controlCount(ArrayList<String> codeHold) {
		ifElseCount = 0;
		switchCount = 0;
		forCount = 0;
		whileCount = 0;
		breconCount = 0;
		tryCatchCount = 0;
		methodName = "";
		for (int i = 0; i < codeHold.size(); i++) {
			if (codeHold.get(i).contains("if (") || codeHold.get(i).contains("if else (")
					|| codeHold.get(i).contains(" else {")) {
				ifElseCount++;
			}
			if (codeHold.get(i).contains("switch (")) {
				switchCount++;
			}
			if (codeHold.get(i).contains("for (")) {
				forCount++;
			}
			if (codeHold.get(i).contains("while (")) {
				whileCount++;
			}
			if (codeHold.get(i).contains("break;") || codeHold.get(i).contains("continue;")) {
				breconCount++;
			}
			if (codeHold.get(i).contains("try {") || codeHold.get(i).contains("catch (")) {
				tryCatchCount++;
			}
			if (codeHold.get(i).contains("public") || codeHold.get(i).contains("private")) {
				String strHolder = codeHold.get(i);
				String[] hold = codeHold.get(i).split(" ");
				if (strHolder.contains("(") && strHolder.contains(")") && strHolder.contains(" {")) {
					for (int j = 0; j < hold.length; j++) {
						if (hold[j].contains("(")) {
							int t = hold[j].indexOf("(");
							methodName += hold[j].substring(0, t) + "\n";
						}
					}
				}
			}
		}
	}
}
