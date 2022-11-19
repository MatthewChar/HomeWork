import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Catelog implements Serializable{
	
	private ArrayList<TextBook> catelog = new ArrayList<TextBook>();
	//HashSet<Integer> skuholder = new HashSet<Integer>();

//	public Catelog(TextBook textBook) {
//		getCatelog().add(textBook);
//	}
	
	public String toString() {
		String show = "";
		for (int i = 0; i < getCatelog().size(); i++) {
			show = getCatelog().get(i).toString();
		}
		return show;
	}
	
//	public void update(ArrayList<TextBook> cateLoad) {
//		for (int m = 0; m < catelog.size(); m++) {
//			skuholder.add(catelog.get(m).getSku());
//		}
//		for (int i = 0; i < skuholder.size(); i++) {
//			for (int j = 0; j < cateLoad.size(); j++) {
//				if (cateLoad.get(j).getSku() == )
//			}
//		}
//	}
//	public String save() {
//		
//	}
	public ArrayList<TextBook> getCatelog() {
		return catelog;
	}
	public void setCatelog(ArrayList<TextBook> catelog) {
		this.catelog = catelog;
	}

}
