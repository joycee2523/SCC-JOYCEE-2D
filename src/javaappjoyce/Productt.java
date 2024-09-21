
package javaappjoyce;

import java.util.ArrayList;
import java.util.Scanner;

public class Productt {
    private ArrayList<Productss> products = new ArrayList<>();

    public void GetInfo() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("-------------------");
            System.out.println("WELCOME TO PRODUCT APP");
            System.out.println("-------------------");
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. EDIT");
            System.out.println("4. CALCULATE TOTAL PAYMENT");
            System.out.println("5. EXIT");
            System.out.println("-------------------");
            System.out.print("Enter Option: ");
            int option = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Customer Name: ");
                    String customerName = sc.nextLine();
                    System.out.print("Product Name: ");
                    String productName = sc.nextLine();
                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Cash: ");
                    double cash = sc.nextDouble();
                    sc.nextLine(); // Consume newline

                    Productss product = new Productss();
                    product.addProduct(customerName, productName, quantity, price, cash);
                    products.add(product);
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    if (products.isEmpty()) {
                        System.out.println("No products to view.");
                    } else {
                        System.out.println("Product List:");
                        System.out.println("-------------------------------------------------------------------------------------");
                        System.out.printf("%-15s %-20s %-10s %-10s %-10s%n", "Customer Name", "Product Name", "Quantity", "Price", "Cash");
                        System.out.println("-------------------------------------------------------------------------------------");
                        for (Productss prod : products) {
                            prod.viewProduct();
                        }
                        System.out.println("-------------------------------------------------------------------------------------");
                    }
                    break;

                case 3:
                    if (products.isEmpty()) {
                        System.out.println("No products available to edit.");
                    } else {
                        System.out.print("Enter Product Name to edit: ");
                        String nameToEdit = sc.nextLine();
                        boolean found = false;

                        for (Productss prod : products) {
                            if (prod.productName.equalsIgnoreCase(nameToEdit)) { // Check by product name
                                System.out.print("New Customer Name: ");
                                customerName = sc.nextLine();
                                System.out.print("New Product Name: ");
                                productName = sc.nextLine();
                                System.out.print("New Quantity: ");
                                quantity = sc.nextInt();
                                System.out.print("New Price: ");
                                price = sc.nextDouble();
                                System.out.print("New Cash: ");
                                cash = sc.nextDouble();
                                sc.nextLine(); // Consume newline

                                prod.editProduct(customerName, productName, quantity, price, cash);
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("Product not found.");
                        }
                    }
                    break;

                case 4:
                    calculateTotalPayment(sc);
                    break;

                case 5:
                    System.out.println("Exiting Product App...");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void calculateTotalPayment(Scanner sc) {
        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();
        double totalPayment = 0;
        double totalCash = 0;

        for (Productss prod : products) {
            if (prod.customerName.equalsIgnoreCase(customerName)) {
                totalPayment += prod.price * prod.quantity;
                totalCash += prod.cash;
            }
        }

        System.out.println("Product List:");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-10s %-10s %-10s%n", "Customer Name", "Product Name", "Quantity", "Price", "Cash");
        System.out.println("-------------------------------------------------------------------------------------");
        for (Productss prod : products) {
            if (prod.customerName.equalsIgnoreCase(customerName)) {
                prod.viewProduct();
            }
        }
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("Total Payment: %.2f%n", totalPayment);
        System.out.printf("Total Cash: %.2f%n", totalCash);
        System.out.printf("Change: %.2f%n", totalCash - totalPayment);
    }
}
