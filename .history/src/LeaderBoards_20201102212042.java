import java.util.*;
import java.io.*;

public class LeaderBoards {

    public static void showLeaderBoards(File file) throws IOException{
        PriorityQueue<Score> lb = new PriorityQueue<>();
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()){
            String[] temp = sc.nextLine().split(" ");
            lb.add(new Score(temp[0], Integer.parseInt(temp[1])));
        }

        System.out.println("LEADERBOARDS");
        for(int i = 1; i <= 10; ++i){
            if(!lb.isEmpty()){
                Score cur = lb.poll();
                System.out.println(i + ": " + cur.name + " - " + cur.score);
            }
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
    
}
