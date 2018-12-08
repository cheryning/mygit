
public class TestTheard {

	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			new TestSingle().start();
			new TestSingle().start();
		}
	 //   new TestSingle().start();
		//new TestSingle().start();
	}


}
