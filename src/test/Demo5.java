package test;

import java.util.HashSet;
import java.util.Vector;
//去掉一个Vector集合中重复的元素 
public class Demo5 {
	public static void main(String[] args) {
		Vector vector = new Vector();
		for (int i = 0; i < vector.size(); i++) {
			Object object = vector.get(i);
			if(!vector.contains(object)){
				vector.add(object);
			}
		}
		
		//还有一种简单的方式
		HashSet hashSet = new HashSet(vector);
	}
}
