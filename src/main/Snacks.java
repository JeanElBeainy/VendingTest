
public class Snacks extends VendingMachine {
	String name,price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setName(String price) {
		this.price = price;
	}
	public Snacks (String name,String price) {
		this.name = name;
		this.price = price;
	}
}
	