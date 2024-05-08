public class BattleshipMain {
    public static void main(String[] args) {
        
        BattleshipSystem bs = new BattleshipSystem();
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
        int check = bs.InsertShip(5,6, shipType, 0); 
        
        // Example usage // Assuming a 10x10 grid
        
        // Populate shipGrid with ships (example)
        bs.Shipgrid[0][0] = new Carrier(0, 0, 0);
        bs.Shipgrid[1][1] = new Cruiser(0, 1, 1);
        bs.Shipgrid[2][2] = new Battleship();
        bs.Shipgrid[3][3] = new Carrier(0, 3, 3);
        bs.Shipgrid[4][4] = new Cruiser(0, 4, 4);
        
        Displayer.DisplayShipGrid(bs.Shipgrid);
    }
    }    
