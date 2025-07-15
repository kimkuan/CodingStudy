package y2021.mon03.day31.boj_즐거운단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_즐거운단어_이상현 {

	static int N;
	static long answer = 0; // 제발 데이터 범위 좀 확인해~!~~!
	static char[] arr;
	static boolean usedL = false;
	
	public static void main(String[] args) throws IOException {
		input();
		solve(0, 1, 0, 0, usedL);
		System.out.println(answer);
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = br.readLine().toCharArray();
		N = arr.length;
		
		for(int i = 0; i < N; i++) {
			if(arr[i] == 'L') usedL = true;
		}
	}

	// sum : 경우의 수 
	// jaCnt : 연속되는 자음의 개수, moCnt : 연속되는 모음의 개수
	// 모음을 선택하는 경우 = 5개, 자음을 선택하는 경우=20개, L을 선택하는 경우 = 1개
	public static void solve(int cnt, long sum, int jaCnt, int moCnt, boolean usedL) {
		
		// 연속으로 3번 사용한 경우는 가지치기
		if(jaCnt >= 3 || moCnt >= 3) 
			return;
				
		if(cnt == N) {
			if(usedL) answer += sum; 
			return;
		}

		if(arr[cnt] == '_') {
			solve(cnt+1, sum*20, jaCnt+1, 0, usedL); // 자음을 사용할 경우
			solve(cnt+1, sum, jaCnt+1, 0, true); // L을 사용할 경우
			solve(cnt+1, sum*5, 0, moCnt+1, usedL); // 모음을 사용할 경우
		}
		else {
			if(isMoeum(arr[cnt])) solve(cnt+1, sum, 0, moCnt+1, usedL); // 모음이면 모음카운트 +1
			else solve(cnt+1, sum, jaCnt+1, 0, usedL); // 자음이면 자음카운트 +1
		}
	}
	
	public static boolean isMoeum(char c) {
		switch(c) {
		case 'A':
		case 'E':
		case 'I':
		case 'O':
		case 'U':
			return true; // 모음이면 true
		}
		return false; // 자음이면 false
	}
}
