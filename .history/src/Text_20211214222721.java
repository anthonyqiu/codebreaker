/*=================================================================
Task Definition – This class prints every visibal texts for user to have a better understanding of program procedure
Input – no input
Output – messages
Process – print texts
=================================================================
List of Identifiers -listed in each method
=================================================================
*/
public class Text {
/**printOptions method:
* This functional method prints option messages
*
*
* @param none
* @output texts
*/
    public static void printOptions(){
        System.out.println("1. Player Guess");
        System.out.println("2. AIGuess (Easy)");
        System.out.println("3. AIGuess (Medium)");
        System.out.println("4. AIGuess (Hard)");
        System.out.println("5. PVP");
        System.out.println("6. Leaderboards");
        System.out.println("7. Rules");
        System.out.println("8. ANY OTHER NUMBER TO EXIT");
    }
/**rule method:
* This functional method prints rules
*
* @param none
* @output texts
*/
    public static void rules(){
        System.out.println("RULES");
        System.out.println("PLAYER GUESS");
        System.out.println("1. The computer will randomly generate a code (eg. B Y R G) (B for blue, G for green, O for orange, P for purple, R for red, Y for yellow, spaces in between)");
        System.out.println("2. You will have 10 tries to guess the code");
        System.out.println("3. Each guess if you did not win, the computer will provide you with some hints (B stands for right colour and right position, W stands for right colour");
        System.out.println("AI GUESS");
        System.out.println("1. You are the computer and the computer is you");
        System.out.println("2. You will create a secret code that the computer will try to break (eg. B Y R G) (B for blue, G for green, O for orange, P for purple, R for red, Y for yellow, spaces in between)");
        System.out.println("3. The comuputer will attempt to guess you code in 10 tries");
        System.out.println("4. If the computer did not guess correctly you are to give the computer a set of hints which conssists of B, black (colour and position correct), W whites (correct colour), N none (no colour correct)");
        System.out.println("PVP");
        System.out.println("In this gamemode there are 2 players each will make their own code and then guess each others (eg. B Y R G) (B for blue, G for green, O for orange, P for purple, R for red, Y for yellow, spaces in between)");
        System.out.println("Refer to player guess for the instructions on this gamemode. Instead of playing against an AI you will see who can guess each others code first");
    }
/**printLosingMessage method:
* This functional method prints losing message
*
* @param none
* @output texts
*/
    public static void printLosingMessage(){
        System.out.println("YOU LOSE :(");
        return;
    }
/**printWinningMessage method:
* This functional method prints winning message
*
* @param (player)
* @output texts
* return 
*/
    public static void printWinningMessage(String player){
        System.out.println("CONGRATS " + player + " YOU WON!!!");
        return;
    }
/**printTime method:
* This functional method prints time you complete the task
*
* @param (time)
* @output texts
*/
    public static void printTime(long time){
        System.out.println("Your time was " + time + "s");
    }
    
}//end Text class
