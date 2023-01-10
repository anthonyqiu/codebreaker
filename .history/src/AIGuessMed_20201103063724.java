import java.util.*;

public class AIGuessMed {

    static ArrayList<int[]> permutations = new ArrayList<>();

    public static void AIGuessMed(){
        int[] freq = new int[7];
        int blacks = 0;
        System.out.println("B B B B");
        int[] hints = Util.getResponsePegs();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[1];
                ++blacks;
            }
        }
        System.out.println("G G G G");
        hints = Util.getResponsePegs();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[2];
                ++blacks;
            }
        }
        System.out.println("O O O O");
        hints = Util.getResponsePegs();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[3];
                ++blacks;
            }
        }
        System.out.println("P P P P");
        hints = Util.getResponsePegs();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[4];
                ++blacks;
            }
        }
        System.out.println("R R R R");
        hints = Util.getResponsePegs();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[5];
                ++blacks;
            }
        }
        if(blacks != 4){
            freq[6] = 4 - blacks;
        }

        int index = 0;
        int[] code = new int[4];
        for(int i = 1; i <= 6; ++i){
            for(int j = 0; j < freq[i]; ++j){
                code[index] = i;
                ++index;
            }
        }

        permute(code, 0);

        for(int[] permutation : permutations){
            for(int i = 0; i < 4; ++i){
                System.out.print(permutation[i] + " ");
            }
            System.out.println();
            hints = Util.getResponsePegs();
            int blacksPermute = 0;
            for(int i = 0; i < 4; ++i){
                if(hints[i] == 0) ++blacksPermute;
            }
            if(blacksPermute == 4){
                break;
            }
        }

        permutations.clear();
    }

    public static void permute(int[] code, int pos){
        if(pos == code.length - 1){
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

    public static void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    
}
