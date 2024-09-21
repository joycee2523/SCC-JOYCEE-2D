
package javaappjoyce;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Account {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private int UID;

    public static Set<Integer> existingIDs = new HashSet<>();

    public void addInfo(String fname, String lname, String umail, String uname, String pass, int uid) {
        this.firstName = fname;
        this.lastName = lname;
        this.email = umail;
        this.username = uname;
        this.password = pass;
        this.UID = uid;
    }

    public void viewInfo() {
        System.out.printf("| %-5d | %-15s | %-15s | %-25s | %-15s |\n", UID, firstName, lastName, email, username);
    }

    public static String validatePass(String pass) {
        if (pass.length() >= 😎 {
            return "valid";
        }
        return "Password must be at least 8 characters long";
    }

    public void getPersonInfo(Scanner sc) {
        Account[] acc = new Account[100];
        int nums = 0;

        while (true) {
            System.out.println("\n1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. EDIT");
            System.out.println("4. EXIT");
            System.out.print("Enter Option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: // Add Account
                    acc[nums] = new Account();
                    System.out.println("Enter details of user " + (nums + 1));

                    int UID;
                    while (true) {
                        System.out.print("ID: ");
                        UID = sc.nextInt();
                        sc.nextLine();

                        if (!existingIDs.contains(UID)) {
                            existingIDs.add(UID);
                            break;
                        } else {
                            System.out.println("ID already exists! Please enter a different ID.");
                        }
                    }

                    System.out.print("Firstname: ");
                    String fname = sc.nextLine();

                    System.out.print("Lastname: ");
                    String lname = sc.nextLine();

                    System.out.print("Email: ");
                    String umail = sc.nextLine();

                    System.out.print("Username: ");
                    String uname = sc.nextLine();

                    String pass;
                    while (true) {
                        System.out.print("Password: ");
                        pass = sc.nextLine();
                        String passval = Account.validatePass(pass);
                        if (passval.equals("valid")) {
                            break;
                        } else {
                            System.out.println(passval);
                        }
                    }

                    acc[nums].addInfo(fname, lname, umail, uname, pass, UID);
                    nums++;
                    System.out.println("Account added successfully!");
                    break;

                case 2: // View Accounts
                    if (nums == 0) {
                        System.out.println("No accounts to display.");
                    } else {
                        System.out.println("\n| ID   | Firstname      | Lastname       | Email                     | Username       |");
                        System.out.println("-----------------------------------------------------------------------------------------");
                        for (int i = 0; i < nums; i++) {
                            acc[i].viewInfo();
                        }
                    }
                    break;

                case 3: // Edit Account
                    if (nums == 0) {
                        System.out.println("No accounts available to edit.");
                    } else {
                        System.out.print("Enter the ID of the account to edit: ");
                        int editID = sc.nextInt();
                        sc.nextLine();
                        boolean found = false;

                        for (int i = 0; i < nums; i++) {
                            if (acc[i].UID == editID) {
                                System.out.print("New Firstname: ");
                                acc[i].firstName = sc.nextLine();
                                System.out.print("New Lastname: ");
                                acc[i].lastName = sc.nextLine();
                                System.out.print("New Email: ");
                                acc[i].email = sc.nextLine();
                                System.out.print("New Username: ");
                                acc[i].username = sc.nextLine();

                                String newPass;
                                while (true) {
                                    System.out.print("New Password: ");
                                    newPass = sc.nextLine();
                                    String passval = Account.validatePass(newPass);
                                    if (passval.equals("valid")) {
                                        acc[i].password = newPass;
                                        break;
                                    } else {
                                        System.out.println(passval);
                                    }
                                }

                                found = true;
                                System.out.println("Account updated successfully!");
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Account not found.");
                        }
                    }
                    break;

                case 4: // Exit
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}


