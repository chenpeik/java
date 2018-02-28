package test;

public class Demo9 {
	public static int halfSeach(int[] arr,int key)
	{
		int max = arr.length-1;
		int min = 0;
		int mid = (max+min)/2;
		
		while(arr[mid]!=key){
			if(key>arr[mid]){
				min = mid+1;
			}else if(key<arr[mid]){
				max= mid-1;
			}
			if(min>max){
				return -1;
			}
			mid = (max+min)/2;
		}
		return mid;
	}
}
