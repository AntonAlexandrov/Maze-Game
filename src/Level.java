import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Level {


    Character[][] level = new Character[8][];
    int counter = 0;
    public  void createMaze() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("TextFiles/map.txt"));
        String line;

        while ((line = br.readLine()) != null) {

                level[counter] = new Character[8];
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


    public void printBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.print(level[i][j]);
            }
            System.out.println();
        }
    }
}