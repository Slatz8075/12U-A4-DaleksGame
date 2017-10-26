
/**
 * This class models a Dalek in the game. A Dalek has a position and can advance
 * towards the Doctor.
 */
public class Dalek {

    private int row, col;
    private boolean hasCrashed;

    /**
     * Initializes the variables for a Dalek.
     *
     * @param theRow The row this Dalek starts at.
     * @param theCol The column this Dalek starts at.
     */
    public Dalek(int theRow, int theCol) {
        row = theRow;
        col = theCol;
    }

    /**
     * Attempts to move the Dalek towards the Doctor by the most direct route,
     * moving up, down, right, left or diagonally. For example, if the Doctor is
     * above and to the right of a Dalek, it will move diagonally. If the Doctor
     * is directly below a Dalek, it will move down.
     *
     * @param doc The Doctor to move towards.
     */
    public void advanceTowards(Doctor doc) {

        //allow the dalek to move only if they have not crashed yet
        if (hasCrashed() == false) {
            //compare dalek's row and col against doctor's row and col then adjust the dalek's position accordingly
            if (row < doc.getRow() && col == doc.getCol()) {
                //move down
                row++;
            } else if (row > doc.getRow() && col == doc.getCol()) {
                //move up
                row--;
            } else if (row == doc.getRow() && col < doc.getCol()) {
                //move right
                col++;
            } else if (row == doc.getRow() && col > doc.getCol()) {
                //move left
                row--;
            } else if (row < doc.getRow() && col < doc.getCol()) {
                //move down, and right
                row++;
                col++;
            } else if (row > doc.getRow() && col < doc.getCol()) {
                //move up, and right
                row--;
                col++;
            } else if (row > doc.getRow() && col > doc.getCol()) {
                //move up, and left
                row--;
                col--;
            } else if (row < doc.getRow() && col > doc.getCol()) {
                //move down, and left
                row++;
                col--;
            }
        }
    }

    /**
     * Returns the row of this Dalek.
     *
     * @return This Dalek's row.
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of this Dalek.
     *
     * @return This Dalek's column.
     */
    public int getCol() {
        return col;
    }

    /**
     * Sets the Dalek to be in a crashed state.
     */
    public void crash() {
        //set the daleks 'hasCrashed' state equal to true
        hasCrashed = true;
    }

    /**
     * Returns whether or not this Dalek has crashed.
     *
     * @return true if this Dalek has crashed, false otherwise
     */
    public boolean hasCrashed() {
        //is 'hasCrashed' true
        if (hasCrashed == true) {
            //return such
            return true;
            //it isn't
        } else {
            //so return false
            return false;
        }
    }
}
