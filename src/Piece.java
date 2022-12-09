/**
 * This class represents a game piece
 *
 * @author Marie-Therese Acloque
 */
public class Piece{

    /** The position of the piece on the board */
    private int position;

    /** The starting position of the piece on the board*/
    private int start;

    /** If the piece has been deployed on the board */
    private boolean atBase;

    /** If the piece has reached the end of the game */
    private boolean atEnd;

    /** The number of the place on the board that is the piece's respective end aisle */
    private int endAisle;

    /** If the piece is in the aisle leading to the end */
    private boolean inEndAisle;

    /**
     * Instances a piece object
     *
     * @param color The color of the piece on the board
     */

    public Piece(int color){ //Color is in reference to the colors on the board
        if (color == 1){ // Theres 52 spaces on the board counting from 1- 52
            start = 1;
            endAisle = 51;
        }else {
            start = 27;
            endAisle = 25;
        }
        atEnd = false;
        atBase = true;
        inEndAisle = false;
        position = start;
    }

    /**
     * Returns if the piece was able to move
     *
     * @param move The number of spaces the piece should move
     *
     * @return If the piece was capable of moving
     */
    public boolean moveSpace(int move){ // Moves pice & return true but returns false if piece is unable to move;
        atBase = false;
        if (inEndAisle){
            if (position + move <= 6){
                position+= move;
                return true;
            }else {
                return false;
            }
        }else{
            if (move + position >= endAisle){
                for (int i = position; i<= endAisle; i++){
                    move--;
                }
                position = 0;
                position+= move;
                inEndAisle = true;
                return true;
            }else {
                if (position + move > 52){
                    for (int i = 1; i <= move; i++){
                        if (position + i <= 52){
                            position ++;
                        }else {
                            position = 1;
                        }
                    }
                    return true;
                }else {
                    position += move;
                    return true;
                }
            }
        }
    }

    /**
     * Returns if the piece has made it to the end of the game
     *
     * @return If the piece has reached the end of the game
     */
    public boolean isAtEnd(){
        if (inEndAisle && position == 6){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Returns if the piece hasn't been deployed on the board yet
     *
     * @return If the piece is at it's home
     */
    public boolean isAtBase(){
        return atBase;
    }

    /**
     * Returns the position of the piece on the board
     *
     * @return The position of the piece
     */
    public int getPosition(){
        return position;
    }

    /**
     * Method that sends a piece back to it's starting point if it's been landed on the opponents piece
     */
    public void sendBack(){
        position = start;
        atBase = true;
    }
}