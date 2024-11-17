package application;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private int randomNumber;
	private int attemptNumber;
	private int attemptCount;
	private boolean completed;

	public Game() {
		this.completed = false; 
	}
	
	public boolean getCompleted() {
		return completed;
	}
	
	public void setRandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}
	
	public int randomNumber(int minNumber, int maxNumber) {
		Random random = new Random();
		return random.nextInt((maxNumber - minNumber) + 1) + minNumber;
	}
	
	public int isNumber() {
		Scanner scanner = new Scanner(System.in);
		boolean validNumber = false;
		int number = 0;
		
		while(!validNumber) {
			String input = scanner.next();
			try {
				number = Integer.parseInt(input);
				validNumber = true;
				return number;
			}catch(NumberFormatException e) {
				System.out.println("Voce deve inserir um numero!");
			}
		}
		scanner.close();
		return isNumber();
	}
	
	public void tryAttempt(int attemptNumber) {
		this.attemptNumber = attemptNumber;
		this.attemptCount = this.attemptCount + 1;
		if(this.attemptNumber == this.randomNumber) {
			System.out.printf("Acertou! O Numero é:%d \n", this.randomNumber);
			System.out.printf("Tentativas %d \n", this.attemptCount);
			this.completed = true;
			this.attemptCount = 0;
		}else {
			if(attemptNumber < this.randomNumber) {
				System.out.println("Insira um numero maior.");
			}else {
				System.out.println("Insira um numero menor.");
			}
		}
	}
}
