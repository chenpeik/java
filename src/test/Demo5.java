package test;

import java.util.HashSet;
import java.util.Vector;
//ȥ��һ��Vector�������ظ���Ԫ�� 
public class Demo5 {
	public static void main(String[] args) {
		Vector vector = new Vector();
		for (int i = 0; i < vector.size(); i++) {
			Object object = vector.get(i);
			if(!vector.contains(object)){
				vector.add(object);
			}
		}
		
		//����һ�ּ򵥵ķ�ʽ
		HashSet hashSet = new HashSet(vector);
	}
}
