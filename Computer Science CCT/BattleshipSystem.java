public class BattleshipSystem {
    public final static int HEIGHT = 7;
    public final static int WIDTH = 7;
    public final static int SUCCESFULL = 1;

    private Ships[][] Shipgrid;
    private int[][] AttackGrid;
    private Player[] allPlayers;
    private Player currPlayer;
    public Object bs;

    //========================= Private Method======================//
    private int WhatShip (Ships Shiptype) {
        if (Shiptype.GetIdentity() ==1) {
            return 1;
        }
        else if (Shiptype.GetIdentity() == 2) {
            return 2;
        }
        else if (Shiptype.GetIdentity() == 3) {
            return 3;
        }
        else if (Shiptype.GetIdentity() == 4) {
            return 4;
        }
        else {
            return 5;
        }
    }
    //========================= PUBLIC METHODS======================//
    public int Attack(int col, int row, int Ship) {          
        //if the ship is not out of bounds
        if (col >= 0 && col < 7 && row >= 0 && row < 7) {
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
        } else {
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
    int gridRows = Shipgrid.length;
    int gridCols = Shipgrid[0].length;

    // Check if row and col are within bounds
    if (row < 0 || row >= gridRows || col < 0 || col >= gridCols) {
        return 0; // Out of bounds
    }

    // Check if box is empty
    if (Shipgrid[row][col] != null) {
        return -1; // Box is full
    }

    // Check if ship placement exceeds grid boundaries
    if ((orientation == 0 && col + size > gridCols) || (orientation == 1 && row + size > gridRows)) {
        return 0; // Out of bounds
    }

    // Place ship based on orientation
    for (int i = 0; i < size; i++) {
        if (orientation == 0) {
            Shipgrid[row][col + i] = ShipType;
        } else {
            Shipgrid[row + i][col] = ShipType;
        }
    }

    return 1; // Successful
}
}
        /* //check if box is empty
        if (Shipgrid[row][col] != null) {
          return -1; //if box is full
        }
        if (col > Shipgrid.length || row > Shipgrid[0].length ) {
          return 0; //if row and col are outside boundary
        }
        if (ShipType instanceof Carrier){ //Carrier ship
          if (orientation == 0) { //horizontal 
            //check if with the orientation it will be out of bounds
            if (col + 5 > Shipgrid[0].length) {
              return 0; //out of bounds
            }
            else {
              for (int i = 0; i <= 5; i++) {
                Shipgrid[row][col] = new Carrier(0, row, col);
                col++;
              }
              return 1; //SUCCESFUL
            }
          }
          else if (orientation == 1) { //Vertical 
            if (row + 5 > Shipgrid.length) {
              return 0; //out of bounds
            }
            else {
                for (int i = 0; i <= 5; i++) {
                    Shipgrid[row][col] = new Carrier(0, row, col);
                    row++;
                  }
                  return 1; //SUCCESFUL
            }
          }
        }
        return 0;
    }
} */
