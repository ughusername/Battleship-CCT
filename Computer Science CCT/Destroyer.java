public class Destroyer extends Ships {
    private static final int Power = 2;
    private int orientation;
    private int startColumn;
    private int startRow;
    private static final int size = 2;
    private boolean isSunk = false;
    public static final int identity = 4;
    private static int lives = 2;

    //================= CONSTRUCTOR =================//
    public Destroyer(int orientation, int startRow, int startColumn) {
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
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (opponent.ShipGrid[i][j] != null) {
                    currPlayer.AttackGrid[i][j] = 1;
                }
                else {
                    currPlayer.AttackGrid[i][j] = 0;
                }  
            }
        }
    }
}
