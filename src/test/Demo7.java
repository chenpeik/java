package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo7 {

	public static void main(String[] args) throws Exception {
		File file1 = new File("D:/java");
		FilenameFilter filenameFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		};
		
		File[] files = file1.listFiles(filenameFilter);
		File file2 = new File("D:/jad");
		for(File f:files){
			FileInputStream in = new FileInputStream(f);
			String decName = f.getName();
			decName.replaceAll(".java", ".jad");
			
			FileOutputStream out = new FileOutputStream(new File(file2,decName));
			copy(in, out);
			in.close();
			out.close();
		}
	}
	
	private static void copy(InputStream in,OutputStream out) throws Exception{
		int len = 0;
		byte[] buf = new byte[1024];
		while((len=in.read(buf))!=-1){
			out.write(buf,0,len);
		}
	}

}

