package application;

public class Main {
    
	public static void main(String[] args) {
		
		int minNumber, maxNumber, player, ramdomicNumber, playerChar;
		//char playerChar;
		boolean thanHigh;
		boolean playAgain = true;
		
		while(playAgain) {
			Game game = new Game();
			//clearConsole();
			thanHigh = false;
			System.out.println("Insira o numero menor");
			minNumber = game.isNumber();
			System.out.println("Insira o numero maior");
			maxNumber = game.isNumber();
			
			do {
				if(minNumber < maxNumber) {
					ramdomicNumber = game.randomNumber(minNumber, maxNumber);
					game.setRandomNumber(ramdomicNumber);
					thanHigh = true;
				}else {
					System.out.printf("Insira um numero maior que %d \n", minNumber);
					maxNumber = game.isNumber();
				}	
			}while(!thanHigh);
			
			
			System.out.printf("Insira um valor entre %d e %d \n", minNumber, maxNumber);
			while(!game.getCompleted()) {
				player = game.isNumber();
				game.tryAttempt(player);
			}
			System.out.println("Jogar novamente? 1(um) para jogar novamente, ou qualquer outro numero para sair!");
			playerChar = game.isNumber();
			if(playerChar != 1 ) { 
				playAgain = false;
			}
		}
		System.out.println("Jogo Finalizado!");
	}

}
