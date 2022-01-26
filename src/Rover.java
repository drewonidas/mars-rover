public class Rover {
    private int x;
    private int y;
    private int direction;
    private int plateauMaxX;
    private int plateauMaxY;
    private final String directionCharacters = "NESW";

    Rover(String roverParams, String plateauCoordinates) {
        String[] params = roverParams.split("\\s+", 3);
        this.x = Integer.parseInt(params[0]);
        this.y = Integer.parseInt(params[1]);

        String[] coordinates = plateauCoordinates.split("\\s+", 2);
        this.plateauMaxX = Integer.parseInt(coordinates[0]);
        this.plateauMaxY = Integer.parseInt(coordinates[1]);
        this.direction = directionCharacters.indexOf(params[2]);

        checkBounds();
    }

    void parseInstructions(String instructions) {
        for (int c = 0; c < instructions.length(); c++) {
            if (instructions.charAt(c) == 'M') {
                move();
                checkBounds();
            } else if (instructions.charAt(c) == 'L' || instructions.charAt(c) == 'R') {
                changeDirection(instructions.charAt(c));
            }
        }
    }

    void move() {
        switch (directionCharacters.charAt(direction)) {
            case 'N':
                y = y + 1;
                break;
            case 'E':
                x = x + 1;
                break;
            case 'S':
                y = y - 1;
                break;
            case 'W':
                x = x - 1;
                break;
            default:
                break;
        }
    }

    void checkBounds() {
        if ((this.x < 0 || this.x > plateauMaxX) || (this.y < 0 || this.y > plateauMaxY)) {
            throw new RuntimeException("Rover out of bounds");
        }
    }

    void changeDirection(char rotationDirection) {
        int rotationValue;
        if (rotationDirection == 'L') {
            rotationValue = -1;
        } else {
            rotationValue = 1;
        }

        direction = direction + rotationValue; 
        if (direction < 0) {
            direction = 3;
        } else if (direction > 3) {
            direction = 0;
        }
    }

    String getCurrentPosition() {
        return String.format("%d %d %c", x, y, directionCharacters.charAt(direction));
    }
}
