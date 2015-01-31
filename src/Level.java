import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Level {

	int levelSize = 4;
	
    Character[][] level = new Character[25][];
    int counter = 0;
    public  void createMaze() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("TextFiles/maze-2.txt"));
        String line;

        while ((line = br.readLine()) != null) {

                level[counter] = new Character[line.length()];
                for (int i = 0; i < line.length(); i++) {
                    level[counter][i] = line.charAt(i);
                }
                counter++;
        }
        br.close();
    }

//    char[][] level = { {'#', '#', '#', '#', '#', '#', '#', '#'},
//            {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
//            {'#', ' ', ' ', ' ', ' ', '#', ' ', '#'},
//            {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
//            {'#', ' ', ' ', '#', ' ', ' ', ' ', '#'},
//            {'#', '#', ' ', ' ', '#', ' ', ' ', '#'},
//            {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
//            {'#', '#', '#', '#', '#', '#', '#', '#'},};

    
    public void printBoard(int playerX, int playerY){
        for (Character[] characters : level) {
            for (int i = 0; i < characters.length; i++) {
                System.out.print(characters[i]);
            }
            System.out.println();
        }
    }
}