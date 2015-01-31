import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Veronica on 31.1.2015 г..
 */
public class PrintGameLogo {
    public  void printLogo() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("TextFiles/mazeLogo.txt"));
        String line;

        while ((line = br.readLine()) != null) {

            System.out.println(line);

        }
        br.close();
    }
}
