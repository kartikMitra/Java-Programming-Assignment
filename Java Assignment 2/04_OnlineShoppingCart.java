import java.util.*;

class Product {
    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotal() { return price * quantity; }

    public String toString() {
        return productName + " x" + quantity + " = " + getTotal();
    }
}

class Order {
    private String orderId;
    private List<Product> products = new ArrayList<>();

    public Order(String orderId) { this.orderId = orderId; }
    public void addProduct(Product p) { products.add(p); }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) total += p.getTotal();
        return total;
    }

    public String toString() {
        StringBuilder s = new StringBuilder("Order ID: " + orderId + "\nProducts:");
        for (Product p : products) s.append("\n").append(p);
        s.append("\nTotal: ").append(calculateTotal());
        return s.toString();
    }
}

public class OnlineShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String orderId = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        Order order = new Order(orderId);

        for (int i = 0; i < n; i++) {
            String[] d = sc.nextLine().split(",");
            order.addProduct(new Product(d[0], Double.parseDouble(d[1]), Integer.parseInt(d[2])));
        }

        System.out.println(order);
        sc.close();
    }
}
