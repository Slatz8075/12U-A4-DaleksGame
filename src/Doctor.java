
/**
 * This class models the Doctor in the game. A Doctor has a position and can
 * move to a new position.
 */
public class Doctor {

    private int row, col;

    /**
     * Initializes the variables for a Doctor.
     *
     * @param theRow The row this Doctor starts at.
     * @param theCol The column this Doctor starts at.
     */
    public Doctor(int theRow, int theCol) {
        //set this classes row and column equal to what is passed in
        row = theRow;
        col = theCol;
    }

    /**
     * Move the Doctor. If the player clicks on one of the squares immediately
     * surrounding the Doctor, the peg is moved to that location. Clicking on
     * the Doctor does not move the peg, but instead allows the Doctor to wait
     * in place for a turn. Clicking on any other square causes the Doctor to
     * teleport to a random square (perhaps by using a �sonic screwdriver�).
     * Teleportation is completely random.
     *
     * @param newRow The row the player clicked on.
     * @param newCol The column the player clicked on.
     */
    public void move(int newRow, int newCol) {
        //check to see if the click was where the doctor currently is
        if (newRow == row && newCol == col) {
            //it is so do nothing
            //now check to see if the click is larger than the bounds of the doctor
        } else if (newRow != row+1 && newRow != row-1 && newCol != col+1 && newCol != col-1) {
            //"teleport" the doctor to a random location within the 12 by 12 grid
            row = (int)(Math.random()*12);
            col = (int)(Math.random()*12);
        } else {
            //therefore the click is within bounds, move the doctor to the exact click
            row = newRow;
            col = newCol;
        }
    }

    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    public int getRow() {
        //return row
        return row;
    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol() {
        //return column
        return col;
    }
}
