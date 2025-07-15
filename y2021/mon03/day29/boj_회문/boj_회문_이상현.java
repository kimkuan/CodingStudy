package y2021.mon03.day29.boj_회문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_회문_이상현 {
	
	static int T;
	static String[] str;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		int tc = 0;
		
		input();
		while(tc < T) {
			char[] strArr = str[tc].toCharArray();
			int left = isPalindromeLeft(strArr, strArr.length);
			int right = isPalindromeRight(strArr, strArr.length);

			sb.append(Math.min(left, right)).append("\n");
			tc++;
		}
		System.out.print(sb);
	}
	
	public static int isPalindromeLeft(char[] strArr, int len) {
		int j = len - 1;
		int wrongCnt = 0;
		
		for(int i = 0; i < j; ) { 
			if(strArr[i] == strArr[j]) {
				i++; j--;
				continue;	
			}
			else {
				wrongCnt++;
				if(i+1 < j && strArr[i+1] == strArr[j]) i++; // 왼쪽 인덱스+1 과 오른쪽 인덱스를 비교했는데 같다면
				else if(i+1 == j) break; // 현재 값 1개만 사라지면 유사회문이 된다
				else return 2;
			}
		}
		
		if(wrongCnt == 1) return 1; // 1번 고쳤을 때 회문이면 유사회문
		else if(wrongCnt > 1) return 2;
		return 0;
	}
	
	public static int isPalindromeRight(char[] strArr, int len) {
		int j = len - 1;
		int wrongCnt = 0;
		
		for(int i = 0; i < j; ) { 
			if(strArr[i] == strArr[j]) {
				i++; j--;
				continue;	
			}
			else {
				wrongCnt++;
				if(j-1 > i && strArr[i] == strArr[j-1]) j--; // 왼쪽 인덱스와 오른쪽 인덱스+1를 비교했는데 같다면
				else if(i+1 == j) break; // 현재 값 1개만 사라지면 유사회문이 된다
				else return 2;
			}
		}
		
		if(wrongCnt == 1) return 1; // 1번 고쳤을 때 회문이면 유사회문
		else if(wrongCnt > 1) return 2;
		return 0;
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 문자열의 개수
		str = new String[T];
		
		for(int i = 0; i < T; i++) {
			str[i] = br.readLine();
		}
	}
}
