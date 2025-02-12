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


        Admin admin = new Admin();

        String[][][] array;
        array = admin.getArray();
        int maxLengthOfStockName = admin.getMaxLengthOfStockName();
        int count = 0;

        StringBuilder s = new StringBuilder();
        for(int i = 0; i < array.length; i++) {
            for(int k = 0; k < array[0][0].length; k++) {
                if(k == 0) {
                    s.append("Product:");
                }
                else if(k == 1) {
                    s.append("Price:  ");
                }
                else {
                    s.append("Quantity:");
                }
                for(int j = 0; j < array[0].length; j++) {
                    if(k == 1) {
                        s.append("   ").append(array[i][j][k]);
                        int lenPrice = array[i][j][1].length() - 1;
                        s.append(" ".repeat(maxLengthOfStockName-lenPrice));
                        s.append("  |");
                    }
                    else if(k == 2) {
                        if(count == 0) {
                            s.append("  ").append(array[i][j][k]);
                            count++;
                        }
                        else {
                            s.append("   ").append(array[i][j][k]);
                        }
                        int lenQuantity = array[i][j][2].length() - 1;
                        s.append(" ".repeat(maxLengthOfStockName-lenQuantity));
                        s.append("  |");
                    }
                    else {
                        s.append("   ").append(array[i][j][k])
                                .append(" ".repeat(maxLengthOfStockName-array[i][j][k].length()))
                                .append("   |");
                    }
                }
                s.append("\n");
            }
            count--;
            s.append("-".repeat("Quantity:".length()-1+array[0].length*(6 + maxLengthOfStockName + 1)));
            s.append("\n");
        }
        System.out.println(s);
        //System.out.println(Arrays.deepToString(array));
    }
}
