
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

    

    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(System.in);
        Level level = new Level();

        Message message = new Message();
        Menu menu = new Menu();

        level.createMaze();
        int screToBeDone = level.count * 5;

        int playerX = 1, playerY = 1;
        boolean play = false;

        String menuInput;
        String gameInput;
        int moves = 0;
        int score = 0;

        //the menu loop
        while (true) {
            menu.printMenu();
            menuInput = input.next();

            if (menuInput.equals("1")) {
                play = true;

                Calendar start = Calendar.getInstance();
                //the game loop

                while (play) {
                	
                	if (score == screToBeDone || level.level[playerY][playerX] == 'O') {
                        Calendar end = Calendar.getInstance();
                        long diff = (end.getTimeInMillis()-start.getTimeInMillis())/1000;
                        int hours = (int) (diff/3600);
                        int minutes = (int)(diff%3600)/60;
                        int second = (int) (diff%60);
                        message.printEnd();
                        System.out.printf("You have passed the maze for %02dh : %02dm : %02ds\n",hours,minutes,second);
                    	message.printHUD(moves, score);
                    	level.restartMaze();
                    	level.level[playerY][playerX] = ' ';
                    	playerX = 1;
                    	playerY = 1;
                    	moves = 0;
                    	score = 0;
                        break;                     
                    }
                    //try to clear the screen
                    for (int i = 0; i < 1; i++) {
                        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    }
                	
                    level.level[playerY][playerX] = 'P';

                    //printing stuff on screen
                    message.printHUD(moves, score);
                    level.printBoard(playerX, playerY);

                    //wait for input and move after that
                    gameInput = input.next();

                  //now accepts multiple and mixed inputs and moves accordingly (for example sadd, sswdswss, sawds)
                    char[] currentInput = gameInput.toCharArray();
                    for (int i = 0; i < currentInput.length; i++) {
						
                    	if (currentInput[i] == 'a') {
							if (level.level[playerY][playerX - 1] != '#') {
                                if (level.level[playerY][playerX - 1] == '$') {
                                    score += 5;
                                }
                                playerX--;
                                level.level[playerY][playerX + 1] = ' ';
                                moves++;
                            }
						}
						if (currentInput[i] == 'd') {
							if (level.level[playerY][playerX + 1] != '#') {
                                if (level.level[playerY][playerX + 1] == '$') {
                                    score += 5;
                                }
                                playerX++;
                                level.level[playerY][playerX - 1] = ' ';
                                moves++;
                            }
						}
						if (currentInput[i] == 'w') {
							if (level.level[playerY - 1][playerX] != '#') {
                                if (level.level[playerY - 1][playerX] == '$') {
                                    score += 5;
                                }
                                playerY--;
                                level.level[playerY + 1][playerX] = ' ';
                                moves++;
                            }
						}
						if(currentInput[i] == 's')  {
                            if (level.level[playerY + 1][playerX] != '#') {
                                if (level.level[playerY + 1][playerX] == '$') {
                                    score += 5;
                                }
                                playerY++;
                                level.level[playerY - 1][playerX] = ' ';
                                moves++;
                            }
                        }
						if(currentInput[i] == 'x') {
                            level.level[playerY][playerX] = ' ';
                            playerX = 1;
                            playerY = 1;
                            play = false;
                        }
					}
                           
                }
            }

            if (menuInput.equals("2")) {
                menu.printInstructions();
            }
            if (menuInput.equals("3")) {
                menu.printAbout();
            }
            if (menuInput.equals("4")) {
                System.exit(0);
            }

        }       

    }
}
