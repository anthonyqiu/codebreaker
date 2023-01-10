/*=================================================================
Task Definition – This class 
Input – no input
Output – messages
Process – In PVP options, compare player 1 vs player 2's score
=================================================================
List of Identifiers -listed in each method
=================================================================
*/
public class Score implements Comparable<Score>{//implement tool to compare two scores

    String name;
    int score;

    public Score(String name, int score){
        this.name = name;
        this.score = score;
    }

    public int compareTo(Score other){
        if(score <= other.score) return 1;//if player 1 has higher score, returns 1 
        else return -1;//if player 2 has higher score, returns -1
    } 
    
}//end class
