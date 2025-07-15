package y2021.mon01.day28.boj_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_문자열_이상현{
	
	// 다른 문자의 개수 반환
	public static int getDiff(String str1, String str2, int j) { // start : str2의 sub문자열
		int cnt=0;
		
		for(int i = 0; i < str1.length(); i++, j++) {
			if(str1.charAt(i) != str2.charAt(j))
				cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str1 = st.nextToken();
		String str2 = st.nextToken(); // 무조건 얘가 큼
		
		int sub = str2.length() - str1.length();
		int minDiff = 100; // 차이가 가장 작은 경우
		
		for(int i = 0; i <= sub; i++) {
			int cnt = getDiff(str1, str2, i);
			minDiff = Math.min(minDiff, cnt);
		}
		
		System.out.println(minDiff);
	}
}
