package main;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        //FOR TESTING ONLY

        if (input.equals("1")) {
            VendingMachine item1 = new VendingMachine("c");
            Orders.initializeOrders(item1);

            VendingMachine vendingMachine = new VendingMachine("c");
            Orders.initializeOrders(vendingMachine);
        }
        
        String r = scanner.nextLine();
        System.out.println("Would you like to get a receipt? (yes/no)");
        if(r.equals("yes")) {
            Orders.listOrders();
        }
        scanner.close();
    }
}
