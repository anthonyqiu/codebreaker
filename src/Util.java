/*================================================================
Task Definition - Required to find the largest number in a list of numbers
Input - includes user's hints to AIGuess and user's code
Output - return type:no output
Process - AI/User generating 4 pegs code from 6 colors, user's hints, and executing a series of try-catch detection
=================================================================
List of Identifiers - listed in each method 
=================================================================

*/

import java.util.*;//get access to java util library

public class Util {//start Util class

    public static int[] getResponsePegs(){//getResponsePegs method starts
        Scanner sc = new Scanner(System.in);// get input from Scanner 
        int[] hints = new int[4];//create a array of length 4
        System.out.println("Please enter the hints in proper format (eg. B B W N) (B for black, W for white, N for blank, spaces in between)");/*User Prompt that prints a message requiring for input in proper format,(eg. B B W N) (B for black, W for white, N for blank, spaces in between*/
        String[] input = new String[4];//create a new array string type with length 4
        boolean isValid = false;//boolean variable isValid is automatically setted to false;
        input = sc.nextLine().split(" ");//spacing user's hints letter by letter
        isValid = true;//after spliting user input, set boolean variable to true
        if(input.length != 4){//if statement to check over whether length of the input is 4
            isValid = false;      //if not, then re-set to false;
        }
        for(String st : input){       //from every letter in the array 'input', check to see the key letter "B" "W" and "N" is in the text
            if(!st.equalsIgnoreCase("B") && !st.equalsIgnoreCase("W") && !st.equalsIgnoreCase("N")){
                isValid = false;     //if input is neither B,W nor N, set the boolean variable to false
            }
        }
        while(!isValid){//when all obove conditions are met,
            System.out.println("Please enter a valid hint (eg. B B W N) (B for black, W for white, N for blank, spaces in between)");/*User prompt allow user to enter hints*/
            input = sc.nextLine().split(" "); //spacing user's hints letter by letter
            isValid = true;//boolean variable isValid is automatically setted to true;
            if(input.length != 4){//if statement to check over whether length of the input is 4
                isValid = false;//if not, then re-set to false;
            }
            for(String st : input){//from every letter in the array 'input', check to see the key letter "B" "W" and "N" is in the text
                if(!st.equalsIgnoreCase("B") && !st.equalsIgnoreCase("W") && !st.equalsIgnoreCase("N")){
                    isValid = false;//if input is neither B,W nor N, set the boolean variable to false
                }
            }
        }

        for(int i = 0; i < input.length; ++i){ //a finite loop to store the number of black/white pegs into the corresponding position
            if(input[i].equalsIgnoreCase("B")){
                hints[i] = 0;// 0 represents black pegs
            }
            else if(input[i].equalsIgnoreCase("W")){
                hints[i] = 1;//1 represents white pegs
            }
            else{
                hints[i] = 2;//2 represents blank pegs
            }
        }
        return hints;
    }//end of gerResponsePegs method

    public static int[] getRandomPegs(){
        int[] colours = new int[4];  // create an array of length 4
        for(int i = 0; i < colours.length; ++i){  
            colours[i] = (int)(Math.random() * (6 - 1) + 1);//generate random color pegs from 6 options
        }
        return colours;//return the random pegs
    }

    public static int[] getUserCode(){//start of getUserCode method
        Scanner sc = new Scanner(System.in);//get input from Scanner
        System.out.println("Please enter your code in proper format (eg. B Y R G) (B for blue, G for green, O for orange, P for purple, R for red, Y for yellow, spaces in between)"); //printing prompt messages
        String[] input = new String[4]; /*set an string type array aims to get user input, and check over the length and its content to ensure it is correct*/
        boolean isValid = false; 
        input = sc.nextLine().split(" ");
        isValid = true;
        if(input.length != 4){
            isValid = false;
        }
        for(String st : input){
            if(!st.equalsIgnoreCase("B") && !st.equalsIgnoreCase("G") && !st.equalsIgnoreCase("O") && !st.equalsIgnoreCase("P") && !st.equalsIgnoreCase("R") && !st.equalsIgnoreCase("Y")){
                isValid = false;
            }
        }
        while(!isValid){//when isValid is set to true
            System.out.println("Please enter a valid code (eg. B Y R G) (B for blue, G for green, O for orange, P for purple, R for red, Y for yellow, spaces in between)");
            input = sc.nextLine().split(" ");
            isValid = true;
            for(String st : input){
                if(st.length() > 1){//when length is greater than 1, set to false
                    isValid = false;
                }
                if(!st.equalsIgnoreCase("B") && !st.equalsIgnoreCase("G") && !st.equalsIgnoreCase("O") && !st.equalsIgnoreCase("P") && !st.equalsIgnoreCase("R") && !st.equalsIgnoreCase("Y")){// if the supposed content does not appear in the text,set to false
                    isValid = false;
                }
            }
        }

        int[] code = stringToIntCode(input);//store user input in the array
        return code;
    }

    public static int[] stringToIntCode(String[] code){/* create an array length 4, convert user's input into integer form in corresponce to their positions*/
        int[] code2 = new int[4];
        for(int i = 0; i < code.length; ++i){
            if(code[i].equalsIgnoreCase("B")){//represents black pegs
                code2[i] = 1;
            }
            else if(code[i].equalsIgnoreCase("G")){//represents green pegs
                code2[i] = 2;
            }
            else if(code[i].equalsIgnoreCase("O")){//represents orange pegs
                code2[i] = 3;
            }
            else if(code[i].equalsIgnoreCase("P")){//represents purple pegs
                code2[i] = 4;
            }
            else if(code[i].equalsIgnoreCase("R")){//represents red pegs
                code2[i] = 5;
            }
            else{
                code2[i] = 6;
            }
        }
        return code2;//return array in int type
    }

    public static String[] intToStringCode(int[] code){
        String[] code2 = new String[4];
        for(int i = 0; i < code.length; ++i){
            if(code[i] == 1){
                code2[i] = "B";
            }
            else if(code[i] == 2){
                code2[i] = "G";
            }
            else if(code[i] == 3){
                code2[i] = "O";
            }
            else if(code[i] == 4){
                code2[i] = "P";
            }
            else if(code[i] == 5){
                code2[i] = "R";
            }
            else{
                code2[i] = "Y";
            }
        }
        return code2;
    }

    public static String getInput(){//getInput method starts
        Scanner sc = new Scanner(System.in);//get input using scanner
        String input = sc.nextLine();//store user input
        return input;//return user's input
    }

    public static int getIntInput(){//getIntInput method starts
        String input = getInput();//store user input
        while(!isInteger(input)){/*when input is not integer, re get input from user*/
            System.out.println("***Input is not an integer***");
            input = getInput();
        }
        return Integer.parseInt(input);//return of integer type
    }

    public static boolean isInteger(String st){//isInteger method starts
        try{/*check if the entered number is integer type, if yes return true, if not, return false*/
            int num = Integer.parseInt(st);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public static void endProgram(){//method endProgram to exit the program when finished
        System.out.println("C U NEXT TIME...");
        System.exit(0);//exit from the system
    }
    
}
