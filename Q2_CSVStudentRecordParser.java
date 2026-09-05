import java.util.Scanner;

public class Q2_CSVStudentRecordParser {

    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Name: " + fields[0]
                + " | Roll No: " + fields[1]

