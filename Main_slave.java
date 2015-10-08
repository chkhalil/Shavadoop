package src.shavadoop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class Main_slave {
	
	 private void test_remotely(){
		 
		 
	 }
	public static void main(String[] a) throws IOException{
		Main_slave ssh = new Main_slave();
		
		// Splitting the initial document using "\n"  
		System.out.println(Split_doc.readFile("/home/khalil/Downloads/Distributed_systems/text"));
		
		// to do: send the splitted parts to remote computers
		
		// get the ip's that our machine can connect to
	    Scan_network.get_ip_Adress();
		
		// Run the map processes over the slaves
		
		
		   // Read from the ip_adresses file to get ip's of machines where we will execute the map tasks
		ArrayList<String> ip_adresses = Split_doc.readFile("/home/khalil/Downloads/Distributed_systems/ip_adresses");
		
		  // Create list of processes that we are going to execute on slaves
		ArrayList<Process> Processes = new ArrayList<Process>();
		for (int i=0; i< ip_adresses.size();i++){
		    String hostname = ip_adresses.get(i);
		    // Launch the process on the remote machine
		    Process p = Runtime.getRuntime().exec(new String[]{"bash","-c","ssh -i /cal/homes/kchourou/.ssh/id_rsa.save " +hostname + " java -jar /cal/homes/kchourou/workspace/Slave_Shavadoop/bin/slave_shavadoop.jar  "});
		    Process p1 = new ProcessBuilder("bash -c ssh -i /cal/homes/kchourou/.ssh/id_rsa.save " +hostname + " java -jar /cal/homes/kchourou/workspace/Slave_Shavadoop/bin/slave_shavadoop.jar  ").start();  // to be tested tomorrow
		    Processes.add(p);
		    //Process p2 = Runtime.getRuntime().exec(new String[]{"bash","-c","ssh -i /cal/homes/kchourou/.ssh/id_rsa.save " +"c130-04" + " java -jar /cal/homes/kchourou/workspace/Slave_Shavadoop/bin/slave_shavadoop.jar  "});
		   
		    //System.out.println(Ssh_connection.ExecutesshCommand(new String[]{"bash","-c","ssh -i /cal/homes/kchourou/.ssh/id_rsa.save " +hostname + " java -jar /cal/homes/kchourou/workspace/Slave_Shavadoop/bin/slave_shavadoop.jar  "}));
		}

		
		   // Wait for slaves until they finish
		    for (int i=0;i<Processes.size();i++){
		    	WaitForSlave.wait(Processes.get(i));
		    }
		
		
		
		
		//System.out.println(ssh.ExecutesshCommand(new String[]{"bash","-c","ssh -i /cal/homes/kchourou/.ssh/id_rsa.save c130-03 java -jar /cal/homes/kchourou/workspace/Slave_Shavadoop/bin/slave_shavadoop.jar  "}));
		System.out.println("fin du slave");
		
	}
}
