public class BattleshipMain {
    public static void main(String[] args) {
        Player one = new Player(1,5);
        Player two = new Player(2,5);

        BattleshipSystem bs = new BattleshipSystem();
        bs.SetCurrPlayer(0);
        Ships[][] Shipsgrid = new Ships[BattleshipSystem.HEIGHT][BattleshipSystem.WIDTH];
        int[][] AttackGrid = new int[BattleshipSystem.HEIGHT][BattleshipSystem.WIDTH];
        AttackGrid = new int[][] {
            {-1, -1, -1, -1, -1, -1, -1, 1, 0, 1},
            {-1, -1, -1, -1, -1, -1, -1, 1, 0, 1},
            {-1, -1, -1, -1, -1, -1, -1, 1, 0, 1},
            {-1, -1, -1, -1, -1, -1, -1, 1, 0, 1},
            {-1, -1, -1, -1, 1, 0, 1, -1, -1, -1},
            {-1, -1, -1, -1, 1, 0, 1, -1, -1, -1},
            {-1, 1, 0, 1, -1, -1, -1, -1, -1, -1}
        };
        Displayer.DisplayAttackGrid(AttackGrid);
        //if shiptype == 1 {}
        
        
        Ships shipType = new Battleship();
        bs.InsertShip(5,6, shipType, 0); 
        
        // Example usage // Assuming a 10x10 grid
        
        // Populate shipGrid with ships (example)
        bs.ShipGrid[0][0] = new Carrier(0, 0, 0);
        bs.ShipGrid[1][1] = new Cruiser(0, 1, 1);
        bs.ShipGrid[2][2] = new Battleship();
        bs.ShipGrid[3][3] = new Carrier(0, 3, 3);
        bs.ShipGrid[4][4] = new Cruiser(0, 4, 4);
        
        Displayer.DisplayShipGrid(bs.ShipGrid);
    }
    }    
