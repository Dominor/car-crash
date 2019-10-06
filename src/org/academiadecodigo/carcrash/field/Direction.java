package org.academiadecodigo.carcrash.field;

import org.academiadecodigo.carcrash.Randomizer;

import java.security.DigestException;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    public static Direction getOppositeDirection (Direction direction) {

        switch (direction) {
            case UP:
                return DOWN;
            case LEFT:
                return RIGHT;
            case DOWN:
                return UP;
            case RIGHT:
                return LEFT;
            default:
                return null;
        }
    }

    public static Direction[] excludeDirection (Direction direction) {

        switch (direction) {
            case UP:
                return new Direction[]{LEFT, RIGHT, DOWN};
            case LEFT:
                return new Direction[]{UP, RIGHT, DOWN};
            case DOWN:
                return new Direction[]{UP,LEFT,RIGHT};
            default:
                return new Direction[]{UP,LEFT,DOWN};
        }
    }
}
