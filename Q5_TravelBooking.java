
import java.util.*;

abstract class Travel {
    double distance;
    static final double FEE = 50;

    Travel(double d) { distance = d; }

    abstract double fare();

    double total() {
        return fare() + FEE;
    }
}

class Bus extends Travel {
    Bus(double d) { super(d); }
    double fare() { return distance * 2; }
}

class Train extends Travel {
    Train(double d) { super(d); }
    double fare() { return distance * 1.5; }
}

class Flight extends Travel {
    Flight(double d) { super(d); }
    double fare() { return 2500 + distance * 4; }
}

public class Q5_TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Travel t;

            if (mode.equals("BUS"))
                t = new Bus(distance);
            else if (mode.equals("TRAIN"))
                t = new Train(distance);
            else
                t = new Flight(distance);

            System.out.printf(Locale.US, "%s: %.2f%n",
                              mode, t.total());
        }

        sc.close();
    }
}

