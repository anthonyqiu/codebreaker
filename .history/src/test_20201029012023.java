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
        while(true){
            removeCode(guess, key, pos);
        }
    }

    public static void removeCode(Code code, Key key, ArrayList<Code> pos){
        ArrayList<Code> toRemove = new ArrayList<>();
        for(Code curCode : pos){
            Key curKey = Key.getKeyWithCode(curCode, code);
            System.out.println(curKey.blacks + " " + curKey.whites);
            if(curKey.blacks == key.blacks && curKey.whites == key.whites){
                System.out.println(curCode.pegs[0] + " " + curCode.pegs[1] + " " + curCode.pegs[2] + " " + curCode.pegs[3]);
                toRemove.add(curCode);
            }
        }
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
