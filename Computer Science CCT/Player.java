public class Player {
    private String name;            //name of the Player
    private int lives;              //lives(ships) left of the player
    public Ships[] shiptypes;        //Ship types of the player

    //======================= CONSTRUCTOR =======================//
    public Player(String name, int lives) {
        this.name = name;
        this.lives = lives;
    }
    //====================== PUBLIC METHOD =======================//    

    /* Gets the player's name 
   * @return - The name */
    public String GetName(){
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