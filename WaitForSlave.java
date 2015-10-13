package src.shavadoop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WaitForSlave {
	
	
	 public static String wait(Process p) throws IOException {
		
		 StringBuffer output = new StringBuffer();
		 try {
			  
			p.waitFor();
			//System.out.println("wait finished");
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
	 
	 
	 public static HashMap<String,ArrayList<String>> wait_slaves(ArrayList<Machine_process_struct> Processes) throws IOException{
		 HashMap<String,ArrayList<String>> key_umx = new HashMap<String,ArrayList<String>>();
		 for (int i=0;i<Processes.size();i++){
			    
		    	String[] words_process = WaitForSlave.wait(Processes.get(i).p).split("\n");
		    	
		    	System.out.println("result returned by hostname  "+Processes.get(i).host );
		    	
		    	for (String word: words_process){
		    		
		    		 if (word.length()!=0)
		    		 {
		    	     if (key_umx.containsKey(word)){
		    				//ArrayList<String> tmp_value = key_umx.get(word);
		    				//tmp_value.add(Processes.get(i).host);
		    				key_umx.get(word).add(Processes.get(i).host);
			    			//key_umx.put(word, tmp_value);	
		    			}
		    	     else{
		    	    	 System.out.println("here is the begin of the word");
		    	    	 System.out.println(word.length());
		    	    	 System.out.println("here is the end of the word");
		    	    	 ArrayList<String> value  = new ArrayList<String>(Arrays.asList(Processes.get(i).host));  
		    	    	 key_umx.put(word,value);
		    	     }
		    		 }
		    	}
		    }
		 return key_umx;
		 
		 
	 }

}
