import java.io.*;
import java.nio.file.*;
import java.util.*;

public class StockManager
{
    private static final String FILE_NAME = "stock.txt";
    public void addItem(Item item)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true)))
        {
            bw.write(item.toFileFormat());
            bw.newLine();
            System.out.println("Item added successfully.");
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void viewStock()
    {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nID\tName\tQty\tPrice");
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(",");
                Item item = new Item(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3]));
                System.out.println(item);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteItem(String id)
    {
        boolean deleted = false;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
             BufferedWriter bw = new BufferedWriter(new FileWriter("temp.txt")))
        {

            String line;
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (!parts[0].equals(id.trim()))
                {
                    bw.write(line);
                    bw.newLine();
                }
                else
                {
                    deleted = true;
                }
            }

        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        try {
            Files.move(Paths.get("temp.txt"), Paths.get(FILE_NAME), StandardCopyOption.REPLACE_EXISTING);
            System.out.println(deleted ? "Item deleted." : "Item ID not found.");
        } catch (IOException e) {
            System.out.println("Error renaming file: " + e.getMessage());
        }
    }

    public void searchItem(String query)
    {
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (parts[0].equalsIgnoreCase(query.trim()) || parts[1].equalsIgnoreCase(query.trim()))
                {
                    Item item = new Item(parts[0], parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3]));
                    System.out.println("Item found:\n" + item);
                    found = true;
                    break;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        if (!found)
            System.out.println("Item not found.");
    }
}