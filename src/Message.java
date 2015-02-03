public class Message {
    public void printEnd(int moves, int score){
    	System.out.print("\n\n\n\n");
    	System.out.println("CONGRATULATIONS!!!");
    	System.out.println("You completed the game in: " + moves +" moves "+ "\nYour score was: " + score);
    	System.out.print("\n");
    }

    public void printHUD(int moves,int score){
        System.out.println("Your moves: " + moves + " " + "Your score: " + score + "\n");
    }
    
}