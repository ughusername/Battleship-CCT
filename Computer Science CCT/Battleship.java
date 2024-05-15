public class Battleship extends Ships {
    private static final int Power = 1;
    private int orientation;
    private int startColumn;
    private int startRow;
    private static final int size = 4;
    private boolean isSunk = false;
    private static final int identity = 2;
    private int lives = 4;

    //================= CONSTRUCTOR =================//
    public Battleship() {
    }

    //================ PUBLIC METHODS ===============//
    /*Set the start row of the ship
     * @param Startrow - the starting row of the ship */
    public void SetStartRow(int StartRow) {
        this.startRow = StartRow;
    }
    
    /* Get Start Row of Ship
     * @return - Row ship is at */
    public int GetStartRow() {
        return startRow;
    }


    /*Set the start Column of the ship
     * @param startColumn - the starting column of the ship */
    public void SetStartColumn(int startColumn) {
        this.startColumn = startColumn;
    }
    
    /* Get Start Column of Ship
     * @return - Column ship is at */
    public int GetStartColumn() {
        return startColumn;
    }

    /* Set the orientation  of the ship
     * @param orientation - 0 is horizontal, 1 is vertical */
    public void SetOrientation(int orientation) {
        this.orientation = orientation;
    }

    /* Get Orientation of Ship
     * @return - value of orientation */
    public int GetOrientation() {
        return orientation;
    }

    /* Get the Power of the Ship
     * @return - the power (int value)
     */
    public int GetPower() {
        return Power;
    }
    
    /* Gets the size of the ship 
     * @return - the int size of ship which is based on private variable in subclass
    */
    public int GetSize() {
        return size;
    }
    // wait leave this one. i might delete it later   ok, btw i should do value too right? like private variable
    //for? the class like Power or isSunk etc...
    public int GetIdentity() {
        return identity;
    }

   /* Set the number of lives of the ship as it decreases by one 
       @param live - the lives of the ship */
    public void SetLives(int live) {
        this.lives -= live;
    }
    
    /* Gets the lives of the ship
     * @return - the number of remaining lives that the ship has  
     */
    public int GetLives() {
        return lives;
    }

    //MADE BY AAYUSH
    // Battleship will attack an entire column
    public void PowerAttack(int row, int col, Player opponent, Player currPlayer) {
        for (int i = 0; i < 10; i++ ) {
            if (opponent.ShipGrid[i][col] != null) {
                currPlayer.AttackGrid[i][col] = 1;
                opponent.ShipGrid[i][col].SetLives(1);
            }
            else {
                currPlayer.AttackGrid[i][col] = 0;
            }
        }
    }
}
