package main;

public class VendingMachine {
    public String productName;
    public int productPrice = 3;

    public VendingMachine(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }
}
