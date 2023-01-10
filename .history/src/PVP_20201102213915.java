import java.util.*;

public class PVP {

    public static void playerVsPlayer(){
        System.out.println("Player 1 please enter your code:");
        int[] codeP1 = Util.getUserCode();
        System.out.println("Player 2 please enter your code:");
        int[] codeP2 = Util.getUserCode();
        int[] colourFreqP1 = new int[7];
        int[] colourFreqP2 = new int[7];
        for(int i = 0; i < codeP1.length; ++i){
            ++colourFreqP1[codeP1[i]];
            ++colourFreqP2[codeP2[i]];
        }

        while(true){
            int[] tempColourFreqP1 = colourFreqP1;
            int[] tempColourFreqP2 = colourFreqP2;
            System.out.println("P1 please make a guess:");
            int[] guessP1 = Util.getUserCode();
            int blacksP1 = 0;
            PriorityQueue<Integer> hintsP1 = new PriorityQueue<>();

            for(int i = 0; i < guessP1.length; ++i){
                if(guessP1[i] == codeP2[i]){
                    ++blacksP1;
                    --tempColourFreqP2[guessP1[i]];
                    if(blacksP1 == 4){
                        Text.printWinningMessage("PLAYER 1");
                        return;
                    }
                    hintsP1.add(0);   //0 represents black peg
                }
            }
            for(int i = 0; i < guessP1.length; ++i){
                if(tempColourFreqP2[guessP1[i]] > 0){
                    --tempColourFreqP2[guessP1[i]];
                    hintsP1.add(1);   //1 represents white peg
                }
            }
            System.out.println("P1 hints");
            while(!hintsP1.isEmpty()){
                System.out.print(" " + hintsP1.poll() + " |");
            }
            System.out.println();

            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println("P2 please make a guess:");
            int[] guessP2 = Util.getUserCode();
            int blacksP2 = 0;
            PriorityQueue<Integer> hintsP2 = new PriorityQueue<>();

            for(int i = 0; i < guessP2.length; ++i){
                if(guessP2[i] == codeP1[i]){
                    ++blacksP2;
                    --tempColourFreqP1[guessP2[i]];
                    if(blacksP2 == 4){
                        Text.printWinningMessage("PLAYER 2");
                        return;
                    }
                    hintsP2.add(0);   //0 represents black peg
                }
            }
            for(int i = 0; i < guessP2.length; ++i){
                if(tempColourFreqP1[guessP2[i]] > 0){
                    --tempColourFreqP1[guessP2[i]];
                    hintsP2.add(1);   //1 represents white peg
                }
            }
            System.out.println("P2 hints");
            while(!hintsP2.isEmpty()){
                System.out.print(" " + hintsP2.poll() + " |");
            }
            System.out.println();
        }
    }
    
}
