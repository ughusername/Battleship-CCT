import java.util.Random;

public class BattleshipSystem {
    public final static int HEIGHT = 10;
    public final static int WIDTH = 10;
    private final static int MISS = 0;
    private final static int SUCCESFULL = 1;
    private final static int OUT_OF_BOUNDS = -1;
    private final static int INVALID_BOX = -2;
    private final static int isHIT = -3;
    private final static int INVALID_SHIP = -4;

    public Ships[][] ShipGrid = new Ships[HEIGHT][WIDTH];
    private int[][] AttackGrid = new int[HEIGHT][WIDTH];
    private Player[] allPlayers;
    private Player currPlayer;
    public Object bs;

    //========================= Private Method======================//
    


    private void SubmarinePowerAttack(Player opponent, int row) {
        //Will attack an entire column
        for (int i = 0; i < 10; i++ ) {
            if (opponent.ShipGrid[row][i] != null) {
                currPlayer.AttackGrid[row][i] = 1;
            }
            else {
                currPlayer.AttackGrid[row][i] = 0;
            }
        }
    }
    //========================= PUBLIC METHODS======================//
    //MADE BY AHMHED & AAYUSH

    //MADE BY AAYUSH
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
    public int PowerAttack(int Ship, int row, int col) {
        if (row > AttackGrid.length || col > AttackGrid[0].length) {
            return OUT_OF_BOUNDS;
        }
        else {
            if (Ship == 1) { //Carrier
                if (currPlayer.GetName() == 0) {
                    CarrierPowerAttack(allPlayers[0]); 
                }
                else {
                    CarrierPowerAttack(allPlayers[1]);
                }
                return SUCCESFULL;
            }
            if (Ship == 2) { //Battleship
                if (currPlayer.GetName() == 0) {
                    BattleshipPowerAttack(allPlayers[0], col); 
                }
                else {
                    BattleshipPowerAttack(allPlayers[1], col);
                }
                return SUCCESFULL;
            }
            if (Ship == 4) {
                if (row + 2 > ShipGrid.length || row - 2> ShipGrid.length
                    || col + 2 > ShipGrid[0].length || col - 2 > ShipGrid[0].length) {
                    return OUT_OF_BOUNDS;
                }
                else {
                    if (currPlayer.GetName() == 0) {
                        DestroyerPowerAttack(allPlayers[1], row, col); 
                    }
                    else {
                        DestroyerPowerAttack(allPlayers[0], row, col); 
                    }
                    return SUCCESFULL;
                }
            }
            if (Ship == 5) {
                if (currPlayer.GetName() == 0) {
                   SubmarinePowerAttack(allPlayers[0], row);
                }
                else {
                    SubmarinePowerAttack(allPlayers[1], col);
                }
                return SUCCESFULL;
            }
            else {
                return INVALID_SHIP;
            }
            }
        }

    public int PerformPowerAttack(int Ship) {
        return currPlayer.GetShipType(Ship).PowerAttack(0,0);
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