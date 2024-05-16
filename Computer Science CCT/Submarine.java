//Made By Aayush
public class Submarine extends Ships{
    private static final int Power = 3;         //The variable used to indicate the power of the ship
    private int orientation;                    //The variable used to indicate the orientation of the ship
    private int startColumn;                    //The variable used to indicate the start column of the ship
    private int startRow;                       //The variable used to indicate the start row of the ship
    private static final int size = 3;          //blud blud you dont need to comment on this, it has to be in the SHIPS class and then inherited here and then decalared in the constrtor.
    private boolean isSunk = false;             // okok ill copy it from here then
    public static final int identity = 5;
    private int lives = 2;
    
    //================= CONSTRUCTOR =================//
    public Submarine(int orientation, int startRow, int startColumn) {
      this.orientation = orientation;
      this.startColumn = startColumn;
      this.startRow = startRow;
    }
    //================ PUBLIC METHODS ===============//
    
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
     //submarine will attack an entire column
     public void PowerAttack(int row, int col, Player opponent, Player currPlayer){
       for (int i = 0; i < 10; i++ ) {
         if (opponent.ShipGrid[row][i] != null) {
           currPlayer.AttackGrid[row][i] = 1;
           opponent.ShipGrid[row][i].SetLives(1);
         }
         else {
           currPlayer.AttackGrid[row][i] = 0;
         }
       }
     }
  }