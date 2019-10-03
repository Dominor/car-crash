package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class Fiat extends Car {

    public Fiat () {
        super();
    }

    public Fiat(Position position, int speed) {

        super(position, speed);
    }

    @Override
    public String toString () {

        return "F";
    }
}
