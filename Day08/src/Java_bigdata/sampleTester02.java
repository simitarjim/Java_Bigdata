package Java_bigdata;

public class sampleTester02 {
	public static void main(String[] args) {

	}

	class File {
		String fileName;
		byte[] content;
		String fileType;
		long size;
//��ͬһ�����У�������һ��������ֵһ����������һ������overload ����
		public void write(String content) {
			this.content = content.getBytes();
			System.out.println("��content����byte[]���͵�ʵ������content");

		}

		public void write(byte[] content) {
			this.content = content;
			System.out.println("��content����byte[]���͵�ʵ������content");

		}

	}

}
