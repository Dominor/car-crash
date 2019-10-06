package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Direction;
import org.academiadecodigo.carcrash.field.Position;

public class Mustang extends Car {

    public Mustang() {
        super();
    }

    public Mustang(Position position, int speed, Direction previousDirection, int timesToTurn) {

        super(position, speed, previousDirection, timesToTurn);
    }

    @Override
    public String toString () {

        return "M";
    }

    @Override
    public String toDebugString () {
        return "Mustang " + super.toDebugString();
    }
}
