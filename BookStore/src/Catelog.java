import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Catelog implements Serializable {

	private ArrayList<TextBook> catelog = new ArrayList<TextBook>();

	public String toString() {
		String show = "";
		for (int i = 0; i < getCatelog().size(); i++) {
			show = getCatelog().get(i).toString();
		}
		return show;
	}

	public boolean check(TextBook b1) {
		boolean check = true;
		for (int i = 0; i < catelog.size(); i++) {
			if (catelog.get(i).getSku().equals(b1.getSku())) {
				check = false;
			}
		}
		return check;
	}

	public String remove(Integer skuNum) {
		String ans = "";
		boolean check = true;
		int count = 0;
		ArrayList<TextBook> newCatelog = new ArrayList<TextBook>();
		for (int i = 0; i < catelog.size(); i++) {
			if (catelog.get(i).getSku().equals(skuNum) == true) {
				count++;
				continue;
			} else {
				newCatelog.add(catelog.get(i));
			}
		}
		if (count > 0) {
			catelog = newCatelog;
			ans = "Removed Successfully";
		} else {
			ans = "SKU could not be found";
		}
		return ans;

	}

	public ArrayList<TextBook> getCatelog() {
		return catelog;
	}

	public void setCatelog(ArrayList<TextBook> catelog) {
		this.catelog = catelog;
	}

}
