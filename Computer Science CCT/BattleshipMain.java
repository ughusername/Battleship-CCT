public class BattleshipMain {
    public static void main(String[] args) {
        
        BattleshipSystem bs = new BattleshipSystem();
        Ships[][] Shipsgrid = new Ships[BattleshipSystem.HEIGHT][BattleshipSystem.WIDTH];
        int[][] AttackGrid = new int[BattleshipSystem.HEIGHT][BattleshipSystem.WIDTH];
        AttackGrid = new int[][] {
            {-1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1}
        };
        Displayer.DisplayAttackGrid(AttackGrid);
        //if shiptype == 1 {}
        Ships shipType = new Carrier(0, 0, 0);
        bs.InsertShip(1,1, shipType, 0);
    }    
}
