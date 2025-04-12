import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  
        for (int tc = 0; tc < t; tc++) {
            Electronics laptop = new Electronics("laptop", 20.0, 10, "Dell");
            Book harryPotter = new Book("Harry Potter", 10.0, 12, "camnh");

            User user1 = new User("Alice");
            User user2 = new User("Bob");
            User user3 = new User("Charlie");

            user1.buyProduct(laptop, 3);
            user1.buyProduct(harryPotter, 10);
            user2.buyProduct(laptop, 1);
            user3.buyProduct(harryPotter, 5);

            System.out.println("====");

            List<User> users = Arrays.asList(user1, user2, user3);
            List<User> sorted = new ArrayList<>(users);
            for (int i = 0; i < sorted.size(); i++) {
                int maxIdx = i;
                for (int j = i + 1; j < sorted.size(); j++) {
                    if (sorted.get(j).getTotalSpent() > sorted.get(maxIdx).getTotalSpent()) {
                        maxIdx = j;
                    }
                }
                if (maxIdx != i) {
                    Collections.swap(sorted, i, maxIdx);
                }
            }
            System.out.println("Users with Highest Total Spent:");
            for (int i = 0; i < sorted.size(); i++) {
                User u = sorted.get(i);
                System.out.printf("%d. %s: $%.1f%n", i + 1, u.getUsername(), u.getTotalSpent());
            }

            System.out.println("====");

            laptop.displayDetails();
            System.out.println("---");
            harryPotter.displayDetails();
        }
        sc.close();
    }
}

abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateCost(int quantity);

    public void displayDetails() {
        System.out.printf("Name: %s%n", name);
        System.out.printf("Price: $%.1f%n", price);
        System.out.printf("Available Quantity: %d%n", quantity);
    }
}

class Book extends Product {
    private String author;

    public Book(String name, double price, int quantity, String author) {
        super(name, price, quantity);
        this.author = author;
    }

    @Override
    public double calculateCost(int qty) {
        return price * qty;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("Author: %s%n", author);
    }
}

class Electronics extends Product {
    private String brand;

    public Electronics(String name, double price, int quantity, String brand) {
        super(name, price, quantity);
        this.brand = brand;
    }

    @Override
    public double calculateCost(int qty) {
        return price * qty * 1.1;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("Brand: %s%n", brand);
    }
}

class User {
    private String username;
    private double totalSpent;

    public User(String username) {
        this.username = username;
        this.totalSpent = 0.0;
    }

    public String getUsername() {
        return username;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public void buyProduct(Product product, int qty) {
        if (qty <= product.quantity) {
            double cost = product.calculateCost(qty);
            System.out.printf("User: %s bought %d %s for $%.1f%n",
                              username, qty, product.name, cost);
            product.quantity -= qty;
            totalSpent += cost;
        } else {
            System.out.printf("Insufficient quantity of %s available.%n", product.name);
        }
    }
}