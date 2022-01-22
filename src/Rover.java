import java.util.Arrays;

public class Rover {
    int x;
    int y;
    int direction;
    char[] directionCharacter = {'N', 'W', 'S', 'E'};

    Rover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = Arrays.asList(directionCharacter).indexOf(direction);
    }

    // change rovers postion based on direction value
    boolean move() {
        switch (direction) {
            case 0:
                y = y + 1;
                return true;
            case 1:
                x = x - 1;
                return true;
            case 2:
                y = y - 1;
                return true;
            case 3:
                x = x + 1;
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
        if (direction < 0 || direction > 4) {
            direction = 3;
        }

        return true;
    }

    String getCurrentPostion() {
        return String.format("%d %d %c", x, y, directionCharacter[direction]);
    }
}
