public class Key {

    int blacks;
    int whites;
    int blanks;

    public Key(int blacks, int whites, int blanks){
        this.blacks = blacks;
        this.whites = whites;
        this.blanks = blanks;
    }

    public static Key getKeyWithHints(int[] hints){
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

    public static Key getKeyWithCode(Code code, Code ans){
        int[] pegs = code.pegs;
        int[] ansPegs = ans.pegs;
        int blacks = 0;
        int whites = 0;
        int[] ansFreq = new int[7];
        for(int i = 0; i < 4; ++i){
            ++ansFreq[code.pegs[i]];
        }
        for(int i = 0; i < pegs.length; ++i){
            if(pegs[i] == ansPegs[i]){
                ++blacks;
                --ansFreq[pegs[i]];
            }
        }
        for(int i = 0; i < pegs.length; ++i){
            if(ansFreq[pegs[i]] > 0){
                --ansFreq[pegs[i]];
                ++whites;
            }
        }
        int blanks = 4 - blacks - whites;
        return new Key(blacks, whites, blanks);
    }
    
}
