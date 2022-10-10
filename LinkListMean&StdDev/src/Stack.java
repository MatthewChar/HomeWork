public class Stack {

	private Node head;
	private Node tail;
	private Double mean;
	private Double stdDev;

	public Stack() {
		head = null;
		tail = null;
		mean = 0.0;
		stdDev = 0.0;

	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public Double getMean() {
		return mean;
	}

	public void setMean(Double mean) {
		this.mean = mean;
	}

	public Double getStdDev() {
		return stdDev;
	}

	public Boolean isEmpty() {
		Boolean True;
		if (head == null && tail == null) {
			True = true;
		} else {
			True = false;
		}
		return True;

	}

	public Boolean check(String big) {
		Boolean trueY = true;
		for (int i = 0; i < big.length(); i++) {
			if (big.charAt(i) == '\n' || big.charAt(i) == '\r') {
				continue;
			} else {
				trueY = Character.isDigit(big.charAt(i));
				if (trueY) {

				} else {
					trueY = false;
					break;
				}
			}
		}
		return trueY;
	}

	public void push(Integer n) {
		Node temp = new Node(n);

		if (head == null) {
			head = temp;
			tail = temp;
		} else {
			temp.prev = tail;
			tail.next = temp;
			tail = temp;
		}

		assert (tail.n == n) : "Node is added to the back";
	}

	public Integer pop() {

		Node errorDet;

		Integer value = 1;

		try {
			errorDet = tail.prev;
			value = tail.n;
			tail = tail.prev;
			if (tail == null) {
				head = null;
			}
			assert (tail == errorDet) : "Value is popped";
		} catch (Exception e) {
			System.out.println("Exception: No Node to pop");
		}

		return value;
	}

	public Double sum(Stack S) {
		int count = 0;
		Stack numS = S;
		Double holdS;
		while (numS.head != null) {
			holdS = Double.valueOf(numS.getTail().n);
			mean += holdS;
			numS.pop();
			count++;
		}
		mean = mean / count;

		return mean;
	}

	public Double stdDev(Stack S) {
		int count = 0;
		Stack numD = S;
		Double holdD;
		Double sum = 0.0;
		while (numD.head != null) {
			holdD = Double.valueOf(numD.getTail().n);
			holdD = Math.pow(Math.abs(holdD - mean), 2);
			sum += holdD;
			numD.pop();
			count++;
		}
		sum = sum / count;
		stdDev = Math.sqrt(sum);

		return stdDev;
	}

}