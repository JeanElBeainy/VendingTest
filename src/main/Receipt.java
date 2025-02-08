package main;

import java.io.BufferedWriter;
import java.io.IOException;

public class Receipt {
    BufferedWriter writer;
    String productName;
    int productPrice;
    int productQuantity;
    int finalPrice;


    public Receipt(BufferedWriter writer, String productName, int productPrice, int productQuantity) throws IOException {
            this.writer = writer;
            this.productName = productName;
            this.productPrice = productPrice;
            this.productQuantity = productQuantity;
            this.finalPrice = productPrice * productQuantity;
            setItem(productName, Integer.toString(productPrice), Integer.toString(productQuantity));
    }

    public void setItem(String productName, String productPrice, String productQuantity) throws IOException {
        writer.write(productName
                + ",        "
                + productPrice
                + ",         "
                + productQuantity
                +",           "
                + productPrice);
        writer.newLine();
    }
}
