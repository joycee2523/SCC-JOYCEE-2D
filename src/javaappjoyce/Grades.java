
package javaappjoyce;

public class Grades {
    private String name;
    int id;
    private double prelim;
    private double midterm;
    private double prefinal;
    private double finals;

    public void addGrades(String name, int id, double prelim, double midterm, double prefinal, double finals) {
        this.name = name;
        this.id = id;
        this.prelim = prelim;
        this.midterm = midterm;
        this.prefinal = prefinal;
        this.finals = finals;
    }

    public void viewGrades() {
        System.out.printf("%-10d %-10s %-10.2f %-10.2f %-10.2f %-10.2f%n", id, name, prelim, midterm, prefinal, finals);
    }

    public void editGrades(int id, double newPrelim) {
        this.prelim = newPrelim;
    }

    public double calculateAverage() {
        return (prelim + midterm + prefinal + finals) / 4;
    }

    public String checkStatus(double average) {
        if (average >= 75) {
            return "Passed";
        } else {
            return "Failed";
        }
    }
}
