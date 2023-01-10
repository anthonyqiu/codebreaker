import java.util.*;
import java.io.*;

public class CodeBreaker{

    public static void main(String[] args) throws IOException{
        File leaderboards = new File("leaderboards.txt");
        //if(leaderboards.exists()) System.out.println("yes1");
        //if(leaderboards.isDirectory()) System.out.println("yes2");
        //if(leaderboards.canRead()) System.out.println("yes3");
        while(true){
            System.out.println("MENU");
            System.out.println("***AT ANY TIME YOU WISH TO EXIT THE GAME PLEASE PRESS EXIT***");
            System.out.println("Please enter an option");
            int option = Util.getIntInput();
            if(option == 1){
                PlayerGuess.playerGuess(leaderboards);
            }
            else if(option == 2){
                AIGuessEasy.AIGuessEasy();
            }
            else if(option == 3){
                AIGuessMed.AIGuessMed();
            }
            else if(option == 4){
                Knuths.AIGuessKnuths();
            }
            else if(option == 5){
                PVP.playerVsPlayer();
            }
            else if(option == 6){
                Leaderboards.showLeaderBoards(leaderboards);;
            }
            else if(option == 7){
                Text.rules();
            }
        }
    }
    
}
