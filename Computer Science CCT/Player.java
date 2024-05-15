//Made by Aayush
public class Player {
    private int name;                //name of the Player
    private int lives;               //lives(ships) left of the player
    private Ships[] ShipTypes;       //Ship types of the player
    public Ships[][] ShipGrid;
    public int[][] AttackGrid; 
    private int score;
    
    //======================= CONSTRUCTOR =======================//
    public Player(int name, int lives) {
      this.name = name;
      this.lives = lives;
      this.ShipGrid = new Ships[10][10];
      this.AttackGrid = new int[10][10];
    }
    //====================== PUBLIC METHOD =======================//    
    
    /* Gets the player's name 
     * @return - The name */
    public int GetName(){
      return name; 
    }
    
    /* Gets the player's amount of lives
     * @return - The amount of lives*/
    public int GetLives() {
      return lives; 
    }
    
    /* Updates the players lives if a ship is sunk */
    public void LifeDecrease() {
      lives -= 1;
    }
    
    /* Gets the Ship Object at the specific index 
     * @param index - the position in the array at which the ship is stored 
     * @return Ships - Shipobject
    */
    public Ships GetShipType(int index) {
      return ShipTypes[index];
    }
    
    /*Get the Array of ShipType */
    public Ships[] GetShipTypes() {
      return ShipTypes;
    }
    
    /* Get the Players Score 
     * @return score - The Players score */
    public int GetScore() {
      return score;
    }
    
    /* Add scores to the player's exiting score
    * @param score - The score that needs to be added
    *                to the player's score */
    public void AddScore(int score) {
      this.score += score;
    }
    
  }