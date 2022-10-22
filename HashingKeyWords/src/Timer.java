
public class Timer {
	
	private long timeStart;
	private long timeEnd;
	private long timeSum;
	private long timeTotal = 0;
	
	public long startTime() {
		return timeStart = System.currentTimeMillis();
	}
	public long endTime() {
		return timeEnd = System.currentTimeMillis();
	}
	public long sumTime() {
		return timeSum = timeEnd - timeStart;
	}
	public long totalTime() {
		return timeTotal += timeSum;
	}
	public long getTotalTime() {
		return timeTotal;
	}
}
