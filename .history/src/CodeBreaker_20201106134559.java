/*=================================================================
@author - Anthony Qiu, Tonio Dong
@version - 1
@since - 1
Description - A game of Codebreaker that can either have the AI guess, the Player guess, or PVP
Task Definition – present the menu option visible for user
Input – no input
Output – User prompt and menu projection
Process – print the prompts
=================================================================
List of Identifiers - listed in each method 
=================================================================
*/
import java.io.*;//get access to io library

public class CodeBreaker{
/**main method:
* This procedural method is called automatically and is used to organize the calling of other methods defined in the class
*
* List of Local Variables
* leaderboards - a variable in file class to present players' past score in txt.form
* option - a int type variable allowing player to choose mode
* 
* @param args[];type String;
* @ void
*/
    public static void main(String[] args) throws IOException{//main method starts
        File leaderboards = new File("leaderboards.txt");/*invoke file handling option(leaderboards)*/
        while(true){
            System.out.println("MENU");
            System.out.println("Please enter an option");
            Text.printOptions();
            int option = Util.getIntInput();
            if(option == 1){
                PlayerGuess.playerGuess(leaderboards);
            }
            else if(option == 2){
                AIGuessEasy.AIGuessEasy();//invoke AIGuessEasy method from AIGuessEasy class
            }
            else if(option == 3){
                AIGuessMed.AIGuessMed();//invoke AIGuessMed method from AIGuessMed class
            }
            else if(option == 4){
                Knuths.AIGuessKnuths();//invoke AIGuessKnuths method from Knuth class
            }
            else if(option == 5){
                PVP.playerVsPlayer();/*invoke playerVsPlayer method from PVP class*/
            }
            else if(option == 6){
                Leaderboards.showLeaderBoards(leaderboards);/*invoke showLeaderBoards method from leaderboards class*/
            }
            else if(option == 7){
                Text.rules();//invoke rule method from Text class
            }
            else{
                System.exit(0);//terminate the program
            }
        }
    }//end main method
    
}//end CodeBreaker class
