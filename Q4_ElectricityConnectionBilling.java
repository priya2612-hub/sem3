
import java.util.*;

abstract class Connection {
    int units;
    Connection(int u) { units = u; }
    abstract double bill();
}

class Home extends Connection {
    Home(int u) { super(u); }

    double bill() {
        return units <= 100 ? units * 5 :
               500 + (units - 100) * 7;
    }
}

class Shop extends Connection {
    Shop(int u) { super(u); }
    double bill() { return units * 8 + 100; }
}

class Factory extends Connection {
    Factory(int u) { super(u); }
    double bill() { return Math.max(units * 6.0, 1000); }
}

public class Q4_ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;


