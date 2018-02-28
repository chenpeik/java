package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.server.SocketSecurityException;
import java.util.HashSet;

public class Demo2 extends Thread{
	Socket socket;
	static HashSet<String> ips= new HashSet<String>();
	public Demo2(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		OutputStream outputStream =null;
		FileInputStream fileInputStream=null;
		try {
			outputStream = socket.getOutputStream();
			fileInputStream = (FileInputStream) socket.getInputStream();
			byte[] buf = new byte[1024];
			int length = 0;
			while((length=fileInputStream.read(buf))!=-1){
				outputStream.write(buf,0,length);
			}
			String ip = socket.getInetAddress().getHostAddress();
			if(ips.add(ip)){ //������Դ洢�������У���ô����ζ����� ��һ���µ�IP��ַ��
				System.out.println("��ϲ��"+ ip+"ͬѧ����ͼƬ�ɹ�����");
				System.out.println("��ǰ���ص�������"+ ips.size());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{

			
			try {
				fileInputStream.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(9090);
		while(true){
			Socket socket = serverSocket.accept();
			new Demo2(socket).start();
		}
	}
}
