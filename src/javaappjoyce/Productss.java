
package javaappjoyce;

public class Productss {
    String customerName;
    String productName;
    int quantity;
    double price;
    double cash;

    public void addProduct(String customerName, String productName, int quantity, double price, double cash) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.cash = cash;
    }

    public void viewProduct() {
        System.out.printf("%-15s %-20s %-10d %-10.2f %-10.2f%n",
                this.customerName, this.productName, this.quantity, this.price, this.cash);
    }

    public void editProduct(String customerName, String productName, int quantity, double price, double cash) {
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.cash = cash;
    }
}


