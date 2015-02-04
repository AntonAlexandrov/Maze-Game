import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws IOException {
		Scanner input = new Scanner(System.in);
		Level level = new Level();

		Menu menu = new Menu();

		level.createMaze();
		int scoreToBeDone = level.count * 5;

		int playerX = 1, playerY = 1;
		boolean play = false;

		String menuInput;
		String gameInput;
		int moves = 0;
		int score = 0;

		// the menu loop
		while (true) {
			menu.printMenu();
			menuInput = input.next();

			if (menuInput.equals("1")) {
				play = true;

				Calendar start = Calendar.getInstance(); //get the local time
				// the game loop

				while (play) {

					if (score == scoreToBeDone || level.level[playerY][playerX] == 'O') {
						Calendar end = Calendar.getInstance();
						long diff = (end.getTimeInMillis() - start
								.getTimeInMillis()) / 1000;
						int hours = (int) (diff / 3600);
						int minutes = (int) (diff % 3600) / 60;
						int seconds = (int) (diff % 60);
						System.out.print("\n\n\n\n");
						System.out.println("CONGRATULATIONS!!!");
						System.out.println("You completed the game in: "
								+ moves + " moves " + "\nYour score was: "
								+ score);
						if (hours < 1) {
							System.out.printf(
									"Your time was: %02dm : %02ds\n\n\n",
									minutes, seconds);
						} else {
							System.out
									.printf("Your time was:  %02dh : %02dm : %02ds\n\n\n",
											hours, minutes, seconds);
						}
						level.restartMaze();
						level.level[playerY][playerX] = ' ';
						playerX = 1;
						playerY = 1;
						moves = 0;
						score = 0;
						break;
					}
					// clearing the screen
					System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

					level.level[playerY][playerX] = 'P';

					// printing stuff on screen
					level.printBoard(playerX, playerY);

					// wait for input and move after that
					gameInput = input.next();

					// accepts multiple and mixed inputs and moves accordingly
					// (for example sadd, sswdswss, sawds)
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
						if (currentInput[i] == 's') {
							if (level.level[playerY + 1][playerX] != '#') {
								if (level.level[playerY + 1][playerX] == '$') {
									score += 5;
								}
								playerY++;
								level.level[playerY - 1][playerX] = ' ';
								moves++;
							}
						}
						if (currentInput[i] == 'x') {
							play = false;
							level.restartMaze();
							level.level[playerY][playerX] = ' ';
							playerX = 1;
							playerY = 1;
							moves = 0;
							score = 0;
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
				input.close();
				System.exit(0);
			}

		}

	}
}
