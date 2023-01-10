/*=================================================================
Task Definition – code type Casting
Input – pegs from class code
Output – prints out the code in string type
Process – to intToStringCode method from Util class to convert the code from integer type to string type
=================================================================
List of Identifiers - listed in each method
=================================================================
*/
public class Code {

    int[] pegs;

    public Code(int[] pegs){
        this.pegs = pegs;//constructer to 
    }
/**printCode method:
* This functional method reads user input, and returns the value
*
* List of Local Variables
* pegs- an integer type array of length 4
* stPegs- a string type array of length 4
*
* @param (guess)
* @output codes
*/
    public static void printCode(Code guess){
        int[] pegs = guess.pegs;//call pegs method
        String[] stPegs = Util.intToStringCode(pegs);
        for(String st : stPegs){//for every string in stPegs(codes), print the string
            System.out.print(st + " ");
        }
        System.out.println();
    }

}// class Code ends