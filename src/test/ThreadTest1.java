package test;

public class ThreadTest1 {

	public static void main(String[] args) {
		new ThreadTest1().init();
	}
	
	public void init(){
		final Bussiness bussiness = new Bussiness();
		new Thread(
			new Runnable() {
				public void run() {
					for(int i=0;i<50;i++){
						bussiness.SubThread(i);
					}
				}
			}
		).start();
		
		for(int i=0;i<50;i++){
			bussiness.MainThread(i);
		}
	}
	
	private class Bussiness{
		boolean bShouldSub = true;////这里相当于定义了控制该谁执行的一个信号灯
		public synchronized void MainThread(int i){
			if(bShouldSub){
				try {
					this.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				for(int j=0;j<5;j++){
					System.out.println(Thread.currentThread().getName() + ":i=" + i +",j=" + j);
				}
				bShouldSub = true;
				this.notify();
			}
		}
		
		public synchronized void SubThread(int i){
			if(!bShouldSub)
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
			for(int j=0;j<10;j++)
			{
				System.out.println(Thread.currentThread().getName() + ":i=" + i +",j=" + j);
			}
			bShouldSub = false;				
			this.notify();
		}
	}

}
