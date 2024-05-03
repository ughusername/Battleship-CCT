public class Destroyer extends Ship {
    private static final int Power = 2;
    private int orientation;
    private int startColumn;
    private int startRow;

    public Destroyer() {
        //default constructor
    }
    public Destroyer(int orientation, int startRow, int startColumn) {
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