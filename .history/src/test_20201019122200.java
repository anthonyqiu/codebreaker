public class test {

    public static void main(String[] args) {
        int[] freq = {0, 1, 1, 1, 1, 0};
        int index = 0;
        int[] code = new int[4];
        for(int i = 1; i <= 6; ++i){
            for(int j = 0; j < freq[i]; ++j){
                code[index] = i;
                ++index;
            }
        }
    }
    
}
