import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExportFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "output.txt";

        // exit เพื่อส่งข้อมูลเป็น.txt
        try (FileWriter writer = new FileWriter(fileName)) {
            System.out.println("Welcome to the Grading System! Type 'exit' to quit.\n");

            while (true) {
                // รับข้อมูล Name
                System.out.print("Enter Name (or type 'exit' to quit): ");
                String name = scanner.nextLine();
                if ("exit".equalsIgnoreCase(name)) {
                    System.out.println("Exiting and saving to file...");
                    break;
                }

                // รับข้อมูล Christian Era
                System.out.print("Enter Christian Era (Year of Birth): ");
                int birthYear = Integer.parseInt(scanner.nextLine());

                // รับข้อมูล Software Testing Score
                int score;
                while (true) {
                    System.out.print("Enter Software Testing Score (1-100): ");
                    try {
                        String scoreInput = scanner.nextLine();
                        score = Integer.parseInt(scoreInput);

                        // ตรวจสอบว่าคะแนนอยู่ในช่วง 1-100
                        if (score < 1 || score > 100) {
                            throw new IllegalArgumentException("Score must be between 1 and 100.");
                        }

                        break; // ถ้าคะแนนถูกต้อง ให้ออกจากลูป
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Score must be a whole number.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                // คำนวณอายุ
                int currentYear = 2024; // ปีปัจจุบัน
                int age = currentYear - birthYear;

                // กำหนดเกณฑ์ในการให้เกรด
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

                // เขียนข้อมูลลงไฟล์
                writer.write("Name: " + name + System.lineSeparator());
                writer.write("Age: " + age + System.lineSeparator());
                writer.write("Software Testing Score: " + grade + System.lineSeparator());
                writer.write("---------------------" + System.lineSeparator());

                System.out.println("\n--- Output ---");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Software Testing Score: " + grade);
                System.out.println("---------------------\n");
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("Content has been saved to " + fileName);
    }
}
