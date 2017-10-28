
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
        if (!hasCrashed()) {
            //first check if the dalek is in the same row as the Doctor
            if(row == doc.getRow()){
                //now check to see if the column in this row is greater or less than the daleks
                if(col > doc.getCol()){
                    //thus the column is less that daleks so move left
                    col--;
                } else {
                    //therefore the column is greater than the daleks so move right
                    col++;
                }
                //second check to see if the dalek is in the same column as the Doctor
            } else if(col == doc.getCol()){
                //now check to see if the row in this column is greater or less than the daleks
                if(row > doc.getRow()){
                    //thus the row is less that daleks so move up
                    row--;
                } else {
                    //therefore the row is greater than the daleks so move down
                    row++;
                }
            }else {
                //this means the dalek needs to travel in a diagonal direction
                //break it down first into moving up or down, then left or right
                //Should the dalek move down?
                if(row < doc.getRow()){
                    //It should! - move down
                    row++;
                    //now should it move right?
                    if(col < doc.getCol()){
                        //yes it should move right
                        col++;
                    }else{
                        // no instead it must move left
                        col--;
                    }  
                } else {
                    //it shouldn't so move up
                    row--;
                    //now should it move right?
                    if(col < doc.getCol()){
                        //yes it should move right
                        col++;
                    }else{
                        // no instead it must move left
                        col--;
                    }  
                }
            }
        }
    }

    /**
     * Returns the row of this Dalek.
     *
     * @return This Dalek's row.
     */
    public int getRow() {
        //return row
        return row;
    }

    /**
     * Returns the column of this Dalek.
     *
     * @return This Dalek's column.
     */
    public int getCol() {
        //return column
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
        //tell the user the state of hasCrashed;
        return hasCrashed;
    }
}
