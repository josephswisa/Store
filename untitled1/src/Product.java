public class Product {
    private String productName;
    private int quantity;
    private int price;

    public Product(String productName, int quantity, int price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductName() { return this.productName = productName;}

    public int getQuantity() { return this.quantity = quantity;}

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }
}
