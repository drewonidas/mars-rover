public class App {
    public static void main(String[] args) throws Exception {
        // Get inputs
        int gridMaxX = 5;
        int gridMaxY = 5;
        int inputX = 1;
        int inputY = 2;
        char direction = 'N';

        // Create rover object
        Rover rover1 = new Rover(inputX, inputY, direction);
        for (int count = 0; count < 4; count++) {
            rover1.changeDirection('L');
            rover1.move();
        }
        rover1.move();
        
        System.out.println(rover1.getCurrentPostion());
    }
}
