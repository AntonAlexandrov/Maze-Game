import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Level {

	Character[][] level = new Character[32][];
	int counter = 0; //used in reading the maze from .txt file
	int count = 0; //counts the dollars

	public void createMaze() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(
				"TextFiles/maze_new_01.txt"));
		String line;
		// Read file and get content into string
		Readerr readerr = new Readerr("TextFiles/maze_new_01.txt");
		String fileContent = readerr.readFromFile();
		// Find how many $ have in it
		count = fileContent.length() - fileContent.replace("$", "").length();

		while ((line = br.readLine()) != null) {

			level[counter] = new Character[line.length()];
			for (int i = 0; i < line.length(); i++) {
				level[counter][i] = line.charAt(i);

			}
			counter++;
		}
		br.close();

	}

	public void printBoard(int playerX, int playerY) { //Maze is 32 x 108
		for (int i = (playerY / 16) * 16; i < (playerY / 16) * 16 + 16; i++) {
			for (int j = (playerX / 54) * 54; j < (playerX / 54) * 54 + 54; j++) {
				System.out.print(level[i][j]);
			}
			System.out.println();
		}
	}

	public void restartMaze() throws IOException {
		level = new Character[32][108];
		counter = 0;
		count = 0;
		createMaze();
	}
}
