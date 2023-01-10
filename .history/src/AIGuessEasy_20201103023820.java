public class AIGuessEasy {

    public static void AIGuessEasy(){
        boolean correct = false;
        int count = 0;
        while(correct == false && count < 10){
            Code guess = new Code(Util.getRandomPegs());
            Code.printCode(guess);
            Key key = Key.getKeyWithHints(Util.getResponsePegs());
            if(key.blacks == 4) return;
            ++count;
        }
    }


    
}
