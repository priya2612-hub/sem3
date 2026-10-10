
import java.util.*;

interface SaverMode {
    double saving();
}

abstract class Appliance {
    double hours;

    Appliance(double h) {
        hours = h;
    }

    abstract double power();

    double units() {
        return power() * hours / 1000;
    }

    double cost() {
        return units() * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double h) { super(h); }
    double power() { return 150; }
}

class AC extends Appliance implements SaverMode {
    AC(double h) { super(h); }
    double power() { return 1500; }
    public double saving() { return 0.75; }

    double units() {
        return super.units() * saving();
    }
}

class TV extends Appliance {
    TV(double h) { super(h); }
    double power() { return 100; }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) { super(h); }
    double power() { return 500; }
    public double saving() { return 0.75; }

    double units() {
        return super.units() * saving();
    }
}

public class Q10_HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext("SAVER");

            if (saver)
                sc.next();

            Appliance a;

            if (type.equals("FRIDGE"))
                a = new Fridge(hours);
            else if (type.equals("AC"))
                a = new AC(hours);
            else if (type.equals("TV"))
                a = new TV(hours);
            else
                a = new Washer(hours);

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = saver ?
                ((SaverMode) a).saving() * a.units() : a.units();

            double cost = units * 8;

            System.out.printf(Locale.US,
                "%s: Units=%.2f Cost=%.2f%n", type, units, cost);

            total += cost;
        }

        System.out.printf(Locale.US, "Total Cost: %.2f%n", total);
        sc.close();
    }
}
