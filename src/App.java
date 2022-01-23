import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("data/testFile.txt"));

            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String roverLine1 = fileScanner.nextLine();
                String roverLine2 = fileScanner.nextLine();

                Rover rover = new Rover(roverLine1);
                rover.parseInstructions(roverLine2);
                System.out.println(rover.getCurrentPosition());
            }

            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error processing input: " + e.getMessage());
        }
    }
}
