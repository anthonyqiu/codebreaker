import java.util.*;

public class Knuths {

    public static void main(String[] args) {
        AIGuessKnuths();
    }

    public static void AIGuessKnuths(){
        ArrayList<Code> candidates = getCombo();
        ArrayList<Code> unused = getCombo();
        int[] temp = {1, 1, 2, 2};
        Code guess = new Code(temp);
        printGuess(guess);

        while(true){
            removeCode(guess, candidates);
            removeCode(guess, unused);

            int[] hints = getHint();
            Key key = Key.getKeyWithHints(hints);

            if(key.blacks == 4){
                System.out.println("1 Move");
                return;
            }
            
            removeCodes(guess, key, candidates);
            guess = minimax(unused, candidates);
            printGuess(guess);
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
            if(maxHits < minElim){
                minElim = maxHits;
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
            //System.out.println(curCode.pegs[0] + " " + curCode.pegs[1] + " " + curCode.pegs[2] + " " + curCode.pegs[3] + " keys: " + curKey.blacks + " " + curKey.whites + " " + curKey.blanks);
            if(!(curKey.blacks == key.blacks && curKey.whites == key.whites)){
                ++i;
                //System.out.println(curCode.pegs[0] + " " + curCode.pegs[1] + " " + curCode.pegs[2] + " " + curCode.pegs[3]);
                toRemove.add(curCode);
            }
        }
        System.out.println(i + "/" + j);
        candidates.removeAll(toRemove);
    }

    public static int[] getHint(){
        Scanner sc = new Scanner(System.in);
        int[] hints = new int[4];
        for(int i = 0; i < 4; ++i){
            hints[i] = sc.nextInt();
        }
        sc.close();
        return hints;
    }

    public static void printGuess(Code guess){
        int[] pegs = guess.pegs;
        for(int i : pegs){
            System.out.print(i + " ");
        }
        System.out.println();
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
