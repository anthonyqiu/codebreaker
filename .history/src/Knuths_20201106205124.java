/*=================================================================
Problem Definition : Hard level AI Guess mode
Process : creates a set S of all the possible colour combinations and eliminates all the impossible codes in order to guess the correct code in under 5 tries
=================================================================
List of Identifiers - listed in each method 
=================================================================
*/
import java.util.*; //get access to java util library

public class Knuths {

/* AIGuessKnuths Method:
/* This void type method creates a set S of all the possible colour combinations and eliminates all the impossible codes in order to guess the correct code in under 5 tries
*
* List of Local Variables
* candidates -- a list of all possible codes that could be the correct code
* unused -- a list of all codes that have not been guessed yet
* temp -- an array containg the first guess to save one run of minimax
* guess -- a new code that stores temp (for clearer understanding of the code)
* hints -- stores the hints provided by the user
* key -- stores a key with hints as a reference
* @param none
*/
    public static void AIGuessKnuths(){
        ArrayList<Code> candidates = getCombo();
        ArrayList<Code> unused = getCombo();
        Code guess = minimax(unused, candidates);
        Code.printCode(guess);

        while(true){    //every loop is one trun for the ai
            removeCode(guess, candidates);  //removes the current guess from candidates and unused
            removeCode(guess, unused);

            int[] hints = Util.getResponsePegs();   //takes user input for hints and converts it into a key
            Key key = Key.getKeyWithHints(hints);

            if(key.blacks == 4){    //returns if the guess is correct
                return;
            }

            removeCodes(guess, key, candidates);    //removes the impossible codes from candidates
            
            if(candidates.size() == 1) guess = candidates.get(0);   //base case, if there is one code left that is the correct answer, thus guess it
            else guess = minimax(unused, candidates);   //else get the next code from minimax
            Code.printCode(guess);
        }
    }

    /* minimax Method:
/* This is a Code type method that finds the best Code to guess in unused (anything that hasn't been guessed). The best code is the code that has the maximum minimum number of max hits
*
* List of Local Variables
* minElim -- minElim is the highest minimum of max hitcounts
* guess -- guess is the next guess
* minMaxTable -- stores the number of guesses the current code would eleminate for each specified number of black and whites for a response
* key -- stores the number of blacks and whites for code and candidate
* maxHits -- stores the max number of hits for each guess
* @param unused, candidates
* @return guess (the next guess)
*/
    public static Code minimax(ArrayList<Code> unused, ArrayList<Code> candidates){
        int minElim = -1;
        Code guess = null;
        for(Code code: unused){ //loops through all unused codes
            int[][] minMaxTable = new int[code.pegs.length + 1][code.pegs.length + 1];  //creates a minmax table for the current unused code
            for(Code candidate: candidates){    //processes the minmax table with a 2D frequency map query
                Key key = Key.getKeyWithCode(code, candidate);
                ++minMaxTable[key.blacks][key.whites];
            }
            int maxHits = -1;
            for(int[] row : minMaxTable){   //querys through all the elements in minMaxTable to find the max value
                for(int i : row){
                    maxHits = Integer.max(i, maxHits);
                }
            }
            int score = unused.size() - maxHits;    //calculates the score based on the max number of hits
            if(score > minElim){    //sets minElim score if the score is larger than minElim
                minElim = score;
                guess = code;
            }
        }
        return guess;
    }

/* removeCode Method:
/* This void type method removes all the codes in candidates that do not correspon with the code
* @param code, candidates
* @return none
*/
    public static void removeCode(Code code, ArrayList<Code> candidates){
        candidates.remove(code);    //removes code in the set candidates
    }

    /* removeCodes Method:
/* This void type method removes all the codes in candidates that do not correspon with the code
*
* List of Local Variables
* toRemove -- stores all the Codes that are to be removed (necessary to avoid exception)
* curKey -- the key based on code and curCode
* @param code, key, candidates
* @return none
*/
    public static void removeCodes(Code code, Key key, ArrayList<Code> candidates){
        ArrayList<Code> toRemove = new ArrayList<>();
        for(Code curCode : candidates){ //queries through all the candidates and removes them if the keys dont match
            Key curKey = Key.getKeyWithCode(curCode, code);
            if(curKey.blacks != key.blacks || curKey.whites != key.whites){
                toRemove.add(curCode);
            }
        }
        candidates.removeAll(toRemove);
    }

/* getCombo Method:
/* This ArrayList<Code> type method returns an arraylist that has all 1296 possible codes
*
* List of Local Variables
* combo -- stores all the 1296 possible codes
* pegs -- a temperary array used to store the current permutation
* @param none
* @return combo
*/
    public static ArrayList<Code> getCombo(){
        ArrayList<Code> combo = new ArrayList<>();
        for(int i = 1; i <= 6; ++i){    //quad nested loop to get all permutations of 4 positions and 6 colours
            for(int j = 1; j <= 6; ++j){
                for(int k = 1; k <= 6; ++k){
                    for(int l = 1; l <= 6; ++l){
                        int[] pegs = {i, j, k, l};
                        Code code = new Code(pegs);
                        combo.add(code);
                    }
                }
            }
        }
        return combo;
    }
    
}
