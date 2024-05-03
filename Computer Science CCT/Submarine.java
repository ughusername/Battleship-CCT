public class Submarine extends Ship{
    private static final int Power = 3;
    private int orientation;
    private int startColumn;
    private int startRow;

    public Submarine() {
        //default constructor
    }
    public Submarine(int orientation, int startRow, int startColumn) {
        this.orientation = orientation;
        this.startColumn = startColumn;
        this.startRow = startRow;
    }
    public static int getPower() {
        return Power;
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