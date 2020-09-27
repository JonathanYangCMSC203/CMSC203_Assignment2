//Author: Jonathan Yang
//Assignment 2: 

import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome to Random Number Guesser. To play this game, you must guess the correct number between 1 and 100 to win.\n");

		do {
			int randNum = RNG.rand();
			int lowGuess = 1;
			int highGuess = 100;
			boolean correct = false;
			
			do {
								
				System.out.printf("Guess a number between %d and %d: ",lowGuess, highGuess);
				int nextGuess = in.nextInt();
				
				if(RNG.inputValidation(nextGuess, lowGuess, highGuess))
				{
					if(nextGuess < randNum)
					{
						System.out.println("Guess is too low.");
						lowGuess = nextGuess;
					}
					else if(nextGuess > randNum)
					{
						System.out.println("Guess is too high.");
						highGuess = nextGuess;
					}
					else
					{
						System.out.println("You guess correctly");
						correct = true;
					}
				}
				System.out.println("Number of guesses: " + RNG.getCount() + "\n");
			}while(!correct);
			RNG.resetCount();
			in.nextLine();
			System.out.println("");
		}while(tryAgain());
		in.close();
		
		System.out.println("Author: Jonathan Yang");
	}
	
	private static boolean tryAgain()
	{
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		do
		{
			System.out.print("Try Again?(Yes or no): ");//Ask the question
			String answer = in.nextLine();//User must input yes or no
			
			//this if statement checks if answer is either yes or no.
			if(answer.equalsIgnoreCase("Yes"))
				return true;
			else if(answer.equalsIgnoreCase("No"))
				return false;
			else
				System.out.printf("\nERROR: %s is invalid response. Response accepted: \"%s\" or \"%s\"\n", answer, "Yes", "No");
		}while(true);
	}

}
