import java.io.IOException;
import java.util.Scanner;

public class q11654 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0); // ���ڸ� �Է¹޴� ����� ������ ���ڿ��� ���� ����, ù��° ���� ������

		int ascii = (int)c; // 65
		// int ascii = c - '0'; // 17
		// int ascii = Character.getNumericValue(c); // 10
		
		System.out.println(ascii);
	}

}
