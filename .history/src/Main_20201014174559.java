import java.util.*;

public class Main {

    static String[] colourPoll = {"red", "blue", "yellow", "orrange", "purple", "green"};

    public static void main(String[] args) {
        while(true){
            System.out.println("MENU");
            System.out.println("***AT ANY TIME YOU WISH TO EXIT THE GAME PLEASE PRESS EXIT***");
            System.out.println("Please enter an option");
            int option = getIntInput();
            if(option == 1){
                playerGuess();
            }
            else if(option == 2){

            }
            else if(option == 3){
                playerVsPlayer();
            }
            else if(option == 4){
                
            }
            else if(option == 5){
                
            }
        }
    }

    public static void playerGuess(){
        int[] code = randomColours();
        /*for(int i = 0; i < code.length; ++i){
            System.out.print(code[i] + " ");
        }
        System.out.println();*/
        int[] colourFreq = new int[6];
        for(int i = 0; i < code.length; ++i){
            ++colourFreq[code[i]];
        }
        /*for(int i = 0; i < 6; ++i){
            System.out.print(colourFreq[i] + " ");
        }
        System.out.println();*/

        int numMoves = 1;
        while(numMoves <= 8){
            int[] tempColourFreq = colourFreq;
            System.out.println("Please make a guess:");
            int[] guess = userColours();
            int blacks = 0;
            PriorityQueue<Integer> hints = new PriorityQueue<>();

            for(int i = 0; i < guess.length; ++i){
                if(guess[i] == code[i]){
                    ++blacks;
                    --tempColourFreq[guess[i]];
                    if(blacks == 4){
                        printWinningMessage("");
                        return;
                    }
                    hints.add(0);   //0 represents black peg
                }
            }
            for(int i = 0; i < guess.length; ++i){
                if(tempColourFreq[guess[i]] > 0){
                    --tempColourFreq[guess[i]];
                    hints.add(1);   //1 represents white peg
                }
            }
            System.out.println("Here are the hints");
            while(!hints.isEmpty()){
                System.out.print(" " + hints.poll() + " |");
            }
            System.out.println();
            ++numMoves;
        }
        printLosingMessage();
        return;
    }

    public static void playerVsPlayer(){
        System.out.println("Player 1 please enter your code:");
        int[] codeP1 = userColours();
        System.out.println("Player 2 please enter your code:");
        int[] codeP2 = userColours();
        int[] colourFreqP1 = new int[6];
        int[] colourFreqP2 = new int[6];
        for(int i = 0; i < codeP1.length; ++i){
            ++colourFreqP1[codeP1[i]];
            ++colourFreqP2[codeP2[i]];
        }

        while(true){
            int[] tempColourFreqP1 = colourFreqP1;
            int[] tempColourFreqP2 = colourFreqP2;
            System.out.println("P1 please make a guess:");
            int[] guessP1 = userColours();
            int blacksP1 = 0;
            PriorityQueue<Integer> hintsP1 = new PriorityQueue<>();

            for(int i = 0; i < guessP1.length; ++i){
                if(guessP1[i] == codeP2[i]){
                    ++blacksP1;
                    --tempColourFreqP2[guessP1[i]];
                    if(blacksP1 == 4){
                        printWinningMessage("PLAYER 1");
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
            int[] guessP2 = userColours();
            int blacksP2 = 0;
            PriorityQueue<Integer> hintsP2 = new PriorityQueue<>();

            for(int i = 0; i < guessP2.length; ++i){
                if(guessP2[i] == codeP1[i]){
                    ++blacksP2;
                    --tempColourFreqP1[guessP2[i]];
                    if(blacksP2 == 4){
                        printWinningMessage("PLAYER 2");
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

    public static int[] randomColours(){
        int[] colours = new int[4];
        for(int i = 0; i < colours.length; ++i){
            colours[i] = (int)(Math.random() * (6 - 1) + 1);
        }
        return colours;
    }

    public static int[] userColours(){
        int[] colours = new int[4];
        for(int i = 0; i < colours.length; ++i){
            colours[i] = getIntInput();
        }
        return colours;
    }

    public static String getInput(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        //sc.close();
        if(input.equalsIgnoreCase("exit")) endProgram();
        return input;
    }

    public static int getIntInput(){
        String input = getInput();
        while(!isInteger(input)){
            input = getInput();
        }
        return Integer.parseInt(input);
    }

    public static boolean isInteger(String st){
        try{
            int num = Integer.parseInt(st);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public static void printLosingMessage(){
        System.out.println("YOU LOSE :(");
        return;
    }

    public static void printWinningMessage(String player){
        System.out.println("CONGRATS "+ player + "YOU WON!!!");
        return;
    }

    public static void endProgram(){
        System.out.println("C U NEXT TIME...");
        System.exit(0);
    }
    
}
