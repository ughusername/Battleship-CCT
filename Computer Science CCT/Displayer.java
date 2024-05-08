public class Displayer {

    //======================= CONSTRUCTOR =======================//
    public Displayer() {
      
    }
      //====================== PRIVATE METHOD ======================//
  /* (Place your Private Methods here) */
  public String ShowShipType(int ship) {
    if(ship == Ships.BATTLESHIP) {
      return "B  ";
    }
    else if(ship == Ships.CARRIER) {
      return "CA ";
    }
    else if(ship == Ships.CRUISER) {
        return "CR ";
    }
    else if(ship == Ships.DESTROYER) {
        return "D  ";
    }
    else {
        return "SUB";
    }
  }

    //====================== PUBLIC METHOD =======================//
    /* Displays the game title screen */
    public void GameHeader() {
      System.out.println("==============================");
      System.out.println("|          BATTLESHIP        |");
      System.out.println("==============================");
    }
    public static void DisplayAttackGrid(int[][] grid){
        int rows = 7;
        int cols = 7;
        
        // Print column numbers
        System.out.print("    ");
        for (int col = 0; col < cols; col++) {
            System.out.printf("%4d  ", col + 1);
        }
        System.out.println("");
        System.out.println("   -------------------------------------------");

        // Print the board
        for (int row = 0; row < rows; row++) {
            System.out.print(row + 1 + "  |");
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1 /*&& grid[row][col].IsHit()*/) {
                    System.out.print("  X  |");
                } else if (grid[row][col] == 0){
                    System.out.print("  O  |");
                }
                else if (grid[row][col] == -1) {
                    System.out.print("     |");
                }
            }
            System.out.println("\n   -------------------------------------------");
        }
    }

    public static void DisplayShipGrid(Ships[][] gridShip) {
        
    }
  } 