package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Direction;
import org.academiadecodigo.carcrash.field.Position;

abstract public class Car {

    private boolean crashed;
    private int speed;

    /** The position of the car on the grid */
    private Position pos;

    public Car () {
        this.crashed = false;
        this.speed = 0;
    }
    public Car(Position position, int speed) {

        this.crashed = false;
        this.pos = position;
        this.speed = speed;
    }

    public boolean move (Direction direction) {
        if (isCrashed()) {
            return false;
        }
        return pos.update(speed, direction);
    }

    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {

        return crashed;
    }

    public void setCrashed(boolean crashed) {
        this.crashed = crashed;
    }
}
