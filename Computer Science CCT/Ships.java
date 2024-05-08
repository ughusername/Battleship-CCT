public abstract class Ships {
    public static final int CARRIER = 1;
    public static final int BATTLESHIP = 2;
    public static final int CRUISER = 3;
    public static final int DESTROYER = 4;
    public static final int SUBMARINE = 5;
    private int startRow;
    private int startColumn;
    private int Orientation;
    private int shipType;
    private int numofShips = 5;


    //==================== CONSTRUCTORS ====================//
    public Ships() {
    }


    public String GetShipName(int shipType) {
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
    
    public int GetRemaningShips() {
    return numofShips;
    }

    public abstract int GetStartRow();

    public abstract void SetStartRow(int StartRow);

    public abstract int GetStartColumn(); 

    public abstract void SetStartColumn(int startColumn);

    public abstract int GetOrientation();

    public abstract void SetOrientation(int orientation);

    public abstract int GetPower();
    
    public abstract int GetSize();
    
    public abstract int GetIdentity();
}   