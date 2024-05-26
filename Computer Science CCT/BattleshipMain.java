import java.util.Scanner;

public class BattleshipMain {
  public static void main(String[] args) {
    @SuppressWarnings("resource") 
    Scanner input = new Scanner(System.in);   // Scanner for user input
    Displayer displayer = new Displayer();    // Creates a Displayer object to handle output
    displayer.GameHeader();                   // Display game header
    
    System.out.println("Arrr! Welcome to Battleship! \nWho will take the first turn? Player 1 or Player 2?");
    int firstPlayer = input.nextInt();        // Get the first player from user input
    
    System.out.println("How many rounds be ye wishin' to play?");
    int numRounds = input.nextInt();          // Get the number of rounds from user input
    BattleshipSystem bs = new BattleshipSystem(numRounds); // Create a BattleshipSystem object
    bs.SetCurrPlayer(firstPlayer - 1);        // Set the current player
    
    bs.CreateShips();                         //Creating ships for player 1
    bs.SwitchPlayer();                    
    bs.CreateShips();                         //Creating ships for player 2
    bs.SwitchPlayer();
    
    displayer.ShowRound(numRounds);           // Show the round number
    System.out.println("To start the battle, " + bs.GetCurrPlayerName() + ", which ship be ye placin' first?");
    displayer.DisplayShipGrid(bs.GetCurrPlayer().GetShipGrid()); // Display the current player's ship grid
    
    int count = 1;
    while(count <= 5) {  // Loop to place 5 ships for the first player
      System.out.println(" 1. Carrier (Size = 5) \n 2. BattleShip (Size = 4) \n 3. Cruiser (Size = 3) \n 4. Destroyer (Size = 2) \n 5. Submarine (Size = 3)");
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
        
        int check = bs.InsertShip(row - 1, col - 1, shipChoice, orientation);
        
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
      System.out.println(" 1. Carrier (Size = 5) \n 2. BattleShip (Size = 4) \n 3. Cruiser (Size = 3) \n 4. Destroyer (Size = 2) \n 5. Submarine (Size = 3)");
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
        
        int check = bs.InsertShip(row - 1, col - 1, shipChoice, orientation);
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
      if (choice < 0 || choice >1 ){
        System.out.println("Invalid Choice, please input 0 or 1");
      }
      if (choice == 0) {
        while (true) {
          System.out.println("Which row shall ye attack?");
          int row = input.nextInt();
          System.out.println("Which column shall ye attack?");
          int col = input.nextInt();
          int check = bs.Attack(row - 1, col - 1);
          
          if (check == -2) {
            System.out.println("That position be out of bounds, choose another!");
          } 
          else if(check == -3) {
            System.out.println("That spot be already hit, choose another!");
          } 
          else if (check == -1) {
            System.out.println("Ye missed the ship! Better luck next time.");
            displayer.DisplayAttackGrid(bs.GetCurrPlayer().GetAttackGrid());
            break;
          }
          else if (check == 1) {
            displayer.DisplayAttackGrid(bs.GetCurrPlayer().GetAttackGrid());
            System.out.println("Bullseye Captain, ye hit a ship! Take another shot!");
          } 
        }
      }
      
      if (choice == 1) {
        System.out.println("Which ship be ye attackin' with?");
        System.out.println(" 1. Carrier (Guaranteed attack on a ship) \n 2. Battleship (Power - Will attack an entire column) \n 3. Cruiser (No Power) \n 4. Destroyer (Will attack a 2x2 grid around the position chosen) \n 5. Submarine (Attack an entire row)");
        int shipType = input.nextInt();
        if (shipType <1 || shipType > 5 || shipType == 3){
          System.out.println("Invalid Choice, Please choose a number from 1-5");
        }
        else {
          if (shipType == 2) { //Battleship
            System.out.println("Which column woud you like to attack?");
            int col = input.nextInt();
            int check = bs.PerformPowerAttack(shipType,0,col);
            if (check == 1){
              System.out.println("ARR succesfully raided his ShipGrid");
            }
            else {
              System.out.println("Powers been used Captain, choose another ship");
            }
          }
          else if (shipType ==4) { //Destroyer
            System.out.println("Which row would you like to attack");
            int row = input.nextInt();
            System.out.println("Which column would you like to attack");
            int col = input.nextInt();
            int check = bs.PerformPowerAttack(shipType,row,col);
            if (check == 1){
              System.out.println("ARR succesfully raided his ShipGrid");
            }
            else {
              System.out.println("Powers been used Captain, choose another ship");
            }
          }
          else if(shipType == 5){
            System.out.println("Which row would you like to attack");
            int row = input.nextInt();
            int check = bs.PerformPowerAttack(shipType,row,0);
            if (check == 1){
              System.out.println("ARR succesfully raided his ShipGrid");
            }
            else {
              System.out.println("Powers been used Captain, choose another ship");
            }
          }
          
          displayer.DisplayAttackGrid(bs.GetCurrPlayer().GetAttackGrid());
        }
        
        bs.SwitchPlayer();
        System.out.println(bs.GetCurrPlayerName() + "Have a look at your ship grid and ATTACK BACK!");
        displayer.DisplayShipGrid(bs.GetCurrPlayer().GetShipGrid());
      }
    }
    
    // Add score for the current player
    int lives = bs.GetCurrPlayer().GetLives();
    bs.GetCurrPlayer().AddScore(lives * 10);
    
    bs.SwitchPlayer();
    
    // Add score for the current player after switching
    lives = bs.GetCurrPlayer().GetLives();
    bs.GetCurrPlayer().AddScore(lives * 10);

    displayer.ScoreBoard(bs.GetAllPlayers());
    
    int winner = bs.GetGameWinnner();
    if (winner == 0){
      System.out.println("Captain 1 you have successfuly won the game");
    }
    else {
      System.out.println("Captain 2 you have succesfully won the game");
    }
  }
}
