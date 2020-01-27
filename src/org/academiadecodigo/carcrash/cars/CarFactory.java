package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.Randomizer;
import org.academiadecodigo.carcrash.field.Direction;
import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

import java.util.Random;

public class CarFactory {

    public static CarType getRandomCarType() {
        CarType[] types = CarType.values();
        return types[Randomizer.getRandom(types.length)];
    }

    public static Car getNewCar() {

       int column = Randomizer.getRandom(Field.getWidth());
       int row = Randomizer.getRandom(Field.getHeight());
       int speed;
       CarType type = getRandomCarType();
       Direction[] directions;
       switch (type) {
            case FIAT:
                directions = Direction.values();
                return new Fiat(new Position(column, row), 1, directions[Randomizer.getRandom(directions.length)], 7);
                //return new Fiat(new Position(3, 1), 1, Direction.LEFT, 10);
            case MUSTANG:
                directions = Direction.values();
                return new Mustang(new Position(column, row), 2, directions[Randomizer.getRandom(directions.length)], 4);
                //return new Mustang(new Position(2, 1), 1, Direction.RIGHT, 10);
            default:
               return null;
        }
   }
}
