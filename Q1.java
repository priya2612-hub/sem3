
import java.util.Scanner;

class Staff {
    String name;
    double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getBonus() {
        return 0;
    }

    String getType() {
        return "Staff";
    }

    double getTotal() {
        return baseSalary + getBonus();
    }

    void display() {
        System.out.printf("%s (%s): base %.1f, bonus %.1f, total %.1f%n",
                name, getType(), baseSalary, getBonus(), getTotal());
    }
}

class Teacher extends Staff {
    Teacher(String name, double baseSalary) {
        super(name, baseSalary);
    }

    double getBonus() {
        return 5000;
    }

    String getType() {
        return "Teacher";
    }
}

class LabAssistant extends Staff {
    LabAssistant(String name, double baseSalary) {
        super(name, baseSalary);
    }

    double getBonus() {
        return 2000;
    }

    String getType() {
        return "LabAssistant";
    }
}

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Staff[] staff = new Staff[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equalsIgnoreCase("Teacher")) {
                staff[i] = new Teacher(name, salary);
            } else if (type.equalsIgnoreCase("LabAssistant")) {
                staff[i] = new LabAssistant(name, salary);
            } else {
                staff[i] = new Staff(name, salary);
            }
        }

        for (int i = 0; i < n; i++) {
            staff[i].display();
            grandTotal += staff[i].getTotal();
        }

        System.out.printf("Grand Total Salary: %.1f%n", grandTotal);
        sc.close();
    }
}
