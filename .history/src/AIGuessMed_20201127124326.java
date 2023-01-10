/*=================================================================
Problem Definition : Medium level AI Guess mode
Process : performs the task by generating 5 AI guesses, and based on the response the user gives, permutating 24 4-pegs codes,and loop through each one until guess out the code;
*List of Global Variables
* permutations--an arraylist object that stores hints
=================================================================
List of Identifiers - listed in each method 
=================================================================
*/
import java.util.*;//get access to java util library




/* AIGuessMed Method:
/* This void type method generates 5 sets of the 4 pegs consisting of the same color.Based on the response(black/white pegs) given, generates 24 permuates code to later test.
*
* List of Local Variables
* blacks -- the response of numbers of correct position and correct color code.
* freq -- an array of length 7, represents the frequency of black/white pegs appeared based on one's guess.
* hints -- call getResponsePegs class to get the array'hints'
* @param none
*/
public class AIGuessMed {//AIGuessMed class starts

    static ArrayList<int[]> permutations = new ArrayList<>();//generate an arraylist to contain permutated codes later on

    public static void AIGuessMedMode(){//AIGuessMed method starts
        int[] freq = new int[7];//generate an int type array of length 7
        int blacks = 0;//intialize the number of black pegs to be 0
        System.out.println("B B B B"); /*For a total of 5 times, generate 4 codes consisting of the same colour,, store the number of black pegs and frequency respectively based on user's hints */
        int[] hints = Util.getResponsePegs();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[1];
                ++blacks;
            }
        }
        System.out.println("G G G G");//represents "green" "green" "green" "green" 
        hints = Util.getResponsePegs();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[2];
                ++blacks;
            }
        }
        System.out.println("O O O O");//represents "Orange" "Orange" "Orange" "Orange" 
        hints = Util.getResponsePegs();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[3];
                ++blacks;
            }
        }
        System.out.println("P P P P");//represents "Purple" "Purple" "Purple" "Purple" 
        hints = Util.getResponsePegs();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[4];
                ++blacks;
            }
        }
        System.out.println("R R R R");//represents "Red" "Red" "Red" "Red" 
        hints = Util.getResponsePegs();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[5];
                ++blacks;
            }
        }
        if(blacks != 4){//if it does not contain 4 black pegs 
            freq[6] = 4 - blacks;//finds the number of non-black pegs, which represents incorrect-positioned/colored code
        }

        int index = 0;
        int[] code = new int[4];//create an int type array of length 4
        for(int i = 1; i <= 6; ++i){
            for(int j = 0; j < freq[i]; ++j){
                code[index] = i;//
                ++index;
            }
        }

        permute(code, 0);//

        for(int[] permutation : permutations){//for each element in arraylist permutation, go through permutations
            for(int i = 0; i < 4; ++i){
                String[] stPegs = Util.intToStringCode(permutation);//covert int type code to string type
                System.out.print(stPegs[i] + " ");//tell user the AIGuess code in string type and ask for feedback
            }
            System.out.println();
            hints = Util.getResponsePegs();//call gerResonsePegs from util class
            int blacksPermute = 0;//initialize black pegs
            for(int i = 0; i < 4; ++i){
                if(hints[i] == 0) ++blacksPermute;//store black pegs based on user's hint
            }
            if(blacksPermute == 4){//if user enters 4 black pegs, AI won
                break;
            }
        }

        permutations.clear();//clear 'permutation' arraylist
    }
/* permute Method:
/* This void type method test 24 permutated codes generated, and sort out the correct one from these 24 codes.
*
* List of Local Variables
* temp -- an array of length 4 to store each possible codes.
* swap --swap permutation codes based on response to figure out the code efficiently
*
* @param none
*/
    public static void permute(int[] code, int pos){//permute method starts
        if(pos == code.length - 1){//go through each cell consisting of permutation codes in an array
            int[] temp = {code[0], code[1], code[2], code[3]};
            permutations.add(temp);
        }
        else{
            for(int i = pos; i < code.length; ++i){
                swap(code, pos, i);
                permute(code, pos + 1);
                swap(code, pos, i);
            }
        }
    }
/* swap Method:
/* This void type method test 24 permutated codes generated, and sort out the correct one from these 24 codes.
*
* List of Local Variables
* temp -- 
* i1 --
* i2 --
* @param none
*/
    public static void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    
}//end AIGuessMed class
