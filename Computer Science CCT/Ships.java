public abstract class Ships {
    public static final int CARRIER = 1;
    public static final int BATTLESHIP = 2;
    public static final int CRUISER = 3;
    public static final int DESTROYER = 4;
    public static final int SUBMARINE = 5;
    private int startRow;
    private int startColumn;
    private int Orientation;
    private boolean isSunk;
    private int shipType;
    private int numofShips = 10



    //==================== CONSTRUCTORS ====================//
    public Ships() {
        this.isSunk = false;
        this.numofShips = numofShips;

    }

    public boolean IsHit(int x, int y) {
        if (lives == 0) {
            isSunk = true;
            System.out.println("You sunk the " + getShipName(shipType)); // Using a method to get ship name
            numofShips--;            
            return false;
        }
         else {
            System.out.println("You hit a ship at coordinates (" + x + ", " + y + ")"); // Using a method to get ship name
            lives--;
            return true;
        }
    }

    public String getShipName(int shipType) {
        switch (shipType) {
            case CARRIER:
                return "Carrier";
            case BATTLESHIP:
                return "Battleship";
            case CRUISER:
                return "Cruiser";
            case DESTROYER:
                return "Destroyer";
            case SUBMARINE:
                return "Submarine";
            default:
                return "Unknown";
        }
    }

    public boolean IsSunk() {
        return isSunk;
    }
    
    public int GetRemaningShips() {
    return numofShips;
    }

    public int GetStartRow() {
        return startRow;
    }

    public void SetStartRow(int StartRow) {
        this.startRow = StartRow;
    }

    public int GetStartColumn() {
        return startColumn;
    }

    public void SetStartColumn(int startColumn) {
        this.startColumn = startColumn;
    }

    public int GetOrientation() {
        return orientation;
    }

    public void SetOrientation(String orientation) {
        this.Orientation = orientation;
    }

    public abstract int GetPower();

}   