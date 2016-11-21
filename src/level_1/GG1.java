package level_1;
/**
 * Created by healthstr on 19/11/2016.
 */

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by healthstr on 14/11/2016.
 */
public class GG1 {
    public static void main(String []args) throws FileNotFoundException, UnsupportedEncodingException {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        int numberMax;
        int guess;
        int numberOfTries = 0;
        boolean win = false;
        String username;
        System.out.println("Welcome to random number game!");
        System.out.println();
        System.out.println("Please enter your name");
        username = input.nextLine();
        System.out.println("Please enter the max range");
        numberMax = input.nextInt();
        System.out.println("I'm thinking of a number between 1 - " + numberMax);

        int numberToGuess = rand.nextInt(numberMax);

        while (win == false){
            guess = input.nextInt();
            numberOfTries++;
            System.out.println(numberToGuess);

            if (guess < 1 || guess > numberMax){
                System.out.println("Invalid input");
            }
            else if (guess > numberToGuess + 10){
                System.out.println("Way too high!");
            }
            else if (guess < numberToGuess - 10){
                System.out.println("Way too low!");
            }
            else if (guess > numberToGuess){
                System.out.println("Too high!");
            }
            else if (guess < numberToGuess){
                System.out.println("Too low!");
            }
            else{
                System.out.println("You guessed right!");
                win = true;
            }
        }
        System.out.println("You win!");
        System.out.println("The number was " + numberToGuess);
        System.out.println("It took you " + numberOfTries + " tries");
        try{
            String data = username + ", " + numberOfTries + "\n";
            File file = new File("scores.txt");

            if (!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getName(), true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

