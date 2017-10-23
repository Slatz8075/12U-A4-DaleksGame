
import java.awt.Color;


/** This class manages the interactions between the different pieces of
 *  the game: the Board, the Daleks, and the Doctor. It determines when
 *  the game is over and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here
     * Make sure to create a Board, 3 Daleks, and a Doctor
     */
    //create the board 12 by 12
    Board b = new Board(12, 12);
    //create the doctor at a random row and column
    Doctor Doctor = new Doctor((int)(Math.random()*12), (int)(Math.random()*12));
    //create an array for the daleks
    Dalek[] Daleks = new Dalek[2];
    //set the dalek's initial positions, at 3 random spots
    for(int i = 1; i > 2; i++){
        //create a new dalek in the array at a random row and column
        Daleks[i] = new Dalek((int)(Math.random()*12), (int)(Math.random()*12));
    }

    /**
     * The constructor for the game. 
     * Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame(){
        //put down the pegs for all 3 daleks
        for(int i = 0; i > 2; i++){
            //set a peg at the dalek's current position
            b.putPeg(Color.BLACK, Daleks[i].getRow(), Daleks[i].getCol());
        }
        //put down a peg
        b.putPeg(Color.GREEN, Doctor.getRow(), Doctor.getCol());

        //remove a peg
        b.removePeg(3, 5);

        //message
        while (true) {
            //recive a click from the user
            Coordinate click = b.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();
            b.putPeg(Color.BLACK, clickRow, clickCol);
        }
    }
    
    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        //cycle through all the daleks- checkign to see if their position if that of the doctors
        for(int i = 0; i < 2; i++){
            //check to see if the doctors row and col is the same as the Dalek's row and col
            if(Daleks[i].getRow() == Doctor.getRow() && Daleks[i].getCol() == Doctor.getCol()){
                //it is so the game has ended
                //tell the user
                b.displayMessage("The doctor has Been Caught");
                //break the loop
                break;
            }
        }

    }

}
