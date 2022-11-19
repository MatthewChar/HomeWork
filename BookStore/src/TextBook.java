import java.io.Serializable;

public class TextBook implements Serializable{

	private Integer sku;
	private String title;
	private Double price;
	private Integer quan;

	public TextBook(Integer sku, String title, Double price, Integer quan) {
		this.sku = sku;
		this.title = title;
		this.price = price;
		this.quan = quan;
	}

	public Integer getSku() {
		return sku;
	}

	public String getTitle() {
		return title;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQuan() {
		return quan;
	}

	public String toString() {
		return "Stock-Keeping unit: " + sku + "\n" + "title: " + title + "\n"
				+ "price: $" + price + "\n" + "There are " + quan + " copies left";
	}

}
