package Exam04;

public class No09 {
	public static void main(String[] args) {

		// ���ݻ�����Ϣ �������ж�ȡ
		ProcessData1 webdata = new ProcessData1();
		webdata.name = "bigdata";
		webdata.path = "www.zuikc.com";
		// ���ݴ�Ӳ���ж�ȡ
		ProcessData2 driverdata = new ProcessData2();
		driverdata.name = "java";
		driverdata.path = "c:";
		// ���ݴ��ڴ��϶�ȡ
		ProcessData3 memmorydata = new ProcessData3();
		memmorydata.name = "java1";
		memmorydata.path = "heap";

		
		webdata.process();
		webdata.file();
		driverdata.process();
		driverdata.file();
		memmorydata.process();
		memmorydata.file();
	}

}

class ReadData{
	public String name;
	public String path;
	
	public void file() {
		System.out.println("��ʼ�����ļ�");
	}
}

class ProcessData1 extends ReadData{
	public void process() {
		System.out.println("��ʼ��"+ path+"�����ļ�"+name);
	}
	}
class ProcessData2 extends ReadData{
	public void process() {
		System.out.println("��ʼ��"+ path+"�����ļ�"+name);
	}
	}
class ProcessData3 extends ReadData{
	public void process() {
		System.out.println("��ʼ��"+ path+"�����ļ�"+name);
	}
	}