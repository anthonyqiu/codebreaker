import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);
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
                
            }
            else if(option == 4){
                
            }
            else if(option == 5){
                
            }
        }
    }

    public static void playerGuess(){
        int[] code = randomColours();
        int[] colourFreq = new int[6];
        for(int i = 0; i < code.length; ++i){
            ++colourFreq[code[i]];
        }

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
                    if(blacks == 4){
                        printWinningMessage();
                        return;
                    }
                    hints.add(0);   //0 represents black peg
                }
                else if(tempColourFreq[guess[i]] > 0){
                    --tempColourFreq[guess[i]];
                    hints.add(1);   //1 represents white peg
                }
            }
            while(!hints.isEmpty()){
                System.out.println(hints.poll());
            }
        }
    }

    public static int[] randomColours(){
        int[] colours = new int[4];
        for(int i = 0; i < colours.length; ++i){
            colours[i] = (int)Math.random() * (6 - 1) + 1;
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
        String input = sc.nextLine();
        sc.close();
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

    public static void printWinningMessage(){
        System.out.println("CONGRATS YOU WON!!!");
        return;
    }

    public static void endProgram(){
        System.out.println("C U NEXT TIME...");
        System.exit(0);
    }
    
}
