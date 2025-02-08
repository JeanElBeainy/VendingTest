package main;

public class Drink {
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
    public void setPrice(String price) {
    	this.price = price;
    }
    public Drink (String price,String name){
    	this.name = name;
    	this.price = price;
    }
}
