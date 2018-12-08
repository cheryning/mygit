
public class TestSingle extends Thread{

	private int num = 5;
	
	public void run() {
		while(true) {
			
				SinglrObject a = SinglrObject.getsingleObject();
				//SingleObject2 b = SingleObject2.getsingleObject2();
				try {
					a.getMessage(num);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*
				try {
					b.getMessage(num);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/	
			
		}
		
	}
	
	
//	public static void main(String[] args) {
//		for(int i=0;i<5;i++) {
//			TestSingle thread = TestSingle().start();
//		}
//	}


}
