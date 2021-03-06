package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.Car;
import org.academiadecodigo.carcrash.cars.CarFactory;
import org.academiadecodigo.carcrash.field.Direction;
import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

public class Game {

    public static final int MANUFACTURED_CARS = 20;
    //public static final int MANUFACTURED_CARS = 2;

    /** Container of Cars */
    private Car[] cars;

    // Matrix used to track the positions of the cars in each instant and thus check for collisions.
    private int[][] positions;

    /** Animation delay */
    private int delay;

    public Game(int cols, int rows, int delay) {

        Field.init(cols, rows);
        this.delay = delay;
        positions = new int[cols][rows];

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar();
        }

        Field.draw(cars);
    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (!areAllCarsCrashed()) {

            // Pause for a while
            Thread.sleep(delay);

            // Move all cars
            moveAllCars();

            // Check for collisions
            //checkCollisions();

            // Update screen
            Field.draw(cars);

        }

    }

    private void moveAllCars() {
        for (Car car: cars
             ) {
            car.move();
            checkCollisions(car);
        }
    }

    private boolean areAllCarsCrashed() {
        for (Car car: cars
             ) {
            if (!car.isCrashed()) {
                return false;
            }
        }
        return true;
    }

    /**private void checkCollisions() {
        Position position;

        // reset positions matrix before checking for collisions
        for (int i = 0; i < positions.length; i++) {
            for (int j = 0; j < positions[i].length; j++) {
                positions[i][j] = 0;
            }
        }
        for (Car car : cars) {
            position = car.getPos();
            positions[position.getCol()][position.getRow()]++;
            if (positions[position.getCol()][position.getRow()] > 1) {
                car.setCrashed(true);
            }
        }
    }*/

    private void checkCollisions(Car car) {

        for (Car otherCar : cars) {
            if (car == otherCar) {
                continue;
            }
            if (car.getPos().equals(otherCar.getPos())) {
                car.setCrashed(true);
                otherCar.setCrashed(true);
                System.out.println(car.toDebugString() + " crashed with " + otherCar.toDebugString());
            }
        }
    }

}
