import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("data/testFile.txt"));

            String plateauCoordinates = fileScanner.nextLine();

            while (fileScanner.hasNextLine()) {
                String roverCoordinates = fileScanner.nextLine();
                String roverInstructions = fileScanner.nextLine();

                Rover rover = new Rover(roverCoordinates, plateauCoordinates);
                rover.parseInstructions(roverInstructions);

                System.out.println(rover.getCurrentPosition());
            }

            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Error processing input: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
