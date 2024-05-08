public class Player {
    private String name;            //name of the Player
    private int lives;              //lives(ships) left of the player
    private Ships[] shiptypes;        //Ship types of the player
    private Ships[][] ShipGrid;
    private int[][] AttackGrid; 

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

    public Ships[][] GetShipGrid() {
        return ShipGrid;
    }

    public int[][] GetAttackGrid() {
        return AttackGrid;
    }

    //MADE BY AAYUSH
    public boolean Attack(Player opponent, int row, int col) {
        // Check if the attack hits a ship on the opponent's grid
        if (opponent.ShipGrid[row][col] != null) {
            opponent.AttackGrid[row][col] = 1; // Mark hit on opponent's grid
            return true; // Hit
        } 
        else {
            opponent.AttackGrid[row][col] = -1; // Mark miss on opponent's grid
            return false; // Miss
        }
    }

    public boolean PowerAttack(int Ship, int row, int col, int place, Player opponent) {
        
        return true;
    }

}