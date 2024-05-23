import java.util.Scanner;

public class BattleshipMain {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);   // Scanner for user input
    Displayer displayer = new Displayer();    // Creates a Displayer object to handle output
    displayer.GameHeader();                   // Display game header
    
    System.out.println("Arrr! Welcome to Battleship, ye scurvy sea dogs! \nWho will take the first turn? Player 1 or Player 2?");
    int firstPlayer = input.nextInt();        // Get the first player from user input
    
    System.out.println("How many rounds be ye wishin' to play?");
    int numRounds = input.nextInt();          // Get the number of rounds from user input
    BattleshipSystem bs = new BattleshipSystem(numRounds); // Create a BattleshipSystem object
    bs.SetCurrPlayer(firstPlayer - 1);        // Set the current player
    
    displayer.ShowRound(numRounds);           // Show the round number
    System.out.println("To start the battle, " + bs.GetCurrPlayerName() + ", which ship be ye placin' first?");
    displayer.DisplayShipGrid(bs.GetCurrPlayer().GetShipGrid()); // Display the current player's ship grid
    
    int count = 1;
    while(count <= 5) {  // Loop to place 5 ships for the first player
      System.out.println(" 1. Battleship (Size = 4) \n 2. Cruiser (Size = 3) \n 3. Carrier (Size = 5) \n 4. Destroyer (Size = 2) \n 5. Submarine (Size = 3)");
      int shipChoice = input.nextInt();
      
      if (shipChoice > 5 || shipChoice < 1) {
        System.out.println("Invalid choice, ye scallywag! Try again!");
      } else {
        System.out.println("Which row shall the ship be placed in?");
        int row = input.nextInt();
        System.out.println("Which column shall the ship be placed in?");
        int col = input.nextInt();
        System.out.println("Would ye like to place it vertically (1) or horizontally (0)?");
        int orientation = input.nextInt();
        
        int check = bs.InsertShip(row - 1, col - 1, bs.CreateShip(shipChoice, row - 1, col - 1, orientation), orientation);
        
        if (check == -4) {
          System.out.println("This ship be already placed, choose another one!");
        } else if(check == -1) {
          System.out.println("That position be out of bounds, choose another!");
        } else if(check == -2) {
          System.out.println("A ship be already there, choose another spot!");
        } else if (check == 1) {
          System.out.println("Ship successfully placed!");
          displayer.DisplayShipGrid(bs.GetCurrPlayer().GetShipGrid());
          count++;  
        }
      }
    }
    System.out.println("Wonderful Job " + bs.GetCurrPlayerName() + " Next Player please\n");
    
    bs.SwitchPlayer(); // Switch to the second player
    
    // Ship Placement for the second player
    System.out.println("\n" + bs.GetCurrPlayerName() + ", which ship be ye placin' first?");
    displayer.DisplayShipGrid(bs.GetCurrPlayer().GetShipGrid());
    
    count = 1;
    while(count <= 5) { // Loop to place 5 ships for the second player
      System.out.println(" 1. Battleship (Size = 4) \n 2. Cruiser (Size = 3) \n 3. Carrier (Size = 5) \n 4. Destroyer (Size = 2) \n 5. Submarine (Size = 3)");
      int shipChoice = input.nextInt();
      
      if (shipChoice > 5 || shipChoice < 1) {
        System.out.println("Invalid choice! Try again!");
      } 
      else {
        System.out.println("Which row shall the ship be placed in?");
        int row = input.nextInt();
        System.out.println("Which column shall the ship be placed in?");
        int col = input.nextInt();
        System.out.println("Would ye like to place it vertically (1) or horizontally (0)?");
        int orientation = input.nextInt();
        
        int check = bs.InsertShip(row - 1, col - 1, bs.CreateShip(shipChoice, row - 1, col - 1, orientation), orientation);
        if (check == -4) {
          System.out.println("This ship be already placed, choose another one!");
        } 
        else if(check == -1) {
          System.out.println("That position be out of bounds, choose another!");
        } 
        else if(check == -2) {
          System.out.println("A ship be already there, choose another spot!");
        } 
        else if (check == 1) {
          System.out.println("Ship successfully placed, Good work Captain!");
          displayer.DisplayShipGrid(bs.GetCurrPlayer().GetShipGrid());
          count++;
        }
      }
    }
    System.out.println("Ships are placed Captains, Get ready to ATTACK!");
    
    bs.SwitchPlayer();
    
    while (!bs.HasRoundWinner()) {
      System.out.println(bs.GetCurrPlayerName() + ", would ye like to use Normal Attack (0) or Power Attack (1)?");
      int choice = input.nextInt();
      
      if (choice == 0) {
        while (true) {
          System.out.println("Which row shall ye attack?");
          int row = input.nextInt();
          System.out.println("Which column shall ye attack?");
          int col = input.nextInt();
          int check = bs.Attack(row - 1, col - 1);
          
          if (check == -1) {
            System.out.println("That position be out of bounds, choose another!");
          } else if(check == -3) {
            System.out.println("That spot be already hit, choose another!");
          } else if (check == 1) {
            displayer.DisplayAttackGrid(bs.GetCurrPlayer().GetAttackGrid());
            System.out.println("Aye, ye hit a ship! Take another shot!");
          } else { // if miss
            System.out.println("Ye missed the ship! Better luck next time.");
            displayer.DisplayAttackGrid(bs.GetCurrPlayer().GetAttackGrid());
            break;
          }
        }
      }
      
      if (choice == 1) {
        System.out.println("Which ship be ye attackin' with?");
        System.out.println(" 1. Battleship (Power - Will attack an entire column) \n 2. Carrier (Guaranteed attack on a ship) \n 3. Destroyer (Will attack a 2x2 grid around the position chosen) \n 4. Submarine (Attack an entire column)");
        int shipType = input.nextInt();
        int check = bs.PerformPowerAttack(shipType);
        if (check == 1){
          System.out.println("ARR succesfully raided his ships");
        }
        else {
          System.out.println("Powers been used Captain, choose another ship");
        }
        displayer.DisplayAttackGrid(bs.GetCurrPlayer().GetAttackGrid());
      }
      
      bs.SwitchPlayer();
      System.out.println(bs.GetCurrPlayerName() + "Have a look at your ship grid and ATTACK BACK!");
      displayer.DisplayShipGrid(bs.GetCurrPlayer().GetShipGrid());
    }
    
    // Add score for the current player
    int lives = bs.GetCurrPlayer().GetLives();
    bs.GetCurrPlayer().AddScore(lives * 10);
    
    bs.SwitchPlayer();
    
    // Add score for the current player after switching
    lives = bs.GetCurrPlayer().GetLives();
    bs.GetCurrPlayer().AddScore(lives * 10);
  }
}
