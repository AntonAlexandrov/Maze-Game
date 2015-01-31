import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Message {
    public void printMessage(){
        System.out.println("Hello, this is an example maze!");
    }

    public void printHUD(int moves,int score, int pX, int pY){
        System.out.println("Your moves: " + moves + "Your score: " + score);
        System.out.print("X: " + pX + ' ');
        System.out.println("Y: " + pY);
    }
}