
import java.awt.Color;

/**
 * This class manages the interactions between the different pieces of the game:
 * the Board, the Daleks, and the Doctor. It determines when the game is over
 * and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here Make sure to create a Board, 3 Daleks, and
     * a Doctor
     */
    //create the board 12 by 12
    Board b = new Board(12, 12);
    //create the doctor at a random row and column
    Doctor Doctor = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
    //create an array for the daleks that will be created in the constructer area
    Dalek[] Daleks = new Dalek[3];

    /**
     * The constructor for the game. Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame() {

        //put down a peg for the doctor
        b.putPeg(Color.GREEN, Doctor.getRow(), Doctor.getCol());

        //create an array of 3 daleks at 3 random spots
        for (int i = 0; i < 3; i++) {
            //create a new dalek in the array at a random row and column
            Daleks[i] = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
            //set a peg at this position
            b.putPeg(Color.BLACK, Daleks[i].getRow(), Daleks[i].getCol());
        }
    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {

        //let the loop run while there is still one dalek alive
        while (!Daleks[0].hasCrashed() || !Daleks[1].hasCrashed() || !Daleks[2].hasCrashed()) {

            //MOVE THE DOCTOR
            //recieve a click from the user
            Coordinate click = b.getClick();
            //store the click's row and col
            int clickRow = click.getRow();
            int clickCol = click.getCol();
            //remove the peg the doctor is at
            b.removePeg(Doctor.getRow(), Doctor.getCol());
            //move the doctor with this data
            Doctor.move(clickRow, clickCol);
            //mark this with a peg
            b.putPeg(Color.GREEN, Doctor.getRow(), Doctor.getCol());

            //DALEK MOVING
            //create a for loop to cycle through each dalek
            for (int DalekNum = 0; DalekNum < Daleks.length; DalekNum++) {
                //MOVE THE DALEK
                //only move the dalek if they have not crashed yet
                if (!Daleks[DalekNum].hasCrashed()) {
                    //remove the peg they are currently at
                    b.removePeg(Daleks[DalekNum].getRow(), Daleks[DalekNum].getCol());
                    //actually move the dalek, towards the doctor
                    Daleks[DalekNum].advanceTowards(Doctor);
                    //finally set a new peg at their new position
                    b.putPeg(Color.BLACK, Daleks[DalekNum].getRow(), Daleks[DalekNum].getCol());
                }
            }

            //DALEK CHECKING (Checking the daleks with eachother and the doctor
            //create a for loop to cycle through each dalek
            for (int DalekNum = 0; DalekNum < Daleks.length; DalekNum++) {

                //CHECK THE DALEK'S POSITIONS WITH EACH OTHER
                //create a integer for the current dalek to compare with
                int DalekCompare = DalekNum + 1;
                //check to see if the dalek checker is at a dalek that is not in the array
                if (DalekNum == 2) {
                    //it is so cycle back to compare with the first Dalek
                    DalekCompare = 0;
                }
                //check the row and col of the dalek of question with the dalek compare out lined in the above parameters
                if ((Daleks[DalekNum].getRow() == Daleks[DalekCompare].getRow()) && (Daleks[DalekNum].getCol() == Daleks[DalekCompare].getCol())) {
                    //their positions are the same so set their states to crashed, and change put a peg on top of the crash
                    Daleks[DalekNum].crash();
                    Daleks[DalekCompare].crash();
                    b.putPeg(Color.RED, Daleks[DalekNum].getRow(), Daleks[DalekNum].getCol());
                }
                //now check if all of the daleks have crashed
                if ((Daleks[0].hasCrashed() && Daleks[1].hasCrashed() && Daleks[2].hasCrashed())) {
                    //tell the user the out come of the game
                    b.displayMessage("Game Over: all Daleks have crashed");
                    System.out.println("this has triggered");
                }
                //CHECK THE DALEK'S POSITIONS WITH THE DOCTOR'S
                //check to see if the doctors row and col is the same as the Dalek's row and col
                if ((Daleks[DalekNum].getRow() == Doctor.getRow()) && (Daleks[DalekNum].getCol() == Doctor.getCol())) {
                    //it is so the game has ended
                    //set the doctor to be yellow
                    b.putPeg(Color.YELLOW, Doctor.getRow(), Doctor.getCol());
                    //set all of the dalek's states to crashed so the main while loop will be cut
                    for (int DCrash = 0; DCrash < Daleks.length; DCrash++) {
                        //crash the Dalek
                        Daleks[DCrash].crash();
                    }
                    //tell the user the outcome of the game
                    b.displayMessage("Game Over: the Doctor has been caught");
                }
            }
        }
    }
}
