package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Direction;
import org.academiadecodigo.carcrash.field.Position;

public class Fiat extends Car {

    public Fiat() {
        super();
    }

    public Fiat(Position position, int speed, Direction previousDirection, int timesToTurn) {

        super(position, speed, previousDirection, timesToTurn);
    }

    @Override
    public String toString() {

        return "F";
    }

    @Override
    public String toDebugString () {
        return "Fiat " + super.toDebugString();
    }
}
