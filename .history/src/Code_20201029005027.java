public class Code {

    int[] pegs;

    public Code(int[] pegs){
        this.pegs = pegs;
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
        Key key = new Key(blacks, whites, blanks);
        return key;
    }

}