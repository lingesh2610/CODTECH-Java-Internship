import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    static String fileName = "sample.txt";

    // Write content to file
    public static void writeToFile() {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter text to write into the file:");
            String text = sc.nextLine();

            bw.write(text);
            bw.close();

            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // Read content from file
    public static void readFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            System.out.println("\nFile Content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }

    // Modify file by appending content
    public static void modifyFile() {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter text to add to the file:");
            String text = sc.nextLine();

            bw.newLine();
            bw.write(text);
            bw.close();

            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying the file.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- File Handling Utility ---");
            System.out.println("1. Write to file");
            System.out.println("2. Read file");
            System.out.println("3. Modify file");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    writeToFile();
                    break;
                case 2:
                    readFromFile();
                    break;
                case 3:
                    modifyFile();
                    break;
                case 4:
                    System.out.println("Program exited.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
