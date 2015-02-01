
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

 public class Readerr {
  
 public String content = null;
 File file = null;
 char[] returnerChar;
 
 
 public Readerr(String filePath) {
  this.file = new File(filePath);
 }
 
 public String readFromFile() {
  if(file != null) {
   try {
          FileReader reader = new FileReader(file);
          char[] chars = new char[(int) file.length()];
          reader.read(chars);
          content = new String(chars);
          reader.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
      return content;
  } else {
   return "Something went wrong";
  }
 }
}
