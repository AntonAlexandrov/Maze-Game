
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import src.Readerr;

public class Level {

    Character[][] level = new Character[32][];
    int counter = 0;
    public int count = 0;
    public void createMaze() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("TextFiles/maze-2.txt"));
        String line;
        //Read file and get content into string
        Readerr readerr = new Readerr("TextFiles/maze-2.txt");
        String fileContent = readerr.readFromFile();
        //Find how many $ have in it
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

    public void printBoard(int playerX, int playerY) {
        for (int i = (playerY / 16) * 16; i < (playerY / 16) * 16 + 16; i++) {
            for (int j = (playerX / 54) * 54; j < (playerX / 54) * 54 + 54; j++) {
                System.out.print(level[i][j]);
            }
            System.out.println();
        }
    }
}
