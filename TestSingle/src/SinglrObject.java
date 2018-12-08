/*
 * 恶汉式单例模式
 * */

public class SinglrObject {
	//私有化构造方法
	private SinglrObject() {
		
	}
	//实例化对象
	private static SinglrObject singleObject = new SinglrObject();
	
	public static SinglrObject getsingleObject() {
		return singleObject;
	}
	public void getMessage(int i) throws InterruptedException {
		//Thread.sleep((int)(Math.random()*100));
//		int j = 0;
//		j++;
		System.out.println("恶汉式单例模式"+i);
	}
}
