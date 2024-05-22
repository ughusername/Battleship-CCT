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
    bs.SetCurrPlayer(firstplayer-1);
    
    //displayer.ScoreBoard(bs., two);
    //Ship Placement for the first player
    displayer.ShowRound(numRounds);
    System.out.println("To Start " +bs.GetCurrPlayerName() + " which ship would you like to place first"); 
    displayer.DisplayShipGrid(bs.GetCurrPlayer().GetShipGrid());
    int count = 1;
    while(count <=5){
      System.out.println(" 1. Battleship(Size = 4) \n 2. Cruiser(Size = 3) \n 3. Carrier(Size = 5) \n 4. Destroyer(Size = 2) \n 5. Submarine(Size = 3)");
      int ShipChoice = input.nextInt();
      if (ShipChoice >5 || ShipChoice < 1) {
        System.out.println("Invaid Choice please choose again");
      }
      else {
        System.out.println("Which row would you like to place the Ship");
        int row = input.nextInt();
        System.out.println("Which column would you like to place the Ship");
        int col = input.nextInt();
        System.out.println("If you would like to place it vertical, Enter 1. otherwise Enter 0 for horizontal");
        int orientation = input.nextInt();
        int check = bs.InsertShip(row-1,col-1,bs.CreateShip(ShipChoice, row-1, col-1, orientation), orientation);
        
        if (check == -4){
          System.out.println("The Ship has already been placed, please choose another ship");
        }
        else if(check == -1){
          System.out.println("The position chosen is out of bounds, please choose another position");
        }
        else if(check == -2){
          System.out.println("A ship is already present in that position, Please choose another box");
        }
        else if (check == 1){
          System.out.println("Ship Succesfully placed");
          displayer.DisplayShipGrid(bs.GetCurrPlayer().GetShipGrid());
          count++;  
        }
      }
    }
    bs.SwitchPlayer();
    //Ship Placement for the Second Player
    System.out.println("\n" + bs.GetCurrPlayerName() + " which ship would you like to place first"); 
    displayer.DisplayShipGrid(bs.GetCurrPlayer().GetShipGrid());
    count = 1;
    while(count <=5){
      System.out.println(" 1. Battleship(Size = 4) \n 2. Cruiser(Size = 3) \n 3. Carrier(Size = 5) \n 4. Destroyer(Size = 2) \n 5. Submarine(Size = 3)");
      int ShipChoice = input.nextInt();
      if (ShipChoice >5 || ShipChoice < 1) {
        System.out.println("Invaid Choice please choose again");
      }
      else {
        System.out.println("Which row would you like to place the Ship");
        int row = input.nextInt();
        System.out.println("Which column would you like to place the Ship");
        int col = input.nextInt();
        System.out.println("If you would like to place it vertical, Enter 1. otherwise Enter 0 for horizontal");
        int orientation = input.nextInt();
        int check = bs.InsertShip(row-1,col-1,bs.CreateShip(ShipChoice, row-1, col-1, orientation), orientation);
        
        if (check == -4){
          System.out.println("The Ship has already been placed, please choose another ship");
        }
        else if(check == -1){
          System.out.println("The position chosen is out of bounds, please choose another position");
        }
        else if(check == -2){
          System.out.println("A ship is already present in that position, Please choose another box");
        }
        else if (check == 1){
          System.out.println("Ship Succesfully placed");
          displayer.DisplayShipGrid(bs.GetCurrPlayer().GetShipGrid());
          count++;
        }
      }
    } 
    
    System.out.println("Stage 2: Attack");
    bs.SwitchPlayer();
    while (!bs.HasRoundWinner()){
      System.out.println(bs.GetCurrPlayerName() + "Would you like to use Normal Attack (0) or Power Attack(1)");
      int choice = input.nextInt();
      if (choice == 0){
        while (true) {
          System.out.println("Which Row would you like to attack?");
          int row = input.nextInt();
          System.out.println("Which Column would you like to attack");
          int col = input.nextInt();
          int check = bs.Attack(row, col);
        
          if (check == -1){
            System.out.println("The position chosen is out of bounds, please choose another position");
          }
          else if(check == -3){
            System.out.println("The position is already hit, please choose another");
          }
          else if (check == 1){
            displayer.DisplayAttackGrid(bs.GetCurrPlayer().GetAttackGrid());
            System.out.println("Succesfully hit a ship, you get another chance");
          }
          else {//if miss
            System.out.println("You have missed the ship");
            break;
          }
        }
      }
      if (choice == 1){
        System.out.println("Which Ship would you like to Attack with");
        System.out.println(" 1. Battleship(Power - Will Attack an entire Column) \n 2. Cruiser(No power) \n 3. Carrier(Guaranteed Attack on Ship) \n 4. Destroyer(Will attack a 2x2 grid around the Position chose) \n 5. Submarine(Attack an entire column)");
        int shiptype = input.nextInt();
        bs.PerformPowerAttack(shiptype);
      }
      bs.SwitchPlayer();
    }
    int lives = bs.GetCurrPlayer().GetLives();
    bs.GetCurrPlayer().AddScore(lives*10);
    bs.SwitchPlayer();
    lives = bs.GetCurrPlayer().GetLives();
    bs.GetCurrPlayer().AddScore(lives*10);
}
}