//Made By Aayush
public class Submarine extends Ships{
  private final int Power ;
  private final int size;
  public final int identity = 5; 
  private int lives;

  //================= CONSTRUCTOR =================//
  public Submarine(int startRow, int startColumn, int orientation, boolean isSunk, boolean isPlace) {
    super(startRow, startColumn, orientation, isSunk, isPlace);
    this.Power = 3;
    this.size = 3;
    this.lives = 3;
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