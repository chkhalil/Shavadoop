package src.shavadoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Split_doc {
	
	
 public static Integer readFile(String filename) throws IOException{
		 
		 BufferedReader br = new BufferedReader(new FileReader(filename));
		 try {
			 
			 StringBuilder sb = new StringBuilder();
			 String line = br.readLine();
			 //ArrayList<String> Splitted_lines = new ArrayList<String>();
			 
			 int file_index = 0;
			 while(line != null){
				 
				 //Splitted_lines.add(line);
				 WriteFile.ecrire("data/S_"+ String.valueOf(file_index), line);
				 
				 file_index++;
				 line = br.readLine();
			 
			 }
			 return (file_index);
			 
			 //return Splitted_lines;
		 } finally {
			 br.close();
			 
		 }
	 }

}
