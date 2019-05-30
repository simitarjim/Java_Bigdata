package Java_bigdata;

public class sampleTester02 {
	public static void main(String[] args) {

	}

	class File {
		String fileName;
		byte[] content;
		String fileType;
		long size;
//在同一个类中，方法名一样，返回值一样，参数不一样，叫overload 重载
		public void write(String content) {
			this.content = content.getBytes();
			System.out.println("将content给了byte[]类型的实例变量content");

		}

		public void write(byte[] content) {
			this.content = content;
			System.out.println("将content给了byte[]类型的实例变量content");

		}

	}

}
