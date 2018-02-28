package test;

public class Demo4 {
	
	public int add(int i){
//		int sum = 0;
//		if(i==1){
//			sum = 1;
//		}else{
//			sum += i*add(i-1);
//		}
		return i==1?1:i*add(i-1);
	}
	
	public static void main(String[] args) {
		Demo4 d = new Demo4();
		System.out.println(d.add(5));
	}
}
