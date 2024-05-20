//Made By Aayush
public class Battleship extends Ships {
  private final int Power ;
  private final int size;
  public final int identity = 2; 
  private int lives;
  
  //================= CONSTRUCTOR =================//
  public Battleship(int startRow, int startColumn, int orientation, boolean isSunk, boolean isPlace) {
    super(startRow, startColumn, orientation, isSunk, isPlace);
    this.Power = 1;
    this.size =4;
    this.lives = 4;
  }
  //================ PUBLIC METHODS ===============//
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
  