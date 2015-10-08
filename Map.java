package src.shavadoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Map {
	
	public  ArrayList<HashMap<String,Integer>> readFile(String filename) throws IOException{
		 
		ArrayList<HashMap<String,Integer>> keys = new ArrayList<HashMap<String,Integer>>();
		 BufferedReader br = new BufferedReader(new FileReader(filename));
		 try {
			 
			 StringBuilder sb = new StringBuilder();
			 String line = br.readLine();
			 ArrayList<String> Splitted_lines = new ArrayList<String>();
			 
			 while(line != null){
				 HashMap<String,Integer> key = new HashMap<String,Integer>();
				 //String[] words = line.split(" ");
				 Iterator<String> it = Arrays.asList(line.split(" ")).iterator();
				 while(it.hasNext()){
		    			String word = it.next();
		    		
		    			key.put(word, 1);
		    			
		    			WriteFile.ecrire("file", word+ " 1 \n" );
		    			keys.add(key);
		    		}
				 Splitted_lines.add(line);
				 line = br.readLine();
			 }
			 
			 // write the keys on a file
			 
			 return keys;
		 } finally {
			 br.close();
			 
		 }
	 }
	
	public static void main(String[] a) throws IOException{
		
		Map map = new Map();
		
		System.out.println(map.readFile("/home/khalil/workspace/shavadoop/src/shavadoop/text"));
	}

}


 
