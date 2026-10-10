
import java.util.*;

interface Insurable {
    double insurance();
}

abstract class Parcel {
    double weight, value;

    Parcel(double w, double v) {
        weight = w;
        value = v;
    }

    abstract double charge();

    double insurance() {
        return 0;
    }

    double total() {
        return charge() + insurance();
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double w, double v) {
        super(w, v);
    }

    double charge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double w, double v) {
        super(w, v);
    }

    public double charge() {
        return 80 + 15 * weight;
    }

    public double insurance() {
        return value * 0.02;
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double w, double v) {
        super(w, v);
    }

    public double charge() {
        return 40 + 10 * weight + 50;
    }

    public double insurance() {
        return value * 0.02;
    }
}

public class Q7_ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel p;

            if (type.equals("STANDARD"))
                p = new StandardParcel(weight, value);
            else if (type.equals("EXPRESS"))
                p = new ExpressParcel(weight, value);
            else
                p = new FragileParcel(weight, value);

            double charge = p.charge();
            double insurance = p.insurance();
            double total = p.total();

            System.out.printf(Locale.US,
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total);

            grandTotal += total;
        }

        System.out.printf(Locale.US,
            "Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
