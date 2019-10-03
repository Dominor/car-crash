package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.Randomizer;

public enum CarType {
    FIAT,
    MUSTANG;

    /**
     * Pick a random value of the CarType enum.
     * @return a random CarType.
     */
    public static CarType getRandomCarType() {
        return values()[Randomizer.getRandom(values().length)];
    }
}
