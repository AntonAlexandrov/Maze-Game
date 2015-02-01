import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Message {
    public void printEnd(){
    	System.out.print("\n\n\n\n");
    	System.out.println("CONGRATULATIONS!!!");
    	System.out.print("\n");
    }

    public void printHUD(int moves,int score){
        System.out.println("You completed the game in: " + moves +" moves "+ "\nYour score was: " + score + "\n\n\n");
    }
}