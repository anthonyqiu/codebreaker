import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class CodeBreaker extends JFrame{

    JPanel pan1 = new JPanel();
    JPanel pan2 = new JPanel();
    JTextField Title = new JTextField("CODE BREAKER");
    JButton playerGuess = new JButton("Player Guess");

    public CodeBreaker(){
        setTitle("CODE BREAKER");
        setSize(400, 400);

        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        pan1.add(playerGuess);
        pan2.add(Title);

        add(pan1);
        add(pan2);

        setVisible(true);
    }

    static ArrayList<int[]> permutations = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        CodeBreaker codeBreaker = new CodeBreaker();

        File leaderboards = new File("leaderboards.txt");
        //if(leaderboards.exists()) System.out.println("yes1");
        //if(leaderboards.isDirectory()) System.out.println("yes2");
        //if(leaderboards.canRead()) System.out.println("yes3");
        while(true){
            System.out.println("MENU");
            System.out.println("***AT ANY TIME YOU WISH TO EXIT THE GAME PLEASE PRESS EXIT***");
            System.out.println("Please enter an option");
            int option = getIntInput();
            if(option == 1){
                playerGuess(leaderboards);
            }
            else if(option == 2){
                AIGuess();
            }
            else if(option == 3){
                playerVsPlayer();
            }
            else if(option == 4){
                showLeaderBoards(leaderboards);
            }
            else if(option == 5){
                rules();
            }
        }
    }

    public static void playerGuess(File leaderboards) throws IOException{
        System.out.println("Please enter you name:");
        String name = getInput();
        int[] code = randomColours();
        for(int i = 0; i < code.length; ++i){
            System.out.print(code[i] + " ");
        }
        System.out.println();
        int[] colourFreq = new int[7];
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
                        updateScore(leaderboards, new Score(name, (10 - numMoves) * 120));
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

    public static void AIGuess(){
        int[] freq = new int[7];
        int blacks = 0;
        System.out.println("1 1 1 1");
        int[] hints = getHint();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[1];
                ++blacks;
            }
        }
        System.out.println("2 2 2 2");
        hints = getHint();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[2];
                ++blacks;
            }
        }
        System.out.println("3 3 3 3");
        hints = getHint();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[3];
                ++blacks;
            }
        }
        System.out.println("4 4 4 4");
        hints = getHint();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[4];
                ++blacks;
            }
        }
        System.out.println("5 5 5 5");
        hints = getHint();
        for(int i = 0; i < 4; ++i){
            if(hints[i] == 0){
                ++freq[5];
                ++blacks;
            }
        }
        if(blacks != 4){
            freq[6] = 4 - blacks;
        }

        System.out.println(blacks);

        int index = 0;
        int[] code = new int[4];
        for(int i = 1; i <= 6; ++i){
            for(int j = 0; j < freq[i]; ++j){
                code[index] = i;
                ++index;
            }
        }

        //HashSet<int[]> permutations = new HashSet<>();
        permute(code, 0);
        System.out.println(permutations.size());

        for(int[] permutation : permutations){
            for(int i = 0; i < 4; ++i){
                System.out.print(permutation[i] + " ");
            }
            System.out.println();
            hints = getHint();
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
            System.out.println("permute code: " + code[0] + code[1] + code[2] + code[3]);
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

    public static int[] getHint(){
        int[] hints = new int[4];
        for(int i = 0; i < 4; ++i){
            hints[i] = getIntInput();
        }
        return hints;
    }

    public static void playerVsPlayer(){
        System.out.println("Player 1 please enter your code:");
        int[] codeP1 = userColours();
        System.out.println("Player 2 please enter your code:");
        int[] codeP2 = userColours();
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

    public static void rules(){
        System.out.println("RULES");
    }

    public static void printLosingMessage(){
        System.out.println("YOU LOSE :(");
        return;
    }

    public static void printWinningMessage(String player){
        System.out.println("CONGRATS " + player + " YOU WON!!!");
        return;
    }

    public static void showLeaderBoards(File file) throws IOException{
        PriorityQueue<Score> lb = new PriorityQueue<>();
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()){
            String[] temp = sc.nextLine().split(" ");
            lb.add(new Score(temp[0], Integer.parseInt(temp[1])));
        }

        System.out.println("LEADERBOARDS");
        while(!lb.isEmpty()){
            Score cur = lb.poll();
            System.out.println(cur.name + " - " + cur.score);
        }
        System.out.println("_____________________________");
        sc.close();
    }

    public static void updateScore(File file, Score score) throws IOException{
        PriorityQueue<Score> lb = new PriorityQueue<>();
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()){
            String[] temp = sc.nextLine().split(" ");
            lb.add(new Score(temp[0], Integer.parseInt(temp[1])));
        }
        lb.add(score);
        sc.close();

        PrintWriter pw = new PrintWriter(file);
        for(int i = 0; i < 10; ++i){
            if(lb.size() > 0){
                Score cur = lb.poll();
                pw.println(cur.name + " " + cur.score);
            }
        }
        pw.close();
    }

    public static void endProgram(){
        System.out.println("C U NEXT TIME...");
        System.exit(0);
    }
    
}
