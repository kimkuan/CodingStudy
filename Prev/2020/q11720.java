import java.util.Scanner;

public class q11720 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int sum = 0;
		/*
		  nextInt() 사용 후 nextLine() 사용시 문제점 및 해결 방법
		  
		  - Scanner.nextInt 함수는 가장 마지막 개행문자를 제거하지 않음
		  - 개행문자는 다음에 호출된 Scanner.nextLine 함수의 입력으로 처리되어 문제가 발생한다
		  
		  방법1) Scanner.nextLine 추가 -> 개행문자를 제거하기 위함
		  방법2) Scanner.nextLine으로 정수를 입력받고 Integer.parseInt로 변환
		*/
		int n = Integer.parseInt(sc.nextLine());
		String num = sc.nextLine();
			
		for(int i = 0; i < n; i++) {
			sum += num.charAt(i) - '0';
		}
		
		System.out.println(sum);
	}
}
