package Exam03;

public class No20 {
	public static void main(String[] args) {
		String[][] school = { { "����һ", "����", "��ѧ" }, { "���ڶ�", "��ѧ", "�ֹ�" }, { "������", "����", "����" },
				{ "������", "�ֹ�", "����" }, { "������", "����", "��ѧ" } };
		for (int j = 0; j < school[j].length; j++) {
			for (int i = 0; i < school[i].length; i++) {

				System.out.print(school[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

}
