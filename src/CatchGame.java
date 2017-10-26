
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
    Doctor Doctor = new Doctor((int)(Math.random() * 12), (int)(Math.random() * 12));
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
            Daleks[i] = new Dalek((int)(Math.random()*12), (int)(Math.random()*12));
            //set a peg at this position
            b.putPeg(Color.BLACK, Daleks[i].getRow(), Daleks[i].getCol());
        }
    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        while (true) {
            //move the daleks
            for (int i = 0; i < 3; i++) {
                //remove the peg they are currently at
                b.removePeg(Daleks[i].getRow(), Daleks[i].getCol());
                //actually move the dalek, towards the doctor
                Daleks[i].advanceTowards(Doctor);
                //finally set a new peg at their new position
                b.putPeg(Color.BLACK, Daleks[i].getRow(), Daleks[i].getCol());
            }
            

            //This is the process for moving the doctor

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

            //cycle through all the daleks - checking their positions with the docotr as well as that of each other
            for (int DalekNum = 0; DalekNum < 3; DalekNum++) {
                //check to see if the doctors row and col is the same as the Dalek's row and col
                if ((Daleks[DalekNum].getRow() == Doctor.getRow()) && (Daleks[DalekNum].getCol() == Doctor.getCol())) {
                    //it is so the game has ended
                    //tell the user
                    b.displayMessage("The doctor has Been Caught");
                    //break the loop
                    break;
                }
                //create a integer for the current dalek to check
                int DalekCompare = DalekNum++;
                //check to see if the dalek checker is at the final dalek
                if (DalekNum == 2) {
                    //it is so cycle back to check the first Dalek
                    DalekCompare = 0;
                }
                //check the row and col of the dalek at question with the dalek check out lined in the above parameters
                if ((Daleks[DalekNum].getRow() == Daleks[DalekCompare].getRow()) && (Daleks[DalekNum].getCol() == Daleks[DalekCompare].getCol())) {
                    System.out.println("daleks have crashed");
                    //their positions are the same so set their state to crashed, and chenge their colour to red
                    Daleks[DalekNum].crash();
                    b.putPeg(Color.RED, Daleks[DalekNum].getRow(), Daleks[DalekNum].getCol());
                    Daleks[DalekCompare].crash();
                    b.putPeg(Color.RED, Daleks[DalekCompare].getRow(), Daleks[DalekCompare].getCol());
                }
            }
        }
    }
}
