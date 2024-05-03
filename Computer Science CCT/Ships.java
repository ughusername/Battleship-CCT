public abstract class Ships {
    public static final int CARRIER = 1;
    public static final int BATTLESHIP = 2;
    public static final int CRUISER = 3;
    public static final int DESTROYER = 4;
    public static final int SUBMARINE = 5;
    private int startRow;
    private int startColumn;
    private int Orientation;

    //==================== CONSTRUCTORS ====================//
    public Ships() {
    }
    
    public boolean IsHIt() {
        return false; //DUMMY VALUE, NEEDS TO BE CHANGED
    }
    
    public boolean IsSunk() {
        return false; //DUMMY VALUE, NEEDS TO BE CHANGED
    }

    public int GetRemaningShips() {
        return 0; //DUMMY VALUES, NEEDS TO BE CHANGED 
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
        return 0; //DUMMY VALUE, NEEDS TO BE CHANGED
    }

    public void SetOrientation(int orientation) {
        this.Orientation = orientation;
    }

    public abstract int GetPower();

}