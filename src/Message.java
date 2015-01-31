import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Message {
    public void printMessage(){
        System.out.println("Hello, this is an example maze!");
    }

    public void printMoves(int moves){
        System.out.println("Your moves: " + moves);
    }
}