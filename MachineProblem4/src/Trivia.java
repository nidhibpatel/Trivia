/*
 * Name:- Nidhi Patel
 * Project Name:- Machine Problem 4
 * project description:- It's a game called Trivia, it asks the user 5 questions & if you get it correct you earn certain amount of points
 */
import java.io.Serializable;

public class Trivia implements Serializable {
	//private variables 
	private String question;
	private String answer;
	private int points;
	public static int TotalPoints = 0;
	//getters methods
	//returns question
	public String getQuestion()
	{
		return question;
	}
	//returns answer
	public String getAnswer()
	{
		return answer;
	}
	//gets points, returns points
	public int getPoints()
	{
		return points;
	}
	public void setQuestion(String question)
	{
		this.question = question;
	}
	//setters method
	public void setAnswer(String answer)
	{
		String[] words = answer.split("\\s+");
		if(words.length <= 2)
		{
			this.answer = answer;
		}
		else 
		{
			System.out.println("The answer needs to be less than 3 words");
		}
	
	}
	public void setPoints(int points)
	{
		this.points = points;
	}
	//default constructor 
	public Trivia()
	{ 
		question = "What is the capital of MI?";
		answer = "Lansing";
		points = 2;
		
	}
	//overloaded constructor 
	public Trivia(String q, String a, int p)
	{
		question = q;
		this.setAnswer(a);
		points = p;
	}
	public boolean equal(String a)
	{
		String[] words = a.split("\\s+");
		if (answer.equalsIgnoreCase(a) && words.length <= 2)
		{
			TotalPoints = points + TotalPoints; //adds up the points
			return true;
		}
		//if the answer is wrong it prints the right answer
		else
		{
			System.out.println("Sorry the answer you entered is incorrect, 0 points");
			System.out.println("The Answer is: " + answer);
			return false;
		}
	}
	//calpoints returns totalpoints
	public static int calcPoints()
	{
		return TotalPoints;
	}
	//prints out the game info
	public String toString()
	{
		return "Game info: " + question + "-> " + answer + " Points: " + points;
	}
	
	

}
