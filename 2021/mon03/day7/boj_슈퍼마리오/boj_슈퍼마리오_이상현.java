package mon03.day7.boj_슈퍼마리오;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_슈퍼마리오_이상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0, max = 0;
		
		for(int i = 0; i < 10; i++) {
			int mush = Integer.parseInt(br.readLine());
			
			// 절대값이 같다면 더 큰 수를 선택하기
			max = Math.abs(max-100) >= Math.abs(sum+mush-100) ? sum+mush : max;
			sum += mush;
		}
		
		System.out.print(max);
	}
}
