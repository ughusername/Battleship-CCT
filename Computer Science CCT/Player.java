public class Player {
    private int name;            //name of the Player
    private int lives;              //lives(ships) left of the player
    private Ships[] shiptypes;        //Ship types of the player
    public Ships[][] ShipGrid;
    public int[][] AttackGrid; 

    //======================= CONSTRUCTOR =======================//
    public Player(int name, int lives) {
        this.name = name;
        this.lives = lives;
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
    
    /* Updates the players lives if a ship is sunk
    */
    public void LifeDecrease() {

    }

}