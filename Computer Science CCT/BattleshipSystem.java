import java.util.Random;

public class BattleshipSystem {
    public final static int HEIGHT = 10;           //The default height of the grid (DO NOT CHANGE)
    public final static int WIDTH = 10;            //The default width of the grid (DO NOT CHANGE)

    private final static int MISS = 0;             //The value if a hit is missed  
    private final static int SUCCESFULL = 1;       //The value if a hit is successful
    private final static int OUT_OF_BOUNDS = -1;   //The value if a hit is out of bounds
    private final static int INVALID_BOX = -2;     //The value if a hit is invalid
    private final static int isHIT = -3;           // 
    private final static int INVALID_SHIP = -4;    // 

    public Ships[][] ShipGrid = new Ships[HEIGHT][WIDTH]; //
    private int[][] AttackGrid = new int[HEIGHT][WIDTH];
    private Player[] allPlayers;
    private Player currPlayer;
    public Object bs;

    //========================= Private Method======================//


    //========================= PUBLIC METHODS======================//
    //MADE BY AHMHED & AAYUSH

    //MADE BY AAYUSH
    /* */
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
                    currPlayer.AttackGrid[row][col] = 1; // Mark hit on players grid
                    allPlayers[1].ShipGrid[row][col] = null; //update opponents shipgrid to null
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
                    allPlayers[0].ShipGrid[row][col] = null; //update one opponents shipgrid to null
                    return SUCCESFULL; // Hit
                } 
                else {
                    currPlayer.AttackGrid[row][col] = -1; // Mark miss on currPlayerss grid
                    return MISS; // Miss
                }
            }
        }
    }
    
    
    //MADE BY AAYUSH
    public int PerformPowerAttack(int Ship) {
        if (currPlayer.GetName() == 0) {
        currPlayer.GetShipType(Ship).PowerAttack(0,0, allPlayers[1],currPlayer);
        return 1;
        }
        else {
            return 1;
        }
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