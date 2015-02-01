import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Message {
    public void printEnd(){
    	System.out.print("\n\n\n\n");
    	System.out.println("CONGRATULATIONS");
    	System.out.print("\n\n\n\n");
    }

    public void printHUD(int moves,int score, int pX, int pY){
        System.out.println("Your moves: " + moves +" "+ "Your score: " + score);
        System.out.print("X: " + pX + ' ');
        System.out.println("Y: " + pY);
    }
}