public class Submarine extends Ships{
    private static final int Power = 3;
    private int orientation;
    private int startColumn;
    private int startRow;

    //================= CONSTRUCTOR =================//
    public Submarine(int orientation, int startRow, int startColumn) {
        this.orientation = orientation;
        this.startColumn = startColumn;
        this.startRow = startRow;
    }
    //================ PUBLIC METHODS ===============//
    /* Get Orientation of Ship
     * @return - value of orientation */
    public int GetOrientation() {
        return orientation;
    }
    /* Get Start Column of Ship
     * @return - Column ship is at */
    public int GetStartColumn() {
        return startColumn;
    }
    /* Get Start Row of Ship
     * @return - Row ship is at */
    public int GetStartRow() {
        return startRow;
    }
    @Override
    public int GetPower() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetPower'");
    }
}