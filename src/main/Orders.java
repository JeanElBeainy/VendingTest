package main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Orders {
    static ArrayList<ArrayList<String>> arrayList = new ArrayList<>(); //static for usage in listOrders() Method
    //product name, price , quantity

    public Orders(ArrayList<String> array) {
        if(!checkDuplicate(array)) {
            arrayList.add(array);
        }
    }

    public boolean checkDuplicate(ArrayList<String> array) {
        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).getFirst().equals(array.get(i))) {
                String quantity = arrayList.get(i).get(2);
                int quantityInt = Integer.parseInt(quantity) + 1;
                arrayList.get(i).set(2, Integer.toString(quantityInt));
                return true;
            }
        }
        return false;
    }

    public static void initializeOrders(VendingMachine vendingMachine) {
        ArrayList<String> arrayList1 = new ArrayList<>(3);
        arrayList1.add(vendingMachine.productName);
        arrayList1.add(String.valueOf(vendingMachine.productPrice));
        arrayList1.add("1");
        new Orders(arrayList1);
    }

    public static void listOrders() throws IOException { // static for usage in Main

        String userHome = System.getProperty("user.home");
        Path path = Paths.get(userHome, "Documents", "Receipt.txt"); //can either save to desktop or documents
        BufferedWriter writer = Files.newBufferedWriter(path);
        for (ArrayList<String> strings : arrayList) {
            new Receipt(writer, strings.getFirst(),
                    Integer.parseInt(strings.get(1)),
                    Integer.parseInt(strings.get(2)));
        }
        System.out.println("File Path: " + path);
        writer.close();
    }
}
