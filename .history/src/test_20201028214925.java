import java.util.*;

public class Test {

    public static void main(String[] args) {
        AIGuessKnuths();
    }

    public static void AIGuessKnuths(){
        ArrayList<int[]> pos = getCombo();
        int[] guess = {1, 1, 2, 2};
        printGuess(guess);
        
    }

    public static int[] getHint(){
        Scanner sc = new Scanner(System.in);
        int[] hints = new int[4];
        for(int i = 0; i < 4; ++i){
            hints[i] = sc.nextInt();
        }
        return hints;
    }

    public static void printGuess(int[] guess){
        for(int i : guess){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static ArrayList<int[]> getCombo(){
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 1; i <= 6; ++i){
            for(int j = 1; j <= 6; ++j){
                for(int k = 1; k <= 6; ++k){
                    for(int l = 1; l <= 6; ++l){
                        int[] pegs = {i, j, k, l};
                        arr.add(pegs);
                    }
                }
            }
        }
        return arr;
    }
    
}
