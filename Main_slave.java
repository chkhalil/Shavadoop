package src.shavadoop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Main_slave {
	
	 private void test_remotely(){
		 
		 
	 }
	public static void main(String[] a) throws IOException{
		
		
		String home_directory = System.getProperty("user.home");  // get the home directory
		// Splitting the initial document using "\n"  
		
		Integer input_file_rows = Split_doc.readFile(home_directory+"/workspace/Shavadoop/data/initial_file");
		
		// to do: send the splitted parts to remote computers
		
		// get the ip's that our machine can connect to
	    Scan_network.get_ip_Adress();
		
		// Run the map processes over the slaves
		
		
		   // Read from the ip_adresses file to get ip's of machines where we will execute the map tasks
		ArrayList<String> ip_adresses = Read_file.read(home_directory+"/workspace/Shavadoop/ip_adresses");
		
		  // Create list of processes that we are going to execute on slaves
		ArrayList<Machine_process_struct> Processes = new ArrayList<Machine_process_struct>();
		HashMap<String,String> Maps_dict = new HashMap<String,String>();  // constrcut dict <UM_x,Machines> 
		for (int i=0; i< input_file_rows;i++){     // ip_adresses.size()
		    String hostname = ip_adresses.get(i);
		    // Launch the process on the remote machine
		   
            System.out.println(hostname);
		    String[] command = new String[]{"bash","-c","ssh -i /cal/homes/kchourou/.ssh/id_rsa.save "+hostname + " java -jar "+ home_directory+"/workspace/Slave_Shavadoop/jar/slave_map.jar /cal/homes/kchourou/workspace/Shavadoop/data/S_"+String.valueOf(i)+" UM_"+String.valueOf(i)};
		    Process p1 = new ProcessBuilder(command).start();
		    Maps_dict.put("UM_"+String.valueOf(i), hostname); 
		    Machine_process_struct element = new Machine_process_struct(p1,hostname);
		    Processes.add(element);
		}
		//System.out.print("all processes launched");

		
		   // Wait for slaves until they finish
		    
		    HashMap<String,ArrayList<String>> key_umx = new HashMap<String,ArrayList<String>>();
		    key_umx = WaitForSlave.wait_slaves(Processes);  // to be tested tomorrow
		    
		    
		    for (String key : key_umx.keySet()) {
		    	   System.out.println("------------------------------------------------");
		    	   System.out.println("Iterating or looping map using java5 foreach loop");
		    	   System.out.println("key: " + key + " value: " + key_umx.get(key));
		    	}


		    
		
		
		
		
		//System.out.println(ssh.ExecutesshCommand(new String[]{"bash","-c","ssh -i /cal/homes/kchourou/.ssh/id_rsa.save c130-03 java -jar /cal/homes/kchourou/workspace/Slave_Shavadoop/bin/slave_shavadoop.jar  "}));
		System.out.println("fin du slave");  
		
	}
}
