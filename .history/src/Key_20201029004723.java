public class Key {

    int blacks, whites, blanks;

    public Key(int blacks, int whites, int blanks){
        this.blacks = blacks;
        this.whites = whites;
        this.blacks = blanks;
    }

    public static Key getKeyWithCode(Code code){
        int[] pegs = code.pegs;
        int blacks = 0;
        int whites = 0;
        int[] freq = new int[7];
        for(int i = 0; i < 4; ++i){
            ++freq[code.pegs[i]];
        }
        for(int i = 0; i < pegs.length; ++i){
            if(pegs[i] == pegs[i]){
                ++blacks;
                --freq[pegs[i]];
            }
        }
        for(int i = 0; i < pegs.length; ++i){
            if(freq[pegs[i]] > 0){
                --freq[pegs[i]];
                ++whites;
            }
        }
        int blanks = 4 - blacks - whites;
        return new Key(blacks, whites, blanks);
    }
    
}
