package src.shavadoop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ssh_connection {
	
	
	 public static String ExecutesshCommand(String[] command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			//String[] command_final =  new String[]{"bash","-c","ssh -i /cal/homes/kchourou/.ssh/id_rsa.save c133-"+machine_nb+" "+command};
			
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = 
                           new BufferedReader(new InputStreamReader(p.getInputStream()));

                       String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}   
	

}
