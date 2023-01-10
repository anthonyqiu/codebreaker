public class Score implements Comparable<Score>{

    String name;
    int score;

    public Score(String name, int score){
        this.name = name;
        this.score = score;
    }

    public int compareTo(Score other){
        if(score >= other.score) return 1;
        else return -1;
    } 
    
}
