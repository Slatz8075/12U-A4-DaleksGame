
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
    //create the doctor at row 9 and column 9
    Doctor Doctor = new Doctor(9,9);
    
    //create an array for the daleks
    
    //set the dalek's initial positions, at 3 random spots
    for(int i = 0; i > 2; i++){
        Dalek Dalek[i] = new Dalek((int)(Math.random()*12), (int)(Math.random()*12));
    }
    
    
    

    /**
     * The constructor for the game. 
     * Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame(){

        

        //put down a peg
        b.putPeg(Color.GREEN, 3, 5);
        b.putPeg(Color.BLUE, 1, 2);

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

    }

}
