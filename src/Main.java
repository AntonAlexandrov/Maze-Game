import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);		
		Level level = new Level();
		Message message = new Message();		
		int playerX = 1, playerY = 2;
		
		String userInput;
		int moves = 0;
		
		while(true){
			level.level[playerY][playerX] = 'P';
			
			//printing stuff on screen
			message.printMessage();
			message.printMoves(moves);
			level.printBoard();
			
			//wait for input and move after that
			userInput = input.next();
			
			switch(userInput){
				case "left":{
					if(level.level[playerY][playerX-1] != '#'){
						playerX--;
						level.level[playerY][playerX+1] = ' ';
						moves++;
					}					
				} break;
				case "right":{
					if(level.level[playerY][playerX+1] != '#'){
						playerX++;
						level.level[playerY][playerX-1] = ' ';
						moves++;
					}
				}break;
				case "up":{
					if(level.level[playerY-1][playerX] != '#'){
						playerY--;
						level.level[playerY+1][playerX] = ' ';
						moves++;
					}
				}break;
				case "down":{
					if(level.level[playerY+1][playerX] != '#'){
						playerY++;
						level.level[playerY-1][playerX] = ' ';
						moves++;
					}
				}break;
				case "exit":{
					System.exit(0);
				} break;
			}
			
			//try to clear the screen
			for(int i = 0; i < 10; i++) {
				System.out.println("\n");
			}
			
		}
		
	}
}
