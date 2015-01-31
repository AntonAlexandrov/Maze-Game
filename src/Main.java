import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public void playGame(){
		
	}

    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(System.in);
        Level level = new Level();
        
        Message message = new Message();
        Menu menu = new Menu();

        level.createMaze();
        
        int playerX = 1, playerY = 2;
        boolean play = false;

        String menuInput;
        String gameInput;
        int moves = 0;
        
        //the menu loop
        while(true){
	        menu.printMenu();
	        menuInput = input.next();
	        
	        if(menuInput.equals("1")){
	        	play = true;
	        	
	        	//the game loop
	        	while(play){	        		
		        	level.level[playerY][playerX] = 'P';
		    		
		            //printing stuff on screen
		            message.printMessage();
		            message.printMoves(moves);
		            level.printBoard(playerX, playerY);

		            //wait for input and move after that
		            gameInput = input.next();

		            switch(gameInput){
		                case "a":{
		                    if(level.level[playerY][playerX-1] != '#'){
		                        playerX--;
		                        level.level[playerY][playerX+1] = ' ';
		                        moves++;
		                    }
		                } break;
		                case "d":{
		                    if(level.level[playerY][playerX+1] != '#'){
		                        playerX++;
		                        level.level[playerY][playerX-1] = ' ';
		                        moves++;
		                    }
		                }break;
		                case "w":{
		                    if(level.level[playerY-1][playerX] != '#'){
		                        playerY--;
		                        level.level[playerY+1][playerX] = ' ';
		                        moves++;
		                    }
		                }break;
		                case "s":{
		                    if(level.level[playerY+1][playerX] != '#'){
		                        playerY++;
		                        level.level[playerY-1][playerX] = ' ';
		                        moves++;
		                    }
		                }break;
		                case "exit":{
		                	level.level[playerY][playerX] = ' ';
		                	playerX = 1; playerY = 2;
		                    play = false;
		                } break;
		            }

		            //try to clear the screen
		            for(int i = 0; i < 10; i++) {
		                System.out.println("\n");
		            }		
		        }
	        }
	        
	        if(menuInput.equals("2")){
	        	menu.printInstructions();
	        }
	        if(menuInput.equals("3")){
	        	menu.printAbout();
	        }
	        if(menuInput.equals("4")){
	        	System.exit(0);
	        }
	        
        }

    }
    
    
}