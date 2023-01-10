/*=================================================================
Task Definition – the easist AI Guess mode, that randomly generates 4 colors and ask for answer
Input – AI generating random number
Output – The actual code
Process – compare the guess code and actual code, with feedback.
=================================================================
List of Identifiers - listed in method
=================================================================
*/
 
public class AIGuessEasy {
/*AIGuessEasy method:
* This void type method performs the task by random guessing a 4-pegs code through conditional loop consists of same or different colors
*
* List of Local Variables
* correct -- a boolean variable to determine whether the 4-pegs code AI Guess is correct or not
* guess -- a object type variable in the class Code;
* key -- a primitive type varibale in the class Key; 
* @param none
* 
*/
    public static void AIGuessEasyMode(){
        boolean correct = false;
        int count = 0;
        while(correct == false && count < 10){
            Code guess = new Code(Util.getRandomPegs());//call Util class getRandomPegs to get random codes
            Code.printCode(guess);
            Key key = Key.getKeyWithHints(Util.getResponsePegs());
            if(key.blacks == 4) return;
            ++count;
        }
    }//end AIGuessEasy method


    
}//end AIGuessEasy class
