//Made By Aayush
public class Cruiser extends Ships {
    private final static int NoPower = -3;
    private int orientation;
    private int startColumn;
    private int startRow;
    private int size = 3;
    private boolean isSunk = false;
    public int identity = 3;
    private int lives = 3;
    
    //================= CONSTRUCTOR =================//
    
    public Cruiser(int orientation, int startRow, int startColumn) {
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
      return NoPower;
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
    
    //MADE BY AHMED
    /*Attack the grid with power accordingly
    * @param row - the row of the grid
    *        col - the col of the grid
    *        opponent - opponent player object
    *        currPLayer = currplayer object
    */
    public void PowerAttack(int row, int col, Player opponent, Player currPlayer){
       
    }
}