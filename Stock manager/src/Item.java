public class Item
{
    private String id;
    private String name;
    private int quantity;
    private double price;
    public Item(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public double getPrice()
    {
        return price;
    }
    @Override
    public String toString()
    {
        return id + "\t" + name + "\t" + quantity + "\t" + price;
    }

    public String toFileFormat()
    {
        return id + "," + name + "," + quantity + "," + price;
    }
}