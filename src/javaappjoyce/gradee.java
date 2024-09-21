
package javaappjoyce;

import java.util.Scanner;

public class gradee {
    
    public void getGradeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();
        Grades[] gr = new Grades[numStudents];
        int nums = 0;  
        String choice;

        do {
            System.out.println("-------------------");
            System.out.println("WELCOME TO GRADE APP");
            System.out.println("-------------------");
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. EDIT");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");
            System.out.println("-------------------");

            System.out.print("Enter Option: ");
            int option = sc.nextInt();

            while (option > 5 || option < 1) {
                System.out.print("Invalid Selection, Try Again: ");
                option = sc.nextInt();
            }

            switch (option) {
                case 1:
                    if (nums < numStudents) {
                        System.out.println("Enter details of student " + (nums + 1) + ":");
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Prelim: ");
                        double pr = sc.nextDouble();
                        System.out.print("Midterm: ");
                        double md = sc.nextDouble();
                        System.out.print("Prefinal: ");
                        double pf = sc.nextDouble();
                        System.out.print("Final: ");
                        double fn = sc.nextDouble();

                        gr[nums] = new Grades();
                        gr[nums].addGrades(name, id, pr, md, pf, fn);
                        nums++;
                    } else {
                        System.out.println("Maximum number of students reached.");
                    }
                    break;

                case 2:
                    if (nums == 0) {
                        System.out.println("No students available to view.");
                    } else {
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-20s %-20s%n", "ID", "Name", "Prelim", "Midterm", "Prefinal", "Finals", "Average", "Status");
                        System.out.println("------------------------------------------------------------------------------------------------------------------------------");

                        for (int i = 0; i < nums; i++) {
                            gr[i].viewGrades();
                            double average = gr[i].calculateAverage();
                            String status = gr[i].checkStatus(average);
                            System.out.printf("%-20.2f %-20s%n", average, status);
                        }

                        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
                    }
                    break;

                case 3:
                    if (nums == 0) {
                        System.out.println("No students available to edit.");
                    } else {
                        System.out.print("Enter ID of the Student: ");
                        int editId = sc.nextInt();

                        boolean found = false;
                        for (int i = 0; i < nums; i++) {
                            if (gr[i].id == editId) {
                                System.out.print("New Prelim Grade: ");
                                double newPr = sc.nextDouble();
                                gr[i].editGrades(editId, newPr);
                                System.out.println("Prelim grade updated.");
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Student not found.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Delete functionality not yet implemented.");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;
            }

            System.out.print("Want to continue (y/n)?: ");
            choice = sc.next();
        } while (choice.equalsIgnoreCase("y"));
    }
}

