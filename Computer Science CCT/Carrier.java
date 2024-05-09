import java.util.Random;

public class Carrier extends Ships {
    private static final int Power = 0;
    private int orientation;
    private int startColumn;
    private int startRow;
    private static final int size = 5;
    private boolean isSunk = false;
    public static final int identity = 1;
    private static int lives = 5;

    //================= CONSTRUCTOR =================//
    public Carrier(int orientation, int startRow, int startColumn) {
        this.orientation = orientation;
        this.startColumn = startColumn;
        this.startRow = startRow;
    }
    //================ PUBLIC METHODS ===============//
    @Override
    public void SetStartRow(int StartRow) {
        this.startRow = StartRow;
    }
    
    /* Get Start Row of Ship
     * @return - Row ship is at */
    public int GetStartRow() {
        return startRow;
    }


    @Override
    public void SetStartColumn(int startColumn) {
        this.startColumn = startColumn;
    }

    /* Get Start Column of Ship
     * @return - Column ship is at */
    public int GetStartColumn() {
        return startColumn;
    }


    @Override
    public void SetOrientation(int orientation) {
      this.orientation =orientation;
    }

    /* Get Orientation of Ship
     * @return - value of orientation */
    public int GetOrientation() {
        return orientation;
    }

    @Override
    public int GetPower() {
        return Power;
    }

    /* Gets the size of the ship */
    public int GetSize() {
        return size;
    }
    
    public int GetIdentity() {
        return identity;
    }

    //MADE BY AAYUSH
    public void PowerAttack(int row, int col, Player opponent, Player currPlayer) {
         // Generate random row and column indices
         Random rand = new Random();
         row = rand.nextInt(10); // Assuming a 10x10 grid
         col = rand.nextInt(10);
         // Check if there's a ship at the randomly chosen location
         Ships ship = opponent.ShipGrid[row][col];
         if (ship != null) {
             // Ship exists at this location, mark it as hit
             opponent.ShipGrid[row][col] = null; // Mark it as hit (assuming 2 represents a hit)
             currPlayer.AttackGrid[row][col] = 1;
         } 
         else {
             // No ship at this location, try again
             PowerAttack(row, col, opponent, currPlayer); // Recursive call to try again
         }
}
}