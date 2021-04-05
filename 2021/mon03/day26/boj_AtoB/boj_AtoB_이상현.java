package mon03.day26.boj_AtoB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_AtoB_이상현 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		while(num2 > 0) {
			if(num1 == num2) // num1로 num2를 만들 수 있다면
				break;
			
			if(num2 % 2 == 0) 
				num2 /= 2;
			else if(num2 % 10 == 1)
				num2 /= 10; // 1으 자리 없애기
			else 
				break; // 둘 다 안되면 끝
			
			cnt++;
		}
		
		System.out.println(num1 != num2 ? -1 : cnt+1);
	}
}
