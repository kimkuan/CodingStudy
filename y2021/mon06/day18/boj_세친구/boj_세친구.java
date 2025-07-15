package y2021.mon06.day18.boj_세친구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_세친구 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		// 짝수일 때는, 무조건 불가능
		if(N % 2 == 0) {
			System.out.println("NOT POSSIBLE");
			return;
		}
		
		// 작은 & 큰
		String U1 = findUString(str.substring(0, N/2+1), str.substring(N/2+1, N));
		// 큰 & 작은
		String U2 = findUString(str.substring(N/2, N), str.substring(0, N/2));
		
		// 둘다 NOT POSSIBLE => NOT POSSIBLE
		// 하나만 NOT POSSIBLE => S 출력
		// 둘다 NOT POSSIBLE이 아니고, 서로 다른값 => NOT UNIQUE
		// 둘다 NOT POSSIBLE이 아니고, 서로 같은같 => S출력
		
		System.out.println(getResult(U1, U2));	
	}
	
	private static String findUString(String bigString, String smallString) {
		boolean flag = false;
		int len = smallString.length();
	
		// i : 작은 문자열에 대한 인덱스
		for(int i = 0, j = 0; i < len; j++) {
			if(bigString.charAt(j) != smallString.charAt(i)) {
				if(flag) 
					return "NOT POSSIBLE";
				flag = true;
			}
			else
				i++; // 두 문자가 같을때에만 이동
		}
		return smallString;
	}
	
	private static String getResult(String U1, String U2) {
		String result = "";
		if(U1.equals("NOT POSSIBLE") && U2.equals("NOT POSSIBLE")) {
			result = "NOT POSSIBLE";
		}
		else if(U1.equals("NOT POSSIBLE")) {
			result = U2;
		}
		else if(U2.equals("NOT POSSIBLE")){
			result = U1;
		}
		else {
			if(U1.equals(U2))
				result = U1;
			else
				result = "NOT UNIQUE";
		}
		return result;
	}
}
