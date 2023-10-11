import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame{
    public static void main(String args[]){
        
        //for input
        Scanner sc = new Scanner(System.in);

        //Random number generator
        Random rnd = new Random();

        //ranges
        int minRange = 1;
        int maxRange = 100;

        //number of attempts user can make
        int numberOfAttempts = 10;

        //score of user
        int score = 0;

        //to indicate user want to play more or not
        boolean playAgain = true;

        //Starting Message
        System.out.println("- - - Welcome To The Number Game - - -");


        //game will continue till the value of play again is true
        while(playAgain) {

            //generating a random number
            int generatedNumber = rnd.nextInt(maxRange - minRange + 1) + minRange;

            //to count the attempts of user
            int attempts = 1;

            //to indicate the number user guessed is correct or not
            boolean correctOrNot = false;

            System.out.println("- - - Guess A Number Between 1 To 100 - - - ");

            //loop will run till the total number of attempts
            while(attempts < numberOfAttempts) {
                System.out.println("Enter Your Guess (Attempt " + attempts + "/" + numberOfAttempts + ") : ");
                
                //input of user guessed number
                int userGuess = sc.nextInt();

                //if the user gussed the right number then it will make the indicator to true
                if (userGuess == generatedNumber) {
                    System.out.println("- - - Congratulations!! You Guessed The Correct Number!! - - -\n");
                    correctOrNot = true;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("- - - Too Low. Try Again. - - -\n");
                } else {
                    System.out.println("- - - Too High. Try Again. - - -\n");
                }

                //attempts incremented by one after the whole process
                attempts++;
            }

            //if the indicator is true it will incremet the score by 1
            if(!correctOrNot) {
                System.out.println("Sorry, You've run out of attempts. The correct number was : " + generatedNumber + "\n");
            } else {
                score++;
            }


            //to check if the user want to play more or not
            System.out.println("Do You Want To Play Again ? (yes/no) : ");
            
            //taking user input and convert it to lowercase sothat if the user put capital letter we still can recognise it
            String playAgainResponse = sc.next().toLowerCase();

            //if user input is "yes" then the value of playAgain will be true and the loop will run again and for any other input, the value would be false
            playAgain = playAgainResponse.equals("yes");

            //display after the user choice
            if(playAgain) { 
                System.out.println("\n- - - Lets play Another Round !! - - -\n\n");
            } else {
                System.out.println("\n- - - Thanks For Playing !! Your Total Score : " + score + " - - -\n\n");
            }
        }

        //closing the scanner object
        sc.close();
    }
}