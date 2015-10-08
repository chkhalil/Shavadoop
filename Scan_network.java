package src.shavadoop;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Scan_network {
	
	
	
 public static void get_ip_Adress(){
		 
		 InetAddress address;
		try {
			ArrayList<String> ip_adresses = new ArrayList<String>() ; 
			for (int i=0;i<=30; i++){
				if (i<9){
					String hostname = "c130-0"+ String.valueOf(i);	
					System.out.println(hostname);
					//String ssh_test = Main_slave.ExecutesshCommand(new String[]{"bash","-c","ssh -i /cal/homes/kchourou/.ssh/id_rsa.save " +hostname + " echo OK"});
					String ssh_test = Ssh_connection.ExecutesshCommand(new String[]{"bash","-c","ssh -i /cal/homes/kchourou/.ssh/id_rsa.save " +hostname + " echo OK"});
					System.out.println(ssh_test);
					if (ssh_test.length()!=0)
					{
						address = InetAddress.getByName(hostname);
						WriteFile.ecrire("ip_adresses", address.getHostAddress());
						//this.ecrire("ip_adresses_new", address.getHostAddress());
						ip_adresses.add(address.getHostAddress());	
						
					}
				}
				else
				{
					String hostname = "c130-"+ String.valueOf(i);
					System.out.println(hostname);
					String ssh_test = Ssh_connection.ExecutesshCommand(new String[]{"bash","-c","ssh -i /cal/homes/kchourou/.ssh/id_rsa.save " +hostname + " echo OK"});
					if (ssh_test.length()!=0)
					{
						address = InetAddress.getByName(hostname);
						WriteFile.ecrire("ip_adresses", address.getHostAddress());
						ip_adresses.add(address.getHostAddress());	
						
					}
					
				}
						
			}
			System.out.println(ip_adresses);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 }

}
