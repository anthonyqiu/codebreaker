import java.util.*;

public class Knuths {

    public static void AIGuessKnuths(){
        ArrayList<Code> candidates = getCombo();
        ArrayList<Code> unused = getCombo();
        int[] temp = {1, 1, 2, 2};
        Code guess = new Code(temp);
        Code.printCode(guess);

        while(true){
            removeCode(guess, candidates);
            removeCode(guess, unused);

            int[] hints = Util.getResponsePegs();
            Key key = Key.getKeyWithHints(hints);

            if(key.blacks == 4){
                System.out.println("1 Move");
                return;
            }

            removeCodes(guess, key, candidates);
            if(candidates.size() == 1) guess = candidates.get(0);
            else guess = minimax(unused, candidates);
            Code.printCode(guess);
        }
    }

    public static Code minimax(ArrayList<Code> unused, ArrayList<Code> candidates){
        int minElim = -1;
        Code guess = null;
        for(Code code: unused){
            int[][] minMaxTable = new int[code.pegs.length + 1][code.pegs.length + 1];
            for(Code candidate: candidates){
                Key key = Key.getKeyWithCode(code, candidate);
                ++minMaxTable[key.blacks][key.whites];
            }
            int maxHits = -1;
            for(int[] row : minMaxTable){
                for(int i : row){
                    maxHits = Integer.max(i, maxHits);
                }
            }
            int score = unused.size() - maxHits;
            if(score > minElim){
                minElim = score;
                guess = code;
            }
        }
        return guess;
    }

    public static void removeCode(Code code, ArrayList<Code> candidates){
        candidates.remove(code);
    }

    public static void removeCodes(Code code, Key key, ArrayList<Code> candidates){
        ArrayList<Code> toRemove = new ArrayList<>();
        int i = 0;
        int j = 0;
        for(Code curCode : candidates){
            ++j;
            Key curKey = Key.getKeyWithCode(curCode, code);
            if(curKey.blacks != key.blacks || curKey.whites != key.whites){
                ++i;
                toRemove.add(curCode);
            }
        }
        System.out.println(i + "/" + j);
        candidates.removeAll(toRemove);
    }

    public static ArrayList<Code> getCombo(){
        ArrayList<Code> combo = new ArrayList<>();
        for(int i = 1; i <= 6; ++i){
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
