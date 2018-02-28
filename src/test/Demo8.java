package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Demo8 {
	
	private static int trimGBK(byte[] buf,int n){
		int num = 0;
		boolean bChineseFirstHalf = false;
		for(int i=0;i<n;i++){
			if(buf[i]<0 && !bChineseFirstHalf){
				bChineseFirstHalf = true;
			}else{
				num++;
				bChineseFirstHalf = false;
			}
		}
		return num;
	}
	
	public static void main(String[] args) throws IOException {
		//String str = "��a���л�abc�Ұ�����def';
		String str = "��ABC��";
		int num = trimGBK(str.getBytes("GBK"),5);
		System.out.println(str.substring(0,num) );
	}
}
