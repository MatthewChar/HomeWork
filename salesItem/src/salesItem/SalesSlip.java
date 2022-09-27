package salesItem;

import java.util.ArrayList;

public class SalesSlip {

	private ArrayList<saleItem> list;
	
	public SalesSlip() {
		list = new ArrayList<saleItem>();
	}
	
	public void addNewItem(saleItem newItem) {
		list.add(newItem);
	}
	
	public String toWord() {
		String wholeList = "";
		
		for (int i = 0; i < list.size(); i++) {
			wholeList += list.get(i).toString() + "\n";
		}
		
		return wholeList;
	}
	
	public String getToAmt() {
		Double sum = 0.0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).getTotal();
		}
		return "$" + sum;
	}
}