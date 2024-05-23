// Made by Aayush
public class Player {
    private final int HEIGHT = 10;                 // Fixed height of the grid
    private final int WIDTH = 10;                  // Fixed width of the grid
    private int name;                              // Name of the player
    private int lives;                             // Lives (ships) left of the player
    private Ships[] ShipTypes;                     // Array to store the ships of the player
    public Ships[][] ShipGrid;                     // The grid that shows the player's ship grid
    public int[][] AttackGrid;                     // The grid that shows the player's attack grid
    private int score;                             // Score of the player 
    
    //======================= CONSTRUCTOR =======================//
    public Player(int name, int lives) {
      this.name = name;
      this.lives = lives;
      this.ShipGrid = new Ships[HEIGHT][WIDTH];
      this.AttackGrid = new int[HEIGHT][WIDTH];
      this.ShipTypes = new Ships[5];
    }
    
    //====================== PUBLIC METHODS =======================//    
    
    /* Gets the player's name 
     * @return - The name */
    public int GetName() {
      return name; 
    }
    
    /* Gets the player's amount of lives
     * @return - The amount of lives */
    public int GetLives() {
      return lives; 
    }
    
    /* Updates the player's lives if a ship is sunk */
    public void LifeDecrease() {
      lives -= 1;
    }
    
    /* Adds a ship to the player's ship types at the specified index 
     * @param shiptype - The ship type to add
     * @param index - The index at which to add the ship type */
    public void AddShip(Ships shiptype, int index) {
      this.ShipTypes[index] = shiptype;
    }
    
    /* Gets the Ship object at the specific index 
     * @param index - The position in the array at which the ship is stored 
     * @return Ships - Ship object */
    public Ships GetShipType(int index) {
      return ShipTypes[index];
    }
    
    /* Gets the array of ShipType 
     * @return - The array of ShipType */
    public Ships[] GetShipTypes() {
      return ShipTypes;
    }
    
    /* Gets the player's score 
     * @return score - The player's score */
    public int GetScore() {
      return score;
    }
    
    /* Adds scores to the player's existing score
     * @param score - The score to be added to the player's score */
    public void AddScore(int score) {
      this.score += score;
    }
    
    /* Gets the player's ship grid 
     * @return - The ship grid */
    public Ships[][] GetShipGrid() {
      return ShipGrid;
    }
    
    /* Gets the player's attack grid 
     * @return - The attack grid */
    public int[][] GetAttackGrid() {
      return AttackGrid;
    }
    
    /* Adds a ship to the player's ship types array at the specified index
     * @param shiptype - The ship type to add
     * @param index - The index at which to add the ship type */
    public void AddShipToShipTypesArray(Ships shiptype, int index) {
      this.ShipTypes[index] = shiptype;
    }
}
  