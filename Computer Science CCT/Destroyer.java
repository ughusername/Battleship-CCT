//Made By Aayush
public class Destroyer extends Ships {
    private final int Power;
    private final int size;
    private boolean IsSunk;
    public static final int identity = 4;
    private int lives;
    private boolean IsPlaced;

    //================= CONSTRUCTOR =================//
    public Destroyer(int startRow, int startColumn, int orientation, boolean isSunk, boolean isPlace) {
        super(startRow, startColumn, orientation, isSunk, isPlace);
        this.Power = 2;
        this.size =2;
        this.lives = 2;
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

   public void SetIsPlaced(boolean isPlaced){
    this.IsPlaced = isPlaced;
   }

   public boolean GetIsPlaced(){
    return IsPlaced;
   }

   public void SetIsSunk(boolean IsSunk){
    this.IsSunk = IsSunk;
   }

   public boolean GetIsSunk(){
    return IsSunk;
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
