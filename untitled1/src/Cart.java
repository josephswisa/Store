import java.util.List;

public class Cart {
    private List<Product> productList;
    private double totalCart;

    public Cart(List<Product> productList, double totalCart) {
        this.productList = productList;
        this.totalCart = totalCart;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public double getTotalCart() {
        return totalCart;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void setTotalCart(double totalCart) {
        this.totalCart = totalCart;
    }
}
