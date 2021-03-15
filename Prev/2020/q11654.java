import java.io.IOException;
import java.util.Scanner;

public class q11654 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char c = sc.next().charAt(0); // 문자를 입력받는 기능이 없으니 문자열로 받은 다음, 첫번째 문자 꺼내기

		int ascii = (int)c; // 65
		// int ascii = c - '0'; // 17
		// int ascii = Character.getNumericValue(c); // 10
		
		System.out.println(ascii);
	}

}
