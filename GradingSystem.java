import java.util.Scanner;

public class GradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Grading System!");
        System.out.println("Type 'exit' to quit.\n");

        while (true) {
            //รับข้อมูล Name
            System.out.print("Enter Name (or type 'exit' to quit): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            //รับข้อมูล Christian Era
            System.out.print("Enter Christian Era (Year of Birth): ");
            int birthYear = Integer.parseInt(scanner.nextLine());

            //รับข้อมูล Software Testing Score
            System.out.print("Enter Software Testing Score: ");
            int score = Integer.parseInt(scanner.nextLine());

            //คำนวณอายุ
            int currentYear = 2024; //ปีปัจจุบัน
            int age = currentYear - birthYear;

            //กำหนดเกณฑ์ในการให้เกรด
            String grade;
            if (score >= 80) {
                grade = "A";
            } else if (score >= 75) {
                grade = "B+";
            } else if (score >= 70) {
                grade = "B";
            } else if (score >= 65) {
                grade = "C+";
            } else if (score >= 60) {
                grade = "C";
            } else if (score >= 55) {
                grade = "D+";
            } else if (score >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

            //แสดงผลลัพธ์
            System.out.println("\n--- Output ---");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Software Testing Score: " + grade);
            System.out.println("---------------------\n");
        }

        System.out.println("Exiting the program. Goodbye!");
        scanner.close();
    }
}
