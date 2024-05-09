public class Submarine extends Ships{
    private static final int Power = 3;
    private int orientation;
    private int startColumn;
    private int startRow;    
    private static final int size = 3;
    private boolean isSunk = false;
    public static final int identity = 5;
    private static int lives = 2;

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
    
    //MADE BY AAYUSH
    public void PowerAttack(int row, int col, Player opponent, Player currPlayer){
                //Will attack an entire column
                for (int i = 0; i < 10; i++ ) {
                    if (opponent.ShipGrid[row][i] != null) {
                        currPlayer.AttackGrid[row][i] = 1;
                    }
                    else {
                        currPlayer.AttackGrid[row][i] = 0;
                    }
                }
    }
}