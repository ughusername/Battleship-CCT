//Made By Aayush
public class Destroyer extends Ships {
    private final int Power;                //The variable to hold the power uniquely assigned to each ship
    private final int size;                 //The variable to hold the size of the ship 
    public final int identity = 4;          //The variable to hold the identity of the ship
    private int lives;                      //The variable to hold the number of lives of the ship

    //================= CONSTRUCTOR =================//
    public Destroyer(){
      this.Power = 2;
      this.size = 2;
    }

    public Destroyer(int startRow, int startColumn, int orientation) {
        super(startRow, startColumn, orientation);
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
