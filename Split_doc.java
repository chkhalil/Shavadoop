package src.shavadoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Split_doc {
	
	
 public static ArrayList<String> readFile(String filename) throws IOException{
		 
		 BufferedReader br = new BufferedReader(new FileReader(filename));
		 try {
			 
			 StringBuilder sb = new StringBuilder();
			 String line = br.readLine();
			 ArrayList<String> Splitted_lines = new ArrayList<String>();
			 
			 while(line != null){
				 
				 Splitted_lines.add(line);
				 line = br.readLine();
				 
			 }
			 return Splitted_lines;
		 } finally {
			 br.close();
			 
		 }
	 }

}
