/*
 * Name:- Nidhi Patel
 * Project Name:- Machine Problem 4
 * project description:- It's a game called Trivia, it asks the user 5 questions & if you get it correct you earn certain amount of points
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class FiveTriviaQuestions {

	public static void main(String[] args) {
		//creating object
		Trivia Q1 = new Trivia("How many states are there in U.S?", "50", 1);
		Trivia Q2 = new Trivia("What is the national bird of the US", "Bald Eagle", 2);
		Trivia Q3 = new Trivia("Which year was USA discoverd?", "1492", 3);
		Trivia Q4 = new Trivia("Which year was Java developed?", "1995", 3);
		Trivia Q5 = new Trivia("Which year was Oracle developed?", "1977", 3);
		//array that goes through the questions
		ArrayList<Trivia> questions = new ArrayList<Trivia>();
		ArrayList<Trivia> readQuestions = new ArrayList<Trivia>();
		//adding the questions to the array
		questions.add(Q1);
		questions.add(Q2);
		questions.add(Q3);
		questions.add(Q4);
		questions.add(Q5);
		
		//scanner reads the input
		Scanner keyb = new Scanner(System.in);
		String filename = null;
		//for text file
		FileInputStream Fis = null;
		FileOutputStream Fos = null;
		//for binary file
		ObjectOutputStream oos = null; 
		ObjectInputStream ois = null;
		
		filename = "myTrivia.dat";
		
		try 
		{
			Fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(Fos);
			//From questions Array, we write each question to binary file
			for(Trivia question:questions) {
				oos.writeObject(question);
			}
			oos.flush();
			oos.close();
		}
		catch(FileNotFoundException e) 
		{
			System.out.println("File not created");
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		//Reading
		//try is used for error handling
		try
		{
			Fis = new FileInputStream(filename);
			ois = new ObjectInputStream(Fis);
			Trivia tempQ = null;
			
			//Keep reading from file until nothing, then store into array
			for(int i = 0; i < 5; i++) {
				tempQ = (Trivia) ois.readObject();
				readQuestions.add(tempQ);
			}
			// catches the errors that are invoked 
		}catch (EOFException e) {
			System.out.println("No more numbers");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//gets a random number between 0-4
		int randIndex = (int)(Math.random()*4);
		//count stores the randIndex
		int count = randIndex;
		//this loop goes through each questions
		for(int i = 0; i < readQuestions.size(); i++) {
			Trivia question = readQuestions.get(count);
			//prints
			System.out.println(question.getQuestion());
			System.out.print("Enter your answer: ");
			String answer = keyb.nextLine();
			//checking if the answer is right
			if(question.equal(answer)) {
				System.out.println("Right Answer! You gained " + question.getPoints() + " points.");
			}
			count++;
			//loops around to the next question
			if(count >= readQuestions.size()) {
				count = 0;
			}
			System.out.println();
		}
		System.out.println("Your total points: " + Trivia.calcPoints() + " /12");	
		
	}

}
