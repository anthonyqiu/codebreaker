public class Timer {

    private long executionTime;

    public Timer(){
        this.executionTime = 0;
    }

    public void startTimer(){
        this.executionTime = System.nanoTime();
    }

    public void stopTimer(){
        this.executionTime = System.nanoTime() - executionTime;
    }

    public void resetTimer(){
        this.executionTime = 0;
    }

    public long toSecs(){
        this.executionTime /= 1000000000;
        return this.executionTime;
    }
    
}
