package y2021.mon03.day28.boj_골드바흐파티션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_골드바흐파티션_이상현 {
	
	static int size = 1000000;
	static int[] sosu = new int[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		
		make();

		while(tc++ < T) {
			int N = Integer.parseInt(br.readLine());
			sb.append(count(N)).append("\n");
		}
		System.out.print(sb);
	}
	private static void make() {
		for(int i = 2; i <= size; i++) {
			sosu[i] = i;
		}
		
		for(int i = 2; i <= size; i++) {
			if(sosu[i] == 0) continue;			
			for(int j = i+i; j <= size; j += i) { // i를 제외한  i의 배수들을 모두 0으로 설정
				sosu[j] = 0;
			}
		}
	}
	
	private static int count(int num) {
		int cnt = 0;
		for(int i = 0; i <= num/2; i++) { // 중복을 제거하기 위해 num의 반까지만 탐색
			 if(sosu[i] == 0) continue;
			 if(sosu[num - i] != 0) 
				 cnt++; // 소수  + 소수 = num
		}
		return cnt;
	}
}
