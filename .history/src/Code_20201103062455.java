public class Code {

    int[] pegs;

    public Code(int[] pegs){
        this.pegs = pegs;
    }

    public static void printCode(Code guess){
        int[] pegs = guess.pegs;
        String[] stPegs = Util.intToStringCode(pegs);
        for(String st : stPegs){
            System.out.print(st + " ");
        }
        System.out.println();
    }

}