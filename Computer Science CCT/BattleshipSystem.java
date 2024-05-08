public class BattleshipSystem {
    public final static int HEIGHT = 10;
    public final static int WIDTH = 10;
    private final static int MISS = 0;
    private final static int SUCCESFULL = 1;
    private final static int OUT_OF_BOUNDS = -1;
    private final static int INVALID_BOX = -2;
    private final static int isHIT = -3;

    public Ships[][] ShipGrid = new Ships[HEIGHT][WIDTH];
    private int[][] AttackGrid = new int[HEIGHT][WIDTH];
    private Player[] allPlayers;
    private Player currPlayer;
    public Object bs;

    //========================= Private Method======================//

    //========================= PUBLIC METHODS======================//
    //MADE BY AHMHED & AAYUSH


    public int pPowerAttack(int col, int row, int ShipType, int place ) {
        //if the ship is not out of bounds
        if (col >= 0 && col < HEIGHT && row >= 0 && row < 7) {
            //if the ship is a Carrier
            if (Ship == 1) {
            // Check if the cell is already attacked
            if (opponentBoard[row][col] == 0) {// Check if the cell is already attacked
                // Mark the cell as attacked
                opponentBoard[row][col] = 1;
                // Check the 3x3 grid around the selected cell
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        // Check if the neighboring cell is within the game board bounds
                        if (col + i >= 0 && col + i < 7 && row + j >= 0 && row + j < 7) {
                            // Check if the neighboring cell is already attacked
                            if (opponentBoard[row + j][col + i] == 0) {
                                // Mark the neighboring cell as attacked
                                opponentBoard[row + j][col + i] = 1;
                            }
                        }
                    }
                }
                // Return 0 if successful
                return 0;
            } 
            else {
                // Return -1 if the cell is already attacked
                return -1;
            }
        } else {
            // Return -1 if row and col are out of bounds
            return -1;
        }
    }
    
            {//if the ship is a Battleship
            if (Ship == 2) {
    
            }
            //if the ship is a Cruiser
            if (Ship == 3) {
            }
            //if the ship is a Destroyer
            if (Ship == 4) {
            }
            //if the ship is a Submarine
            if (Ship == 5) {
    
            
            if (opponentBoard[row][col] == 0) {
                // Mark the cell as attacked
                opponentBoard[row][col] = 1;
                // Return 0 if successful
                return 0;
            }
            }
            }
            return 0; // DEFAULT VALUE NEEDS TO BE CHANGED
    }

    public int InsertShip(int row, int col, Ships ShipType, int orientation) {
        int size = ShipType.GetSize();
        int gridRows = ShipGrid.length;
        int gridCols = ShipGrid[0].length;

        // Check if row and col are within bounds
        if (row < 0 || row >= gridRows || col < 0 || col >= gridCols) {
            return OUT_OF_BOUNDS; // Out of bounds
        }

        // Check if box is empty
        if (ShipGrid[row][col] != null) {
            return INVALID_BOX; // Box is full
        }

        // Check if ship placement exceeds grid boundaries
        if ((orientation == 0 && col + size > gridCols) || (orientation == 1 && row + size > gridRows)) {
            return OUT_OF_BOUNDS; // Out of bounds
        }

        // Place ship based on orientation
        for (int i = 0; i < size; i++) {
            if (orientation == 0) { //Vertical placement
                ShipGrid[row][col + i] = ShipType;
            } 
            else { //Horizontal Placement
                ShipGrid[row + i][col] = ShipType;
            }
        }

        return SUCCESFULL; // Successful
    }

    //MADE BY AAYUSH
    public int Attack(int row, int col) {
        if (row > AttackGrid.length || col > AttackGrid[0].length) {
            return OUT_OF_BOUNDS;
        }
        else if (currPlayer.AttackGrid[row][col] == 1) {
            return isHIT;
        }
        else {
            if (currPlayer.GetName() == 0) {
                // Check if the attack hits a ship on the opponent's grid
                if (allPlayers[1].ShipGrid[row][col] != null) {
                    currPlayer.AttackGrid[row][col] = 1; // Mark hit on opponent's grid
                    allPlayers[1].ShipGrid[row][col].
                    return SUCCESFULL; // Hit
                } 
                else {
                    currPlayer.AttackGrid[row][col] = -1; // Mark miss on currPlayers grid
                    return MISS; // Miss
                }
            }
            else {
                if (allPlayers[0].ShipGrid[row][col] != null) {
                    currPlayer.AttackGrid[row][col] = 1; // Mark hit on currPlayers grid
                    return SUCCESFULL; // Hit
                } 
                else {
                    currPlayer.AttackGrid[row][col] = -1; // Mark miss on currPlayerss grid
                    return MISS; // Miss
                }
            }
        }
    }

    public int PowerAttack(int Ship, int row, int col, int place) {
        if (row > AttackGrid.length || col > AttackGrid[0].length) {
            return OUT_OF_BOUNDS;
        }
        else
        
        
    }

   //Made by Aayush
    /* Set who will be the current player
   * @param index - The value that represents the player. This
   *                is based on the array position of where the 
   *                player is stored. */
    public void SetCurrPlayer(int index) {
        if (index == 0) {
          this.currPlayer = allPlayers[0];
        }
        else {
          this.currPlayer = allPlayers[1];
        }
      }  
}
