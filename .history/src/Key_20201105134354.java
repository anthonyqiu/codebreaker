/*=================================================================
Task Definition – This procedural program generates hints consisting of black, white, and blank pegs
Input – a series of numbers until the word exit is input
Output – the largest number entered
Process – compare numbers to see which one is the largest
=================================================================
List of Identifiers - listed in each method
=================================================================
*/
import java.util.Arrays;//get access to util libaray to import Arrays

public class Key {

    int blacks;
    int whites;
    int blanks;

    public Key(int blacks, int whites, int blanks){
        this.blacks = blacks;
        this.whites = whites;
        this.blanks = blanks;
    }
/**getKeyWithHints method:
* This functional method reads user input, and returns the value
*
* List of Local Variables
* blacks-number of black pegs
* whites-number of white pegs
* @param (hints)
* @return the number input by user &lt;type String&gt;
*/
    public static Key getKeyWithHints(int[] hints){
        int blacks = 0;
        int whites = 0;
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){//if we get user's hint to be 0, it means correct color/position pegs
                ++blacks;
            }
            else if(hints[i] == 1){//if we get user's hint to be 0, it means correct color incorrect position pegs
                ++whites;
            }
        }
        int blanks = 4 - blacks - whites;
        Key key = new Key(blacks, whites, blanks);//key method of Key type(found in separate class) is to store number of black/white pegs, and blank
        return key;
    }
/**getKeyWithCode method:
* This functional method store in hints consisting of black/white pegs based on player's guess
*
* List of Local Variables
* br - a BufferedReader object used for keyboard input &lt;type BufferedReader&gt;
*
* @param (code, ans)
* @return user's hints
*/
    public static Key getKeyWithCode(Code code, Code ans){
        int[] pegs = code.pegs;
        int[] ansPegs = ans.pegs;
        int blacks = 0; //initialize the number of blacks
        int whites = 0; //initialize the number of whites
        int[] codeFreq = new int[7];
        int[] ansFreq = new int[7];
        for(int i = 0; i < 4; ++i){
            ++ansFreq[ansPegs[i]]; //add frequency of answer to the corresponding(answer pegs position) position 
            ++codeFreq[pegs[i]]; //add frequency of guessing code to the corresponding position
        }
        for(int i = 0; i < pegs.length; ++i){
            if(pegs[i] == ansPegs[i]){// if position i in guessing code and answer code is the same, add 1 to black pehs
                ++blacks;
                --ansFreq[pegs[i]];//minus 1 to the corresponding position of answer frequency
                --codeFreq[pegs[i]];//minus 1 to the corresponding position of guessing code frequency
            }
        }
        for(int i = 0; i < pegs.length; ++i){
            if(ansFreq[pegs[i]] > 0 && codeFreq[pegs[i]] > 0){//if a color appears, but not on the correct position, we add 1 white pegs
                ++whites;
                --ansFreq[pegs[i]]; //minus 1/update the number of white pegs 
                --codeFreq[pegs[i]];    //-------------------------------------> FIX FREQUENCY MAPS <---------------------------------------------------------------------*/
            }
        }
        int blanks = 4 - (blacks + whites);//number of blank pegs is the total number - the sum of black/white pegs
        return new Key(blacks, whites, blanks);
    }
    
}//end key class
