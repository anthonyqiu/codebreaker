import java.util.*;

public class Test {

    public static void main(String[] args) {
        AIGuessKnuths();
    }

    public static void AIGuessKnuths(){
        ArrayList<Code> pos = getCombo();
        int[] temp = {1, 1, 2, 2};
        Code guess = new Code(temp);
        printGuess(guess);
        int[] hints = getHint();
        Key key = Key.getKeyWithHints(hints);
        if(key.blacks == 4){
            System.out.println("1 Move");
            return;
        }

        /*int[] temp1 = {1, 1, 2, 2};
        int[] temp2 = {1, 1, 1, 2};
        Key test = Key.getKeyWithCode(new Code(temp1), new Code(temp2));
        System.out.println(test.blacks + " " + test.whites + " " + test.blanks);*/

        removeCode(guess, key, pos);
        /*while(true){
            removeCode(guess, key, pos);
        }*/
    }

    public static void removeCode(Code code, Key key, ArrayList<Code> pos){
        ArrayList<Code> toRemove = new ArrayList<>();
        int i = 0;
        int j = 0;
        for(Code curCode : pos){
            ++j;
            Key curKey = Key.getKeyWithCode(curCode, code);
            //System.out.println(curCode.pegs[0] + " " + curCode.pegs[1] + " " + curCode.pegs[2] + " " + curCode.pegs[3] + " keys: " + curKey.blacks + " " + curKey.whites + " " + curKey.blanks);
            if(curKey.blacks == key.blacks && curKey.whites == key.whites){
                ++i;
                //System.out.println(curCode.pegs[0] + " " + curCode.pegs[1] + " " + curCode.pegs[2] + " " + curCode.pegs[3]);
                toRemove.add(curCode);
            }
        }
        System.out.println(i + "/" + j);
        pos.removeAll(toRemove);
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
