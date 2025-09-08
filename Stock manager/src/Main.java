import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StockManager manager = new StockManager();
        int choice;
        do
        {
            System.out.println("\n--- Stock Management System ---");
            System.out.println("1. Add Item");
            System.out.println("2. View Stock");
            System.out.println("3. Delete Item");
            System.out.println("4. Search Item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice)
            {
                case 1 ->
                {
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    manager.addItem(new Item(id, name, qty, price));
                }
                case 2 -> manager.viewStock();
                case 3 ->
                {
                    System.out.print("Enter ID to delete: ");
                    String id = sc.nextLine();
                    manager.deleteItem(id);
                }
                case 4 ->
                {
                    System.out.print("Enter ID or Name to search: ");
                    String query = sc.nextLine();
                    manager.searchItem(query);
                }
                case 5 -> System.out.println("Exiting system.");
                default -> System.out.println("Invalid choice.");
            }
        }
        while (choice != 5);
    }
}