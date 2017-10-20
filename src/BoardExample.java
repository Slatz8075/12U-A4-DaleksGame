
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author slatz8075
 */
public class BoardExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board(8, 8);

        //put down a peg
        b.putPeg(Color.GREEN, 3, 5);
        b.putPeg(Color.BLUE, 1, 2);

        //remove a peg
        b.removePeg(3, 5);

        //message
        b.displayMessage("Hello Everyone");
        while (true) {
            //recive a click from the user
            Coordinate click = b.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();
            b.putPeg(Color.BLACK, clickRow, clickCol);
        }

    }
}
