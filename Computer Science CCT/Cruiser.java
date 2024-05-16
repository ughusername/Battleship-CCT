//Made By Aayush
public class Cruiser extends Ships {
  private final int NoPower ;
  private final int size;
  public final int identity = 1; 
  private int lives;
  private boolean IsPlaced;
  private boolean IsSunk;

    //================= CONSTRUCTOR =================//
  public Cruiser(int startRow, int startColumn, int orientation, boolean isSunk, boolean isPlace) {
    super(startRow, startColumn, orientation, isSunk, isPlace);
    this.NoPower = 10;
    this.size =3;
    this.lives = 3;
  }
    //================ PUBLIC METHODS ===============//
    
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