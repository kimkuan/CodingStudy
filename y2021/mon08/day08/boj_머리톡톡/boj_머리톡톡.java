package mon08.day08.boj_머리톡톡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_머리톡톡 {
	
	static int[] count = new int[1000001]; // 학생들이 가지고 있는 숫자들 개수 카운트
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] number = new int[N];
		
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(br.readLine());
			count[number[i]] += 1; // 기존의 개수 + 1
		}	
		
		for (int i = 0; i < N; i++) {
			int n = number[i];
			int answer = 0;
			int size =  (int) Math.sqrt(n);
			for (int j = 1; j <= Math.sqrt(n); j++) {
				if(n % j == 0) { // N은 j의 배수가 아닐 때는 PASS
					answer += count[j];
					
					if(j*j < n) // 제곱근이 아니면 j와 짝을 이루는 약수도 개수 구함 ex) 16의 공약수 (1,16) (2, 8)
						answer += count[n/j];
				}
			}
			sb.append(answer-1).append("\n"); // 자기자신은 제외
		}
		System.out.print(sb);
	}
}
