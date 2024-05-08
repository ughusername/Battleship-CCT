public class Submarine extends Ships{
    private static final int Power = 3;
    private int orientation;
    private int startColumn;
    private int startRow;    
    private int size = 3;
    private boolean isSunk = false;
    public int identity = 5;

    //================= CONSTRUCTOR =================//
    public Submarine(int orientation, int startRow, int startColumn) {
        this.orientation = orientation;
        this.startColumn = startColumn;
        this.startRow = startRow;
    }
    //================ PUBLIC METHODS ===============//
    public void SetStartRow(int StartRow) {
        this.startRow = StartRow;
    }
    
    /* Get Start Row of Ship
     * @return - Row ship is at */
    public int GetStartRow() {
        return startRow;
    }

    public void SetStartColumn(int startColumn) {
        this.startColumn = startColumn;
    }
    /* Get Start Column of Ship
     * @return - Column ship is at */
    public int GetStartColumn() {
        return startColumn;
    }

    public void SetOrientation(int orientation) {
        this.orientation = orientation;
    }

    /* Get Orientation of Ship
     * @return - value of orientation */
    public int GetOrientation() {
        return orientation;
    }

    public int GetPower() {
        return Power;
    }
    
    /* Gets the size of the ship */
    public int GetSize() {
        return size;
    }

    public int GetIdentity() {
        return identity;
    }
}