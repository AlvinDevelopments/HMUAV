 
import java.io.*;
 
public class PythonTest {
 
/**
* @param args
* @throws IOException
*/
	public static void main(String[] args) throws IOException {
		// set up the command and parameter
		System.out.println("running script...");
		Process p = Runtime.getRuntime().exec("python src/test.py");
		
		
		// retrieve output from python script
		BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
		
		String line = "";
		while(true) {
			while((line = bfr.readLine()) != null) {
				// display each output line form python script
				System.out.println(line);
			}
		}
	}
}