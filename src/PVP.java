/*=================================================================
Task Definition – a player versus player mode of Code Breaker
Input – player 1 and player 2 set up a 4-pegs code and input each other's guessing code by turns
Output – Winning/Losing message, and the number of time two takes
Process – compare numbers to see which one is the largest
=================================================================
List of Identifiers - listed in each method 
=================================================================
*/
import java.util.*;

public class PVP {
/**playerVsPlayer method:
* This functional method prompts the user to enter 4-pegs code, after, take turns to guess it
*
* List of Local Variables
* colourFreqP1 - the frequency of colors appearing of player 1's code
* colourFreqP2 - the frequency of colors appearing of player 2's code
* codeP1 - player 1's 4-pegs code
* codeP2 - player 1's 4-pegs code
* blacksp1 - number of black pegs for player 1's guess
* blacksp2 - number of black pegs for player 2's guess
* hintsP1 - an arraylist that contains player1's hints
* hintsP2 - an arraylist that contains player2's hints
* tempColourFreqP1 -the updated frequency for player 1 after calculation 
* tempColourFreqP2 -the updated frequency for player 2 after calculation
* @param none
* @void - prints Winning/Losing message, and the number of time two takes
*/
    public static void playerVsPlayer(){
        System.out.println("Player 1 please enter your code:");
        int[] codeP1 = Util.getUserCode();//get player1's code from Util class
        System.out.println("Player 2 please enter your code:");
        int[] codeP2 = Util.getUserCode();//get player2's code from Util class
        int[] colourFreqP1 = new int[7];//create an array int type to store the frequency of occurance for each color in the color poll
        int[] colourFreqP2 = new int[7];//create an array int type to store the frequency of occurance for each color in the color poll
        for(int i = 0; i < codeP1.length; ++i){
            ++colourFreqP1[codeP1[i]];
            ++colourFreqP2[codeP2[i]];
        }

        while(true){
            int[] tempColourFreqP1 = colourFreqP1;
            int[] tempColourFreqP2 = colourFreqP2;
            System.out.println("P1 please make a guess:");
            int[] guessP1 = Util.getUserCode();
            int blacksP1 = 0;//initialize number of black pegs to 0
            PriorityQueue<Integer> hintsP1 = new PriorityQueue<>();//sort from black pegs>>>white pegs>>>blank pegs

            for(int i = 0; i < guessP1.length; ++i){
                if(guessP1[i] == codeP2[i]){//if player1's guess in corresponding position is the same as player2's code, add 1 to player1's black pegs
                    ++blacksP1;
                    --tempColourFreqP2[guessP1[i]];
                    if(blacksP1 == 4){//if 4 black pegs are collected, player1 successfully guesses out player2's code
                        Text.printWinningMessage("PLAYER 1"); //player1 wins
                        return;
                    }
                    hintsP1.add(0);   //0 represents black peg 
                }
            }
            for(int i = 0; i < guessP1.length; ++i){
                if(tempColourFreqP2[guessP1[i]] > 0){//to sort out the number of white pegs
                    --tempColourFreqP2[guessP1[i]];
                    hintsP1.add(1);   //1 represents white peg
                }
            }
            System.out.println("P1 hints");
            while(!hintsP1.isEmpty()){//if player1's hints to player2 is not empty
                System.out.print(" " + hintsP1.poll() + " |");//output player1's hints
            }
            System.out.println();

            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println("P2 please make a guess:");
            int[] guessP2 = Util.getUserCode();
            int blacksP2 = 0;
            PriorityQueue<Integer> hintsP2 = new PriorityQueue<>();//sort hints from black pegs>>>white pegs>>>blank pegs

            for(int i = 0; i < guessP2.length; ++i){
                if(guessP2[i] == codeP1[i]){
                    ++blacksP2;//add 1 to player2's black pegs
                    --tempColourFreqP1[guessP2[i]];//updating the frequency of one color
                    if(blacksP2 == 4){
                        Text.printWinningMessage("PLAYER 2");//player 2 wins
                        return;
                    }
                    hintsP2.add(0);   //0 represents black peg
                }
            }
            for(int i = 0; i < guessP2.length; ++i){
                if(tempColourFreqP1[guessP2[i]] > 0){
                    --tempColourFreqP1[guessP2[i]];
                    hintsP2.add(1);   //1 represents white peg
                }
            }
            System.out.println("P2 hints");
            while(!hintsP2.isEmpty()){
                System.out.print(" " + hintsP2.poll() + " |");//output player2's hints
            }
            System.out.println();
        }
    }
    
}//end class