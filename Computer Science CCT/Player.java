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
    /*  Method to attack the opponent
     *  @param col - The column that the player wants to attack
     *         row - The row that the player wants to attack
     *         Ship - The ship that the player wants to attack with
     *  @return - 0 if succesfull
     *            -1 if col and row is out of bounds  
     */
    public int Attack(int col, int row, int Ship) {
        return 0; // DEFAULT VALUE NEEDS TO BE CHANGED
    }

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