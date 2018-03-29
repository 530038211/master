
public class SynchronizedTest {

	private static String A = "A";
	private static String B = "B";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new SynchronizedTest().deadLock();
	}
	
	private void deadLock(){
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized(A){
					try {
						Thread.currentThread().sleep(2000);
						System.out.println("111");
						System.out.println("222");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				synchronized(A){
					System.out.println(B+"22222");
				}
			}
			
		});
		
		t2.start();
		t1.start();
	}
    
	
}
