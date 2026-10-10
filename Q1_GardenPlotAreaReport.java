
import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();
}

class CirclePlot extends Plot {
    double r;

    CirclePlot(String o, double r) {
        super(o);
        this.r = r;
    }

    double area() {
        return Math.PI * r * r;
    }
}

class RectanglePlot extends Plot {
    double l, w;

    RectanglePlot(String o, double l, double w) {
        super(o);
        this.l = l;
        this.w = w;
    }

    double area() {
        return l * w;
    }
}

class TrianglePlot extends Plot {
    double b, h;

    TrianglePlot(String o, double b, double h) {
        super(o);
        this.b = b;
        this.h = h;
    }

    double area() {
        return 0.5 * b * h;
    }
}

public class Q1_GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();
            Plot p;

            if (type.equals("CIRCLE"))
                p = new CirclePlot(owner, sc.nextDouble());
            else if (type.equals("RECTANGLE"))
                p = new RectanglePlot(owner, sc.nextDouble(),
                                      sc.nextDouble());
            else
                p = new TrianglePlot(owner, sc.nextDouble(),
                                     sc.nextDouble());

            double a = p.area();
            System.out.printf(Locale.US, "%s (%s): %.2f%n",
                              owner, type, a);
            total += a;
        }

        System.out.printf(Locale.US, "Total Area: %.2f%n", total);
        sc.close();
    }
}
