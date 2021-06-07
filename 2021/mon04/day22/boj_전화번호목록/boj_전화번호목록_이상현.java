package mon04.day22.boj_전화번호목록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_전화번호목록_이상현 {
	
	static String[] phone;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			boolean flag = false;
			int N = Integer.parseInt(br.readLine());
			phone = new String[N];
			
			for(int i = 0; i < N; i++) 
				phone[i] = br.readLine();
			
			// 문자열이 끝나는 시점에 해당 문자열을 접두어로 갖는 문자열이 있는지 확인
			// 정렬을 이용하면 쉽게 접근할 수 있다 (바로 아래에 있는 문자열이 가장 흡사한 문자열임)
			Arrays.sort(phone);
			
			for(int i = 1; i < N; i++) {
				if(phone[i].startsWith(phone[i-1])) {
					flag = true;
					break;
				}
			}
			if(flag) sb.append("NO\n");
			else sb.append("YES\n");
		}
		System.out.print(sb);
	}

}
