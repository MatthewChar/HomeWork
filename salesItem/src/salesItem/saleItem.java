package salesItem;

public class saleItem {

	private String item;
	private Double cost;
	private int quan;

	public saleItem(String i, Double c, int q) {
		this.item = i;
		this.cost = c;
		this.quan = q;
	}

	public Double getTotal() {
		return quan * cost;
	}

	public String toString() {
		return (item + "\t$" + cost + "\t" + quan);
	}

	public Boolean checkCost() {
		Boolean trueNum = true;
		
		return trueNum;
	}

}