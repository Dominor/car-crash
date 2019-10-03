package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.*;
import org.academiadecodigo.carcrash.field.Direction;
import org.academiadecodigo.carcrash.field.Position;

public class Test {

    public static void main(String[] args) {

        Car car1 = new Fiat(new Position(3, 2), 1);

        System.out.println(car1);

        car1.move(Direction.UP);

        System.out.println(car1);

        car1.move(Direction.DOWN);

        System.out.println(car1);
    }
}
