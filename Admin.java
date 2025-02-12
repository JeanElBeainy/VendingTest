import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Admin {
    private Map<String, Integer> stock;
    private String[][][] array = new String[7][8][3];
    private final String stockFile = "src/stock.txt";
    private int maxLengthOfStockName = 0;

    public Admin() {
        stock = new HashMap<>();
        loadStock();
        //System.out.println(stock.toString());
        //System.out.println(Arrays.deepToString(array));
    }

    public int getMaxLengthOfStockName() {
        return maxLengthOfStockName;
    }

    public String[][][] getArray() {
        return array;
    }

    public void fillArray() {
        for(int i = 0; i < 7; i++) {
            for(int j = 0; j < 8; j++) {
                if(array[i][j][0] == null) {
                    array[i][j][0] = "Empty";
                    array[i][j][1] = "0";
                    array[i][j][2] = "0";
                }
            }
        }
    }

    private void loadStock() {
        try (BufferedReader br = new BufferedReader(new FileReader(stockFile))) {
            String line;
            int row = 0;
            int col = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts[0].length() > maxLengthOfStockName) {
                    maxLengthOfStockName = parts[0].length();
                }
                array[row][col][0] = parts[0];
                array[row][col][1] = parts[1];
                array[row][col][2] = parts[2];
                col++;
                if(col == 8) {
                    row++;
                    col = 0;
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load stock, starting with empty stock.");
            //e.printStackTrace();
        }
        fillArray();
    }

    private void saveStock() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(stockFile))) {
            for (Map.Entry<String, Integer> entry : stock.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save stock.");
        }
    }

    public void addItem(String item, int quantity) {
        stock.put(item, stock.getOrDefault(item, 0) + quantity);
        saveStock();
    }

    public void dispenseItem(String item) {
        if (stock.containsKey(item) && stock.get(item) > 0) {
            stock.put(item, stock.get(item) - 1);
            saveStock();
            System.out.println("Dispensed: " + item);
        } else {
            System.out.println("Item not available or out of stock.");
        }
    }

    public void displayStock() {
    }
}
