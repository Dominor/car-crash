package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.Randomizer;
import org.academiadecodigo.carcrash.field.Direction;
import org.academiadecodigo.carcrash.field.Position;

import java.util.zip.DeflaterInputStream;

abstract public class Car {

    private boolean crashed;
    private int speed;
    private int speedCounter;

    private int timesToTurn;

    /** The position of the car on the grid */
    private Position pos;

    private Direction previousDirection;

    public Car () {
        this.crashed = false;
        this.speed = 0;
    }
    public Car(Position position, int speed, Direction previousDirection, int timesToTurn) {

        this.crashed = false;
        this.pos = position;
        this.speed = speed;
        this.speedCounter = 0;
        this.previousDirection = previousDirection;
        if (timesToTurn > 0 && timesToTurn <= 10) {
            this.timesToTurn = timesToTurn;
        } else {
            timesToTurn = 1 + Randomizer.getRandom(11);
        }
    }

    private Direction[] excludeDirection(Direction[] array, Direction direction) {
        Direction[] directions = new Direction[array.length - 1];
        int i, k, index = direction.ordinal();
        for (i = 0, k = 0; i < array.length; i++) {

            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            directions[k++] = array[i];
        }
        return directions;
    }

    private Direction chooseDirection () {
        Direction[] directions;
        Direction direction;
        int randomTimes = 1 + Randomizer.getRandom(11);

        if (pos.isNearBorder()) {
            directions = Direction.excludeDirection(previousDirection);
            direction = directions[Randomizer.getRandom(directions.length)];
            previousDirection = direction;
            return direction;
        }

        if (randomTimes > timesToTurn) {
            directions = Direction.excludeDirection(Direction.getOppositeDirection(previousDirection));
            direction = directions[Randomizer.getRandom(directions.length)];
            return direction;
        }
        return previousDirection;
    }

    public void move () {
        if (isCrashed()) {
            return;
        }
        if(speedCounter == speed) {
            Direction direction = this.chooseDirection();
            pos.update(direction);
            speedCounter = 0;
        }
        speedCounter++;
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

    public String toDebugString () {
        return "at position " + getPos() + " with speed " + speed;
    }
}
