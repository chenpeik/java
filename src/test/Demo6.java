package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo6 {

	public static void main(String[] args) throws Exception {
		FileManager a = new FileManager("a.txt",new char[]{'\n'});
		FileManager b = new FileManager("b.txt",new char[]{'\n',' '});	
		
		FileWriter fileWriter = new FileWriter("c.txt");
		String aWord = null;
		String bWord = null;
		while((aWord=a.nextWord())!=null){
			fileWriter.write(aWord+ "\n");
			bWord = b.nextWord();
			if(bWord!=null){
				fileWriter.write(bWord+ "\n");
			}
		}
		while ((bWord=b.nextWord())!=null) {
			fileWriter.write(bWord+ "\n");
		}
		fileWriter.close();
	}
}

class FileManager{
	String[] words = null;
	int pos = 1;
	public FileManager(String filename,char[] seperators) throws Exception {
		File file = new File(filename);
		FileReader fileReader = new FileReader(file);
		char[] buf = new char[(int) file.length()];
		int len = fileReader.read(buf);
		String result = new String(buf,0,len);
		String regex = null;
		if(seperators.length>1){
			regex = "" + seperators[0] + "|" + seperators[1];
		}else{
			regex = "" + seperators[0];
		}
		words = result.split(regex);
	}
	
	public String nextWord(){
		if(pos==words.length){
			return null;
		}
		return words[pos++];
	}
}