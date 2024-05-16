//Made By Aayush
public class Destroyer extends Ships {
    private static final int Power = 2;
    private int orientation;
    private int startColumn;
    private int startRow;
    private static final int size = 2;
    private boolean isSunk = false;
    public static final int identity = 4;
    private int lives = 2;

    //================= CONSTRUCTOR =================//
    public Destroyer(int orientation, int startRow, int startColumn) {
        this.orientation = orientation;
        this.startColumn = startColumn;
        this.startRow = startRow;
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

    /* Get the identity of the ship
     * @return - the int identity of the ship which is based on private variable in subclass
     */
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
    //Power to attack a 2x2 grid around the spot chosen by player
    public void PowerAttack(int row, int col, Player opponent, Player currPlayer){
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (opponent.ShipGrid[i][j] != null) {
                    currPlayer.AttackGrid[i][j] = 1;
                    opponent.ShipGrid[i][j].SetLives(1);
                }
                else {
                    currPlayer.AttackGrid[i][j] = 0;
                }  
            }
        }
    }
}
