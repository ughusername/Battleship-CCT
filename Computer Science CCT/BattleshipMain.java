import java.util.Scanner;
public class BattleshipMain {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);   //Creates battleship object
    Displayer displayer = new Displayer();
    displayer.GameHeader();
    
    System.out.println("Welcom to Battleship Game. \nWho would like to go first? Player 1 or Player 2");
    int firstplayer = input.nextInt();


    
    System.out.println("Please enter the number of rounds you would like to play");
    int numRounds = input.nextInt();
    BattleshipSystem bs = new BattleshipSystem(numRounds);
    bs.SetCurrPlayer(0);
    
    //displayer.ScoreBoard(bs., two);
    displayer.ShowRound(numRounds);
    System.out.println("To Start, Player 1 which ship would you like to place first"); 
    System.out.println(" 1. Battleship(Size = 4) \n 2. Cruiser(Size = 3) \n 3. Carrier(Size = 5) \n 4. Destroyer(Size = 2) \n 5. Submarine(Size = 3)");
    int ShipChoice = input.nextInt();

    while(!bs.GetIsAllShipsPlaced()) {
      if (ShipChoice >5 || ShipChoice < 1) {
        System.out.println("Invaid Choice please choose again");
      }
      else if (ShipChoice == 1) {
        System.out.println("Which row would you like to place the Battleship");
        int row = input.nextInt();
        System.out.println("Which column would you like to place the Battleship");
        int col = input.nextInt();
        System.out.println("If you would like to place it vertical, Enter 1. otherwise Enter 0 for horizontal");
        int orientation = input.nextInt();
        Ships shipType = new Battleship(row,col,orientation,false,false);
        bs.InsertShip(row,col, shipType, orientation);
      }
      else if (ShipChoice == 2) {
        System.out.println("Which row would you like to place the Cruiser");
        int row = input.nextInt();
        System.out.println("Which column would you like to place the Cruiser");
        int col = input.nextInt();
        System.out.println("If you would like to place it vertical, Enter 1. otherwise Enter 0 for horizontal");
        int orientation = input.nextInt();
        Ships shipType = new Cruiser(row,col,orientation, false, false);
        bs.InsertShip(row,col, shipType, orientation);
      }
      else if (ShipChoice == 3) {
        System.out.println("Which row would you like to place the Carrier");
        int row = input.nextInt();
        System.out.println("Which column would you like to place the Carrier");
        int col = input.nextInt();
        System.out.println("If you would like to place it vertical, Enter 1. otherwise Enter 0 for horizontal");
        int orientation = input.nextInt();
        Ships shipType = new Carrier(orientation, row, col, false, false);
        bs.InsertShip(row,col, shipType, orientation);
      }
      else if (ShipChoice == 4) {
        System.out.println("Which row would you like to place the Destroyer");
        int row = input.nextInt();
        System.out.println("Which column would you like to place the Destroyer");
        int col = input.nextInt();
        System.out.println("If you would like to place it vertical, Enter 1. Otherwise Enter 0 for horizontal");
        int orientation = input.nextInt();
        Ships shipType = new Destroyer(orientation, row, col, false, false);
        bs.InsertShip(row,col, shipType, orientation);
      }
      else {
        System.out.println("Which row would you like to place the Submarine");
        int row = input.nextInt();
        System.out.println("Which column would you like to place the Submarine");
        int col = input.nextInt();
        System.out.println("If you would like to place it vertical, Enter 1. Otherwise Enter 0 for horizontal");
        int orientation = input.nextInt();
        Ships shipType = new Submarine(orientation, row, col, false, false);
        int check = bs.InsertShip(row,col, shipType, orientation);
        System.out.println(check);
      }
  }

    displayer.DisplayAttackGrid(bs.GetCurrPlayer().GetAttackGrid());
    bs.Attack(1, 1);
    displayer.DisplayAttackGrid(bs.GetCurrPlayer().GetAttackGrid());
    
    displayer.DisplayShipGrid(bs.GetCurrPlayer().GetShipGrid());
  }
}    
