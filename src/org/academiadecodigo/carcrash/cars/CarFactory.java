package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.Randomizer;
import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

import java.util.Random;

public class CarFactory {

    public static Car getNewCar() {

       int column = Randomizer.getRandom(Field.getWidth());
       int row = Randomizer.getRandom(Field.getHeight());
       int speed;
       CarType type = CarType.getRandomCarType();
       switch (type) {
            case FIAT:
                return new Fiat(new Position(column, row), 1 + Randomizer.getRandom(Math.min(Field.getHeight(),Field.getWidth())));
            case MUSTANG:
                return new Mustang(new Position(column, row), 1 + Randomizer.getRandom(Math.min(Field.getHeight(),Field.getWidth())));
            default:
               return null;
        }
   }
}
