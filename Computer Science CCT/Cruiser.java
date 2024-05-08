public class Cruiser extends Ships {
    private int orientation;
    private int startColumn;
    private int startRow;
    private static final int size = 3;
    private boolean isSunk = false;
    public static final int identity = 3;
    private static int lives = 3;

    //================= CONSTRUCTOR =================//
    public Cruiser(int orientation, int startRow, int startColumn) {
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
    
    /* Gets the size of the ship */
    public int GetSize() {
        return size;
    }

    public int GetIdentity() {
        return identity;
    }

    public int GetPower() {
        return 9; //dummy because it needs to be overriden 
    }
}