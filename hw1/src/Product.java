class Product {
    String article;
    String name;
    double price;
    int quantity;

    Product(String article, String name, double price, int quantity) {
        this.article = article;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10.2f %-10d", article, name, price, quantity);
    }
}