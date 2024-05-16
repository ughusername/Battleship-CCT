public abstract class Ships {
    public static final int CARRIER = 1; 
    public static final int BATTLESHIP = 2;
    public static final int CRUISER = 3;
    public static final int DESTROYER = 4;
    public static final int SUBMARINE = 5;
    private int startRow;
    private int startColumn;
    private int orientation;
    private int shipType;
    private int numofShips = 5;
    

    //==================== CONSTRUCTORS ====================//
    public Ships() {
    }
    
    //=================== PUBLIC METHODS ===================//
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
    
    public abstract void SetLives(int live);
    
    public abstract int GetLives();
    
    //MADE BY AAYUSH
    /* Attacks with a special move and each ship has a special attack
     * @param row - the row which the attack will be placed
     * @param col - the column which the attack will be placed
     * @param opponent - the opponent player which stores the shipgrids
     * @param currPlayer - the currPlayer which stores the attackgrid  */
    public abstract void PowerAttack( int row, int col, Player opponent, Player curPlayer);
  
}   