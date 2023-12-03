package day3;

public class GridNumber {
    public int row, col;
    public int digitNumber;
    public int value;
    
    public GridNumber(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.digitNumber = (int)Math.log10(value) + 1;
    }
    
    @Override
    public String toString() {
        return "" + value;
    }
}
