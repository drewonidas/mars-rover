public class Rover {
    private int x;
    private int y;
    private int direction;
    private final String directionCharacters = "NESW";

    Rover(String roverParams) {
        String[] params = roverParams.split("\\s+", 3);
        this.x = Integer.parseInt(params[0]);
        this.y = Integer.parseInt(params[1]);
        this.direction = directionCharacters.indexOf(params[2]);
    }

    void parseInstructions(String instructions) {
        for (int c = 0; c < instructions.length(); c++) {
            if (instructions.charAt(c) == 'M') {
                move();
            } else if (instructions.charAt(c) == 'L' || instructions.charAt(c) == 'R') {
                changeDirection(instructions.charAt(c));
            }
        }
    }

    boolean move() {
        switch (directionCharacters.charAt(direction)) {
            case 'N':
                y = y + 1;
                return true;
            case 'E':
                x = x + 1;
                return true;
            case 'S':
                y = y - 1;
                return true;
            case 'W':
                x = x - 1;
                return true;    
            default:
                return false;
        }
    }

    boolean changeDirection(char rotationDirection) {
        int rotationValue;
        if (rotationDirection == 'L') {
            rotationValue = -1;
        } else if (rotationDirection == 'R') {
            rotationValue = 1;
        } else {
            return false;
        }

        direction = direction + rotationValue; 
        if (direction < 0) {
            direction = 3;
        } else if (direction > 3) {
            direction = 0;
        }

        return true;
    }

    String getCurrentPosition() {
        return String.format("%d %d %c", x, y, directionCharacters.charAt(direction));
    }
}
