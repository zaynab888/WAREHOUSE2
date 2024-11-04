import java.util.*;

class Product {
    private String id;
    private String name;
    private int quantity;

    public Product(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Quantity: " + quantity;
    }
}

class InventoryManagement {
    private Map<String, Product> products;
    private List<Product> productList;
    private List<String> dailyShipments;

    public InventoryManagement() {
        products = new HashMap<>();
        productList = new ArrayList<>();
        dailyShipments = new ArrayList<>();
    }

    // Add a new product to the inventory
    public void addProduct(String id, String name, int quantity) {
        if (!products.containsKey(id)) {
            Product product = new Product(id, name, quantity);
            products.put(id, product);
            productList.add(product);
            System.out.println("Product added: " + product);
        } else {
            System.out.println("Product ID already exists.");
        }
    }

    // Look up a product by ID
    public void lookUpProduct(String id) {
        Product product = products.get(id);
        if (product != null) {
            System.out.println("Product found: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Sort products by name
    public void sortProductsByName() {
        Collections.sort(productList, Comparator.comparing(Product::getName));
        System.out.println("Products sorted by name:");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    // Record daily shipments
    public void recordShipment(List<String> receivedProductIds) {
        dailyShipments.addAll(receivedProductIds);
        System.out.println("Daily shipment recorded: " + dailyShipments);
    }

    // Print all product IDs from a daily shipment
    public void printDailyShipment() {
        System.out.println("Daily shipment IDs in order:");
        for (String id : dailyShipments) {
            System.out.println(id);
        }
    }

    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();
        inventory.addProduct("001", "Laptop", 10);
        inventory.addProduct("002", "Smartphone", 20);
        inventory.addProduct("003", "Tablet", 15);

        inventory.lookUpProduct("002");

        List<String> shipment = Arrays.asList("001", "003");
        inventory.recordShipment(shipment);
        inventory.printDailyShipment();

        inventory.sortProductsByName();
    }
}