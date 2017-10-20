
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
        this.row = row;
        this.col = col;
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
        if (newRow == getRow() && newCol == getCol()) {
            //it is so do nothing
            //now check all the directions
        } else if (newRow == getRow()+1 && newCol == getCol()) {
            //move down
            row++;
        } else if (newRow == getRow()-1 && newCol == getCol()) {
            //move up
            row--;
        } else if (newRow == getRow() && newCol == getCol()+1) {
            //move right
            col++;
        } else if (newRow == getRow() && newCol == getCol()-1) {
            //move left
            col--;
        } else if (newRow == getRow()+1 && newCol == getCol()+1) {
            //move right and down 1
            row++;
            col++;
        } else if (newRow == getRow()+1 && newCol == getCol()-1) {
            //move left and down 1
            row++;
            col--;
        } else if (newRow == getRow()-1 && newCol == getCol()+1) {
            //move right and up 1
            row--;
            col++;
        } else if (newRow == getRow()-1 && newCol == getCol()-1) {
            //move left and up 1
            row--;
            col--;
            //now since none of these if statments have triggered, teleport him to a random spot
        } else {
            //"teleport" the doctor to a random location within the 12 by 12 grid
            row = (int)(Math.random()*12);
            col = (int)(Math.random()*12);
        }

    }

    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol() {
        return this.col;
    }
}
