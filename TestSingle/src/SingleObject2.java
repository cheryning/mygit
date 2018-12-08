/*
 * 饱汉式单例模式
 * */
public class SingleObject2 {
	private SingleObject2() {
		
	}
	private static SingleObject2 singleObject2;
	
	public static SingleObject2 getsingleObject2() {
		if(singleObject2 == null) {
			synchronized (SingleObject2.class) {
				if(singleObject2 == null) {
					singleObject2 = new SingleObject2();
				}
			}
			
		}
		return singleObject2;
	}
	public void getMessage(int i) throws InterruptedException {
		Thread.sleep((int)(Math.random()*100));
		System.out.println("饱汉式单例模式"+i);
	}
}
