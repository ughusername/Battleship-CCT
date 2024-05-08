public class BattleshipGame {
    // Assuming Ship class exists with types: BATTLESHIP, CARRIER, CRUISER, DESTROYER, SUBMARINE
    public static void displayShipGrid(Ship[][] shipGrid) {
        for (int i = 0; i < shipGrid.length; i++) {
            for (int j = 0; j < shipGrid[i].length; j++) {
                Ship ship = shipGrid[i][j];
                if (ship == null) {
                    System.out.print("  "); // If no ship, print blank space
                } else {
                    switch (ship.getType()) {
                        case BATTLESHIP:
                            System.out.print("B ");
                            break;
                        case CARRIER:
                            System.out.print("CA");
                            break;
                        case CRUISER:
                            System.out.print("CR");
                            break;
                        case DESTROYER:
                            System.out.print("D ");
                            break;
                        case SUBMARINE:
                            System.out.print("SU");
                            break;
                        default:
                            System.out.print("  "); // Unknown ship type, print blank space
                    }
                }
                System.out.print(" "); // Add space between cells
            }
            System.out.println(); // Move to the next row
        }
    }
    
    public static void main(String[] args) {
        // Example usage
        Ship[][] shipGrid = new Ship[10][10]; // Assuming a 10x10 grid
        
        // Populate shipGrid with ships (example)
        shipGrid[0][0] = new Ship(ShipType.BATTLESHIP);
        shipGrid[1][1] = new Ship(ShipType.CARRIER);
        shipGrid[2][2] = new Ship(ShipType.CRUISER);
        shipGrid[3][3] = new Ship(ShipType.DESTROYER);
        shipGrid[4][4] = new Ship(ShipType.SUBMARINE);
        
        displayShipGrid(shipGrid);
    }
}
