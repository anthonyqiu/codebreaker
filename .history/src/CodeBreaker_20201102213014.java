import java.util.*;
import java.io.*;

public class CodeBreaker{

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
                AIGuessMedium();
            }
            else if(option == 3){
                playerVsPlayer();
            }
            else if(option == 4){
                LeaderBoards.showLeaderBoards(leaderboards);;
            }
            else if(option == 5){
                rules();
            }
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
    
}
