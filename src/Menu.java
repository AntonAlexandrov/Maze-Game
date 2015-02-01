import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Menu {
	
	public void printLogo() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("TextFiles/mazeLogo.txt"));
        String line;

        while ((line = br.readLine()) != null) {

            System.out.println(line);

        }
        br.close();
    }
	
	public void printMenu(){
		System.out.println("1.Start Game!");
		System.out.println("2.Instructions");
		System.out.println("3.Authors");
		System.out.println("4.Exit");
	}
	public void printInstructions() throws IOException{
		System.out.println("*SomeInstructions*");
		 BufferedReader br = new BufferedReader(new FileReader("TextFiles/instructions.txt"));
	        String line;

	        while ((line = br.readLine()) != null) {

	            System.out.println(line);

	        }
	        br.close();
	   System.out.print("\n\n\n");
	}
	public void printAbout() throws IOException{
		printLogo();
		BufferedReader br = new BufferedReader(new FileReader("TextFiles/Authors.txt"));
        String line;

        while ((line = br.readLine()) != null) {

            System.out.println(line);

        }
        br.close();
		System.out.print("\n\n\n");
	}
}
