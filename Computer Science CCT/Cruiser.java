public class Cruiser extends Ship {
    private int orientation;
    private int startColumn;
    private int startRow;

    public Cruiser() {
        //default constructor
    }
    public Cruiser(int orientation, int startRow, int startColumn) {
        this.orientation = orientation;
        this.startColumn = startColumn;
        this.startRow = startRow;
    }
    public int getOrientation() {
        return orientation;
    }
    public int getStartColumn() {
        return startColumn;
    }
    public int getStartRow() {
        return startRow;
    }
}