
import java.util.Scanner;

public class Q3_LibraryReturnDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] stack = new String[3];
        String[] queue = new String[3];

        int top = -1;
        int front = 0;
        int rear = -1;
        int size = 0;

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine().trim();

            if (command.startsWith("RETURN ")) {
                String book = command.substring(7).trim();

                if (top == 2) {
                    System.out.println(book + " rejected: pile is full");
                } else {
                    stack[++top] = book;
                    System.out.println(book + " placed on pile");
                }

            } else if (command.equals("SHELVE")) {
                if (top == -1) {
                    System.out.println("pile is empty");
                } else {
                    System.out.println("shelved " + stack[top--]);
                }

            } else if (command.startsWith("WAIT ")) {
                String student = command.substring(5).trim();

                if (size == 3) {
                    System.out.println(student + " rejected: line is full");
                } else {
                    rear = (rear + 1) % 3;
                    queue[rear] = student;
                    size++;
                    System.out.println(student + " joined the line");
                }

            } else if (command.equals("SERVE")) {
                if (size == 0) {
                    System.out.println("no one waiting");
                } else {
                    System.out.println("served " + queue[front]);
                    front = (front + 1) % 3;
                    size--;
                }
            }
        }

        sc.close();
    }
}
