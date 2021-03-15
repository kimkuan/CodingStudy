import java.util.Scanner;

public class q11720 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int sum = 0;
		/*
		  nextInt() ��� �� nextLine() ���� ������ �� �ذ� ���
		  
		  - Scanner.nextInt �Լ��� ���� ������ ���๮�ڸ� �������� ����
		  - ���๮�ڴ� ������ ȣ��� Scanner.nextLine �Լ��� �Է����� ó���Ǿ� ������ �߻��Ѵ�
		  
		  ���1) Scanner.nextLine �߰� -> ���๮�ڸ� �����ϱ� ����
		  ���2) Scanner.nextLine���� ������ �Է¹ް� Integer.parseInt�� ��ȯ
		*/
		int n = Integer.parseInt(sc.nextLine());
		String num = sc.nextLine();
			
		for(int i = 0; i < n; i++) {
			sum += num.charAt(i) - '0';
		}
		
		System.out.println(sum);
	}
}
