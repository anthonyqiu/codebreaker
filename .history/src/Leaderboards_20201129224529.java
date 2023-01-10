/*=================================================================
Task Definition- to store past scores of each player and present the scores in leaderboards
Input-write to files
Output-read from files
Process- use file-handling to perform leaderboard functionality
=================================================================
List of Identifiers - listed in each method
=================================================================
*/
import java.util.*;//get access to java util library
import java.io.*;//get access to java io library

public class Leaderboards {//Class leaderboards starts
/**showLeaderBoards method:
* This functional method stores players'names and scores
*
* List of Local Variables
* br - a BufferedReader object used for keyboard input &lt;type BufferedReader&gt;
* sc - a scanner object used to get input from user
* temp - a string type array used to store players' input
* @param(file)
* Throws IOException
* @return the number input by user &lt;type String&gt;
*/
    public static void showLeaderBoards(File file) throws IOException{//present leaderboard on java.console
        PriorityQueue<Score> lb = new PriorityQueue<>();//automatically sorts one's score
        Scanner sc = new Scanner(file);//write/read to files

        while(sc.hasNextLine()){
            String[] temp = sc.nextLine().split(" ");//spacing score;
            lb.add(new Score(temp[0], Integer.parseInt(temp[1])));//store corresponding scores players get
        }

        System.out.println("LEADERBOARDS");
        for(int i = 1; i <= 10; ++i){
            if(!lb.isEmpty()){//when there are scores stored in the arraylist
                Score cur = lb.poll();//poll constructer
                System.out.println(i + ": " + cur.name + " - " + cur.score);//print corresponding player's name and player's score
            }
        }
        System.out.println("_____________________________");
        sc.close();//close file
    }
/**updateScore method:
* This functional method updates 
*
* List of Local Variables
* br - a BufferedReader object used for keyboard input &lt;type BufferedReader&gt;
* sc - a scanner object used to get input from user
* temp - a string type array used to store players' input
* 1b - a string type queue tool that automatically sorts score from highest to lowest
* @param(file,score)
* Throws IOException
* @void method that prints the content inside the file
*/
    public static void updateScore(File file, Score score) throws IOException{
        PriorityQueue<Score> lb = new PriorityQueue<>();
        Scanner sc = new Scanner(file);

        while(sc.hasNextLine()){//while scanner scans user's input
            String[] temp = sc.nextLine().split(" ");
            lb.add(new Score(temp[0], Integer.parseInt(temp[1])));
        }
        lb.add(score);//add scores to file
        sc.close();//close file

        PrintWriter pw = new PrintWriter(file);
        for(int i = 0; i < 10; ++i){
            if(lb.size() > 0){
                Score cur = lb.poll();
                pw.println(cur.name + " " + cur.score);//print out name and score
            }
        }
        pw.close();//close file
    }
    
}
