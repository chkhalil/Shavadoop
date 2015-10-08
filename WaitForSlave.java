package src.shavadoop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaitForSlave {
	
	
	 public static String wait(Process p) throws IOException {
		
		 StringBuffer output = new StringBuffer();
		 try {
			  
			p.waitFor();
			System.out.println("wait finished");
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

                String line = "";			
		while ((line = reader.readLine())!= null) {
			output.append(line + "\n");
		}
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		 
		 return output.toString();
		 
	 }

}
