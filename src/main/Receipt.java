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
            setItem();
    }

    public void setItem() throws IOException {
        writer.write(this.productName
                + ",        "
                + this.productPrice
                + ",         "
                + this.productQuantity
                +",           "
                + finalPrice);
        writer.newLine();
    }
}
