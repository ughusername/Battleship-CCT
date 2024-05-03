public abstract class Ship {
    public static final int CARRIER = 1;
    public static final int BATTLESHIP = 2;
    public static final int CRUISER = 3;
    public static final int DESTROYER = 4;
    public static final int SUBMARINE = 5;
    private boolean isHit = false;
    private int startRow;
    private int startColumn;
    private int Orientation;
}