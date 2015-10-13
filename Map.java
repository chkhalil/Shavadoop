package src.shavadoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Map {
	
	//public  HashMap<String,Integer> readFile(String input_file,String output_file) throws IOException{
		
	public  void readFile(String input_file,String output_file) throws IOException{
		 
		//HashMap<String,Integer> keys = new HashMap<String,Integer>();
		 BufferedReader br = new BufferedReader(new FileReader(input_file));
		 try {
			 
			 //StringBuilder sb = new StringBuilder();
			 String line = br.readLine();
			 //ArrayList<String> Splitted_lines = new ArrayList<String>();
			 HashMap<String,Integer> key = new HashMap<String,Integer>();
			 while(line != null){
				 
				 //String[] words = line.split(" ");
				 Iterator<String> it = Arrays.asList(line.split(" ")).iterator();
				 while(it.hasNext()){
		    			String word = it.next();
		    			key.put(word, 1);
		    			WriteFile.ecrire(output_file, word+ " 1" );
		    			
		    			//key.add(key);
		    		}
				 //Splitted_lines.add(line);
				 line = br.readLine();
			 }
			 //System.out.println("slave executed");
			 
			 // write the keys on a file
			 
			 for (String iter : key.keySet()) {
				  
				   System.out.println(iter);
				}
 
			 //return key;
		 } finally {
			 br.close();
			 
		 }
	 }
	
	public static void main(String[] args) throws IOException{
		
		Map map = new Map();
		 //example to test: 
		//args[0]="/cal/homes/kchourou/workspace/Shavadoop/data/S_0";
		//args[1]="UM_0";
		
		map.readFile(args[0],args[1]);
	}

}


 
