package y2021.mon04.day20.boj_책페이지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_책페이지_이상현 {

	static long[] ans = new long[10]; // 0~9의 사용횟수를 담을 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());		
		long S = 1; // 시작 페이지 (S <= N)
		
		long point = 1; // 자리 수
		while(S <= N) {
			// 끝 수는 9로 끝나도록, N--
			while(N % 10 != 9 && S <= N) {
				cal(N, point);
				N--;
			}
			
			if(S > N) // 앞 수가 뒷 수보다 커지면 break
				break;
			
			// 시작 수는 0로 끝나도록, S++
			while(S % 10 != 0 && S <= N) {
				cal(S, point);
				S++;
			}
			
			N = N / 10;
			S = S / 10;
			
			for(int i = 0; i < 10; i++) {
				ans[i] += (N - S + 1) * point; // (B-A+1)를 자리수만큼 곱해주기 -> i가 나오는 횟수
			}
			point *= 10; // 다음 자리수로 이동
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	private static void cal(long x, long point) {
		while(x > 0) {
			String str = String.valueOf(x);
			int xx = str.charAt(str.length()-1) - '0'; // 자리수를 쪼개서 ans에 합산
			ans[xx] += point;
			x = x / 10;
		}
	}
}
