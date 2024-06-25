import java.util.*;

public class Main {

        private static final Map<String, Product> products = new HashMap<>();

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine().trim();
                String[] parts = input.split(" ", 2);
                String command = parts[0].toLowerCase();

                switch (command) {
                    case "create":
                        createProduct(parts.length > 1 ? parts[1] : "");
                        break;
                    case "read":
                        readProducts();
                        break;
                    case "update":
                        updateProduct(parts.length > 1 ? parts[1] : "");
                        break;
                    case "delete":
                        deleteProduct(parts.length > 1 ? parts[1] : "");
                        break;
                    case "exit":
                        System.out.println("Exiting program...");
                        return;
                    default:
                        System.out.println("Unknown command. Please use: create, read, update, delete, exit.");
                }
            }
        }

        private static void createProduct(String args) {
            String[] parts = args.split(" ", 4);
            if (parts.length != 4) {
                System.out.println("Invalid format. Use: create $article $name $price $quantity");
                return;
            }
            String article = parts[0];
            String name = parts[1];
            try {
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);

                if (products.containsKey(article)) {
                    System.out.println("Product with this article already exists.");
                } else if (!article.matches("[A-Z0-9]+")) {
                    System.out.println("Article must contain only digits and uppercase Latin letters.");
                } else {
                    products.put(article, new Product(article, name, price, quantity));
                    System.out.println("Product created successfully.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price or quantity. Please enter numeric values.");
            }
        }

        private static void readProducts() {
            if (products.isEmpty()) {
                System.out.println("No products available.");
            } else {
                System.out.println(String.format("%-10s %-20s %-10s %-10s", "Article", "Name", "Price", "Quantity"));
                for (Product product : products.values()) {
                    System.out.println(product);
                }
            }
        }

        private static void updateProduct(String args) {
            String[] parts = args.split(" ", 4);
            if (parts.length != 4) {
                System.out.println("Invalid format. Use: update $article $name $price $quantity");
                return;
            }
            String article = parts[0];
            String name = parts[1];
            try {
                double price = Double.parseDouble(parts[2]);
                int quantity = Integer.parseInt(parts[3]);

                Product product = products.get(article);
                if (product != null) {
                    product.name = name;
                    product.price = price;
                    product.quantity = quantity;
                    System.out.println("Product updated successfully.");
                } else {
                    System.out.println("Product with this article does not exist.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price or quantity. Please enter numeric values.");
            }
        }

        private static void deleteProduct(String args) {
            String article = args.trim();
            if (products.remove(article) != null) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Product with this article does not exist.");
            }
        }
    }

