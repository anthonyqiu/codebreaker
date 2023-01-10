public class Key {

    int blacks, whites, blanks;

    public Key(int blacks, int whites, int blanks){
        this.blacks = blacks;
        this.whites = whites;
        this.blacks = blanks;
    }

    public static Key getKey(int[] hints){
        int[] freq = new int[7];
        int blacks = 0;
        int whites = 0;
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++blacks;
            }
            else if(hints[i] == 1){
                ++whites;
            }
        }
        int blanks = 4 - blacks - whites;
        return new Key(blacks, whites, blanks);
    }
    
}
