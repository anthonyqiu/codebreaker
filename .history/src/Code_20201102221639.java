public class Code {

    int[] pegs;

    public Code(int[] pegs){
        this.pegs = pegs;
    }

    public static void printCode(Code guess){
        int[] pegs = guess.pegs;
        for(int i : pegs){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}