package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) throws IOException {
        //put receipts in arrayList<arrayList<....
        //first error : overwrite the data, couldn't get two new receipt at the same
        //time. Second is exiting in receipt which threw an error.
        //Third is now, if user wants receipt, I have to write it again.
        BufferedWriter writer = new BufferedWriter(new FileWriter("Receipt.txt"));

        //comment the above writer & uncomment the 3 lines to get a copy.
        //String userHome = System.getProperty("user.home");
        //Path path = Paths.get(userHome, "Documents", "Receipt.txt"); //can either desktop or documents
        //BufferedWriter writer = Files.newBufferedWriter(path);//comment to not create txt


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        if (input.equals("1")) {
            VendingMachine item1 = new VendingMachine("coke");
            new Receipt(writer, item1.productName, item1.getProductPrice(), 1);
            new Receipt(writer, item1.productName, item1.getProductPrice() + 1, 2);
        }
        exit(writer);




        //System.out.println("File path: " + path); //To know the location of the path the receipt has been copied
    }

    public static void exit(BufferedWriter writer) throws IOException {
        writer.close();
    }
}