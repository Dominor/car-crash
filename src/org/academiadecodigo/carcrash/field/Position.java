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

    public boolean isNearBorder () {

        if (col == 0 || col == Field.getWidth() - 1) {
            return true;
        }

        if (row == 0 || row == Field.getHeight() - 1) {
            return true;
        }
        return false;
    }

    public boolean isValid (int coordinate, CoordinateType type) {
        switch (type) {
            case COLUMN:
                return (coordinate >= 0 && coordinate < Field.getWidth());
            case ROW:
                return (coordinate >= 0 && coordinate < Field.getHeight());
            default:
                return false;
        }
    }

    public void update(Direction direction) {

        switch (direction) {
            case UP:
                if (isValid(row - 1, CoordinateType.ROW)) {
                    row--;
                }
                break;
            case DOWN:
                if (isValid(row + 1, CoordinateType.ROW)) {
                    row++;
                }
                break;
            case LEFT:
                if (isValid(col - 1, CoordinateType.COLUMN)) {
                    col--;
                }
                break;
            case RIGHT:
                if (isValid(col + 1, CoordinateType.COLUMN)) {
                    col++;
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
