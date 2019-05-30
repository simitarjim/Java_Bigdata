package Exam04;

public class No09 {
	public static void main(String[] args) {

		// 数据基本信息 从网络中读取
		ProcessData1 webdata = new ProcessData1();
		webdata.name = "bigdata";
		webdata.path = "www.zuikc.com";
		// 数据从硬盘中读取
		ProcessData2 driverdata = new ProcessData2();
		driverdata.name = "java";
		driverdata.path = "c:";
		// 数据从内存上读取
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
		System.out.println("开始处理文件");
	}
}

class ProcessData1 extends ReadData{
	public void process() {
		System.out.println("开始从"+ path+"下载文件"+name);
	}
	}
class ProcessData2 extends ReadData{
	public void process() {
		System.out.println("开始从"+ path+"下载文件"+name);
	}
	}
class ProcessData3 extends ReadData{
	public void process() {
		System.out.println("开始从"+ path+"下载文件"+name);
	}
	}
