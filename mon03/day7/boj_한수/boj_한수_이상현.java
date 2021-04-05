package mon03.day7.boj_한수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_한수_이상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 99;
		
		if(N <= 99) {
			System.out.print(N);
			return;
		}
		else if(N == 1000) {
			System.out.print(144);
			return;
		}
		
		int h = N / 100; // 백의 자리 수
		int t = (N / 10) % 10; // 십의 자리수
		int o = N % 10; // 일의 자리수
				
		for(int i = 1; i <= h; i++) {
			for(int j = 0; j < 5; j++) {
				String str1 = i + "" + (i+j) + "" + (i+j*2);
				int num1 = Integer.parseInt(str1);

				if(num1 <= N)  // 양수 비교
					ans++;
				
				if(i == h) {
					if(i-j > t)  // 십의자리가 주어진 수의 십의 자리보다 작고
						continue;
					else if(i-j == t && i-j*2 > o)
						continue;
				}
				
				if(j != 0 && i-j*2 >= 0) 
					ans++;			
			}		
		}
		System.out.print(ans);
	}
}

// 210
// 1~99  = > 99개
// 111 123 135 147 159 => 5개
// 210 -> 1개