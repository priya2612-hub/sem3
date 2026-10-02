import java.util.*;
import java.time.LocalDate;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract LocalDate calculateDueDate(LocalDate currentDate);
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class Q2_LibraryItemDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1);

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            LocalDate dueDate = item.calculateDueDate(currentDate);

            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}
