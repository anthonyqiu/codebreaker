/*=================================================================
Task Definition – A higher score is obtained in PVP for the player finish guessing for a less time
Input – no input(calling from other classes)
Output – return execution time for each player
Process – the class is divided into 3 categories, which are startTimer-at the moment one player starts guessing, end timer-at the moment one finish guessing, and resetTimer-which clears the time and starts over again.
=================================================================
List of Identifiers - listed in each method
=================================================================
*/
public class Timer {

    private long executionTime;

    public Timer(){
        this.executionTime = 0;//set the time to 0
    }

    public void startTimer(){//startTimer method starts
        this.executionTime = System.nanoTime();//To nanoseconds
    }

    public void stopTimer(){//stopTimer method starts
        this.executionTime = System.nanoTime() - executionTime;//the duration is execution time player makes, 
    }

    public void resetTimer(){//resetTimer method starts
        this.executionTime = 0;//reset timer to 0 seconds
    }

    public int toSecs(){/*calculation of the convertion from sec to nano sec*/
        this.executionTime /= 1000000000;
        return (int)this.executionTime;//return nanotime
    }

    public int getTime(){
        return (int)this.executionTime;
    }
    
}
