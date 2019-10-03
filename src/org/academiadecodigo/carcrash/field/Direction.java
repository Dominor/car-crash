package org.academiadecodigo.carcrash.field;

import org.academiadecodigo.carcrash.Randomizer;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    /**
     * Pick a random value of the Direction enum.
     * @return a random Direction.
     */
    public static Direction getRandomDirection() {
        return values()[Randomizer.getRandom(values().length)];
    }
}
