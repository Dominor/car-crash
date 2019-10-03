package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class Mustang extends Car {

    public Mustang() {
        super();
    }

    public Mustang(Position position, int speed) {

        super(position, speed);
    }

    @Override
    public String toString () {

        return "M";
    }
}
