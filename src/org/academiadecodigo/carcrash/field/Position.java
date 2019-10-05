package org.academiadecodigo.carcrash.field;

public class Position {

    private int col;
    private int row;

    public Position(int col, int row) {

        if (col >= 0 && row >= 0) {
            this.col = col;
            this.row = row;
        }
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    private boolean isValid (int coordinate, CoordinateType type) {
        switch (type) {
            case COLUMN:
                return (coordinate >= 0 && coordinate < Field.getWidth());
            case ROW:
                return (coordinate >= 0 && coordinate < Field.getHeight());
            default:
                return false;
        }
    }

    public void update(int steps, Direction direction) {

        switch (direction) {
            case UP:
                if (isValid(row - steps, CoordinateType.ROW)) {
                    row -= steps;
                }
                break;
            case DOWN:
                if (isValid(row + steps, CoordinateType.ROW)) {
                    row += steps;
                }
                break;
            case LEFT:
                if (isValid(col - steps, CoordinateType.COLUMN)) {
                    col -= steps;
                }
                break;
            case RIGHT:
                if (isValid(col + steps, CoordinateType.COLUMN)) {
                    col += steps;
                }
                break;
            default:
                return;
        }
    }

    @Override
    public boolean equals(Object o) {
        Position other;

        if (o instanceof Position) {
            other = (Position) o;
            return this.col == other.getCol() && this.row == other.getRow();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Column: " + col + ", Row: " + row;
    }
}
