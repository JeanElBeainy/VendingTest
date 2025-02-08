package main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("1")) {
            VendingMachine item1 = new VendingMachine("c");
            ArrayList<String> arrayList = new ArrayList<>(3);
            arrayList.add(item1.productName);
            arrayList.add(String.valueOf(item1.productPrice));
            arrayList.add("1");

            VendingMachine item2 = new VendingMachine("c");
            ArrayList<String> arrayList1 = new ArrayList<>(3);
            arrayList1.add(item2.productName);
            arrayList1.add(String.valueOf(item2.productPrice));
            arrayList1.add("1");

            VendingMachine item3 = new VendingMachine("c");
            ArrayList<String> arrayList2 = new ArrayList<>(3);
            arrayList2.add(item3.productName);
            arrayList2.add(String.valueOf(item3.productPrice));
            arrayList2.add("1");
            if(!checkDuplicate(arrayLists, arrayList)) {
                arrayLists.add(arrayList);
            }
            if(!checkDuplicate(arrayLists, arrayList1)) {
                arrayLists.add(arrayList1);
            }
            if(!checkDuplicate(arrayLists, arrayList2)) {
                arrayLists.add(arrayList2);
            }
            //new Orders(arrayList);

            //new Receipt(writer, item1.productName, item1.getProductPrice(), 1);
            //new Receipt(writer, item1.productName, item1.getProductPrice() + 1, 2);
        }

        Scanner scanForReceipt = new Scanner(System.in);
        String r = scanner.nextLine();

        if(r.equals("yes")) {
            listOrders(arrayLists);
        }
    }

    public static boolean checkDuplicate(ArrayList<ArrayList<String>> arrayList, ArrayList<String> array) {
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

    public static void exit(BufferedWriter writer) throws IOException {
        writer.close();
    }

    public static void listOrders(ArrayList<ArrayList<String>> arrayList) throws IOException {
        String userHome = System.getProperty("user.home");
        Path path = Paths.get(userHome, "Documents", "Receipt.txt");
        BufferedWriter writer = Files.newBufferedWriter(path);
        for (int i = 0; i < arrayList.size(); i++) {
            new Receipt(writer, arrayList.get(i).getFirst(),
                    Integer.parseInt(arrayList.get(i).get(1)),
                    Integer.parseInt(arrayList.get(i).get(2)));
        }
        System.out.println("File path: " + path);
        exit(writer);
    }
}
