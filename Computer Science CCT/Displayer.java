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
    //MADE BY AAYUSH 
    /* Displays the game title screen */
    public void GameHeader() {
      System.out.println("==============================");
      System.out.println("|          BATTLESHIP        |");
      System.out.println("==============================");
    }
    
    //MADE BY AAYUSH
    /*Displays the game AttakGrid
     * @param - The attackgrid
     */ 
    public void DisplayAttackGrid(int[][] grid){
      int rows = grid.length;
      int cols = grid[0].length;
      
      // Print column numbers
      System.out.println("       ===================== ATTACK GRID =====================");
      System.out.print("    ");
      for (int col = 0; col < cols; col++) {
        System.out.printf("%4d  ", col + 1);
      }
      System.out.println("");
      System.out.println("   -------------------------------------------------------------");
      
      // Print the board
      for (int row = 0; row < rows; row++) {
        System.out.print(row + 1 + "  |");
        for (int col = 0; col < cols; col++) {
          if (grid[row][col] == 1 ) {                              //1 is hit
            System.out.print("  X  |");                         
          } else if (grid[row][col] == 0){                         //O is miss
            System.out.print("  O  |");
          }
          else if (grid[row][col] == -1) {                         //-1 is empty
            System.out.print("     |");
          }
        }
        System.out.println("\n   -------------------------------------------------------------");
      }
      System.out.println();
    }
    
    //MADE BY AAYUSH
    /*Displays the game ShipGrid
     * @param - The shipgrid
     */ 
    public void DisplayShipGrid(Ships[][] ShipGrid) {
      System.out.println("       ===================== SHIP GRID =======================");
      System.out.print("    ");
      for (int col = 0; col < ShipGrid[0].length; col++) {
        System.out.printf("%4d  ", col + 1);
      }
      
      System.out.println("");
      System.out.println("   -------------------------------------------------------------");
      
      
      for (int i = 0; i < ShipGrid.length; i++) {
        System.out.print(i + 1 + "  |");
        for (int j = 0; j < ShipGrid[i].length; j++) {
          Ships ship = ShipGrid[i][j]; 
          if (ship == null) {
            System.out.print("     |"); // If no ship, print blank space
          } 
          else {
            switch (ship.GetIdentity()) {
              case Ships.BATTLESHIP:
                System.out.print("  B  |");
                break;
              case Ships.CARRIER:
                System.out.print("  CA |");
                break;
              case Ships.CRUISER: 
                System.out.print(" CR  |");
                break;
              case Ships.DESTROYER:
                System.out.print("  D  |");
                break;
              case Ships.SUBMARINE:
                System.out.print(" SUB |");
                break;
              default:
                System.out.print("     |"); // Unknown ship type, print blank space
            }
          }
        }
        System.out.println("\n   -------------------------------------------------------------");
      }
    }   
    //Made by Aayush 
    /* Display the player's score on the screen 
     * @param x - Object that represents player x  
     * @param o - Object that represents player o */
    public void ScoreBoard(Player one, Player two) {
      System.out.println("CURRENT SCORE---------------------");
      System.out.println("PLAYER 1: " + one.GetScore());
      System.out.println("PLAYER 2: " + two.GetScore());
      System.out.println("----------------------------------");
    }
    
    //Made by Aayush
    /* Display the current round number
     * @param roundNum - The current round's number */
    public void ShowRound(int roundNum ) {
      System.out.println("*************** ROUND " + roundNum + " *************");
    }
    
  }
  