/*
 * ��ʽ����ģʽ
 * */

public class SinglrObject {
	//˽�л����췽��
	private SinglrObject() {
		
	}
	//ʵ��������
	private static SinglrObject singleObject = new SinglrObject();
	
	public static SinglrObject getsingleObject() {
		return singleObject;
	}
	public void getMessage(int i) throws InterruptedException {
		//Thread.sleep((int)(Math.random()*100));
//		int j = 0;
//		j++;
		System.out.println("��ʽ����ģʽ"+i);
	}
}
